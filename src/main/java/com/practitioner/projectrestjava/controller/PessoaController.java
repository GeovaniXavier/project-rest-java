package com.practitioner.projectrestjava.controller;

import com.practitioner.projectrestjava.dto.PessoaDto;
import com.practitioner.projectrestjava.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Tag(name = "Pessoa", description = "EndPoint")
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Procura todas as pessoas",
            description = "Todas as pessoas",
            tags = {"Pessoa"},
            responses = {@ApiResponse(description = "Sucess", responseCode = "200", content = {
                    @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PessoaDto.class))
                    )
            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public List<PessoaDto> findAll(PessoaDto pessoa) {
        return pessoaService.findAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})

    @Operation(summary = "Procura uma pessoas",
            description = "uma pessoas",
            tags = {"Pessoa"},
            responses = {@ApiResponse(description = "Sucess", responseCode = "200", content =
            @Content(schema = @Schema(implementation = PessoaDto.class))
            ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public PessoaDto findById(@PathVariable(value = "id") Long id) throws Exception {
        return pessoaService.findById(id);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Cria uma pessoas",
            description = "Cria pessoas",
            tags = {"Pessoa"},
            responses = {@ApiResponse(description = "Sucess", responseCode = "200", content =
            @Content(schema = @Schema(implementation = PessoaDto.class))
            ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public PessoaDto create(@RequestBody PessoaDto pessoa) throws Exception {
        return pessoaService.create(pessoa);
    }


    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Atualiza uma pessoas",
            description = "Atualiza pessoas",
            tags = {"Pessoa"},
            responses = {@ApiResponse(description = "Update", responseCode = "200", content =
            @Content(schema = @Schema(implementation = PessoaDto.class))
            ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public PessoaDto update(@RequestBody PessoaDto pessoa) throws Exception {
        return pessoaService.update(pessoa);
    }



    @DeleteMapping(value = "{id}")
    @Operation(summary = "Deleta uma pessoas",
            description = "Deleta pessoas",
            tags = {"Pessoa"},
            responses = {@ApiResponse(description = "No Content", responseCode = "204", content = @Content
            ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
