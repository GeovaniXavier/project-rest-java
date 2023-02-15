package com.practitioner.projectrestjava.Controller;

import com.practitioner.projectrestjava.Dto.PessoaDto;
import com.practitioner.projectrestjava.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PessoaDto> findAll(PessoaDto pessoa) {
        return pessoaService.findAll();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PessoaDto findById(PessoaDto pessoa) throws Exception {
        return pessoaService.findById(pessoa.getId());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PessoaDto create(@RequestBody PessoaDto pessoa) {
        return pessoaService.create(pessoa);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PessoaDto update(@RequestBody PessoaDto pessoa) throws Exception {
        return pessoaService.update(pessoa);
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
