package controleDados;
import controleDados.operacoes.Gravacao;
import controleDados.operacoes.Leitura;

import java.io.IOException;

public class ControleDados {
    private static ControleDados instance;
    private Leitura reader;
    private Gravacao recorder;

    private  ControleDados(){
    }

    /**
     * Pegar uma instancia de ControleDados
     * @return a instancia criada de ControleDados
     */
    public static ControleDados getInstance(){
        if(instance == null)
            instance = new ControleDados();
        return instance;
    }

    /**
     * Relacionar arquivo e fazer Leitura da primeira linha dos dados
     * @param path arquivo para a leitura
     * @throws IOException trabalhnando I/O
     * @throws Exception excessoes não muito bem tratadas
     */
    public void realizarLeitura(String path) throws IOException, Exception{
        this.reader = new Leitura(path);
    }

    /**
     * Fazer a leitura de uma proxima linha no mesmo arquivo, se houver
     * @throws IOException trabalhnando I/O
     * @throws Exception excessoes não muito bem tratadas
     */
    public void realizarLeitura() throws IOException, Exception{
        if(reader == null)
            throw new Exception("Arquivo não relacionado!");
        else this.reader.fazerLeitura();
    }

    /**
     * Apropriar leitura num conjunto de arranjo de valores Integers
     * @return Arranjo dosvalores dos dados do conjunto lido
     * @throws Exception excessões não muito bem tratadas
     */
    public Integer[] getArranjoDados() throws Exception{
        if(reader == null) throw new Exception("Leitura ainda não iniciada!");
        return reader.getArranjoDados();
    }

    /**
     * Libera reader e reinicia estádo não consumivel
     * @throws IOException trabalhnando I/O
     */
    public void fecharArquivoLeitura() throws IOException{
        this.reader.interromperConexao();
        reader = null;
    }

    /**
     * Realizar a gravação da ultima linha feita a leitura para um novo arquivo
     * @param dados lista representando a linha de conjunto dos dados
     * @param pathTo novo arquivo
     * @param cabecalho texto da primeira linha a ser inserido como cabecalho de informacoes importantes
     * @throws IOException trabalhnando I/O
     * @throws Exception excessoes não muito bem tratadas
     */
    public void realizarGravacao(Integer[] dados, String pathTo, String cabecalho) throws IOException, Exception{
        recorder = new Gravacao(dados, pathTo, cabecalho);
    }

    /**
     * Realizar a gravaação de uma proxima linha feita a leitura, ou da anterior já feita a gravação
     * @throws IOException trabalhnando I/O
     * @throws Exception excessoes não muito bem tratadas
     */
    public void realizarGravacao(Integer[] dados) throws IOException, Exception{
        if(recorder == null)
            throw new Exception("Arquivo não relacionado!");
        recorder.fazerGravacao(dados);
    }

    /**
     * Liberar recorder e reiniciar estádo não consumivel
     * @throws IOException trabalhnando I/O
     */
    public void fecharArquivoGravacao() throws IOException{
        this.recorder.interromperConexao();
        recorder = null;
    }

    //apesnas aproveitando um recurso de apresntacao
    public void apresentarArranjoDados(Integer[] dados){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < dados.length; i++) {
            sb.append(dados[i]);
            if(i < (dados.length - 1))
                sb.append(", ");
        }
        sb.append("]\n");
        System.out.println(sb.toString());
    }
}
