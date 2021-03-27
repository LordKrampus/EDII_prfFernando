import java.util.LinkedList;

public class MarcadorTemporal {
    private double tempo;
    private LinkedList<Double> cache;

    public MarcadorTemporal(){
        this.tempo = 0;
        this.cache = new LinkedList<>();
    }

    public void marcarInicio(){
        this.tempo = -System.currentTimeMillis();
    }

    public void marcarFim(){
        this.tempo += System.currentTimeMillis();
        this.cache.add(tempo);
    }

    public double getCusto(){
        return this.tempo/1000f;
    }

    public double gerarCustoTotal(){
        double custoTotal;
        int length;

        custoTotal = 0;
        length = this.cache.size();
        for(int i = 0; i < length; i++){
            custoTotal += this.cache.get(i);
        }

        return custoTotal/1000f;
    }

    public void zerarMarcadorTemporal(){
        this.cache = new LinkedList<>();
        this.tempo = 0;
    }
}
