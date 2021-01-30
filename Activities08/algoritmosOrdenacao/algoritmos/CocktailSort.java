package ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao.algoritmos;

import ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao.recursosFuncionais.Util;

public class CocktailSort extends SortAlgorithm{
    @Override
    public long realizar(Integer[] dados){
        long iteracoes = 0;

        boolean movimentou;
        int maior; //indice
        do{
            int j;
            maior = 0;
            movimentou = false;
            for(j = 1; j < dados.length; j++){
                if(dados[maior] > dados[j]){
                    Util.swap(dados, maior, j);
                    movimentou = true;
                }
                maior++;
                iteracoes++;
            }
            if(!movimentou) break;

            maior = --j;
            movimentou = false;
            for(j = --j; j > -1; j--){
                if(dados[maior] < dados[j]){
                    Util.swap(dados, maior, j);
                    movimentou = true;
                }
                maior--;
                iteracoes++; //conta como iteracao
            }
        }while(movimentou);

        return iteracoes;
    }
}
