package br.com.moraespaulolucas.substpaginaprioridade;

import br.com.moraespaulolucas.substpaginaprioridade.model.Processo;
import br.com.moraespaulolucas.substpaginaprioridade.model.Teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Processo> referencia = new ArrayList<>();

        System.out.printf("Digite a referência: ");
        String referenciaStr = sc.nextLine();
        for (int i = 0; i < referenciaStr.length(); i++) {
            Processo processo = new Processo();
            processo.setValor(Integer.parseInt(referenciaStr.substring(i, i+1)));
            referencia.add(processo);
        }

        System.out.println("Determine a prioridade do seguinte processo:");
        for (int i = 0; i < referencia.size(); i++) {
            Processo processoInd = referencia.get(i);
            boolean igual = false;
            for (int j = i-1; j >= 0; j--) {
                Processo processoAux = referencia.get(j);
                if (processoInd.getValor() == processoAux.getValor()) {
                    igual = true;
                    processoInd.setPrioridade(processoAux.getPrioridade());
                    break;
                }
            }
            if (!igual) {
                System.out.printf("Processo | " +processoInd.getValor()+ " |: ");
                processoInd.setPrioridade(sc.nextInt());
            }
        }

        int qtdFrames;
        List<List<Processo>> memoria = new ArrayList<>();

        System.out.printf("Indique a quantidade de frames da memória: ");
        qtdFrames = sc.nextInt();
        for (int i = 0; i < qtdFrames; i++) {
            List<Processo> frame = new ArrayList<>();
            memoria.add(frame);
        }

        for (Processo procRef: referencia) {
            int indRef = referencia.indexOf(procRef);
            int indFrm, indFrmAux = 0;
            int prioridade = procRef.getPrioridade();
            Processo procAux;

            for (List<Processo> frame: memoria) {
                indFrm = memoria.indexOf(frame);

                if (frame.isEmpty()) {
                    if (procRef.isPageFault()) {
                        Processo procNull = new Processo();
                        frame.add(procNull);
                        continue;
                    }
                    procRef.setPageFault(true);
                    frame.add(procRef);
                    indFrmAux = indFrm;
                    continue;
                }

                procAux = frame.get(indRef - 1);

                if (procRef.getValor() == procAux.getValor()) {
                    procRef.setOnMemory(true);
                    frame.add(procRef);
                    indFrmAux = indFrm;
                    break;
                }

                if (procAux.getPrioridade() < prioridade) {
                    prioridade = procAux.getPrioridade();
                    indFrmAux = indFrm;
                }
            }

            for (List<Processo> frame: memoria) {
                indFrm = memoria.indexOf(frame);

                if (indFrm == 0) { break; }

                procAux = frame.get(indRef - 1);

                if (indFrm == indFrmAux) {
                    if (!procRef.isOnMemory()) {
                        procRef.setPageFault(true);
                        frame.add(procRef);
                    }
                    continue;
                }
                frame.add(procAux);
            }
        }

        Teste teste = new Teste();
        System.out.println("Referência");
        teste.lista(referencia);
        for (List<Processo> frame: memoria) {
            System.out.println("Frame " +memoria.indexOf(frame));
            teste.lista(frame);
        }
    }
}
