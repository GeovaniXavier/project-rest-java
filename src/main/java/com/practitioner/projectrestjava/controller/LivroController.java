package com.practitioner.projectrestjava.controller;

import com.practitioner.projectrestjava.dto.LivroDto;
import com.practitioner.projectrestjava.dto.PessoaDto;
import com.practitioner.projectrestjava.service.LivroService;
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
@RequestMapping("/livro")
@Tag(name = "Livro", description = "EndPoint")
public class LivroController {


    @Autowired
    private LivroService livroService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Procura todos os livros",
            description = "Todos os livros",
            tags = {"Livro"},
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
    public List<LivroDto> findAll(LivroDto livro) {
        return livroService.findAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})

    @Operation(summary = "Procura um livro",
            description = "um livro",
            tags = {"Livro"},
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
    public LivroDto findById(@PathVariable(value = "id") Long id) throws Exception {
        return livroService.findById(id);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Cria um livro",
            description = "Cria livros",
            tags = {"Livro"},
            responses = {@ApiResponse(description = "Sucess", responseCode = "200", content =
            @Content(schema = @Schema(implementation = PessoaDto.class))
            ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public LivroDto create(@RequestBody LivroDto livro) throws Exception {
        return livroService.create(livro);
    }


    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Atualiza um livro",
            description = "Atualiza livro",
            tags = {"Livro"},
            responses = {@ApiResponse(description = "Update", responseCode = "200", content =
            @Content(schema = @Schema(implementation = PessoaDto.class))
            ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public LivroDto update(@RequestBody LivroDto livro) throws Exception {
        return livroService.update(livro);
    }


    @DeleteMapping(value = "{id}")
    @Operation(summary = "Deleta um livro",
            description = "Deleta livro",
            tags = {"Livro"},
            responses = {@ApiResponse(description = "No Content", responseCode = "204", content = @Content
            ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
