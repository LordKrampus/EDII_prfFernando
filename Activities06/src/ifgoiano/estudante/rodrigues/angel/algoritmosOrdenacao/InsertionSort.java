package ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao;

public class InsertionSort {
    private InsertionSort(){}

    public static long realizar(Integer[] dados){
        long iteracoes = 0;

        for(int i = 1; i < dados.length; i++){
            int mao = dados[i];

            int indice = i-1;
            while(indice > -1 && dados[indice] >= mao){
                dados[(indice+1)] = dados[indice--];
                iteracoes++; //conta como iteracao
            }
            dados[++indice] = mao;
            iteracoes++; //conta como iteracao
        }

        return iteracoes;
    }
}
