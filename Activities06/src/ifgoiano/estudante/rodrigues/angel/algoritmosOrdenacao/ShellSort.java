package ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao;

public class ShellSort {
    public ShellSort(){}

    public static long realizar(Integer[] dados){
        long iteracoes = 0;

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
                    iteracoes++; //conta como iteracao
                }
                dados[(indice+h)] = mao;
                iteracoes++; //conta como iteracao
            }
        }

        return iteracoes;
    }
}
