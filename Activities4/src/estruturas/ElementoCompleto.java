package estruturas;

public class ElementoCompleto extends Elemento {
    private Elemento anterior;
    
    public ElementoCompleto(Object obj, Elemento proximo, Elemento anterior){
        super(obj, proximo);
        this.anterior = anterior;
    }
    
    public Elemento getAnterior(){
        return this.anterior;
    }
    
    public void setAnterior(Elemento anterior){
        this.anterior = anterior;
    }
}
