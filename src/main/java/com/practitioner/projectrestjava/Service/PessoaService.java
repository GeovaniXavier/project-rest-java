package com.practitioner.projectrestjava.Service;

import com.practitioner.projectrestjava.Model.Pessoa;
import com.practitioner.projectrestjava.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {


    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa findById(Long id) throws Exception {
        return pessoaRepository.findById(id).orElseThrow(() -> new Exception("ID NÃO ENCONTRADO."));
    }

    public Pessoa create(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }


    public Pessoa update(Pessoa pessoa) throws Exception {
        Pessoa entity = pessoaRepository.findById(pessoa.getId())
                .orElseThrow(() -> new Exception("ID NÃO ENCONTRADO"));
        return pessoaRepository.save(pessoa);
    }

    public void delete(Long id) throws Exception {
        Pessoa entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new Exception("ID NÃO ENCONTRADO"));
        pessoaRepository.delete(entity);
    }
}
