package execucao;
import tree.binaryTreeAVL.BinaryTreeAVL;
import execucao.MarcadorTemporal;
import tree.binaryTreeAVL.BinaryTreeNodeAVL;

import javax.xml.transform.sax.SAXSource;
import java.util.ArrayList;
import java.util.Random;


public class Binarytree_Teste {
    static BinaryTreeAVL bt;
    static StringBuilder sb;
    static MarcadorTemporal mt;

    //Apresenta e remove elemento da arvore.
    //  Os elementos multiplos do valor em um intervalo são eliminados da arvore
    public static void removerMultiplo(int basico, int limite){
        sb = new StringBuilder("{");

        int i = basico;
        while(i <= limite){
            while(bt.hasElement(i)){
                sb.append(i + ",");

                mt.marcarInicio();
                bt.remove(i);
                mt.marcarFim();
            }
            i += basico;
        }
        System.out.println(sb.toString() + "}");
    }

    //Apresenta e remove elemento da arvore.
    //  Os elementos presentes no arranjo são eliminados da arvore.
    public static void removerEntre(int[] espaco){
        sb = new StringBuilder("primos : {");

        int length = espaco.length;
        for(int i = 0; i < length; i++){
            while(bt.hasElement(espaco[i])){
                sb.append(espaco[i] + ",");

                mt.marcarInicio();
                bt.remove(espaco[i]);
                mt.marcarFim();
            }
        }
        System.out.println(sb.toString() + "}");
    }

    public static void imprimir(BinaryTreeAVL bt){
        System.out.println("tree. ");
        System.out.println("Pre:. \t" + bt.printPre());
        System.out.println("In:.  \t" + bt.printIn());
        System.out.println("Pos:. \t" + bt.printPos());

        int height = bt.getHeight();
        System.out.println("total de nos: " + bt.getSize() +
                "\nalturaMax: " + height +
                "\nalturaMin: " + bt.calcMinHeight(bt.getRoot()) +
                "\nbalanceamento: " + bt.getBalance(height));
        System.out.println("Max Left:." + (int)(bt.calcHeight(bt.getRoot().leftBranch) + 1) +
                "Max Right:." + (int)(bt.calcHeight(bt.getRoot().rightBranch) + 1));
    }

    //retorna um número aletório entre o intervalo de A e B.
    public static int getRandBetween(int A, int B, BinaryTreeAVL bt){
        Random rand = new Random();

        int value;
        do {
            value = A + rand.nextInt((B + 1) - A);
        }while(bt.hasElement(value));

        return value;
    }

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
        bt = new BinaryTreeAVL();
        mt = new MarcadorTemporal();

        /*
        bt.insert(70);
        bt.insert(50);
        bt.insert(80);
        bt.insert(71);
        bt.insert(90);
        bt.insert(75);
        bt.remove(50);
        bt.remove(70);
        */

        /*
        bt.insert(2161);
        bt.insert(919);
        bt.insert(479);
        bt.insert(1607);
        bt.insert(4262);
        bt.insert(3673);
        bt.insert(9036);
        bt.insert(9025);
        bt.insert(5438);
        */

        /*
        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        //bt.insert(4);
        bt.insert(5);
        bt.insert(6);
        bt.insert(7);

        bt.insert(3);
        bt.insert(3);

        //bt.insert(8);
        //bt.insert(9);
*/


        /*
        bt.insert(15);
        bt.insert(27);
        bt.insert(49);
        bt.insert(10);
        bt.insert(8);
        bt.insert(67);
        bt.insert(59);
        bt.insert(9);
        bt.insert(13);
        bt.insert(20);
        bt.insert(14);
        imprimir(bt);

        bt.remove(15);
        imprimir(bt);
*/


        //    Criar uma árvore de inteiros com 5000 elementos criados aleatoriamente,
        //    com valores variando de 0 a 9999, e realize as seguintes operações:
        //    (A árvore deve estar balanceada antes de cada operação)
        int i;
        int valor;
        for (i = 0; i < 5000; i++) {
            valor = getRandBetween(0, 9999, bt);
            mt.marcarInicio();
            bt.insert(valor);
            mt.marcarFim();
            //imprimir(bt);
        }
        imprimir(bt);

        //problem
        System.out.println("\na) Verifique se os 10 primeiros números primos estão presentes." +
                " Imprima e Remova-os da árvore");
        int[] primos = encontrarNumerosPrimos(10);
        removerEntre(primos);
        imprimir(bt);


        //problem
        System.out.println("b) Verifique se os múltiplos de 5 estão presentes. Imprima e Remova-os da árvore");
        removerMultiplo(5, 9999);
        imprimir(bt);


        //problem
        System.out.println("c) Insira 100 números criados aleatoriamente na árvore e imprima a árvore em-ordem.");
        for (i = 0; i < 100; i++) {
            mt.marcarInicio();
            bt.insert(getRandBetween(0,9999, bt));
            mt.marcarFim();
        }
        imprimir(bt);


        //problem
        System.out.println("d) Verifique se os múltiplos de 5 e os 10 primeiros números primos estão presentes." +
                " Imprima e Remova-os da árvore.");
        removerEntre(primos);
        removerMultiplo(5, 9999);
        imprimir(bt);


        System.out.println("\n\n" +
                "Arvore AVL" +
                "\nSoma dos custos de tempo das operações conjuntas (ex., balancear e inserir):. " + mt.gerarCustoTotal() + "S");
        mt.zerarMarcadorTemporal();
    }
}
