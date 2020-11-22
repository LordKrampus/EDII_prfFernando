package problem3;



public class Materia {
    private String[] alunos;
    private double[][] notasPorProva;
    private double[] medias;
    private boolean[] situacoes;
    private int qtdAlunos;
    
    public Materia(int numAlunos, int numProvas){
        this.alunos = new String[numAlunos];
        this.notasPorProva = new double[numProvas][numAlunos];
        this.medias = new double[numAlunos];
        this.situacoes = new boolean[numAlunos];
        for(boolean situacao: situacoes){
            situacao = false;
        }
        this.qtdAlunos = 0;
    }
    
    public String[] getAlunos(){
        return this.alunos;
    }
    
    public String getAluno(int numAluno){
        return this.alunos[numAluno];
    }
    
    public double[][] getNotasPorProva(){
        return this.notasPorProva;
    }
    
    public double[] getMedias(){
        return medias;
    }
    
    public boolean[] getSituacoes(){
        return situacoes;
    }
    
    public void addAluno(String nome){
        this.alunos[this.qtdAlunos] = nome;
        qtdAlunos++;
    }
    
    public int buscarNumAluno(String nome)throws Exception{
        int indice = 0;
        for(String aluno: this.alunos){
            if(aluno.equals(nome))
                return indice;
            indice++;
        }
        throw new Exception("Aluno não encontrado!");
    }
    
    public void addNotaAluno(int numAluno, int numProva, double nota)throws Exception{
        if(numAluno >= qtdAlunos)
            throw new Exception("Numero não ocupado!");
        this.notasPorProva[--numProva][numAluno] = nota;
    }
    
    public void calcularSituacaoAlunos(double razao){
        for(int i = 0; i < this.qtdAlunos; i++){
            this.medias[i] = (this.notasPorProva[0][i] + this.notasPorProva[1][i])/ 2f; 
            this.situacoes[i] = medias[i] >= razao;
        }
    }
    
    public String toStringAluno(int numAluno){
        return (String)"Aluno: " + this.alunos[numAluno] +
                "\t|Nota(P1): " +this.notasPorProva[0][numAluno] +
                "\t|Nota(P2): "+ this.notasPorProva[1][numAluno] +
                "\t|Media: " + this.medias[numAluno] +
                "\t|Situacao: " + (this.situacoes[numAluno]? "Aprovado" : "Reprovado");
    }
    
    @Override
    public String toString(){
        String apresentacao = "";
        for(int i = 0; i < qtdAlunos; i++)
            apresentacao += this.toStringAluno(i) + "\n";
        return apresentacao;
    }
}
