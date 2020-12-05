package problema2;
import java.util.Scanner;
import java.util.Stack;
import java.text.DateFormat;
import java.time.LocalDateTime;

public class TorreHanoi {
   static Stack<Integer>[] pinos = new Stack[3];
   static Scanner reader = new Scanner(System.in);
   static int qtdOperacoes = 0;
   static long tempo = 0;
   
    public static void main(String[] args) {
        int qtdDiscos = reader.nextInt();
        
        for(int i = 0; i < 3; i++)
            pinos[i] = new Stack();
        
        for(int i = qtdDiscos; i > 0; i--){
            pinos[0].push(i);
        }
        
        System.out.println(pinos[0].toString());
        tempo = -System.currentTimeMillis();
        resolverTorreHanoi(qtdDiscos, 1, 3, 2);
        tempo += System.currentTimeMillis();
        
        System.out.println("QTD Operações:.. " + qtdOperacoes);
        System.out.println("Tempo de resolução:.. " + (float)tempo/1000 + "s");
    }
    
    // https://www.devmedia.com.br/torres-de-hanoi-solucao-recursiva-em-java/23738
    static void mover(int pinOrigem, int pinDestino) {
        pinos[pinDestino-1].push(pinos[pinOrigem-1].pop());
        qtdOperacoes++;
        
        System.out.println("->Operacao " + qtdOperacoes + ", de pino " + pinOrigem + " para " + pinDestino + "." +
                "\n\tPin1:" + pinos[0] +
                "\n\tPin2:" + pinos[1] +
                "\n\tPin3:" + pinos[2] + "\n");
    }
    
    // https://www.devmedia.com.br/torres-de-hanoi-solucao-recursiva-em-java/23738
    static void resolverTorreHanoi(int numDiscos, int pinOrigem, int pinDestino, int pinTrabalho) {
        if (numDiscos > 0) {
            resolverTorreHanoi(numDiscos - 1, pinOrigem, pinTrabalho, pinDestino);
            mover(pinOrigem, pinDestino);
            resolverTorreHanoi(numDiscos - 1, pinTrabalho, pinDestino, pinOrigem);
        }
    }

    // eeeeer... complicado em.
    public static void resolverTorre(int pino){   
        int mao;
        boolean teveTrocaPino = false;
        //for(int i = (pino - 1); i < 2; i++){
        
        mao = pinos[pino - 1].peek();
        for(int j = (pino - 1); j < 3; j++)
            if(pinos[j].isEmpty() || mao < pinos[j].peek()){
                mao = pinos[pino - 1].pop();
                pinos[j].push(mao);
                teveTrocaPino = true;
            }

        if(pino == 2 && !pinos[2].isEmpty() && pinos[2].peek() < pinos[pino-1].peek()){
                mao = pinos[pino-1].pop();
                pinos[0].push(mao);
        }
        if(!teveTrocaPino && pino == 2){
            pino = 3;
            for(int i = 0; i < 2; i++){
                if(!pinos[pino - 1].isEmpty() && pinos[pino - 1].peek() < pinos[i].peek()){
                    mao = pinos[pino - 1].pop();
                    pinos[i].push(mao);
                }
            }
        }
        

        System.out.println("Pin1:" + pinos[0] + " Pin2:" + pinos[1] + " Pin3:" + pinos[2] + "Pino" + pino);
        if(pino < 3)
            resolverTorre(++pino);
        else{
            resolverTorre(1);
        }     
    }   
}
