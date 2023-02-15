package com.practitioner.projectrestjava.service;

import com.practitioner.projectrestjava.dto.PessoaDto;
import com.practitioner.projectrestjava.mapper.DozerMapper;
import com.practitioner.projectrestjava.model.Pessoa;
import com.practitioner.projectrestjava.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {


    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaDto> findAll() {
        return DozerMapper.parseListObject(pessoaRepository.findAll(), PessoaDto.class);
    }

    public PessoaDto findById(Long id) throws Exception {
        var entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new Exception("ID NÃO ENCONTRADO."));
        return DozerMapper.parseObject(entity, PessoaDto.class);
    }

    public PessoaDto create(PessoaDto pessoa) {
        var entity = DozerMapper.parseObject(pessoa, Pessoa.class);
        var vo = DozerMapper.parseObject(pessoaRepository.save(entity), PessoaDto.class);
        return vo;
    }


    public PessoaDto update(PessoaDto pessoa) throws Exception {
        Pessoa entity = pessoaRepository.findById(pessoa.getId())
                .orElseThrow(() -> new Exception("ID NÃO ENCONTRADO"));
        var vo = DozerMapper.parseObject(pessoaRepository.save(entity), PessoaDto.class);
        return vo;
    }

    public void delete(Long id) throws Exception {
        Pessoa entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new Exception("ID NÃO ENCONTRADO"));
        pessoaRepository.delete(entity);
    }
}
