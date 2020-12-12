package estruturas;

import pessoa.Paciente;
import pessoa.Personagem;

public class Lista {
    private Elemento topo;
    private int tamanho;
    
    public Lista(){
        this.topo = null;
        this.tamanho = 0;
    }
    
    protected void underflow(Elemento topo) {
        if (this.estaVazia(topo)) {
            throw new NullPointerException("Lista Vazia!");
        }
    }

    public boolean estaVazia(Elemento topo) {
        return topo == null;
    }
    
    public Object getTopo(){
        this.underflow(this.topo);
        return this.topo.getObj();
    }
    
    protected Elemento getTopo(boolean opcao){
        return (opcao? this.topo : null);
    }
    
    protected void setTopo(Elemento obj){
        this.topo = obj;
    }
    
    public int getTamanho(){
        return this.tamanho;
    }
    
    protected void setTamanho(boolean opcao){
        if(opcao) 
            this.tamanho++;
        else 
            this.tamanho--;
    }
    
    public Object getElemento(int indice) {
        this.underflow(this.topo);

        Elemento auxTopo = this.topo;
        for (int i = 1; i < indice; i++) {
            if (auxTopo.getProximo() == null) {
                throw new IndexOutOfBoundsException("Valor Não Encontrado!");
            }
            auxTopo = auxTopo.getProximo();
        }
        return auxTopo.getObj();
    }
    
    public int temElemento(Object obj) {
        this.underflow(this.topo);

        int indice = 0;
        Elemento auxTopo = this.topo;
        while (auxTopo != null) {
            indice++;
            if (auxTopo.getObj().equals(obj)) {
                return indice;
            }
            auxTopo = auxTopo.getProximo();
        }
        throw new IndexOutOfBoundsException("Elemento Não Encontrado!");
    }
    
    public void inserir(Object obj){
        Elemento eNovo = new Elemento(obj, this.topo);
        this.topo = eNovo;
        this.tamanho++;
    }
    
    public void inserirNoIndice(Object obj, int indice){
        if (this.estaVazia(this.topo) || indice <= 1){
            this.inserir(obj);
            return;
        }
        
        Elemento auxTopo = this.topo;
        for(int i = 1; i < indice; i++){
            if(auxTopo.getProximo() == null){
                this.inserirFinal(obj);
                return;
            }
            if(i < (indice - 1))
                auxTopo = auxTopo.getProximo();
        }
        
        Elemento eNovo = new Elemento(obj, auxTopo.getProximo());
        auxTopo.setProximo(eNovo);
        this.tamanho++;
    }
    
    public void inserirFinal(Object obj){
        if (this.estaVazia(this.topo)){
            this.inserir(obj);
            return;
        }

        Elemento auxTopo = this.topo;
        while (auxTopo.getProximo() != null) {
            auxTopo = auxTopo.getProximo();
        }

        Elemento eNovo = new Elemento(obj, null);
        auxTopo.setProximo(eNovo);
        this.tamanho++;
    }
    
    public Object remover(){
        this.underflow(this.topo);
        
        Elemento removido = this.topo;
        this.topo = this.topo.getProximo();
        this.tamanho--;
        return removido.getObj();
    }
    
    public Object removerNoIndice(int indice){
        this.underflow(this.topo);
        
        if (indice == 1){
            return this.remover();
        }else if(indice < 1) 
            throw new IndexOutOfBoundsException("Indice Discrepante!");
        
        Elemento auxTopo = this.topo;
        for(int i = 1; i < indice; i++){
            if(auxTopo.getProximo() == null){
                throw new IndexOutOfBoundsException("Indice Discrepante!");
            }
            if(i < (indice - 1))
                auxTopo = auxTopo.getProximo();
        }
        Elemento removido = auxTopo.getProximo();
        auxTopo.setProximo(auxTopo.getProximo().getProximo());
        
        this.tamanho--;
        return removido.getObj();
    }
    
    public Object removerFinal(){
        this.underflow(this.topo);
        
        Elemento removido;
        if(this.tamanho == 1){
            removido = this.topo;
            this.topo = null;
        }else{
            Elemento auxTopo = this.topo;
            while(auxTopo.getProximo().getProximo() != null){
                auxTopo = auxTopo.getProximo();
            }
            removido = auxTopo.getProximo();
            auxTopo.setProximo(null);
        }
        this.tamanho--;
        return removido.getObj();
    }
    
    public void esvaziar(){
        while(this.topo != null){
            this.remover();
        }
    }
    
    public void imprimirPacientes(){
        this.underflow(this.topo);
        
        int indice = 0;
        Elemento auxTopo = this.topo;
        while(!estaVazia(auxTopo)){
            indice++;
            Object pessoa = (Paciente)auxTopo.getObj(); // estou engessando em razão do objetivo específico; 
                                                            // é necessário revisar métodologia.
            System.out.println(indice + " - " + pessoa.toString());
            auxTopo = auxTopo.getProximo();
        }
    }
    
    public void imprimirPersonagens(){
        this.underflow(this.topo);
        
        int indice = 0;
        Elemento auxTopo = this.topo;
        while(!estaVazia(auxTopo)){
            indice++;
            Object pessoa = (Personagem)auxTopo.getObj(); // igualmente...
            System.out.println(indice + " - " + pessoa.toString());
            auxTopo = auxTopo.getProximo();
        }
    }
}
