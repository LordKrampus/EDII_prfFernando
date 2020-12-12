package pessoa;

public enum EnumPrioridadePaciente {
    BAIXA(1), MEDIA(2), ALTA(3);
    
    private int prioridade;
    private EnumPrioridadePaciente(int enumeracao){
        this.prioridade = enumeracao;
    }
    
    public int getPrioridade(){
        return this.prioridade;
    }
}
