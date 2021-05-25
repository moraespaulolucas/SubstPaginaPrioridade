package br.com.moraespaulolucas.substpaginaprioridade;

import br.com.moraespaulolucas.substpaginaprioridade.model.Processo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Processo>> memoria = new ArrayList<>();

        List<Processo> referencia = new ArrayList<>();
        System.out.printf("Digite a referência: ");
        String referenciaStr = sc.nextLine();
        for (int i=0; i<referenciaStr.length(); i++) {
            Processo processo = new Processo();
            processo.setValor(Integer.parseInt(referenciaStr.substring(i, i+1)));
            referencia.add(processo);
        }
        memoria.add(referencia);

        System.out.println("Informe a prioridade do seguinte processo:");
        for (Processo processo : referencia) {
            System.out.printf("Processo " +processo.getValor()+ ": ");
            processo.setPrioridade(sc.nextInt());
            System.out.println(processo.getValor()+ " | " +processo.getPrioridade());
        }
    }
}
