package meusConteiners;
import calculadora.EnumOperacoesBasicas;
import meusConteiners.Elemento;

public class Pilha {
    private Elemento topo;
    private int size;
    
    public Pilha(){
        this.topo = null;
        this.size = 0;
    }
    
    public Pilha(Elemento topo){
        this.topo = topo;
        this.size = calcularSize(topo); //calcular size
    }
    
    private int calcularSize(Elemento topo){
        Elemento eAuxiliar = topo;//elementoAuxiliar
        int size = 0;
        
        while(eAuxiliar.getProximo() != null){
            size++;
            eAuxiliar = eAuxiliar.getProximo();
        }
        return size;
    }
    
    public boolean topoEhNumero(){
        return (this.topo instanceof ElementoNumerico);
    }
    
    public boolean valorEhNumero(Elemento valor){
        return valor instanceof ElementoNumerico;
    }
    
    private NullPointerException pilhaVaziaException(){
        return new NullPointerException("Pilha Vazia!");
    }
    
    public long getTopoNumero()throws NullPointerException{
        if(this.topo != null)
            if(topoEhNumero()){
                ElementoNumerico aux = (ElementoNumerico) this.topo;
                return aux.getValor();
            }
        throw this.pilhaVaziaException();
    }
    
    public EnumOperacoesBasicas getTopoOperacao() throws NullPointerException{
        if(this.topo != null)
            if(!topoEhNumero()){
                ElementoOperacional aux = (ElementoOperacional) this.topo;
                return aux.getValor();
            }
        throw this.pilhaVaziaException();
    }

    public int getSize() {
        return this.size;
    }
    
    public boolean underflow(){
        return this.topo == null;
    }
    
    private void complementarInserir(Elemento eNovo){
        this.topo = eNovo;
        this.size++;
    }
    
    public void inserir(long numero){
        ElementoNumerico eNovo = new ElementoNumerico(this.topo, numero);
        this.complementarInserir(eNovo);
    }
    
    public void inserir(EnumOperacoesBasicas operacao){
        ElementoOperacional eNovo = new ElementoOperacional(this.topo, operacao);
        this.complementarInserir(eNovo);
    }
    
    public Elemento retirar(){
        if (this.underflow()) return null;
        
        Elemento aux = this.topo;
        this.topo = this.topo.getProximo();
        this.size--;
        
        aux.setProximo(null);
        return aux;
    }  
    
    public void esvaziar(){
        while(!this.underflow()){
            this.retirar();
        }
    }
    
    private String recursoImprimir(Elemento elemento){
        if(this.valorEhNumero(elemento)){
            ElementoNumerico numero = (ElementoNumerico)elemento; 
            return String.format("%s",numero.getValor());
        }
        //else
        ElementoOperacional operacao = (ElementoOperacional)elemento; 
        return String.format("%s",operacao.getValor());  
    }
    
    public String imprimir(){
        Elemento eAuxiliar = this.topo;
        String apresentacao = "Topo -> ";
        while(eAuxiliar.getProximo() != null){
            apresentacao += this.recursoImprimir(eAuxiliar);
            eAuxiliar = eAuxiliar.getProximo();
        }
        apresentacao += this.recursoImprimir(eAuxiliar);
        return apresentacao;
    }

    public void inserir(ElementoNumerico elementoNumerico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
