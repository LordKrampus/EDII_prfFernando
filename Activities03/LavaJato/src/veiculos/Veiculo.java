package veiculos;

public abstract class Veiculo {
    private int numIdentificacao;
    private String marca;
    private String modelo;
    private String cor;
    private int ano;

    public Veiculo(int numIdentificacao, String marca, String modelo, String cor, int ano){
        this.numIdentificacao = numIdentificacao;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
    }

    public int getNumIdentificacao() {
        return this.numIdentificacao;
    }

    public String getMarca() {
        return this.marca;
    }
    
    public String getModelo() {
        return this.modelo;
    }

    public String getCor() {
        return this.cor;
    }
    
    public int getAno() {
        return this.ano;
    }
    
    @Override
    public String toString(){
        return String.format(".Numero Identificacao: %d\nMarca: %s\nModelo: %s\nCor: %s\nAno: %d",
                this.numIdentificacao, this.marca, this.modelo, this.cor, this.ano);
    }
}
