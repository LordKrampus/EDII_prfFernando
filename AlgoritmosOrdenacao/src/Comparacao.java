import java.io.*;

public class Comparacao {
    static StringBuilder builder;
    static BufferedReader reader;

    public static void main(String[] args) {
        String dados[][] = new String[15][4];

        dados[0][0] = "Algoritmos\t";
        dados[0][1] = "dadosI_ordenados.txt";
        dados[0][2] = "dadosII_ordenados.txt";
        dados[0][3] = "dadosIII_ordenados.txt";

        // Caso queira executar todos os algoritmos por aqui, basta evocar o método principal de cada classe java:
        //SelectionSort_Teste.main(args);
        //SelectionSort_Teste.main(args);
        //BubbleSort_Teste.main(args);
        //CombSort_Teste.main(args);

        //String path;
        try{
            String absolutePath = new File("").getAbsolutePath();

            apresentarEstrutura_3Arquivos_1Path(dados, 1, "InsertionSort", absolutePath + "\\src\\conjuntoDados\\ordenados\\byInsertionSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 2, "SelectionSort", absolutePath + "\\src\\conjuntoDados\\ordenados\\bySelectionSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 3, "BubbleSort", absolutePath + "\\src\\conjuntoDados\\ordenados\\byBubbleSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 4, "CombSort", absolutePath + "\\src\\conjuntoDados\\ordenados\\byCombSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 5, "QuickSort", absolutePath + "\\src\\conjuntoDados\\ordenados\\byQuickSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 6, "MergeSort", absolutePath + "\\src\\conjuntoDados\\ordenados\\byMergeSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 7, "ShellSort", absolutePath + "\\src\\conjuntoDados\\ordenados\\byShellSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 8, "BucketSort", absolutePath + "\\src\\conjuntoDados\\ordenados\\byBucketSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 9, "CocktailSort", absolutePath + "\\src\\conjuntoDados\\ordenados\\byCocktailSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 10, "CountingSort", absolutePath + "\\src\\conjuntoDados\\ordenados\\byCountingSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 11, "GnomeSort", absolutePath + "\\src\\conjuntoDados\\ordenados\\byGnomeSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 12, "HeapSort", absolutePath + "\\src\\conjuntoDados\\ordenados\\byHeapSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 13, "RadixSort", absolutePath + "\\src\\conjuntoDados\\ordenados\\byRadixSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 14, "TimSort", absolutePath + "\\src\\conjuntoDados\\ordenados\\byTimSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);
        }catch(IOException e){
            System.out.println(e.fillInStackTrace());
        }

        builder = new StringBuilder();
        for(int i = 0; i < dados.length; i++){
            for(int j = 0; j < dados[i].length; j++){
                builder.append(dados[i][j] + "\t");
                if(j < (dados[i].length - 1))
                    builder.append("");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    public static void apresentarEstrutura_3Arquivos_1Path(
            String[][] dados, int linha, String cabecalho, String path, String fileNameFirst,
            String fileNameSecond, String fileNameThird) throws IOException{
        dados[linha][0] = cabecalho;
        dados[linha][1] = separarDados(path + fileNameFirst);
        dados[linha][2] = separarDados(path + fileNameSecond);
        dados[linha][3] = separarDados(path + fileNameThird);
    }

    public static String separarDados(String path) throws IOException {
        String[] pedacosCabecalho;
        String linha;
        int length;

        reader = new BufferedReader(new FileReader(path.toLowerCase()));
        linha = reader.readLine().replace("\t", " ");
        pedacosCabecalho = linha.split(" ");
        reader.close();

        length = pedacosCabecalho.length;
        pedacosCabecalho[(length-1)] = pedacosCabecalho[(length-1)];
        pedacosCabecalho[(length-3)] = pedacosCabecalho[(length-3)];
        return pedacosCabecalho[(length-2)] + pedacosCabecalho[(length-1)] + "\t\t";
    }
}
