package ifgoiano.estudante.rodrigues.angel.algoritmosOrdenacao.algoritmos;
import java.util.Vector;

//ainda não funciona
public class RadixSort extends SortAlgorithm{
    @Override
    public long realizar(Integer[] dados){
        int maiorElemento = dados[0];
        int menorElemento = 0;
        int length;

        int i;
        // descobrir o maior elemento, e assim a maior quantidade de digitos
        for(i = 0; i < dados.length; i++){
            if(dados[i] > maiorElemento)
                maiorElemento = dados[i];
            else if(dados[i] < 0 && dados[i] < menorElemento)
                menorElemento = dados[i];
        }
        length = this.calcularLength(maiorElemento, menorElemento);

        //https://pt.wikipedia.org/wiki/Radix_sort
        int maxDigit = String.join(String.valueOf(maiorElemento)).length();
        for(int digit = 0; digit < maxDigit; digit ++){
            int power = (int) Math.pow(10, digit+1);

            int z[][] = new int[dados.length][10];
            int n[] = new int[10];

            for( i = 0; i < dados.length; i++){
                int num = dados[i];
                z[n[((num - menorElemento)%power)/(power/10)]][((num - menorElemento)%power)/(power/10)] = num;
                n[((num - menorElemento)%power)/(power/10)]++;

            }
            int c = 0;
            for( i = 0; i < 10; i++){
                for(int j = 0; j < dados.length; j++){
                    if(j < n[i]){
                        dados[c] = z[j][i];
                        c++;
                    }else{break;}
                }
            }

        }

        return super.iteracoes;
    }

    /*
    @Override
    public long realizar(Integer[] dados){
        int maiorElemento = dados[0];
        int menorElemento = 0;
        int length;

        int i;
        // descobrir o maior elemento, e assim a maior quantidade de digitos
        for(i = 0; i < dados.length; i++){
            if(dados[i] > maiorElemento)
                maiorElemento = dados[i];
            else if(dados[i] < 0 && dados[i] < menorElemento)
                menorElemento = dados[i];
        }
        length = this.calcularLength(maiorElemento, menorElemento);

        int baseDigito = 10;
        while(maiorElemento / baseDigito > 0){
            //Vector<Vector<Integer>> distribuicao = new Vector<Vector<Integer>>(10);
            Vector<Integer>[] aux = new Vector[10];
            for(i = 0; i < 10; i++){
                aux[i] = new Vector<Integer>();
            }
            for (i = 0; i < dados.length; i++){
                int indice = ((dados[i] - menorElemento) % baseDigito);
                if (indice < 0){
                    indice = 0;
                }
                //aux[(dados[i] + length) % baseDigito].add(dados[i]);
                aux[indice].add(dados[i] - menorElemento);
            }
            int indice = 0;
            for (i = 0; i < 10; i++){
                int j = 0;
                while(!aux[i].isEmpty())
                    dados[indice++] = aux[i].elementAt(j++);
            }

            baseDigito *= 10;
        }


        return super.iteracoes;
    }
     */

    private int calcularLength(int indiceA, int indiceB){
        return (indiceA < 0? -indiceA + 1 : indiceA - indiceB + 1);
    }
}
