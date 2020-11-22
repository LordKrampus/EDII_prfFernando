package problem2;

import problem2.MyNumbersVector;

/**
 * Enunciado. Crie uma aplicação em Java para armazenar 15 números em um vetor e imprimr:
 *  a) O vetor em ordem crescente
 *  b) O vetor em ordem decrescente
 *  c) Os números pares e a sua soma
 *  d) Os números Impares e seu produto
 */
public class TestMyNumbersVector {
    static final int LIMITE = 15;
    
    public static void main(String[] args){
        MyNumbersVector n = new MyNumbersVector(LIMITE); // Classe de vetor propria
        
        for(int i = 1; i <= LIMITE; i++)
            n.add(i); // adicionando cada valor de um ao limite
        
        System.out.print("Vetor em ordem crescente:   ");
        n.printAscending();
        System.out.print("\nVetor em ordem decrescente: ");
        n.printDescending();
        
        System.out.print("\nNumeros pares:   ");
        for(int number: n.getEvenNumbers())
            System.out.print(number + " ");
        System.out.print("\nSoma numeros pares: " + n.sumEvenNumbers());
        
        System.out.print("\nNumeros impares: ");
        for(int number: n.getOddNumbers())
            System.out.print(number + " ");
        System.out.print("\nProduto numeros impares: " + n.productOddNumbers());
        System.out.println();
    }
}
