package com.david.proj.simples.crud.controllers;

import com.david.proj.simples.crud.Records.DadosDetalhamentoFamiliaDto;
import com.david.proj.simples.crud.Records.FamilasCadastroDto;
import com.david.proj.simples.crud.Repository.FamiliaRepository;
import com.david.proj.simples.crud.modells.Familias;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/familias")
public class FamilliasControllers {

    List<Familias> familias = new ArrayList<>();

    @Autowired
    private FamiliaRepository repository;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoFamiliaDto> cadastrarFamilia(@RequestBody FamilasCadastroDto dados, UriComponentsBuilder builder) {
        Familias familias = new Familias(dados);
        repository.save(familias);

        URI uri = builder.path("/familias/{id}").buildAndExpand(familias.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoFamiliaDto(familias));

    }

    @GetMapping("/todas")
    public ResponseEntity<List<DadosDetalhamentoFamiliaDto>> todas() {

        var lista = repository.findAll().stream().map(DadosDetalhamentoFamiliaDto::new).toList();
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
