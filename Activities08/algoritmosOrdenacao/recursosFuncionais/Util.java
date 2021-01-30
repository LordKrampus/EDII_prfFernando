package ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao.recursosFuncionais;

public class Util {
    /**
     * Troca dois elementos num conjunto de dados, pelo reposicionamento cruzado de acordo
     * aos elementos dos indices involvidos (A e B)
     * @param dados o conjunto de dados (valores inteiros)
     * @param indiceFrom indice de troca A
     * @param indiceTo indice de troca B
     */
    public static void swap(Integer[] dados, int indiceFrom, int indiceTo){
        int aux = dados[indiceTo];
        dados[indiceTo] = dados[indiceFrom];
        dados[indiceFrom] = aux;

    }
}
