public class Administrador extends Usuario implements Autenticavel
{
    public String objetivo;
    public int num_moderadores = 0;
    public int num_adm = 0;
    
    public void objetivo(){
        if(objetivo == "lista de moderadores"){
            System.out.println("Nome dos moderados: ");
        }
        if(objetivo == "adicionar moderador"){
            System.out.println("O usuário virou moderador");
            num_moderadores++;
        }
        if(objetivo == "remover moderador"){
            System.out.println("O usuário perdeu os direitos de moderador");
            num_moderadores--;
        }
        if(objetivo == "adicionar adm"){
            System.out.println("O usuário virou administrador");
            num_adm++;
        }
        if(objetivo == "remover adm"){
            System.out.println("O usuário perdeu os direitos de administrador");
            num_adm--;
        }
    }
    public boolean autentica(int senha) {
        if(this.senha != senha) {
            return false;
        }
        return true;
    }
}
