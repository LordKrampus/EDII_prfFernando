package ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao;

public class SelectionSort {
    private SelectionSort(){}

    public static long realizar(Integer[] dados){
        long iteracoes = 0;

        for(int i = 0; i < dados.length; i++){
            int mao = dados[i];
            int menor = i;

            for(int j = (i + 1); j < dados.length; j++){
                if(dados[j] < dados[menor])
                    menor = j;
                iteracoes++; //conta como iteracao
            }

            if(menor > i){
                dados[i] = dados[menor];
                dados[menor] = mao;
            }
            iteracoes++; //conta como iteracao
        }

        return iteracoes;
    }
}
