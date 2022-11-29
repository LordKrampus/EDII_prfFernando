package algoritmosOrdenacao.algoritmos;

public class BubbleSort extends SortAlgorithm{
    @Override
    public long realizar(Integer[] dados){
        boolean movimentou;
        int mao; //valor
        int maior; //indice

        do{
            movimentou = false;
            maior = 0;
            for(int j = 1; j < dados.length; j++){
                mao = dados[maior];
                if(dados[maior] > dados[j]){
                    dados[maior] = dados[j];
                    dados[j] = mao;
                    movimentou = true;
                }
                maior++;
                super.iteracoes++; //conta como iteracao
            }
        }while(movimentou);

        return super.iteracoes;
    }
}
