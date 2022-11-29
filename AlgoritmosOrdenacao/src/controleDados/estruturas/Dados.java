package controleDados.estruturas;

import java.util.List;
import java.util.ArrayList;

public class Dados {
    private static List<Integer> dados;

    public Dados(){
        dados = new ArrayList<>();
    }

    public List<Integer> getDados() {
        return dados;
    }

    public void inserir(int valor) {
        dados.add(valor);
    }

    public void novaLista(){
        dados.clear();
    }
}
