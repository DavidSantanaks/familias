package com.david.proj.simples.crud.controllers;

import com.david.proj.simples.crud.Records.FamilasDto;
import com.david.proj.simples.crud.Repository.FamiliaRepository;
import com.david.proj.simples.crud.modells.Familias;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/familias")
public class FamilliasControllers {

    List<Familias> familias = new ArrayList<>();

    @Autowired
    private FamiliaRepository repository;

    @PostMapping("/")
    public void cadastrarFamilia(@RequestBody FamilasDto dados) {
        repository.save(new Familias(dados));
    }

    @GetMapping("/todas")
    public List<Familias> todas() {
        return repository.findAll();
    }

}
