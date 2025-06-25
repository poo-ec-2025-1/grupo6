Tentando deixar o projeto mais técnico e eficiente em termos de codificação, pensa-se em juntar elementos comuns para evitar de escrever a mesma coisa repetidamente, e no exemplo abaixo, agrupamos crimes da mesma natureza (hediondo) em uma interface, dessa forma, podemos usar métodos para informar os moderadores de denúncias que tenham mais grau de urgência: 

## Classe principal
```java
public class Crime{
    private String tipo;
    private String plataforma;
    private boolean hediondo;
    private int quant_crimes;
    
    public void criarCrime(String tipo, String plataforma, boolean hediondo){
        quant_crimes++;
        this.tipo = tipo;
        this.plataforma = plataforma;
        this.hediondo = hediondo;
        
        if(hediondo){
            System.out.println("Crime hediondo cadastrado com alta prioridade");
        }
        else{
            System.out.println("Crime cadastrado com sucesso");
        }
    }
    
}
```
## Interface

```java
public interface Crime_hediondo
{
         void prioridade(boolean hediondo);
}
```

## Exemplo de classe filha que pode herdar da classe principal e implementa a interface acima

```java
public class Genocidio extends Crime implements Crime_hediondo
{
        
        public void prioridade(boolean hediondo){
                System.out.println("Mensagem para moderador: esse crime foi classificado como hediondo. Proceder com alta prioridade na análise");
        }
}
```
A partir disso, pensa-se em outros modos de usar interfaces com o objetivo de alertar os moderadores acerca de prioridades ou até mesmo para facilitar a criação de tabelas no banco de dados: agrupar denúncias cujos tipos de postagem sejam parecidos, como crimes cometidos em lives, pois a rapidez para tratar dessas denúncias é essencial para impedir que as provas desapareçam. 
