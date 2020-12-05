package meusConteiners;

public class ElementoNumerico extends Elemento{
    private long numero;
    
    public ElementoNumerico(Elemento proximo, long numero){
        super(proximo);
        this.numero = numero;
    }
    
    public long getValor(){
        return this.numero;
    }
}
