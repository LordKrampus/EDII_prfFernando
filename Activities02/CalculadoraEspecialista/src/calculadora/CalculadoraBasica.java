package calculadora;

public class CalculadoraBasica implements OperacoesBasicas{
    private long A;
    private long B;
    private EnumOperacoesBasicas operation;
    
    public CalculadoraBasica(){
        this.A = 0;
        this.B = 0;
        this.operation = EnumOperacoesBasicas.INDEFINIDA;
    }

    public double getA() {
        return this.A;
    }

    public long getB() {
        return this.B;
    }

    public String toStringOperation() {
        return this.operation.getValor() + ": " + this.operation.name();
    }
    
    @Override
    public long soma(long A, long B) {
        this.A = A;
        this.B = B;
        this.operation = EnumOperacoesBasicas.SOMA;
        return (long)A + B;
    }
    
    @Override
    public long subtracao(long A, long B){
        this.A = A;
        this.B = B;
        this.operation = EnumOperacoesBasicas.SUBTRACAO;
        return (long)A - B;
    }
    
    @Override
    public long multiplicacao(long A, long B){
        this.A = A;
        this.B = B;
        this.operation = EnumOperacoesBasicas.MULTIPLICACAO;

        return (long)A * B;
    }
    
    @Override
    public long divisao(long A, long B)throws ArithmeticException{
        if(B == 0)
            throw new ArithmeticException("Error - Indefinição matemática (/ zero)");
        this.A = A;
        this.B = B;
        this.operation = EnumOperacoesBasicas.DIVISAO;

        return (long)A / B;
    }
}
