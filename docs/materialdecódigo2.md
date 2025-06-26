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
A partir disso, pensa-se em outros modos de usar interfaces com o objetivo de alertar os moderadores acerca de prioridades ou até mesmo para facilitar a criação de tabelas no banco de dados: agrupar denúncias cujos tipos de postagem sejam parecidos, como crimes cometidos em lives, pois a rapidez para tratar dessas denúncias é essencial para impedir que as provas desapareçam. Na seção [modelagem inicial, diagrama de classes, diagramas de sequência, casos de uso, etc.](secao4etapa2.md) encontra-se o diagrama de classes que exemplifica o uso de interfaces no projeto.

Outra preocupação importante é o armazenamento das informações geradas pelos denunciantes e moderadores, tendo em vista que uma das funcionalidades da aplicação é a consulta a denúncias feitas, assim como informações sobre a conduta das plataformas/redes sociais comm base nessas mesmas denúncias, logo, ter um banco de dados é essencial. Para exemplificar, utiliza-se três classes básicas, a primeira, Database, conecta com o banco de dados, a segunda, Crime, onde se instancia os objetos, e a terceira, CrimeRepository, que intermedia o contato entre as duas classes anteriores:

## Database

```java
import java.sql.*;
import com.j256.ormlite.jdbc.JdbcConnectionSource;

public class Database
{
   private String databaseName = null;
   private JdbcConnectionSource connection = null;
   
   public Database(String databaseName) {
       this.databaseName = databaseName;
   }    
   
   public JdbcConnectionSource getConnection() throws SQLException {
      if ( databaseName == null ) {
          throw new SQLException("database name is null");
      }
      if ( connection == null ) {
          try {
              connection = new JdbcConnectionSource("jdbc:sqlite:"+databaseName);             
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("Opened database successfully");
      }
      return connection;
   }
   
   public void close() {
       if ( connection != null ) {
           try {
               connection.close();
               this.connection = null;
           } catch (java.lang.Exception e) {
               System.err.println(e);
           }
       }
   }
}
```

## Classe modelo

```java
import java.util.Date;
import java.text.SimpleDateFormat;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;

@DatabaseTable(tableName = "crime")
public class Crime
{   
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField
    private String tipo;
    
    @DatabaseField
    public String platforma;
    
    @DatabaseField(dataType=DataType.DATE)
    public Date data;    
    
    public String printDate() {
      SimpleDateFormat dateFor = new SimpleDateFormat("dd/MM/yyyy");
        return dateFor.format(data);
    }

//Start GetterSetterExtension Source Code

    /**GET Method Propertie id*/
    public int getId(){
        return this.id;
    }//end method getId

    /**SET Method Propertie id*/
    public void setId(int id){
        this.id = id;
    }//end method setId

    /**GET Method Propertie type*/
    public String getType(){
        return this.tipo;
    }//end method getType

    /**SET Method Propertie type*/
    public void setType(String type){
        this.tipo = tipo;
    }//end method setType

    /**GET Method Propertie platform*/
    public String getPlatform(){
        return this.platforma;
    }//end method getPlatform

    /**SET Method Propertie platform*/
    public void setPlatform(String platform){
        this.platforma = platforma;
    }//end method setPlatform

     /**GET Method Propertie date*/
    public Date getDate(){
        return this.data;
    }//end method getDate

    /**SET Method Propertie date*/
    public void setDate(Date date){
        this.data = date;
    }//end method setDate

//End GetterSetterExtension Source Code


}//End class
```
## Classe Repository

```java
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class CrimeRepository
{
    private static Database database;
    private static Dao<Crime, Integer> dao;
    private List<Crime> loadedCrimes;
    private Crime loadedCrime; 
    
    public CrimeRepository(Database database) {
        CrimeRepository.setDatabase(database);
        loadedCrimes = new ArrayList<Crime>();
    }
    
    public static void setDatabase(Database database) {
        CrimeRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Crime.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Crime.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    public Crime create(Crime crime) {
        int nrows = 0;
        try {
            nrows = dao.create(crime);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedCrime = crime;
            loadedCrimes.add(crime);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return crime;
    }    

    public void update(Crime crime) {
      // TODO
    }

    public void delete(Crime crime) {
      // TODO
    }
    
    public Crime loadFromId(int id) {
        try {
            this.loadedCrime = dao.queryForId(id);
            if (this.loadedCrime != null)
                this.loadedCrimes.add(this.loadedCrime);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedCrime;
    }    
    
    public List<Crime> loadAll() {
        try {
            this.loadedCrimes =  dao.queryForAll();
            if (this.loadedCrimes.size() != 0)
                this.loadedCrime = this.loadedCrimes.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedCrimes;
    }

    // getters and setters ommited...        
}
```
Para se gear tabelas para visualização de dados, utiliza-se o DB Browser:

![print3](https://github.com/user-attachments/assets/b9e80e53-376b-44e3-a056-9a5e41cfa246)

O uso de banco de dados para a aplicação pode se extender para filtrar as denúncias por plataforma, informações sobre usuários, fluxo de visita etc., gerando material para eventual tratamento estatístico, o que é importante, tendo em vista o viés social do projeto. 
