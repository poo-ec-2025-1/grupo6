import java.util.Date;
import java.text.SimpleDateFormat;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;

@DatabaseTable(tableName = "Usuario")
public class User
{   
    @DatabaseField(generatedId = true)
    private int id;
    
    @DatabaseField
    private String nome;
    
    @DatabaseField
    public String categoria;
    
    @DatabaseField
    public int senha;    
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getnome(){
        return this.nome;
    }

    public void setnome(String nome){
        this.nome = nome;
    }

    public String getcategoria(){
        return this.categoria;
    }

    public void setcategoria(String categoria){
        this.categoria = categoria;
    }

    public int getsenha(){
        return this.senha;
    }

    public void setsenha(int senha){
        this.senha = senha;
    }
}