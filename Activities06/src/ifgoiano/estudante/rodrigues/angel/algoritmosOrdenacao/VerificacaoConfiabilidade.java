package ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao;

public class VerificacaoConfiabilidade {
    private VerificacaoConfiabilidade(){}

    public static boolean verificarOrdenacao(Integer[] dados){
        for(int i = 0; i < (dados.length - 1); i++){
            if(dados[i] > dados[(i + 1)])
                return false;
        }
        return true;
    }
}
