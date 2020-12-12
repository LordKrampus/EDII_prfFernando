package problema02;

import estruturas.ListaDuplamenteLigada;
import pessoa.Paciente;

public class ListaDuplamenteLingada_teste {
    static ListaDuplamenteLigada lista;
    
    public static void main(String[] args){
        lista = new ListaDuplamenteLigada();
         
        Paciente p1 = new Paciente("First1 Last1", "CPF01", 11, 2);
        Paciente p2 = new Paciente("First2 Last2", "CPF02", 12, 1);
        Paciente p3 = new Paciente("First3 Last3", "CPF03", 13, 3);
        Paciente p4 = new Paciente("First4 Last4", "CPF04", 14, 2);
        Paciente p5 = new Paciente("First5 Last5", "CPF05", 15, 2);
        Paciente p6 = new Paciente("First6 Last6", "CPF06", 16, 1);
        Paciente p7 = new Paciente("First7 Last7", "CPF07", 17, 1);
        
        for(int i = 100; i < 110; i++){
            lista.inserir(new Paciente(String.format("First%d Last%d", i, i), "CPF" + i, i, 1));
        }
        System.out.println("addT + 110 -> 100");
        lista.imprimirPacientes();
        
        
        lista.inserirFinal(p1); 
        System.out.println("addF + p1");
        lista.imprimirPacientes();
        
        lista.inserirFinal(p2); 
        System.out.println("addF + p2");
        lista.imprimirPacientes();
        
        lista.inserirNoIndice(p3, 1); 
        System.out.println("add(1) + p3");
        lista.imprimirPacientes();
        
        lista.inserirNoIndice(p4, 3);
        System.out.println("add(3) + p4");
        lista.imprimirPacientes();
        
        lista.inserirNoIndice(p5, 15);
        System.out.println("add(15) + p5");
        lista.imprimirPacientes();
        
        lista.inserirNoIndice(p6, 15);
        System.out.println("add(15) + p6");
        lista.imprimirPacientes();
        
        lista.inserirNoIndice(p7, 20); // p7 vai pro final
        System.out.println("add(20) + p7");
        lista.imprimirPacientes();
     
        System.out.println("\nTestando integridade das ligações pela saida");
        lista.testarLigacoes();
        
        lista.remover();
        System.out.println("remov- - p3");
        lista.imprimirPacientes();
        
        lista.remover();
        System.out.println("remov- - p109");
        lista.imprimirPacientes();
        
        System.out.println("\nTestando integridade das ligações pela saida");
        lista.testarLigacoes();
        System.out.println(String.format("Tamanho lista é %d.", lista.getTamanho()));
        
        lista.esvaziar();
        try{
            lista.imprimirPacientes();
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
