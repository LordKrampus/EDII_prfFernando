package ifgoiano.estudante.rodrigues.angel.controleDados.operacoes;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Gravacao {
    private BufferedWriter writer;
    private boolean novoArquivo;
    private String cabecalho;

    public Gravacao(Integer[] dados, String pathTo, String cabecalho) throws IOException, Exception {
        this.cabecalho = cabecalho;
        processarGravacao(dados, pathTo);
        this.novoArquivo = false;
    }

    public void processarGravacao(Integer[] dados, String pathTo)throws IOException, Exception{
        if(this.writer != null)
            this.interromperConexao();
        this.novoArquivo = true;
        this.writer = new BufferedWriter(new FileWriter(pathTo, false));

        this.fazerGravacao(dados);
    }

    public void interromperConexao() throws IOException{
        writer.close();
    }

    protected String formatarLinha(Integer[] dados){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < dados.length; i++) {
            sb.append(dados[i]);
            if(i < (dados.length - 1))
                sb.append(", ");
        }
        sb.append("]\n");
        return sb.toString();
    }

    public void fazerGravacao(Integer[] dados) throws IOException, Exception{
        if(dados == null) throw new Exception ("Conjunto vazio!");

        if(novoArquivo)
            writer.append(cabecalho + "\n");
        String linha;
        linha = this.formatarLinha(dados);
        writer.append(linha);
    }
}
