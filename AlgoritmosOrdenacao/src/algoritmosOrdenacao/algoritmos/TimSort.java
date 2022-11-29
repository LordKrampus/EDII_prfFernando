package algoritmosOrdenacao.algoritmos;

public class TimSort extends SortAlgorithm{
    private int minRun; // comprimento minimo dum subvetor.

    @Override
    public long realizar(Integer[] dados){
        minRun = calcularMinRun(dados);
        dividirEhCombinar(dados, 0, dados.length-1);

        return super.iteracoes;
    }

    private int calcularMinRun(Integer[] dados){
        int max = dados[0];
        int min = 0;
        // descobrir o maior elemento, e assim a maior quantidade de digitos
        for(int i = 0; i < dados.length; i++){
            if(dados[i] > max)
                max = dados[i];
            else if(dados[i] < 0 && dados[i] < min)
                min = dados[i];
        }
        int maxAbsoluto = String.valueOf(max > -min? max: min).length(); //qtd de digitos

        return (maxAbsoluto*8);
    }

    private void dividirEhCombinar(Integer[] dados, int inicio, int fim){
        if(fim - inicio > minRun) {
            int meio = (fim + inicio) / 2;
            dividirEhCombinar(dados, inicio, meio);
            dividirEhCombinar(dados, meio+1, fim);

            MergeSort ordenador = new MergeSort();
            ordenador.conquistar(dados, inicio, meio, fim);
        }else {
            InsertionSort ordenador = new InsertionSort();
            ordenador.ordenar(dados, inicio, fim + 1); // "+1" pelo length, insertionSort não itera até este, apená até antes deste.
        }
    }
}
