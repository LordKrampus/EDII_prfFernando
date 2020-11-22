package problem3;


import java.util.Scanner;
import problem3.TesteMateria;

/**
 * Enunciado. Criar uma aplicação em JAVA que armazene o nome de 5 alunos em um vetor e em outro vetor (ou matriz)
 * as notas da Prova1 e Prova2. Calcular a média, armazenar também a situação do aluno AP (aprovado) ou
 * RP (reprovado). Imprimir um listagem com o nome, notas, médias e situação de cada aluno.
 */
public class TesteMateria {
    static final int QTD_ALUNOS = 5;
    static final String names = "First1 Last1\n"
            + "First2 Last2\n"
            + "First3 Last3\n"
            + "First4 Last4\n"
            + "First5 Last5\n";
    static Scanner reader = new Scanner(names); 
    
    public static void main(String[] args){
        Materia m1 = new Materia(QTD_ALUNOS, 2);
        
        for(int i = 0; i < QTD_ALUNOS; i++){
            m1.addAluno(reader.nextLine());
        }
        System.out.println("Alunos Inseridos...");
        
        reader = new Scanner(System.in); 
        reader.nextLine();
        for(int i = 0; i < QTD_ALUNOS; i++){
            System.out.println("Aluno " + m1.getAluno(i));
            try{
                System.out.print("\tP1: ");
                m1.addNotaAluno(i, 1, (double)reader.nextDouble());
                System.out.print("\tP2: ");
                m1.addNotaAluno(i, 2, (double)reader.nextDouble());
            }catch(Exception e){
                System.out.println(e);
            }
        }
        System.out.println("\nNotas Inseridas...");
        
        m1.calcularSituacaoAlunos(6f);
        System.out.println("\nMedia e Situacao Calculadas...");
        
        System.out.println(m1.toString());
        
        /*
        m1.addAluno("Angel");
        try{
            m1.addNotaAluno(m1.buscarNumAluno("Angel"), 0, 0);
        }catch(Exception e){
            System.out.println(e);
        }
        */
    }
}
