package algoritmosOrdenacao.algoritmos;

import java.util.Vector;

/**
 * Dividir em Baldes (Buckets), um Array de vetor de dados dinamico, por algum fator em cima do numero de elementos
 * (determinante a quantidade de baldes), os elementos do Array de entrada; consequente, ordenalos pela chamada de
 * algum algoritmo de ordenação; e então fazer a distribuição ordenada no Array final dos elementos dop conjuntos
 * já ordenados de cada balde.
 */
public class BucketSort extends SortAlgorithm{
    private int maiorElemento;
    private int menorElemento;

    @Override
    public long realizar(Integer[] dados){
        this.maiorElemento = dados[0];
        this.menorElemento = 0;

        // descobrir o maior elemento, e assim a maior quantidade de digitos
        for(int i = 0; i < dados.length; i++){
            if(dados[i] > this.maiorElemento)
                this.maiorElemento = dados[i];
            else if(dados[i] < 0 && dados[i] < this.menorElemento)
                this.menorElemento = dados[i];
        }

        Vector<Integer>[] bucketsPositivos;
        Vector<Integer>[] bucketsNegativos;
        bucketsPositivos = distribuirPositivo(dados, this.maiorElemento);
        this.ordenar(bucketsPositivos);
        bucketsNegativos = distribuirNegativo(dados, -this.menorElemento);
        this.ordenar(bucketsNegativos);

        int i;
        int index = 0;
        for (i = bucketsNegativos.length-1; i >=0; i--){
            while(!bucketsNegativos[i].isEmpty()){
                dados[index++] = bucketsNegativos[i].remove(0);
                super.iteracoes++;
            }
        }
        for (i = 0; i < bucketsPositivos.length; i++){
            while(!bucketsPositivos[i].isEmpty()){
                dados[index++] = bucketsPositivos[i].remove(0);
                super.iteracoes++;
            }
        }

        return super.iteracoes;

    }

    private Vector<Integer>[]  distribuirPositivo(Integer[] dados, int maiorValor){
        int qtdBuckets = maiorValor/10;

        Vector<Integer>[] aux = new Vector[qtdBuckets];
        for(int i = 0; i < aux.length; i++) {
            aux[i] = new Vector<Integer>();
        }

        for (int i = 0; i < dados.length; i++) {
            int j = qtdBuckets-1;
            while (j >= 0){
                if(dados[i] >= (j*10)){
                    aux[j].add(dados[i]);
                    break;
                }
                j--;
            }
        }

        return aux;
    }

    private Vector<Integer>[]  distribuirNegativo(Integer[] dados, int maiorValor){
        int qtdBuckets = maiorValor/10;

        Vector<Integer>[] aux = new Vector[qtdBuckets];
        for(int i = 0; i < aux.length; i++) {
            aux[i] = new Vector<Integer>();
        }

        for(int i = 0; i < dados.length; i++) {
            int j = qtdBuckets-1;
            while (j >= 0){
                if(dados[i] < 0 && -dados[i] >= (j*10)){
                    aux[j].add(dados[i]);
                    break;
                }
                j--;
            }
        }

        return aux;
    }

    private void ordenar(Vector<Integer>[]  buckets){
        InsertionSort ordenador = new InsertionSort();
        Integer array[];
        // ordenando os elementos por baldes
        for (int i = 0; i < buckets.length; i++){
            array = new Integer[buckets[i].size()];
            array = buckets[i].toArray(array);
            ordenador.realizar(array);

            for(int j = 0; j < array.length; j++){
                buckets[i].set(j, array[j]);
            }
        }
    }
}
