package problema01;


import estruturas.Lista;
import pessoa.Paciente;

public class Lista_teste {

    public static void main(String[] args) {
        Paciente p1 = null;
        Paciente p2 = null;
        Paciente p3 = null;
        try{
            p1 = new Paciente("nome1", "cpf1", 1, 1);
            p2 = new Paciente("nome2", "cpf2", 2, 1);
            p3 = new Paciente("nome3", "cpf3", 3, 1);
            System.out.println(p1.getPrioridade());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        
        Lista l1 = new Lista();
        try{
            for(int i = 0; i < 10; i++){
                l1.inserir(new Paciente("nome" + i, "cpf" + i, i, 1));
            }
            for(int i = 10; i < 15; i++){
                l1.inserirFinal(new Paciente("nome" + i, "cpf" + i, i, 1));
            }
            l1.imprimirPacientes();
            System.out.println(l1.getTamanho());
            
            Paciente pe = (Paciente)l1.getElemento(12); //successful
            System.out.println(pe.getNome());
            
            l1.remover();
            l1.remover();
            l1.imprimirPacientes();
            System.out.println(l1.getTamanho());
            
            l1.inserir(p1);
            l1.inserir(p2);
            l1.inserir(p3);
            l1.imprimirPacientes();
            System.out.println(l1.getElemento(5));
            System.out.println(l1.temElemento(p3)); //Ok
            Paciente temp = (Paciente)l1.getElemento(1); 
            System.out.println(temp.getNome());
            
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
    
}
