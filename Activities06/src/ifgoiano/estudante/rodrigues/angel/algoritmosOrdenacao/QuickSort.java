package ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao;

public class QuickSort {
    private static long iteracoes = 0;

    public QuickSort(){
    }

    public static long realizar(Integer[] dados){
        quicksort(dados, 0, dados.length -1);

        return iteracoes;
    }

    private static void quicksort(Integer[] dados, int inicio, int fim){
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

        quicksort(dados, inicio, pivo-1);
        quicksort(dados, pivo+1, fim);
    }
}
