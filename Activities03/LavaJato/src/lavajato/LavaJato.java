package lavajato;
import estruturas.FilaDeVeiculo;
import java.util.InputMismatchException;
import java.util.Scanner;
import lavajato.GerenciamentoFila;
import veiculos.Caminhao;
import veiculos.Carro;
import veiculos.Moto;
import veiculos.Veiculo;

public class LavaJato {
    static Scanner reader = new Scanner(System.in);
    static GerenciamentoFila numIdentificacao;
    static FilaDeVeiculo fila;
    static FilaDeVeiculo concluidos;
    
    public static void main(String[] args){
        fila = new FilaDeVeiculo();
        concluidos = new FilaDeVeiculo();
        numIdentificacao = new GerenciamentoFila();
        
        int escolha = 0;
        do{
            System.out.println("(1)Novo Veiculo    (2)Verificar Fila    (3)Verificar Concluidos     (4)Encerrar Espedicao   (0)sair");
            try{
                escolha = reader.nextInt();
            }catch(InputMismatchException e){
                System.out.println(e.fillInStackTrace() + " - Valor de entrada não esperado!");
                escolha = -1;
            }
            
            reader.nextLine();
            switch(escolha){
                case 1:
                    abrirApresentacao("Inserir Veiculo");
                    try{
                        inserirVeiculoFila();
                    }catch(InputMismatchException e){
                        System.out.println(e.fillInStackTrace() + " - Valor de entrada não esperado!");
                    }catch(IllegalArgumentException e){
                        System.out.println(e.fillInStackTrace());
                    }
                    fecharApresentacao();
                    break;
                case 2:
                    verificarFila();
                    break;
                case 3:
                    verificarConcluidos();
                    break;
                case 4:
                    abrirApresentacao("Encerrar Espedicao");
                    concluirFila();
                    fecharApresentacao();
                    break;
                default:
                    break;
            }
            System.out.println("tecle para continuar...");
            reader.nextLine();
        }while(escolha != 0);    
    }
    
    public static void abrirApresentacao(){
        System.out.println("\n....................................................................");
    }
    
    public static void abrirApresentacao(String topico){
        System.out.print("\n" + topico);
        abrirApresentacao();
    }
    
    public static void fecharApresentacao(){
        System.out.println("....................................................................\n");
    }
    
    public static void inserirVeiculoFila() throws InputMismatchException, IllegalArgumentException{
        String tipo, marca, modelo, cor;
        int numero, ano;
        
        // solicitando dados
        System.out.println(".Dados do Veiculo");
        System.out.print("\tTipo: ");
        tipo = reader.nextLine().toUpperCase();
        System.out.print("\tMarca: ");
        marca = reader.nextLine();
        System.out.print("\tModelo: ");
        modelo = reader.nextLine();
        System.out.print("\tcor: ");
        cor = reader.nextLine();
        System.out.print("\tAno: ");
        
       try{
        ano = reader.nextInt();
       }catch(InputMismatchException e){
           throw e;
       }
        numero = numIdentificacao.gerarNumero(); // gerar numero de identificacao
        
        //criar objeto específico
        Veiculo veiculoNovo;
        switch (tipo) {
            case "CARRO":
                veiculoNovo = new Carro(numero, marca, modelo, cor, ano);
                break;
            case "MOTO":
                veiculoNovo = new Moto(numero, marca, modelo, cor, ano);
                break;
            case "CAMINHAO":
                veiculoNovo = new Caminhao(numero, marca, modelo, cor, ano);
                break;
            default:
                throw new IllegalArgumentException("Tipo de Veiculo Invalido!");
        }
        fila.add(veiculoNovo); // adicionando veiculo específico para armazenamento como geral
        
        if(fila.getSize() < 3) return;
        
        concluirVeiculo(fila.remover()); // a cada 3 um sai
    }
    
    public static void verificarFila(){
        if(fila.estaVazia()) return;
        abrirApresentacao("Veiculos Na Fila");  
        System.out.println(fila.toStringDadosVeiculos()); // toString na fila
        fecharApresentacao();
    }
    
    public static void verificarConcluidos(){
        if(concluidos.estaVazia()) return;
        abrirApresentacao("Veiculos Concluidos");        
        System.out.println(concluidos.toStringDadosVeiculos()); // toString concluidos
        fecharApresentacao();
    }
    
    /*
     * Ezvazia fila pendente removendo veiculos.
    */
    public static void concluirFila(){
        if(fila.estaVazia()) return;
        
        int length = fila.getSize();
        for(int i = 0; i < length; i++){
            concluirVeiculo(fila.remover()); // liverando veiculos
        }
    }
    
    public static void concluirVeiculo(Veiculo veiculo){
        concluidos.add(veiculo);
    }
}
