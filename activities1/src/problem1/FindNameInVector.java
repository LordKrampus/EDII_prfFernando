package problem1;

import java.util.Vector;
import java.util.Scanner;

/**
 * Enunciado. Crie um aplicação em Java que armazene 5 nomes em um vetor e depois possa ser digitado um nome e,
 * se for encontrado, imprimir a posição desse nome no vetor, caso contrário imprimir a mensagem "Nome não encontrado".
 */
public class FindNameInVector {
    static final String names = "First1 Last1\n"
            + "First2 Last2\n"
            + "First3 Last3\n"
            + "First4 Last4\n"
            + "First5 Last5\n";
    static Scanner reader = new Scanner(names);

    public static void main(String[] args) {
        Vector<String> myNamesVector = new Vector(5); // Vetor de nomes
        storeNamesInSequence(myNamesVector, myNamesVector.capacity()); //tenta add Names com base no tamanho do vetor 

        //buscar Nome e devolver indice
        reader = new Scanner(System.in); // ler console
        String searchedName;
        int index; //indice do searchedName
        do{
            System.out.print("Buscar Nome: ");
            searchedName = reader.nextLine();
            try{
                index = searchNameInVector(myNamesVector, searchedName);
                System.out.println("Index: " + index);
            }catch(IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }while(!searchedName.toUpperCase().equals("SAIR"));
        
        System.out.println("\nNomes no vetor:");
        printAllNames(myNamesVector);
        
        reader.close();
    }
    
    static void storeNamesInSequence(Vector<String> namesVector, int length){
        //System.out.println("Insira " + length + " nomes (confirmando pos cada um com ENTER):");
        for(int i = 0; i < length; i++){
            namesVector.add(reader.nextLine().toUpperCase());
        }
    }
    
    static int searchNameInVector(Vector<String> namesVector, String name)throws IndexOutOfBoundsException{
        int index = namesVector.indexOf(name.toUpperCase()); //busca o objeto em valor do elemento (name equals elemento)
        if(index >= 0) 
            return index;
        throw new IndexOutOfBoundsException("Nome não encontrado!");
    }
    
    static void printAllNames(Vector<String> namesVector){
        for(String name: namesVector)
            System.out.println(name);
    }
}
