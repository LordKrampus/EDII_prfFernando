package ifgoiano.estudante.rodrigues.angel.execucao;
import ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao.recursosFuncionais.VerificacaoConfiabilidade;
import ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao.recursosFuncionais.controle.SortAlgorithmsControl;
import ifgoiano.estudante.rodrigues.angel.controleDados.ControleDados;
import java.io.File;
import java.io.IOException;

//  Ambos os algoritmos são relativamente iguais;
//  o que diferem-os são apesnas a direção dos arquivos e a função (metíodo duma classe) de ordenação utilizada.
public class BubbleSort_Teste {

    public static void main(String[] args){
        realizarOrdenacao("dadosI.txt", "dadosI_ordenados.txt");
        realizarOrdenacao("dadosII.txt", "dadosII_ordenados.txt");
        realizarOrdenacao("dadosIII.txt", "dadosIII_ordenados.txt");
    }

    public static void realizarOrdenacao(String nomeFrom, String nomeTo){
        String absolutePath = new File("").getAbsolutePath();
        String pathFrom = absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\" + nomeFrom;
        String pathTo = absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\byBubbleSort\\" + nomeTo;
        Integer[] dados;
        double timer;
        long numMovimentos;

        ControleDados cd = ControleDados.getInstance();
        try {
            cd.realizarLeitura(pathFrom); // já distribui por filtro os dados na estrutura de Dados
            dados = cd.getArranjoDados();

            System.out.println(".Ordenando de: \"" + pathFrom + "\";\n   para: \"" + pathTo + "\".");
            timer = -System.currentTimeMillis(); // marcador de tempo iniciado
            numMovimentos = SortAlgorithmsControl.bubbleSort(dados); // sorting
            timer += System.currentTimeMillis(); // marcador de tempo definido
            System.out.println("\t.Tempo gasto: " + (float)timer/1000f + "\n\t.Tamanho do conjunto: " + dados.length);

            String resultado = (VerificacaoConfiabilidade.verificarOrdenacao(dados)?
                    "Dados Ordenados - Sucesso!" : "Falha na Ordenção - Insucesso!");
            System.out.println(resultado);

            String cabecalho = "Ferreira, Angel Rodrigues - angel.rodrigues@estudante.ifgoiano.edu.br\t." +
                    "(" + resultado + ") BubbleSort " +
                    numMovimentos + "iteracoes; " + (float)timer/1000f + "s";
            cd.realizarGravacao(dados, pathTo, cabecalho);

            cd.fecharArquivoLeitura();
            cd.fecharArquivoGravacao();
        }catch(IOException e){
            System.out.println(e.fillInStackTrace());
        }catch(Exception e){
            System.out.println(e.fillInStackTrace());
        }
    }
}
