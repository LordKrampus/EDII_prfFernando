package algoritmosOrdenacao.algoritmos;

public class ShellSort extends SortAlgorithm{
    @Override
    public long realizar(Integer[] dados){
        int h = 1;
        do{
            h = 3*h + 1;
        }while(h < dados.length);

        while(h > 1){
            h /= 3;
            for(int i = h; i < dados.length; i++){
                int mao = dados[i];

                int indice = i - h;
                while(indice > -1 && dados[indice] >= mao){
                    dados[(indice+h)] = dados[indice];
                    indice -= h;
                    super.iteracoes++; //conta como iteracao
                }
                dados[(indice+h)] = mao;
                super.iteracoes++; //conta como iteracao
            }
        }

        return super.iteracoes;
    }
}
