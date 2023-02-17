package com.practitioner.projectrestjava.service;

import com.practitioner.projectrestjava.controller.PessoaController;
import com.practitioner.projectrestjava.dto.PessoaDto;
import com.practitioner.projectrestjava.mapper.DozerMapper;
import com.practitioner.projectrestjava.model.Pessoa;
import com.practitioner.projectrestjava.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PessoaService {


    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaDto> findAll() {
        var v = DozerMapper.parseListObject(pessoaRepository.findAll(), PessoaDto.class);
        v.stream()
                .forEach(p -> {
                    try {
                        p.add(linkTo(methodOn(PessoaController.class).findById(p.getKey())).withSelfRel());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
        return v;
    }

    public PessoaDto findById(Long id) throws Exception {
        var entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new Exception("ID NÃO ENCONTRADO."));
        var vo = DozerMapper.parseObject(entity, PessoaDto.class);
        vo.add(linkTo(methodOn(PessoaController.class).findById(id)).withSelfRel());
        return vo;
    }

    public PessoaDto create(PessoaDto pessoa) throws Exception {

        if(pessoa == null) throw new Exception("Erro ao criar usuario.");
        var entity = DozerMapper.parseObject(pessoa, Pessoa.class);
        var vo = DozerMapper.parseObject(pessoaRepository.save(entity), PessoaDto.class);
        vo.add(linkTo(methodOn(PessoaController.class).findById(pessoa.getKey())).withSelfRel());
        return vo;
    }


    public PessoaDto update(PessoaDto pessoa) throws Exception {
        if(pessoa == null) throw new Exception("Erro ao criar usuario.");
        Pessoa entity = pessoaRepository.findById(pessoa.getKey())
                .orElseThrow(() -> new Exception("ID NÃO ENCONTRADO"));
        var vo = DozerMapper.parseObject(pessoaRepository.save(entity), PessoaDto.class);
        vo.add(linkTo(methodOn(PessoaController.class).findById(pessoa.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id) throws Exception {
        Pessoa entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new Exception("ID NÃO ENCONTRADO"));
        pessoaRepository.delete(entity);
    }
}
