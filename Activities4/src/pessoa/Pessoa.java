package pessoa;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private byte idade;

    public Pessoa(String nome, String cpf, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = (byte)idade;
    }
    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public byte getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = (byte)idade;
    }
    
    public String toStringAberto(){
        return String.format("{%s, %s, %s" , this.nome, this.cpf, this.idade);
    }
    
    @Override
    public String toString(){
        return String.format("%s}" , this.toStringAberto());
    }
}
