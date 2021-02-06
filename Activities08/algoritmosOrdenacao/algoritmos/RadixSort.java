package ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao.algoritmos;
import java.util.Vector;

//ainda não funciona
public class RadixSort extends SortAlgorithm{
    private int maiorElemento;
    private int menorElemento;

    @Override
    public long realizar(Integer[] dados){
        this.maiorElemento = dados[0];
        this.menorElemento = 0;

        // descobrir o maior elemento, e assim a maior quantidade de digitos
        for(int i = 0; i < dados.length; i++){
            if(dados[i] > this.maiorElemento)
                this.maiorElemento = dados[i];
            else if(dados[i] < 0 && dados[i] < this.menorElemento)
                this.menorElemento = dados[i];
        }
        int maxQtdDigitos = String.valueOf(
                (this.maiorElemento > -this.menorElemento?
                        this.maiorElemento: this.menorElemento)).length();

        this.ordenarLSD(dados, maxQtdDigitos);

        return super.iteracoes;
    }

    private void ordenarLSD(Integer[] dados, int maxQtdDigitos){
        int i;

        int iteracao = 1; //contagem, para voltas por quantidade de digitos do maior elemento
        while(iteracao <= maxQtdDigitos){
            int potencia = (int) Math.pow(10, iteracao);
            Vector<Integer>[] aux = new Vector[10];
            for(i = 0; i < 10; i++){
                aux[i] = new Vector<Integer>(); //inciciando o vetor de vetor dinamico "Vector<Integer>"
            }

            // distribuindo por digito da potencia no aux (Vector)
            for(i = 0; i < dados.length; i++){
                aux[((dados[i] - this.menorElemento)%potencia)/(potencia/10)].add(dados[i]);
                super.iteracoes++;
            }

            // ordenando pela valor do digito na potencia
            int indice = 0;
            for(i = 0; i < 10; i++){
                while(!aux[i].isEmpty()){
                    dados[indice++] = aux[i].remove(0);
                    super.iteracoes++;
                }
            }
            iteracao++;
        }
    }
}
