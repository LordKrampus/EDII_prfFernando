package ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao.algoritmos;
import ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao.recursosFuncionais.Util;

public class GnomeSort extends SortAlgorithm {
    @Override
    public long realizar(Integer[] dados){
        int indice = 1;
        while(indice < dados.length){
            while(indice > 0){
                if(dados[indice] < dados[indice-1]) {
                    Util.swap(dados, indice, indice - 1);
                    super.iteracoes++;
                }
                else break;
                indice--;
            }
            indice++;
        }

        return super.iteracoes;
    }
}
