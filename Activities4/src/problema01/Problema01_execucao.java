package problema01;
import estruturas.Lista;
import java.util.Scanner;
import pessoa.Paciente;

/**
 * Na classe main:
 *  Instancie a lista ligada.
 *  Instancie 5 pacientes (P1 a P5) e preencha os dados.
 *  Adicione os pacientes na seguinte ordem: 
 *      - P1, P3, P5, P2, P4.
 *  Imprima os dados dos pacientes da lista.
 *  Remova um paciente da lista.
 *  Inclua um paciente P6 na terceira posição da lista, e P7 na segunda posição.
 *  Imprima os dados dos pacientes da lista.
 */
public class Problema01_execucao {
    static final Scanner reader = new Scanner(System.in);
    static Lista lista;
    
    public static void main(String[] args){
        //instanciando lista ligada
        lista = new Lista();
        
        Paciente p1;
        Paciente p2;
        Paciente p3;
        Paciente p4;
        Paciente p5;
        Paciente p6;
        Paciente p7;
        
        //Instanciando os cinco pacientes 
        p1 = new Paciente("First1 Last1", "CPF01", 11, 1);
        p2 = new Paciente("First2 Last2", "CPF02", 12, 2);
        p3 = new Paciente("First3 Last3", "CPF03", 13, 3);
        p4 = new Paciente("First4 Last4", "CPF04", 14, 1);
        p5 = new Paciente("First5 Last5", "CPF05", 15, 2);
        p6 = new Paciente("First6 Last6", "CPF06", 16, 3);
        p7 = new Paciente("First7 Last7", "CPF07", 17, 1);
        
        //adicionando pacientes na ordem específica
        lista.inserir(p1);
        lista.inserir(p3);
        lista.inserir(p5);
        lista.inserir(p2);
        lista.inserir(p4);
        
        // imprimindo os dados dos pacientes na lista
        lista.imprimirPacientes();
        
        // removendo um paciente da lista
        System.out.println("removido!" + lista.remover().toString());
        
        // adicionar em específico indice
        lista.inserirNoIndice(p6, 3);   
        lista.inserirNoIndice(p7, 2);   
        
        // imprimindo os dados dos pacientes na lista
        System.out.println();
        lista.imprimirPacientes();  
    }
}
