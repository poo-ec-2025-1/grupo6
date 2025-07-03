public class Moderador extends Usuario implements Autenticavel
{
    public String objetivo;
    public int denuncias_aceitas = 0;
    public int denuncias_recusadas= 0;
    
    public void objetivo(){
        if(objetivo == "aceitar denúncia"){
            System.out.println("Essa denúncia será publicada na plataforma e o denunciante informado \n");
            denuncias_aceitas++;
        }
        
        if(objetivo == "recusar denúncia"){
            System.out.println("Essa denúncia foi negada e o denunciante poderá fazer as mudanças solicitadas para o aceite \n");
            denuncias_recusadas++;
        }
    }
    public int total_de_denuncias(){
        return denuncias_aceitas + denuncias_recusadas;
    }
    
    public boolean autentica(int senha) {
        if(this.senha != senha) {
            return false;
        }
        return true;
    }
}