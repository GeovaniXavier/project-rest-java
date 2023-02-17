package com.practitioner.projectrestjava.service;

import com.practitioner.projectrestjava.controller.LivroController;
import com.practitioner.projectrestjava.dto.LivroDto;
import com.practitioner.projectrestjava.mapper.DozerMapper;
import com.practitioner.projectrestjava.model.Livro;
import com.practitioner.projectrestjava.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<LivroDto> findAll() {
        var v = DozerMapper.parseListObject(livroRepository.findAll(), LivroDto.class);
        v.stream()
                .forEach(p -> {
                    try {
                        p.add(linkTo(methodOn(LivroController.class).findById(p.getKey())).withSelfRel());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
        return v;
    }

    public LivroDto findById(Long id) throws Exception {
        var entity = livroRepository.findById(id)
                .orElseThrow(() -> new Exception("ID NÃO ENCONTRADO."));
        var vo = DozerMapper.parseObject(entity, LivroDto.class);
        vo.add(linkTo(methodOn(LivroController.class).findById(id)).withSelfRel());
        return vo;
    }

    public LivroDto create(LivroDto livro) throws Exception {

        if (livro == null) throw new Exception("Erro ao criar usuario.");
        var entity = DozerMapper.parseObject(livro, Livro.class);
        var vo = DozerMapper.parseObject(livroRepository.save(entity), LivroDto.class);
        vo.add(linkTo(methodOn(LivroController.class).findById(livro.getKey())).withSelfRel());
        return vo;
    }


    public LivroDto update(LivroDto livro) throws Exception {
        if (livro == null) throw new Exception("Erro ao criar usuario.");
        var entity = livroRepository.findById(livro.getKey())
                .orElseThrow(() -> new Exception("ID NÃO ENCONTRADO"));
        var vo = DozerMapper.parseObject(livroRepository.save(entity), LivroDto.class);
        vo.add(linkTo(methodOn(LivroController.class).findById(livro.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id) throws Exception {
        Livro entity = livroRepository.findById(id)
                .orElseThrow(() -> new Exception("ID NÃO ENCONTRADO"));
        livroRepository.delete(entity);
    }
}
