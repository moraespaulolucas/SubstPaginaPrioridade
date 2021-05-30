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
     public void pageFault(List<Processo> lista) {
        System.out.printf("|");
        for (Processo processo: lista) {
             if (processo.isPageFault()) {
                 System.out.printf(" F");
             } else {
                 System.out.printf(" -");
             }
             System.out.printf(" |");
        }
        System.out.println();
     }
}
