package ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao.recursosFuncionais.controle;
import ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao.algoritmos.*;


public class SortAlgorithmsControl {
    private static long realizar(SortAlgorithm sa, Integer[] dados){
        return sa.realizar(dados);
    }

    public static long insertionSort(Integer[] dados){
        return realizar(new InsertionSort(), dados);
    }

    public static long selectionSort(Integer[] dados){
        return realizar(new SelectionSort(), dados);
    }

    public static long bubbleSort(Integer[] dados){
        return realizar(new BubbleSort(), dados);
    }

    public static long combSort(Integer[] dados){
        return realizar(new CombSort(), dados);
    }

    public static long mergeSort(Integer[] dados){
        return realizar(new MergeSort(), dados);
    }

    public static long quickSort(Integer[] dados){
        return realizar(new QuickSort(), dados);
    }

    public static long shellSort(Integer[] dados){
        return realizar(new ShellSort(), dados);
    }

    public static long heapSort(Integer[] dados){
        return realizar(new HeapSort(), dados);
    }

    public static long cocktailSort(Integer[] dados){
        return realizar(new CocktailSort(), dados);
    }

    public static long radixSort(Integer[] dados){
        return realizar(new RadixSort(), dados);
    }

    public static long countingSort(Integer[] dados){
        return realizar(new CountingSort(), dados);
    }

    public static long gnomeSort(Integer[] dados){
        return realizar(new GnomeSort(), dados);
    }
}
