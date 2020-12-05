package estruturas;
import java.util.List;
import java.util.ArrayList;
import veiculos.Veiculo;

public class FilaDeVeiculo {
    private List<Veiculo> veiculos;
    
    public FilaDeVeiculo(){
        this.veiculos = new ArrayList<>();
    }
    
    public void add(Veiculo veiculo){
        this.veiculos.add(veiculo);
    }
    
    public Veiculo remover(){
        return this.veiculos.remove(0);
    }
    
    public boolean estaVazia(){
        return this.veiculos.isEmpty();
    }
    
    public int getSize(){
        return this.veiculos.size();
    }
    
    public String toStringDadosVeiculos(){
        List<Veiculo> veiculos = this.veiculos;
        String apresentacao = "";
        
        for(Veiculo veiculo: veiculos){
            apresentacao += veiculo.toString() + "\n";
        }
        return apresentacao;
    }
}
