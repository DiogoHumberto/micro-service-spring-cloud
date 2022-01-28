package br.com.interplacecom.fornecedor.domain.enumerators;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public enum Booleano {
	
    SIM(1, true), NAO(2, false);

    private Integer opcao;
    private Boolean valorBooleano;

    Booleano(Integer opcao, Boolean valorBooleano) {
        this.opcao = opcao;
        this.valorBooleano = valorBooleano;
    }

    public static Booleano getByOpcao(Integer opcao){
        return Arrays.stream(Booleano.values())
                .filter(booleano -> booleano.getOpcao().equals(opcao)).findAny()
                .orElse(null);
    }

    public static Booleano getByBoolean(Boolean opcao){
        return getAsList().stream()
                .filter(booleano -> booleano.getValorBooleano().equals(opcao)).findAny()
                .orElse(null);
    }

    public static List<Booleano> getAsList(){
        return Arrays.asList(Booleano.values());
    }

    @Override
    public String toString() {
        return this.name() + " - " + this.getOpcao();
    }

}