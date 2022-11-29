package algoritmosOrdenacao.algoritmos;

public class InsertionSort extends SortAlgorithm{
    @Override
    public long realizar(Integer[] dados){
        this.ordenar(dados, 0, dados.length);
        return super.iteracoes;
    }

    protected void ordenar(Integer[] dados, int inicio, int length){
        for(int i = inicio + 1; i < length; i++){ // se comparar i<= fim, pelo caso de usuario da função mandar o indice exato do fim, enfluencia em 2 s
            int mao = dados[i];

            int indice = i-1;
            while(indice > inicio - 1 && dados[indice] >= mao){
                dados[(indice+1)] = dados[indice--];
                super.iteracoes++; //conta como iteracao
            }
            dados[++indice] = mao;
            super.iteracoes++; //conta como iteracao
        }


    }
}
