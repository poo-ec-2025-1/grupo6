Código em relação ao feedback dado pelo professor e criando uma database conectada à um arquivo fxml.

# Código
Esse código é separado em 3 pacotes.

## Model
Separado em 3 Classes.

### User
```java
package Model;

import java.util.Date;
import java.text.SimpleDateFormat;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;

@DatabaseTable(tableName="User")
public class User {
    
    @DatabaseField(generatedId = true)
    private int id;
        
    @DatabaseField(dataType=DataType.STRING)    
    private String usuario;
    
    @DatabaseField(dataType=DataType.STRING)
    private String tipoConta;
    
    @DatabaseField(dataType=DataType.STRING)        
    private String dataDeNascimento;
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getusuario(){
        return this.usuario;
    }
    
    public void setusuario(String usuario){
        this.usuario = usuario;
    }
    
    public String gettipoConta(){
        return this.tipoConta;
    }
    
    public void settipoConta(String tipoConta){
        this.tipoConta = tipoConta;
    }
    
    public String getdataDeNascimento(){
        return this.dataDeNascimento;
    }
    
    public void setdataDeNascimento(String dataDeNascimento){
        this.dataDeNascimento = dataDeNascimento;
    }
}
```
### UserRepositorio
```java
package Model;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class UserRepositorio
{
    private static Database database;
    private static Dao<User, Integer> dao;
    private List<User> loadedUsers;
    private User loadedUser;
    
    public UserRepositorio(Database database) {
        UserRepositorio.setDatabase(database);
        loadedUsers = new ArrayList<User>();
    }
    
    public static void setDatabase(Database database) {
        UserRepositorio.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), User.class);
            TableUtils.createTableIfNotExists(database.getConnection(), User.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    public User create(User user) {
        int nrows = 0;
        try {
            nrows = dao.create(user);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedUser = user;
            loadedUsers.add(user);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }    

    public void update(User user) {
      
    }

    public void delete(User User) {
        
    }
    
    public User loadFromId(int id) {
        try {
            this.loadedUser = dao.queryForId(id);
            if (this.loadedUser != null)
                this.loadedUsers.add(this.loadedUser);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedUser;
    }    
    
    public List<User> loadAll() {
        try {
            this.loadedUsers =  dao.queryForAll();
            if (this.loadedUsers.size() != 0)
                this.loadedUser = this.loadedUsers.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedUsers;
    }
}
```

### Database
```java
package Model;

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

## View
Separado em 2 classes e um arquivo fxml.

### User
```java
package View;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class User {
    
    private SimpleIntegerProperty id;
    private SimpleStringProperty usuario;
    private SimpleStringProperty tipoConta;
    private SimpleStringProperty dataDeNascimento;
    
    public User(int id, String usuario, 
            String tipoConta, String dataDeNascimento){
        this.id = new SimpleIntegerProperty(id);
        this.usuario = new SimpleStringProperty(usuario);
        this.tipoConta = new SimpleStringProperty(tipoConta);
        this.dataDeNascimento = new SimpleStringProperty(dataDeNascimento);    
    }
  
    public int getId(){
        return this.id.get();
    }
    
    public void setId(int id){
        this.id.set(id);
    }
    
    public String getUsuario(){
        return this.usuario.get();
    }
    
    public void setUsuario(String usuario){
        this.usuario.set(usuario);
    }
    
    public String getTipoConta(){
        return this.tipoConta.get();
    }
    
    public void setTipoConta(String tipoConta){
        this.tipoConta.set(tipoConta);
    }
    
    public String getDataDeNascimento(){
        return this.dataDeNascimento.get();
    }
    
    public void setDataDeNascimento(String dataDeNascimento){
        this.dataDeNascimento.set(dataDeNascimento);
    }
}
```

### UserView
```java
package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;

public class UserView extends Application
{
    private FXMLLoader loader;
    private URL url;
    private Stage primaryStage;
    
    public UserView() {
        this.loader = new FXMLLoader();
        try {
            this.url = new File("View/user.fxml").toURI().toURL();
        } catch (Exception e) {
            System.out.println("Erro na carga do FXML:" + e);
        }
        this.loader.setLocation(this.url);        
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Pane pane = loader.<Pane>load();
            Scene scene = new Scene(pane);
            this.primaryStage = primaryStage;
            primaryStage.setScene(scene);
            primaryStage.show();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void stop() {
        System.exit(0);
    }
    
    public void run(String[] args) {
        Application.launch(args);
    }
}
```

### Arquivo FXML
![image](https://github.com/JoaoP9L/Telas-Projeto/blob/main/Prints/fxml.png)

## Controller
Uma única classe.

### UserController
```java
package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;

import Model.UserRepositorio;
import View.UserView;

public class UserController implements Initializable {
    @FXML
    private TableView<View.User> tabela;
    @FXML
    private TableColumn<View.User, Integer> idCol;
    @FXML
    private TableColumn<View.User, String> usuarioCol;
    @FXML
    private TableColumn<View.User, String> tipoContaCol;
    @FXML
    private TableColumn<View.User, String> dataDeNascimentoCol;
    @FXML
    private TextField idField;
    @FXML
    private TextField usuarioField;
    @FXML
    private TextField tipoContaField;
    @FXML
    private TextField dataDeNascimentoField;
    @FXML
    private Button adicionarButton;
    @FXML
    private Button atualizarButton;
    @FXML
    private Button deletarButton;    
    @FXML
    private Button cancelarButton;    
    @FXML
    private Button salvarButton;
    
    UserView userView;
    
    private static Model.Database database = new Model.Database("user.sqlite");
    private static Model.UserRepositorio UserRepo = 
        new Model.UserRepositorio(database);
        
    public UserController() {
        this.userView = new UserView();
    }
    
    public static void main(String[] args) throws Exception {
        UserController userController = new UserController();
        userController.userView.run(args);
    }
    
    private void desabilitarBotoes(boolean adicionar, boolean atualizar, boolean deletar, boolean cancelar, boolean salvar) {
        adicionarButton.setDisable(adicionar);
        atualizarButton.setDisable(atualizar);
        deletarButton.setDisable(deletar);
        cancelarButton.setDisable(cancelar);
        salvarButton.setDisable(salvar);        
    }
    
    private void desabilitarCampos(boolean desabilitado) {
        usuarioField.setDisable(desabilitado);
        tipoContaField.setDisable(desabilitado);
        dataDeNascimentoField.setDisable(desabilitado);
    }
    
    private void limparCampos() {
        idField.setText("");
        usuarioField.setText("");
        tipoContaField.setText("");
        dataDeNascimentoField.setText("");
    }
    
    @FXML
    public void onCancelarButtonAction() {
        desabilitarCampos(true);
        desabilitarBotoes(false,true,true,true,true);
        limparCampos();
        tabela.getSelectionModel().select(-1);        
    }
    
    @FXML
    public void onSalvarButtonAction() {
        try {
            Model.User user = new Model.User();            
            user.setusuario(usuarioField.getText());
            user.settipoConta(tipoContaField.getText());
            user.setdataDeNascimento(dataDeNascimentoField.getText());            
            Model.User usuario_salvo = UserRepo.create(user); 
            View.User userView = modelToView(usuario_salvo);
            tabela.getItems().add(userView);
            tabela.getSelectionModel().select(userView);    
            desabilitarCampos(true);
            desabilitarBotoes(false,true,true,true,true);            
        }
        catch(Exception e) {
            new Alert(AlertType.ERROR, "Erro ao salvar: "+e.getMessage()).show();
        }
    }    
    
    @FXML
    public void onAdicionarButtonAction() {
        tabela.getSelectionModel().select(-1);
        desabilitarCampos(false);
        desabilitarBotoes(true,true,true,false,false);
        limparCampos();
    }

    @FXML
    private void handleUserSelected(View.User newSelection) {
        if (newSelection != null)
            idField.setText(Integer.toString(newSelection.getId()));
            dataDeNascimentoField.setText(newSelection.getDataDeNascimento());
            tipoContaField.setText(newSelection.getTipoConta());
            usuarioField.setText(newSelection.getUsuario());
            desabilitarBotoes(false,false,false,true,true);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idCol.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        usuarioCol.setCellValueFactory(
                new PropertyValueFactory<>("usuario"));
        tipoContaCol.setCellValueFactory(
                new PropertyValueFactory<>("tipoConta"));
        dataDeNascimentoCol.setCellValueFactory(
                new PropertyValueFactory<>("dataDeNascimento"));
        tabela.setItems(loadAllUsers());
        tabela.getSelectionModel().selectedItemProperty().addListener(
            (observableValue, oldSelection, newSelection) -> {
                handleUserSelected(newSelection);
            });
    }
    
    private View.User modelToView(Model.User user) {
        return new View.User(
            user.getId(),
            user.getusuario(),
            user.gettipoConta(),
            user.getdataDeNascimento()
        );
    }
    
    private ObservableList<View.User> loadAllUsers() {
        ObservableList<View.User> lista = 
            FXCollections.observableArrayList();
        List<Model.User> listaFromDatabase = UserRepo.loadAll();
        for(Model.User user: listaFromDatabase) {
            lista.add(modelToView(user));
        }
        return lista;
    }
}
```
