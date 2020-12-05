package lavajato;

public class GerenciamentoFila {
    private int numero;

    public GerenciamentoFila(){
        this.numero = 0;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public int gerarNumero(){
        return ++this.numero;
    }
}
