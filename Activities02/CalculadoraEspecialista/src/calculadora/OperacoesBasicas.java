package calculadora;

public interface OperacoesBasicas {
    long soma(long A, long B);
    long subtracao(long A, long B);
    long multiplicacao(long A, long B);
    long divisao(long A, long B)throws ArithmeticException;
}
