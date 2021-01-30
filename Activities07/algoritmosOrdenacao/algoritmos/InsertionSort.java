package ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao.algoritmos;

public class InsertionSort extends SortAlgorithm{
    @Override
    public long realizar(Integer[] dados){
        for(int i = 1; i < dados.length; i++){
            int mao = dados[i];

            int indice = i-1;
            while(indice > -1 && dados[indice] >= mao){
                dados[(indice+1)] = dados[indice--];
                super.iteracoes++; //conta como iteracao
            }
            dados[++indice] = mao;
            super.iteracoes++; //conta como iteracao
        }

        return super.iteracoes;
    }
}
