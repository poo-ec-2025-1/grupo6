public class Usuario
{
    String nome;
    String categoria;
    int senha;
    
    public void criarUsuario(String nome, String categoria, int senha){
        this.nome = nome;
        this.categoria = categoria;
        this.senha = senha;
        System.out.println("Usuário " + this.categoria + " criado \n");
    }
    
    public boolean entrar(String nome, int senha){
        if(this.nome == nome && this.senha == senha){
            return true;
        }
        else{
            return false;
        }
    }
}