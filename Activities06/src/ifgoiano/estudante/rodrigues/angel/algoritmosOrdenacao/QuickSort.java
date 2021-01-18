package ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao;

public class QuickSort {
    private static long iteracoes = 0;

    public QuickSort(){
    }

    public static long realizar(Integer[] dados){
        quickSort(dados, 0, dados.length -1);
        //quickSort2(dados, 0, dados.length -1);
        return iteracoes;
    }

    private static void quickSort(Integer[] dados, int inicio, int fim){
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

                        iteracoes++;
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

                        iteracoes++;
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
    private static void quickSort2(Integer[] dados, int inicio, int fim){
        if(inicio >= fim) return;

        int pivo = dados[inicio];
        int indice = fim;
        int auxiliar;
        for(int i = fim; i > inicio; i--){
            if(dados[i] > pivo){
                swap(dados, i, indice);
                indice--;

                iteracoes++;
            }
        }
        swap(dados, inicio, indice);

        quickSort2(dados, inicio, indice-1);
        quickSort2(dados, indice + 1, fim);

        iteracoes++;
    }

    private static void swap(Integer[] dados, int indiceFrom, int indiceTo){
        int aux = dados[indiceFrom];
        dados[indiceFrom] = dados[indiceTo];
        dados[indiceTo] = aux;
    }
}
