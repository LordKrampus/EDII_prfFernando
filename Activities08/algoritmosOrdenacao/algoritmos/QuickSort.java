package ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao.algoritmos;

import ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao.recursosFuncionais.Util;

public class QuickSort extends SortAlgorithm {
    @Override
    public long realizar(Integer[] dados){
        //quickSort(dados, 0, dados.length -1);
        quickSort2(dados, 0, dados.length -1);
        return super.iteracoes;
    }

    private void quickSort(Integer[] dados, int inicio, int fim){
        if(inicio >= fim) return;

        int pivo = inicio;
        int indice = fim;
        while(indice != pivo){
            if(indice > pivo){
                for(int i = indice; i > pivo; i--) {
                    if (dados[indice] < dados[pivo]) {
                        int aux = dados[indice];
                        dados[indice] = dados[pivo];
                        dados[pivo] = aux;

                        aux = indice;
                        indice = pivo;
                        pivo = aux;

                        super.iteracoes++;
                        break;
                    }
                    indice--;
                }
            }else{
                for(int i = indice; i < pivo; i++) {
                    if (dados[indice] > dados[pivo]) {
                        int aux = dados[indice];
                        dados[indice] = dados[pivo];
                        dados[pivo] = aux;

                        aux = indice;
                        indice = pivo;
                        pivo = aux;

                        super.iteracoes++;
                        break;
                    }
                    indice++;
                }
            }
        }

        quickSort(dados, inicio, pivo-1);
        quickSort(dados, pivo+1, fim);
    }

    //segunda implementação,por subsidio de referencias de algoritmos do modelo escritos
    private void quickSort2(Integer[] dados, int inicio, int fim){
        if(inicio >= fim) return;

        int pivo = dados[inicio];
        int indice = fim;
        for(int i = fim; i > inicio; i--){
            if(dados[i] > pivo){
                Util.swap(dados, i, indice);
                indice--;

                super.iteracoes++;
            }
        }
        Util.swap(dados, inicio, indice);
        super.iteracoes++;

        quickSort2(dados, inicio, indice-1);
        quickSort2(dados, indice + 1, fim);
    }
}
