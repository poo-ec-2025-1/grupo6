public class Plataforma
{
    public String nome;
    public int numero_de_denuncias = 0;
    public boolean reputacao;
    
    public boolean reputacao(){
        if(numero_de_denuncias >= 2){
            return reputacao = false;
        }
        return reputacao;
    }
    
    public void aviso_de_reputacao(){
        if(reputacao){
            System.out.println("Essa plataforma não recebeu mais do que 2 denúncias recentemente \n");    
        }
        else{
            System.out.println("A plataforma " + nome + " não é considerada um ambiente saudável por conta da quantidade de denúncias feitas \n");    
        }
    }
    
}