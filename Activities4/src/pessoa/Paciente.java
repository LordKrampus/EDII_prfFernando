package pessoa;

public class Paciente extends Pessoa{
    private EnumPrioridadePaciente prioridade;
    
    public Paciente(String nome, String cpf, int idade, int prioridade) throws IllegalArgumentException{
        super(nome, cpf, idade);
        this.prioridade = this.getEnumPrioridade(prioridade);
        
    }

    private EnumPrioridadePaciente getEnumPrioridade(int prioridade)throws IllegalArgumentException{
        if(prioridade == 1)
            return EnumPrioridadePaciente.BAIXA;
        else if(prioridade == 2)
            return EnumPrioridadePaciente.MEDIA;
        else if(prioridade ==3)
            return EnumPrioridadePaciente.ALTA;
        throw new IllegalArgumentException("Prioridade não definida!");
    }
    
    public int getPrioridade() {
        return this.prioridade.getPrioridade();
    }

    public void setPrioridade(int prioridade) throws IllegalArgumentException{
        this.prioridade = this.getEnumPrioridade(prioridade);
    }
    
    @Override
    public String toString(){
        return String.format("%s, %s}", super.toStringAberto(), this.prioridade); 
    }
}
