package execucao;
import calculadoraespecialista.CalculadoraEspecialista;
import java.util.Scanner;
import meusConteiners.Pilha;

public class Calculadora_Teste {
    static Scanner reader = new Scanner(System.in);
    
    public static void main(String[] args){
        //**********************************************************
        /*
        CalculadoraBasica c1 = new CalculadoraBasica(); // funciona
        
        System.out.println("soma:           " + c1.soma(1, 5));
        System.out.println("subtracao:      " + c1.subtracao(1, 5));
        System.out.println("multiplicacao:  " + c1.multiplicacao(1, 5));
        try{
            System.out.println("divisao:        " + c1.divisao(10, 5));
            System.out.println("divisao:        " + c1.divisao(56, 0));
        }catch(ArithmeticException e){
            System.out.println(e.getMessage() + "|" + e.getStackTrace());
        }
        //System.out.println(1 / 0); 
        
        System.out.println(c1.toStringOperation());
        //*/
         
        //**********************************************************
        /*
        Pilha p1 = new Pilha();
        
        p1.inserir(1);
        p1.inserir(2);
        p1.inserir(3); 
        for(int i = 4; i < 10; i++)
            p1.inserir(i);
        //*/
        //**********************************************************
        /*
        //p1.retirar();
        for(int i = 0; i < 4; i++){
            p1.retirar();
            imprimirInformacaoPilha(p1);
        }
        imprimirInformacaoPilha(p1);
        //*/   
        
        //**********************************************************
        /*
        CalculadoraEspecialista ce1 = new CalculadoraEspecialista();
        ce1.calcular("1+3");
        System.out.println(ce1.getResultado());
        //*/
        
        String entrada = "";
        CalculadoraEspecialista ce1 = new CalculadoraEspecialista();
        OUTER:
        while (true) {
            System.out.println("\t(1) Sair\t(2) Trocar Notacao\t(3)Insirir Expressao");
            System.out.print(".escolha: ");
            entrada = reader.nextLine();
            switch (entrada) {
                case "1":
                    break OUTER;
                case "2":
                    System.out.println("\t(1) Infixa \t(2) PosFixa \t(3) Prefixa");
                    System.out.print(".escolha: ");
                    entrada = reader.nextLine();
                    
                    switch (entrada) {
                        case "2":
                            ce1 = new CalculadoraEspecialista(true);
                            break;
                        case "3":
                            ce1 = new CalculadoraEspecialista(false);
                            break;
                        default:
                            ce1 = new CalculadoraEspecialista();
                            break;
                    }
                    break;

                case "3":
                    System.out.print(".Expressao: ");
                    entrada = reader.nextLine();
                    
                    ce1.calcular(entrada);
                    System.out.print("Resultado: " + ce1.getResultado());
                    System.out.println();
                    break;
                default:
                    break;
            }
        }
       
    }
    
    public static void imprimirInformacaoPilha(Pilha pilha){
        System.out.println("\n............................");
        if(pilha.topoEhNumero())
            System.out.println("Topo..: " + pilha.getTopoNumero());
        else
             System.out.println("Topo..: " + pilha.getTopoOperacao());
        System.out.println("Size..: " + pilha.getSize());
        System.out.println("Pilha: " + pilha.imprimir());
        System.out.println("............................");
    }
    

}
