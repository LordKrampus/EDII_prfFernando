package calculadoraespecialista;

import calculadora.CalculadoraBasica;
import calculadora.EnumOperacoesBasicas;
import meusConteiners.Pilha;
import calculadoraespecialista.EnumNotacoes;
import meusConteiners.ElementoNumerico;
import meusConteiners.ElementoOperacional;

public class CalculadoraEspecialista {

    private CalculadoraBasica cb;
    private Pilha expressao;
    private EnumNotacoes notacao;
    private long resultado;

    public CalculadoraEspecialista() {
        this.cb = new CalculadoraBasica();
        this.expressao = new Pilha();
        this.notacao = EnumNotacoes.INFIXA;
        this.resultado = 0;
    }

    public CalculadoraEspecialista(boolean another) {
        this.cb = new CalculadoraBasica();
        expressao = null;
        if (another) {
            this.notacao = EnumNotacoes.POSFIXA;
        } else {
            this.notacao = EnumNotacoes.PREFIXA;
        }
        this.expressao = null;
    }

    public long getResultado() {
        return this.resultado;
    }

    public Pilha getExpressao() {
        return this.expressao;
    }

    private boolean ehNumero(char valor) {
        return 47 < valor && valor < 58;
    }

    private boolean ehSimbolo(char valor) {
        return !ehNumero(valor);
    }

    //protected abstract void empilharNotacaoInfixa(String expressao); 
    private void empilharExpressaoRegra(Pilha pilha, int numero) {
        pilha.inserir((int) numero);
    }

    private void empilharExpressaoRegra(Pilha pilha, char operacao) {
        switch (operacao) {
            case '(':
                if (this.notacao != EnumNotacoes.INFIXA) {
                    pilha.inserir(EnumOperacoesBasicas.INDEFINIDA);
                }
                pilha.inserir(EnumOperacoesBasicas.PARENTESE_BEGUIN);
                break;
            case ')':
                if (this.notacao != EnumNotacoes.INFIXA) {
                    pilha.inserir(EnumOperacoesBasicas.INDEFINIDA);
                }
                pilha.inserir(EnumOperacoesBasicas.PARENTESE_END);
                break;
            case '+':
                pilha.inserir(EnumOperacoesBasicas.SOMA);
                break;
            case '-':
                pilha.inserir(EnumOperacoesBasicas.SUBTRACAO);
                break;
            case '*':
                pilha.inserir(EnumOperacoesBasicas.MULTIPLICACAO);
                break;
            case '/':
                pilha.inserir(EnumOperacoesBasicas.DIVISAO);
                break;
            default:
                pilha.inserir(EnumOperacoesBasicas.INDEFINIDA);
                break;
        }
    }

    private void empilharNotacao(String expressao) {
        char[] valores = expressao.toCharArray();
        for (char valor : valores) {
            if (this.ehNumero(valor)) {
                int numero = (int) Integer.parseInt(String.valueOf(valor));
                this.empilharExpressaoRegra(this.expressao, numero);
            } else {
                this.empilharExpressaoRegra(this.expressao, valor);
            }
        }
    }

    public long calcularOperacaoBasica(long a, long b, EnumOperacoesBasicas op) {
        if (op == EnumOperacoesBasicas.SOMA) {
            return cb.soma(a, b);
        } else if (op == EnumOperacoesBasicas.SUBTRACAO) {
            return cb.subtracao(a, b);
        } else if (op == EnumOperacoesBasicas.MULTIPLICACAO) {
            return cb.multiplicacao(a, b);
        } else if (op == EnumOperacoesBasicas.DIVISAO) {
            return cb.divisao(a, b);
        }
        return 0;
    }

    private long resolverNotacaoInfixa(Pilha pilha) {
        long a = 0, b = 0;
        EnumOperacoesBasicas op = EnumOperacoesBasicas.INDEFINIDA;
        boolean ehSegundoValor = false;

        while (!pilha.underflow()) {
            if (!ehSegundoValor) {
                if (pilha.topoEhNumero()) {
                    b = pilha.getTopoNumero();
                    pilha.retirar();
                } else {
                    if (pilha.getTopoOperacao() == EnumOperacoesBasicas.PARENTESE_END) {
                        pilha.retirar();
                        b = this.resolverNotacaoInfixa(pilha);
                    } else if (!pilha.topoEhNumero() && pilha.getTopoOperacao() == EnumOperacoesBasicas.PARENTESE_BEGUIN) {
                        pilha.retirar();
                        return b;
                    } else {
                        op = pilha.getTopoOperacao();
                        pilha.retirar();
                        ehSegundoValor = true;
                    }
                }
            } else if (ehSegundoValor) {
                if (pilha.topoEhNumero()) {
                    a = pilha.getTopoNumero();
                    pilha.retirar();
                    pilha.inserir(this.calcularOperacaoBasica(a, b, op));
                    //ehSegundoValor = false;
                } else {
                    if (pilha.getTopoOperacao() == EnumOperacoesBasicas.PARENTESE_END) {
                        pilha.retirar();
                        pilha.inserir(this.calcularOperacaoBasica(this.resolverNotacaoInfixa(pilha), b, op));
                    }
                }
                ehSegundoValor = false;
            }
        }
        pilha.inserir(b);

        try {
            return (long) pilha.getTopoNumero();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    private void calcularNotacaoInfixa(Pilha pilha) {
        if (pilha.underflow()) {
            return;
        }
        this.resultado = resolverNotacaoInfixa(pilha);
    }

    private long resolverNotacaoPosFixa(Pilha pilha) {
        long a = 0, b = 0;
        EnumOperacoesBasicas op = EnumOperacoesBasicas.INDEFINIDA;

        if (pilha.topoEhNumero()) {
            a = pilha.getTopoNumero(); // primeiro valor
            pilha.retirar();
            
            if (pilha.topoEhNumero()) {
                b = pilha.getTopoNumero(); // segundo valor
                pilha.retirar();
                
                if (pilha.topoEhNumero()) { // recursica, se b não precorre diretamente uma operação, b será o resultado inserido
                                            // na pilha representando esta função quando b precorre diretamente uma operacão
                    pilha.inserir(b);
                    resolverNotacaoPosFixa(pilha); //recursiva
                    b = pilha.getTopoNumero(); // b é restante da(s) suboperação(ões)
                    pilha.retirar();
                }
                if (!pilha.topoEhNumero()) { // se não tiver operacao, resultado é incorreto (0)
                    op = pilha.getTopoOperacao();
                    pilha.retirar();
                }
                //decisão final
                if (op != EnumOperacoesBasicas.INDEFINIDA) {
                    if (!pilha.underflow() && pilha.topoEhNumero()) { //tem valor e operacao consequente
                        pilha.inserir(calcularOperacaoBasica(a, b, op));
                        resolverNotacaoPosFixa(pilha);  // se tiver mais operações consequentes ao conjunto da primeira
                                                        //com outro(s) alguns(s) valor(es); recursiva
                    } else 
                        pilha.inserir(calcularOperacaoBasica(a, b, op)); // primeiro conjunto de operacoes concluido
                                                                         // e alocado valor resultado
                    return pilha.getTopoNumero(); // retorno de resultado; util se for a ultima operacao a feita
                }
            }
        }

        return 0;
    }

    private void calcularNotacaoPosFixa(Pilha pilha) {
        if (pilha.underflow()) {
            return;
        }
        this.resultado = resolverNotacaoPosFixa(pilha);
    }
    
    private long resolverNotacaoPreFixa(Pilha pilha) {
        long numero = 0;
        EnumOperacoesBasicas op = EnumOperacoesBasicas.INDEFINIDA;

        if (!pilha.underflow() && !pilha.topoEhNumero()) {
            op = pilha.getTopoOperacao();
            pilha.retirar();
        }
        if (!pilha.underflow() && pilha.topoEhNumero()) {
            numero = pilha.getTopoNumero();
            pilha.retirar();
        } else {
            numero = resolverNotacaoPreFixa(pilha);
        }

        if (op != EnumOperacoesBasicas.INDEFINIDA) {
            if (pilha.topoEhNumero()) {
                return this.calcularOperacaoBasica(resolverNotacaoPreFixa(pilha), numero, op);
            }
            pilha.inserir(resolverNotacaoPreFixa(pilha));
            return this.calcularOperacaoBasica(resolverNotacaoPreFixa(pilha), numero, op);
        } else {
            return numero;
        }
    }

    private void calcularNotacaoPreFixa(Pilha pilha) {
        if (pilha.underflow()) {
            return;
        }
        this.resultado = resolverNotacaoPreFixa(pilha);
    }

    public void calcular(String expressao) {
        this.expressao = new Pilha();

        //this.empilharNotacao(expressao);
        if (this.notacao.equals(EnumNotacoes.INFIXA)) {
            this.empilharNotacao(expressao);
            calcularNotacaoInfixa(this.expressao);
        } else if (this.notacao.equals(EnumNotacoes.POSFIXA)) {
            this.empilharNotacao(new StringBuilder(expressao).reverse().toString());
            calcularNotacaoPosFixa(this.expressao);
        } else {
            this.empilharNotacao(new StringBuilder(expressao).reverse().toString());
            calcularNotacaoPreFixa(this.expressao);
        }
    }

}
