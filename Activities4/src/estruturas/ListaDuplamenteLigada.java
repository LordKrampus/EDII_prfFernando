package estruturas;

public class ListaDuplamenteLigada extends Lista{
    public ListaDuplamenteLigada(){
        super();
        
    }
 
    @Override
    public void inserir(Object obj){
        ElementoCompleto topo = (ElementoCompleto)super.getTopo(true);
        
        ElementoCompleto eNovo;
        if(super.estaVazia(topo))
            eNovo = new ElementoCompleto(obj, topo, null);
        else{
            eNovo = new ElementoCompleto(obj, topo, topo.getAnterior());
            topo.setAnterior(eNovo);
        }
        super.setTopo(eNovo);
        
        super.setTamanho(true);
    }
    
    @Override
    public void inserirNoIndice(Object obj, int indice){
        if(super.estaVazia(super.getTopo(true)) || indice <= 1) {
            this.inserir(obj);
            return;
        }
        
        ElementoCompleto eNovo;
        ElementoCompleto tAux;
        ElementoCompleto topo = (ElementoCompleto)super.getTopo(true);
        for(int i = 1; i < indice; i++){
            if(topo.getProximo() == null){
                this.inserirFinal(obj);
                return;
            }
            if(i < (indice - 1))
                topo = (ElementoCompleto)topo.getProximo();
        }
        
        eNovo = new ElementoCompleto(obj, topo.getProximo(), topo);
        tAux = (ElementoCompleto)topo.getProximo();
        tAux.setAnterior(eNovo);
        topo.setProximo(eNovo);
        
        super.setTamanho(true);
    }
    
    @Override
    public void inserirFinal(Object obj){
        if(super.estaVazia(super.getTopo(true))) this.inserir(obj);
        
        ElementoCompleto eNovo;
        ElementoCompleto topo = (ElementoCompleto)super.getTopo(true);
        while(topo.getProximo() != null){
            topo = (ElementoCompleto)topo.getProximo();
        }
        eNovo = new ElementoCompleto(obj, topo.getProximo(), topo);
        topo.setProximo(eNovo);
        
        super.setTamanho(true);
    }
    
    @Override
    public Object remover(){
        super.underflow(super.getTopo(true));
        
        Object removido = super.remover();
        if(!super.estaVazia(super.getTopo(true))){
            ElementoCompleto topo = (ElementoCompleto)super.getTopo(true);
            topo.setAnterior(null);
        }        
        return removido;
    }
    
    @Override 
    public Object removerNoIndice(int indice){
        super.underflow(super.getTopo(true));
        
        if (indice == 1){
            return this.remover();
        }else if(indice < 1) 
            throw new IndexOutOfBoundsException("Indice Discrepante!");
        
        Elemento topo = (ElementoCompleto)super.getTopo(true);
        for(int i = 1; i < indice; i++){
            if(topo.getProximo() == null){
                throw new IndexOutOfBoundsException("Indice Discrepante!");
            }
            if(i < (indice - 1))
                topo = topo.getProximo();
        }
        ElementoCompleto novoProximo = (ElementoCompleto)topo.getProximo().getProximo();
        Elemento removido = topo.getProximo();
        topo.setProximo(novoProximo);
        if(novoProximo != null)
            novoProximo.setAnterior(topo);
 
        super.setTamanho(false);
        return removido.getObj();
    }
    
    @Override
    public Object removerFinal(){
        super.underflow(super.getTopo(true));
        
        Object removido = super.removerFinal();
        return removido;
    }
    
    public void testarLigacoes(){
        int countProx, countAnt;
        countProx = countAnt = 0;
        
        ElementoCompleto topo = (ElementoCompleto)super.getTopo(true);
        while(topo.getProximo() != null){
            countProx++;
            topo = (ElementoCompleto)topo.getProximo();
        }
        System.out.println("CountProximo = " + countProx);
        
        while(topo.getAnterior() != null){
            countAnt++;
            topo = (ElementoCompleto)topo.getAnterior();
        }
        System.out.println("CountAnterior = " + countAnt);
    }
    
}
