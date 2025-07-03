public class Usuario_comum extends Usuario
{
    public String objetivo;
    public String anonimato;
    public int denuncias_feitas = 0;
    
    public boolean anonimato(){
        if (anonimato == "sim"){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void objetivo(){
        if(objetivo == "ler conteúdo da plataforma"){
            System.out.println("Aviso: os conteúdos disponíveis na plataforma podem ser sensíveis \n");
        }
        if(objetivo == "fazer denúncia"){
            System.out.println("Aviso: sua denúncia será analisada e recusada ou aceita por um moderador \n");
        }
    }
}