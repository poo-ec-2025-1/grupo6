# Exemplos de possíveis classes e códigos para o funcionamento de algumas funcionalidades da aplicação

No escopo do projeto, existem dois possíveis usuários: moderador e usuário comum. No exemplo em [Diagramas](secao4etapa1.md), o diagrama de classes relaciona esses dois usuários a uma classe mãe, usuário comum, que possui aplicações gerais, sem especificações para cada caso. E em linguagem java, alguns métodos poderiam ser codificados da seguinte forma: 

**Exemplo em JavaScript:

```java
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
```

Métodos e objetos possíveis para cada tipo de usuário. Moderador:
```java
public class Moderador extends Usuario
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
}
```
Usuário comum (visitante/denunciante):
```java
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
```
Plataforma:
```java
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
```

Melhorias que podem ser facilmente implementadas: integração com SceneBuilder para interface gráfica, mover o objeto "objetivo" para a classe Usuario pois ele é comum. Outros métodos possíveis para a classe Usuario_comum: fazerDenuncia(), lerDenuncias(), informacaoPlataforma() etc. Métodos possíveis para Moderador: banirUsuario(), cadastrarPlataforma(), gerirPlataforma(). Métodos possíveis para Plataforma: crimesComuns(), retratacoes() etc.

Abaixo, um exemplo de teste no main para mostrar uma rotina possível no sistema:

```java
public class Teste
{
    public static void main(String[] args){
        Usuario_comum usuario1 = new Usuario_comum();    
        usuario1.nome = "usuário";
        usuario1.categoria = "comum";
        usuario1.objetivo = "fazer denúncia";    
        usuario1.anonimato = "não";
        usuario1.senha = 1234;
        
        usuario1.criarUsuario("usuário", "comum", 1234);
        
        usuario1.entrar(usuario1.nome, usuario1.senha);
        
        if(usuario1.entrar(usuario1.nome, usuario1.senha)){
            usuario1.objetivo();
        } 
        
        Plataforma plataforma1 = new Plataforma();
        plataforma1.nome = "X";
        
        Crime crime1 = new Crime();
        crime1.tipo_de_crime = "estelionato";
        crime1.plataforma = "X";
        crime1.criarDenuncia(crime1.tipo_de_crime, crime1.plataforma);
        plataforma1.numero_de_denuncias++;
        
        Moderador moderador1 = new Moderador();    
        moderador1.nome = "moderador1";
        moderador1.categoria = "moderador";
        moderador1.objetivo = "aceitar denúncia";
        moderador1.senha = 5678;
        
        moderador1.entrar(moderador1.nome, moderador1.senha);
        
        if(moderador1.entrar(moderador1.nome, moderador1.senha)){
            moderador1.objetivo();
        } 
        
        System.out.println("Total de denúncias recebidas pelo moderador: " + moderador1.total_de_denuncias());
        
        Crime crime2 = new Crime();
        crime2.tipo_de_crime = "racismo";
        crime2.plataforma = "x";
        crime2.criarDenuncia(crime2.tipo_de_crime, crime2.plataforma);
        plataforma1.numero_de_denuncias++;
        
        moderador1.objetivo();
        
        System.out.println("Total de denúncias recebidas pelo moderador: "+ moderador1.total_de_denuncias());
        
        plataforma1.reputacao();
        plataforma1.aviso_de_reputacao();
    }
} 

```
