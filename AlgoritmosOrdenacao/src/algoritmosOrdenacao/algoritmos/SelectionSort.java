package algoritmosOrdenacao.algoritmos;

public class SelectionSort extends SortAlgorithm{
    @Override
    public long realizar(Integer[] dados){
        for(int i = 0; i < dados.length; i++){
            int mao = dados[i];
            int menor = i;

            for(int j = (i + 1); j < dados.length; j++){
                if(dados[j] < dados[menor])
                    menor = j;
                super.iteracoes++; //conta como iteracao
            }

            if(menor > i){
                dados[i] = dados[menor];
                dados[menor] = mao;
            }
            super.iteracoes++; //conta como iteracao
        }

        return super.iteracoes;
    }
}
