package ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao;

public class BubbleSort {
    private BubbleSort(){}

    public static long realizar(Integer[] dados){
        long iteracoes = 0;

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
                iteracoes++; //conta como iteracao
            }
        }while(movimentou);

        return iteracoes;
    }
}
