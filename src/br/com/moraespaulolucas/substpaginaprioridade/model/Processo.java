package br.com.moraespaulolucas.substpaginaprioridade.model;

public class Processo {
    private int valor;
    private int prioridade;
    private boolean pageFault = false;
    private boolean onMemory = false;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isPageFault() {
        return pageFault;
    }

    public void setPageFault(boolean pageFault) {
        this.pageFault = pageFault;
    }

    public boolean isOnMemory() {
        return onMemory;
    }

    public void setOnMemory(boolean onMemory) {
        this.onMemory = onMemory;
    }

}
