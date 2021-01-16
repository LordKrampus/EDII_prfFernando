package ifgoiano.estudante.rodrigues.angel;

import java.io.*;

public class Comparacao {
    static StringBuilder builder;
    static BufferedReader reader;

    public static void main(String[] args) {
        String dados[][] = new String[8][4];

        dados[0][0] = "Algoritmos\t";
        dados[0][1] = "dadosI_ordenados.txt";
        dados[0][2] = "dadosII_ordenados.txt";
        dados[0][3] = "dadosIII_ordenados.txt";

        //SelectionSort_Teste.main(args);
        //SelectionSort_Teste.main(args);
        //BubbleSort_Teste.main(args);
        //CombSort_Teste.main(args);

        String path;
        try{
            String absolutePath = new File("").getAbsolutePath();

            apresentarEstrutura_3Arquivos_1Path(dados, 1, "InsertionSort", absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\byInsertionSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 2, "SelectionSort", absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\bySelectionSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 3, "BubbleSort", absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\byBubbleSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 4, "CombSort", absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\byCombSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 5, "QuickSort", absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\byQuickSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 6, "MergeSort", absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\byMergeSort\\",
                    dados[0][1], dados[0][2], dados[0][3]);

            apresentarEstrutura_3Arquivos_1Path(dados, 7, "ShellSort", absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\byShellSort\\",
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
