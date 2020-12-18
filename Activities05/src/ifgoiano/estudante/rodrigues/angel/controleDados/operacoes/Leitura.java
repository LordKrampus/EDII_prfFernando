package ifgoiano.estudante.rodrigues.angel.controleDados.operacoes;

import ifgoiano.estudante.rodrigues.angel.controleDados.estruturas.Dados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Leitura {
    private BufferedReader reader;
    private Dados dados;
    private boolean novaLinha;

    public Leitura(String path) throws IOException, Exception {
        //this.reader = new BufferedReader(new FileReader(path.toLowerCase()));
        //this.novaLinha = false;
        this.processarArquivo(path);
        this.novaLinha = true;
    }

    public void processarArquivo(String path)throws IOException, Exception{
        if(reader != null)
            this.interromperConexao(); // libera
        this.novaLinha = false;
        this.reader = new BufferedReader(new FileReader(path.toLowerCase())); // reocupa

        this.fazerLeitura();
    }

    public void interromperConexao() throws IOException{
        reader.close();
    }

    public Dados getDados(){
        return this.dados;
    }

    public Integer[] getArranjoDados(){
        return this.dados.getDados().toArray(new Integer[this.dados.getDados().size()]); // ArrayLista.toArray(Integer[length])
    }

    private Dados filtrarParaDados(String linha){
        Dados valores = new Dados();

        String[] dados = null;
        linha = linha.replace(" ", ""); //liberando caracteres de " "(espaço)
        dados = linha.split(","); //compondo o vetor separando elementos a cada virgula
        if(dados[0].startsWith("["))
            dados[0] = dados[0].replace("[", ""); //liberando caractere de "["(espaço)
        if(dados[(dados.length - 1)].endsWith("]"))
            dados[(dados.length - 1)] = dados[(dados.length - 1)].replace("]", ""); //liberando caractere de "]"(espaço)

        for(int i = 0; i < dados.length; i++)
            valores.inserir(Integer.parseInt(dados[i]));
        return valores;
    }

    public void fazerLeitura() throws IOException, Exception{
        if(!reader.ready())
            throw new Exception("Não encontrados mais dados!");
        String linha;

        if(!novaLinha)
            this.reader.readLine(); //libera primeira linha
        linha = this.reader.readLine(); //faz leitura da linha de caracteres e valores

        this.dados = this.filtrarParaDados(linha);
    }
}
