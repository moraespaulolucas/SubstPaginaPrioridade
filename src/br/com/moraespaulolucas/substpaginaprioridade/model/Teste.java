package br.com.moraespaulolucas.substpaginaprioridade.model;

import java.util.List;

public class Teste {
    public void lista(List<Processo> lista) {
        System.out.printf("|");
        for (Processo processo: lista) {
            if (processo == null) {
                System.out.printf(" -");
            } else {
                System.out.printf(" " +processo.getValor());
            }
            System.out.printf(" |");
        }
        System.out.println();
    }
}
