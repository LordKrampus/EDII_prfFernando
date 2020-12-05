package meusConteiners;

import calculadora.EnumOperacoesBasicas;

public abstract class Elemento {
    private Elemento proximo;
    
    public Elemento(Elemento proximo){
        this.proximo = proximo;
    }

    public Elemento getProximo(){
        return this.proximo;
    }
    
    public void setProximo(Elemento proximo) {
        this.proximo = proximo;
    }   
}
