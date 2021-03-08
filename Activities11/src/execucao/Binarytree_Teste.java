package execucao;
import tree.binaryTree.BinaryTree;
import tree.binaryTree.staticBalancing.AlgorithmicDSW;
import tree.binaryTree.staticBalancing.AlgorithmicVector;
import tree.binaryTree.staticBalancing.StaticBalancing_Interface;
import tree.binaryTree.utilities.Util;

import java.util.Random;
import java.util.Scanner;

public class Binarytree_Teste {
    static BinaryTree bt;
    static StringBuilder sb;
    static byte modoBanceamento;
    static MarcadorTemporal mt;

    public static StaticBalancing_Interface getModoInstancia(byte modo){
        if(modo == 1)
            return new AlgorithmicVector();// 1 ->  algoritmo do vector
        else
            return new AlgorithmicDSW(); // else -> algoritmo dsw
    }

    public static void balancear(StaticBalancing_Interface instance){
        instance.balance(bt);
    }

    //Apresenta e remove elemento da arvore.
    //  Os elementos multiplos do valor em um intervalo são eliminados da arvore
    public static void removerMultiplo(BinaryTree bt, int basico, int limite){
        sb = new StringBuilder("{");

        int i = basico;
        while(i <= limite){
            while(bt.hasElement(i)){
                sb.append(i + ",");
                //balanceando

                mt.marcarInicio();
                balancear(getModoInstancia(modoBanceamento));
                //removendo
                bt.remove(i);
                mt.marcarFim();
            }
            i += basico;
        }
        System.out.println(sb.toString() + "}");
    }

    //Apresenta e remove elemento da arvore.
    //  Os elementos presentes no arranjo são eliminados da arvore.
    public static void removerEntre(BinaryTree bt, int[] espaco){
        sb = new StringBuilder("primos : {");

        int length = espaco.length;
        for(int i = 0; i < length; i++){
            while(bt.hasElement(espaco[i])){
                sb.append(espaco[i] + ",");

                mt.marcarInicio();
                //balanceando
                balancear(getModoInstancia(modoBanceamento));
                //removendo
                bt.remove(espaco[i]);
                mt.marcarFim();
            }
        }
        System.out.println(sb.toString() + "}");
    }

    public static void imprimir(BinaryTree bt){
        System.out.println("tree. ");
        System.out.println("Pre:. \t" + bt.printPre());
        System.out.println("In:.  \t" + bt.printIn());
        System.out.println("Pos:. \t" + bt.printPos());

        int height = bt.getHeight();
        System.out.println("total de nos: " + bt.getSize() +
                "\naltura direita: " + Util.getHeight_rightBalance(bt) +
                "\naltura esquerda: " + Util.getHeight_leftBalance(bt) +
                "\nalturaMax: " + height +
                "\nalturaMin: " + bt.calcMinHeight(bt.getRoot()) +
                "\nbalanceamento: " + bt.getBalance(height));
    }

    //retorna um número aletório entre o intervalo de A e B.
    public static int getRandBetween(int A, int B, BinaryTree bt){
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

    public static void main(String[] args) {
        bt = new BinaryTree();
        modoBanceamento = new Scanner(System.in).nextByte();
        mt = new MarcadorTemporal();

        //    Criar uma árvore de inteiros com 5000 elementos criados aleatoriamente,
        //    com valores variando de 0 a 9999, e realize as seguintes operações:
        //    (A árvore deve estar balanceada antes de cada operação)
        int i;
        for (i = 0; i < 5000; i++) {
            mt.marcarInicio();
            //balanceando
            balancear(getModoInstancia(modoBanceamento));
            //inserindo
            bt.insert(getRandBetween(0, 9999, bt));
            mt.marcarFim();
        }
        imprimir(bt);


        //problem
        System.out.println("\na) Verifique se os 10 primeiros números primos estão presentes." +
                " Imprima e Remova-os da árvore");
        int[] primos = encontrarNumerosPrimos(10);
        removerEntre(bt, primos);
        imprimir(bt);


        //problem
        System.out.println("b) Verifique se os múltiplos de 5 estão presentes. Imprima e Remova-os da árvore");
        removerMultiplo(bt, 5, 9999);
        imprimir(bt);


        //problem
        System.out.println("c) Insira 100 números criados aleatoriamente na árvore e imprima a árvore em-ordem.");
        for (i = 0; i < 100; i++) {
            mt.marcarInicio();
            //balanceando
            balancear(getModoInstancia(modoBanceamento));
            //inserindo
            bt.insert(getRandBetween(0,9999, bt));
            mt.marcarFim();
        }
        imprimir(bt);


        //problem
        System.out.println("d) Verifique se os múltiplos de 5 e os 10 primeiros números primos estão presentes." +
                " Imprima e Remova-os da árvore.");
        removerEntre(bt, primos);
        removerMultiplo(bt, 5, 9999);
        imprimir(bt);

        balancear(getModoInstancia(modoBanceamento));
        imprimir(bt);

        System.out.println("\n\n" +
                (modoBanceamento == 1? "algoritmo do Vetor": "algoritmo DSW") +
                "\nSoma dos custos de tempo das operações conjuntas (ex., balancear e inserir):. " + mt.gerarCustoTotal() + "S");
    }
}
