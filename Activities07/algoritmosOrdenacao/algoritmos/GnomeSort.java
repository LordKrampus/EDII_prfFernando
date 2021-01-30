package ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao.algoritmos;

public class GnomeSort extends SortAlgorithm {
    @Override
    public long realizar(Integer[] dados){
        int indice = 1;
        while(indice < dados.length){
            while(indice > 0){
                if(dados[indice] < dados[indice-1])
                    this.swap(dados, indice, indice-1);
                else break;
                indice--;
            }
            indice++;
        }

        return super.iteracoes;
    }

    private void swap(Integer[] dados, int indiceFrom, int indiceTo){
        int aux = dados[indiceFrom];
        dados[indiceFrom] = dados[indiceTo];
        dados[indiceTo] = aux;
        super.iteracoes++;
    }
}
