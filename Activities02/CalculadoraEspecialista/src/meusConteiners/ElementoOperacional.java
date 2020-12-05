package meusConteiners;

import calculadora.EnumOperacoesBasicas;

public class ElementoOperacional extends Elemento{
    private EnumOperacoesBasicas operacao;
    
    public ElementoOperacional(Elemento proximo, EnumOperacoesBasicas operacao){
        super(proximo);
        this.operacao = operacao;
    }
       
    public EnumOperacoesBasicas getValor(){
        return this.operacao;
    }       
}
