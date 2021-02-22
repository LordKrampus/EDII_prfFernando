package execucao;
import tree.binaryTree.BinaryTree;

public class Binarytree_Teste {
    static BinaryTree bt;

    public static int[] encontrarNumerosPrimos(int size){
        int[] primos = new int[size];

        int valor = 2, i;
        boolean ehPrimo;
        int contagem = 0;
        while(contagem < size) {
            ehPrimo = true;
            for (i = (valor - 1); i > 1; i--) {
                if (valor % i == 0) {
                    ehPrimo = false;
                    break;
                }
            }

            if (ehPrimo)
                primos[contagem++] = valor;
            valor++;
        }

        return primos;
    }

    public static void main(String[] args){
        bt = new BinaryTree();

        int[] primos;
        //a) Que armazene os 1000 primeiros números primos.
        primos = encontrarNumerosPrimos(1000);
        for(int value: primos){
            bt.insert(value);
        }

        //b) Imprima a árvore em Pré-ordem, Em ordem e Pós-ordem.
        System.out.println("Pre:. \t" + bt.printPre());
        System.out.println("In:.  \t" + bt.printIn());
        System.out.println("Pos:. \t" + bt.printPos());

        //c) Remova o menor número primo no intervalo de uma centena.
        //(o menor de 0 a 99, depois o menor de 100 a 199, depois o menor de 200 a 299...)
        int size = bt.getSize();
        for(int i = 0; i < size; i += 100){
            bt.remove(primos[i]);
        }

        //d) Imprima a nova árvore em Pré-ordem, Em ordem e Pós-ordem.
        System.out.println("Pre:. \t" + bt.printPre());
        System.out.println("In:.  \t" + bt.printIn());
        System.out.println("Pos:. \t" + bt.printPos());
    }
}
