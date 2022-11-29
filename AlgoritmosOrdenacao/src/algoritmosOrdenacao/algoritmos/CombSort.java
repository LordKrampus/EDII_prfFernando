package algoritmosOrdenacao.algoritmos;

public class CombSort extends SortAlgorithm{
    private static final float FATOR = 1.247330950103979f;

    @Override
    public long realizar(Integer[] dados){
        boolean movimentou;
        int mao; //valor
        int maior; //indice
        int gap = dados.length;

        while(gap > 1) {
            gap /= FATOR;
            do {
                movimentou = false;
                maior = 0;
                for (int j = gap; j < dados.length; ) {
                    mao = dados[maior];
                    if (dados[maior] > dados[j]) {
                        dados[maior] = dados[j];
                        dados[j] = mao;
                        movimentou = true;
                    }
                    maior += gap;

                    if((j + gap) < dados.length){
                        j += gap;
                    }else
                        j = dados.length;
                    super.iteracoes++; //conta como iteracao
                }
            } while (movimentou);
        }

        return super.iteracoes;
    }
}
