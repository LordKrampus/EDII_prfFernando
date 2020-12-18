package ifgoiano.estudante.rodrigues.angel;

import java.io.*;

public class Comparacao {
    static StringBuilder builder;
    static BufferedReader reader;
    static String[][] dados;

    public static void main(String[] args) {
        String dados[][] = new String[5][4];

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

            dados[1][0] = "InsertionSort";
            path = absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\byInsertionSort\\" + dados[0][1];
            dados[1][1] = separarDados(path);
            path = absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\byInsertionSort\\" + dados[0][2];
            dados[1][2] = separarDados(path);
            path = absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\byInsertionSort\\" + dados[0][3];
            dados[1][3] = separarDados(path);

            dados[2][0] = "SelectionSort";
            path = absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\bySelectionSort\\" + dados[0][1];
            dados[2][1] = separarDados(path);
            path = absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\bySelectionSort\\" + dados[0][2];
            dados[2][2] = separarDados(path);
            path = absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\bySelectionSort\\" + dados[0][3];
            dados[2][3] = separarDados(path);

            dados[3][0] = "BubbleSort\t";
            path = absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\byBubbleSort\\" + dados[0][1];
            dados[3][1] = separarDados(path);
            path = absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\byBubbleSort\\" + dados[0][2];
            dados[3][2] = separarDados(path);
            path = absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\byBubbleSort\\" + dados[0][3];
            dados[3][3] = separarDados(path);

            dados[4][0] = "CombSort\t";
            path = absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\byCombSort\\" + dados[0][1];
            dados[4][1] = separarDados(path);
            path = absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\byCombSort\\" + dados[0][2];
            dados[4][2] = separarDados(path);
            path = absolutePath + "\\src\\ifgoiano\\estudante\\rodrigues\\angel\\conjuntoDados\\ordenados\\byCombSort\\" + dados[0][3];
            dados[4][3] = separarDados(path);
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

    public static String separarDados(String path) throws IOException {
        String[] pedacosCabecalho;
        String linha;
        int length;

        reader = new BufferedReader(new FileReader(path.toLowerCase()));
        linha = reader.readLine().replace("\t", " ");
        pedacosCabecalho = linha.split(" ");
        reader.close();

        length = pedacosCabecalho.length;
        pedacosCabecalho[(length-1)] = pedacosCabecalho[(length-1)].substring(1);
        pedacosCabecalho[(length-3)] = pedacosCabecalho[(length-3)].substring(1);
        return pedacosCabecalho[(length-1)] + ";" + pedacosCabecalho[(length-3)] + "\t\t";
    }
}
