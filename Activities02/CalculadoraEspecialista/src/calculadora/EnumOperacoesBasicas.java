package calculadora;

public enum EnumOperacoesBasicas{
    INDEFINIDA(0), SOMA(1), SUBTRACAO(2), MULTIPLICACAO(3), DIVISAO(4), PARENTESE_BEGUIN(5), PARENTESE_END(6);
    
    private final int operacao;
    EnumOperacoesBasicas(int operacao){
        this.operacao = operacao;
    }
    
    public int getValor(){
        return this.operacao;
    }
}
