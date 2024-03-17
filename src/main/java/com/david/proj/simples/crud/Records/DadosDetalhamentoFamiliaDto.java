package com.david.proj.simples.crud.Records;

import com.david.proj.simples.crud.modells.Familias;

public record DadosDetalhamentoFamiliaDto(
        long id,
        String nome,
        int quantidadeMembros) {

    public DadosDetalhamentoFamiliaDto(Familias familias) {
        this(familias.getId(), familias.getNome(), familias.getQuantidadeMembros());
    }
}
