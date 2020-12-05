package calculadoraespecialista;

public enum EnumNotacoes {
   INFIXA(1), POSFIXA(2), PREFIXA(3); 
   
   private final int notacao;
   EnumNotacoes(int notacao){
       this.notacao = notacao;
   }
   
   public int getNotacao(){
       return this.notacao;
   }
}
