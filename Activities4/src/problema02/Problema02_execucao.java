package problema02;
import estruturas.ListaDuplamenteLigada;
import estruturas.Lista;
import pessoa.Personagem;

/*
 *Problemas propostos pelo professor:
 *  1) Adicione Homer e Marge na lista e depois imprima o resultado.
 *  2) Esvazie a lista e imprima.
 *  3) Adicione Homer na lista. Depois adicione Bart na posição 0 e Lisa na posição 1 e imprima a lista
 *  4) Esvazie a lista.
 *  5) Adicione Homer e Bart na lista e depois Adicione Lisa no início da lista. Imprima o resultado e o tamanho da lista.
 *  6) Esvazie a lista e imprima.
 *  7) Adicione Homer, Maggie na lista. Depois adicione Bart na posição 0 e Marge na posição 1 e imprima a lista. Verifique se Lisa está na lista.
 *  8) Esvazie a lista.
 *  9) Adicione Homer e Bart na lista e depois imprima o resultado e o tamanho da lista.
 *  10) Verifique se Marge, Homer, Bart e Maggie estão na lista e depois imprima o resultado e o tamanho da lista.
 *  11) Esvazie a lista.
 *  12) Adicione Homer e Bart no começo da lista. Depois adicione Marge, e depois Maggie na posição 1 e depois Stanley  no Começo da lista e Sr. Burns no Final da lista imprima a lista
 *  13) Remova do fim da lista e imprima a lista.
 *  14) Remova a posição 1, depois imprima a lista e o tamanho da lista.
 *  15) Verifique se Marge, Homer, Bart e Maggie estão na lista e depois imprima o resultado e o tamanho da lista.
 *  16) Remova do começo da lista, depois imprima a lista e o tamanho da lista.
 *  17) Verifique se Marge, Homer, Bart e Maggie na lista e depois imprima o resultado e o tamanho da lista.
 *  18) Esvazie a lista e imprima.
 */
public class Problema02_execucao {

    static ListaDuplamenteLigada lista;

    public static void main(String[] args) {
        lista = new ListaDuplamenteLigada();

        Personagem[] personagens = {new Personagem("Homer", "CPFHomer", 40),
            new Personagem("Marge", "CPFMarge", 34),
            new Personagem("Bart", "CPFBart", 10),
            new Personagem("Lisa", "CPFLisa", 8),
            new Personagem("Maggie", "CPFMaggie", 1),
            new Personagem("Stanley ", "CPFStanley ", 30),
            new Personagem("Sr. Burns", "CPFSr.Burns", 103),};
        
        //01
        System.out.println("\t1) Adicione Homer e Marge na lista e depois imprima o resultado.");
        lista.inserir(personagens[0]);
        lista.inserir(personagens[1]);
        imprimirLista(lista, false);
        
        System.out.println("\t2) Esvazie a lista e imprima.");
        lista.esvaziar();
        imprimirLista(lista, false);
        
        System.out.println("\t3) Adicione Homer na lista. Depois adicione Bart na posição 0(by 1) e Lisa na posição 1(by 2)"
                + " e imprima a lista");
        lista.inserir(personagens[0]);
        lista.inserirNoIndice(personagens[2], 1);
        lista.inserirNoIndice(personagens[3], 2);
        imprimirLista(lista, false);
        
        System.out.println("\t4) Esvazie a lista.");
        lista.esvaziar();
        imprimirLista(lista, false);
        
        System.out.println("\t5) Adicione Homer e Bart na lista e depois Adicione Lisa no início da lista."
                + " Imprima o resultado e o tamanho da lista.");
        lista.inserir(personagens[0]);
        lista.inserir(personagens[2]);
        lista.inserir(personagens[3]);
        imprimirLista(lista, true);
        
        System.out.println("\t6) Esvazie a lista e imprima.");
        lista.esvaziar();
        imprimirLista(lista, true);
        
        System.out.println("\t7) Adicione Homer, Maggie na lista. Depois adicione Bart na posição 0(by 1)"
                + " e Marge na posição 1(by 2) e imprima a lista. Verifique se Lisa está na lista.");
        lista.inserir(personagens[0]);
        lista.inserir(personagens[4]);
        lista.inserirNoIndice(personagens[2], 1);
        lista.inserirNoIndice(personagens[1], 2);
        imprimirLista(lista, true);
        try{
            lista.temElemento(personagens[3]);
        }catch(IndexOutOfBoundsException e){
            System.out.println( e.getMessage() + " - " + personagens[3].getNome() + " não está na lista...\n");
        }
        
        System.out.println("\t8) Esvazie a lista.");
        lista.esvaziar();
        imprimirLista(lista, false);
        
        System.out.println("\t9) Adicione Homer e Bart na lista e depois imprima o resultado e o tamanho da lista.");
        lista.inserir(personagens[0]);
        lista.inserir(personagens[2]);
        imprimirLista(lista, true);

        System.out.println("\t10) Verifique se Marge, Homer, Bart e Maggie estão na lista e depois imprima"
                + " o resultado e o tamanho da lista.");
        verificarNaLista(personagens[1]);
        verificarNaLista(personagens[0]);
        verificarNaLista(personagens[2]);
        verificarNaLista(personagens[4]);
        System.out.println("Tamanho da lista é " + lista.getTamanho() + "\n");
        
        System.out.println("\t11) Esvazie a lista.");
        lista.esvaziar();
        imprimirLista(lista, false);
        
        System.out.println("\t12) Adicione Homer e Bart no começo da lista. Depois adicione Marge,"
                + " e depois Maggie na posição 1(by 2) e depois Stanley  no Começo da lista e Sr. Burns no Final da lista"
                + " e imprima a lista");
        lista.inserir(personagens[0]);
        lista.inserir(personagens[2]);
        lista.inserir(personagens[1]);
        lista.inserirNoIndice(personagens[4], 2);
        lista.inserir(personagens[5]);
        lista.inserirFinal(personagens[6]);
        imprimirLista(lista, true);
        
        System.out.println("\t13) Remova do fim da lista e imprima a lista.");
        lista.removerFinal();
        imprimirLista(lista, true);
        
        System.out.println("\t14) Remova a posição 1(by 2), depois imprima a lista e o tamanho da lista.");
        lista.removerNoIndice(2);
        imprimirLista(lista, true);
        
        System.out.println("\t15) Verifique se Marge, Homer, Bart e Maggie estão na lista e depois imprima o resultado"
                + " e o tamanho da lista.");
        verificarNaLista(personagens[1]);
        verificarNaLista(personagens[0]);
        verificarNaLista(personagens[2]);
        verificarNaLista(personagens[4]);
        System.out.println("Tamanho da lista é " + lista.getTamanho() + "\n");
        
        System.out.println("\t16) Remova do começo da lista, depois imprima a lista e o tamanho da lista.");
        lista.remover();
        imprimirLista(lista, true);
        
        System.out.println("\t17) Verifique se Marge, Homer, Bart e Maggie na lista e depois imprima o resultado"
                + " e o tamanho da lista.");
        verificarNaLista(personagens[1]);
        verificarNaLista(personagens[0]);
        verificarNaLista(personagens[2]);
        verificarNaLista(personagens[4]);
        System.out.println("Tamanho da lista é " + lista.getTamanho() + "\n");
        
        System.out.println("\t18) Esvazie a lista e imprima.");
        lista.esvaziar();
        imprimirLista(lista, true);

    }
    
    
    public static void  abrirApresentarBloco(){
        System.out.println(".Lista\n..........................................................");
    }
    
    public static void fecharApresentarBloco(){
        System.out.println("..........................................................\n");
    }
    
    public static void imprimirLista(Lista lista, boolean completo){
        abrirApresentarBloco();
        try{
            lista.imprimirPersonagens();
        }catch(NullPointerException e){
            System.out.println("NULL - " + e.getMessage());
        }
        
        if(completo)
            System.out.println("Tamanho da lista:.. " + lista.getTamanho());
        
        fecharApresentarBloco();
    }
    
    public static void verificarNaLista(Personagem p){
        try{
            lista.temElemento(p);
            System.out.println("." + p.getNome() + " está na lista!");
        }catch(IndexOutOfBoundsException e){
            System.out.println("." + e.getMessage() + " - " + p.getNome() + " não está na lista...");
        }
    }
}
