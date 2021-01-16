package ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao;

public class MergeSort {
    public static long  iterations = 0;

    public MergeSort(){
    }

    public static long realizar(Integer[] dados){
        dividirEhCombinar(dados, 0, dados.length-1);
        return iterations;
    }

    private static void dividirEhCombinar(Integer[] dados, int inicio, int fim){
        if(fim > inicio) {
            int meio = inicio + (fim - inicio) / 2;
            dividirEhCombinar(dados, inicio, meio);
            dividirEhCombinar(dados, meio+1, fim);

            conquistar(dados, inicio, meio, fim);
        }
    }

    private static void conquistar(Integer[] dados, int inicio, int meio, int fim){
        int []a = new int[(meio-inicio)+1];
        int []b = new int[(fim-meio)];

        int i;
        int j;
        int indiceAux = inicio;
        for(i = 0; i < a.length ; i++){
            a[i] = dados[indiceAux++];
        }
        indiceAux = meio + 1;
        for(j = 0; j < b.length; j++){
            b[j] = dados[indiceAux++];
        }

        i = 0; j = 0;
        indiceAux = inicio;
        while(i < a.length || j < b.length){
            if(i < a.length && j < b.length && a[i] <= b[j] || j >= b.length){
                dados[indiceAux++] = a[i++];
                iterations++;
            }else{
                dados[indiceAux++] = b[j++];
                iterations++;
            }
        }
    }
}
