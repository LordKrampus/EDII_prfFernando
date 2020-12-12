package estruturas;
import pessoa.Pessoa;

public class Elemento {
    private Object obj;
    private Elemento proximo;
    
    public Elemento(Object obj, Elemento proximo){
        this.obj = obj;
        this.proximo = proximo;
    }

    public Object getObj() {
        return this.obj;
    }

    public Elemento getProximo() {
        return this.proximo;
    }

    public void setProximo(Elemento proximo) {
        this.proximo = proximo;
    }
}
