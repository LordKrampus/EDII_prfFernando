package ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao.algoritmos;

public class CountingSort extends SortAlgorithm{
    private int maiorElemento;
    private int menorElemento;
    private int length;

    @Override
    public long realizar(Integer[] dados){
        int []count;
        count = contar(dados);
        ordenar(dados, count);

        return super.iteracoes;
    }

    private int[] contar(Integer[] dados){
        this.maiorElemento = dados[0]; // também pode ser negativo; caso sim, não deve considerar menorElemento
        this.menorElemento = 0; // se não tiver elementos menores que zero

        int i;
        for(i = 0; i < dados.length; i++){
            if(dados[i] > maiorElemento)
                maiorElemento = dados[i];
            else if(dados[i] < 0 && dados[i] < menorElemento)
                menorElemento = dados[i];
        }

        this.calcularLength(this.maiorElemento, this.menorElemento);
        int []count = new int[length];

        for(i = 0; i < dados.length; i++){
            //int indice = dados[i] + menorElemento*(-1) --> count[indice]++;
            count[dados[i] - menorElemento]++;
            super.iteracoes++;
        }

        return count;
    }

    private void ordenar(Integer[] dados, int[] count){
        int indice = 0;
        for(int i = 0; i < length; i++){
            while (count[i] > 0){
                dados[indice++] = i + menorElemento;
                super.iteracoes++;
                count[i]--;
            }
        }
    }

    private void calcularLength(int indiceA, int indiceB){
        this.length = (indiceA < 0?
                -indiceA + 1 :
                indiceA - indiceB + 1);
    }
}
