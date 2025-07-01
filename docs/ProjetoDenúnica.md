# Programa de Denúncia 
Aqui está o programa completo com código atualizado

## Classe Main
A Classe Main está configurada para exibir a janela inicial e unir com os controllers 

    import javafx.application.Application;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.stage.Stage;
    import java.io.IOException;
    import java.net.URL;
    import java.nio.file.Paths;

    public class Main extends Application {
   
    private static Stage primaryStageInstance; 

**Método start carrega o arquivo e que inicialização da interface fxml chamado PROJ Tela do Usuário.fxml, que está armazenado na pasta resources**
  
    @Override
    public void start(Stage primaryStage) {

        Main.primaryStageInstance = primaryStage;
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/PROJ Tela do Usuário.fxml")); 
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar o arquivo FXML: " + e.getMessage());
        }
        
    }
    
  **Método changeScene utilizado para mudar as telas**
  
     public static void changeScene(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/resources/" + fxmlFileName));
              if (loader.getLocation() == null) {
                System.err.println("Erro: Arquivo FXML para navegação não encontrado! Caminho: /resources/" + fxmlFileName);
                return;
            }
            Parent newRoot = loader.load();
            if (primaryStageInstance != null && primaryStageInstance.getScene() != null) {
                primaryStageInstance.getScene().setRoot(newRoot);
                System.out.println("Navegando para: " + fxmlFileName);
            } else {
                System.err.println("Erro: Stage principal ou Scene não inicializados para navegação.");
             }
             
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar FXML para navegação: " + fxmlFileName+ " - " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
## Classe DenunciaController  
   **No inicio temos as importações dos pacotes javaFx e as conectividades dos componetentes com o arquivo FXML**

    import javafx.fxml.FXML;
    import javafx.scene.control.Button;
    import javafx.scene.control.DatePicker;
    import javafx.scene.control.TextField;
    import javafx.scene.control.Alert; 
    import javafx.scene.control.Alert.AlertType;
    import java.time.LocalDate; 

    public class DenunciaController {
    @FXML
    private TextField nomeTextField; 
    @FXML
    private TextField ambienteTextField; 
    @FXML
    private TextField usuarioDenunciadoTextField; 
    @FXML
    private TextField descricaoTextField; 
    @FXML
    private DatePicker dataData; 
    @FXML
    private Button enviarButton; 
  **Método enviardenuncia é acionado ao apertar o botão enviar, coletando os dados obtidos no formulario e criando um relatório da denúncia, 
   caso haja algum campo do formulario vazio não prossegue com a denúncia. no fim ele retorna uma mesagem de exito**
   
    @FXML
    private void enviardenuncia() {
        String nome = nomeTextField.getText();
        String ambienteVirtual = ambienteTextField.getText();
        String usuarioDenunciado = usuarioDenunciadoTextField.getText();
        String descricao = descricaoTextField.getText();
        LocalDate data = dataData.getValue(); 
        if (ambienteVirtual.isEmpty() || usuarioDenunciado.isEmpty() || descricao.isEmpty() || data == null) {
            exibirAlerta(AlertType.WARNING, "Campos Obrigatórios", "Por favor, preencha todos os campos obrigatórios (Ambiente Virtual, Usuário/Grupo, Descrição, Data).");
            return; 
        }
  ![image](https://github.com/user-attachments/assets/90583799-a2f1-4a1d-a391-4bb667977db7)
  
  Relatório da Denúncia Criado.
 
        System.out.println("--- Dados da Denúncia ---");
        System.out.println("Nome (Opcional): " + (nome.isEmpty() ? "Não informado" : nome));
        System.out.println("Ambiente Virtual: " + ambienteVirtual);
        System.out.println("Usuário/Grupo Denunciado: " + usuarioDenunciado);
        System.out.println("Descrição: " + descricao);
        System.out.println("Data da Ocorrência: " + data);
        System.out.println("-------------------------");

   ![image](https://github.com/user-attachments/assets/366d03b3-38a7-41e3-968d-e2ce0644e3ad)
   
  Menssagem gerada.
    
        exibirAlerta(AlertType.INFORMATION, "Denúncia Enviada", "Sua denúncia foi enviada com sucesso!");    
    }
    
   ![image](https://github.com/user-attachments/assets/a41adc22-d995-47d1-81eb-291d59fe6889)

 **exibirAlerta trabalha como método auxiliar de alerta para o usuario, ajudando no reaproveitamento do código**
 
    private void exibirAlerta(AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null); 
        alert.setContentText(mensagem);
        alert.showAndWait();
     }
    }

  # Classe PrincipalController 
  **A classe é utilizada na configuração da tela de entrada principal. Ao acionar o botão "Realizardenuncia" há uma troca de telas
  que está interligada à cofigurção da classe Main**

    import javafx.fxml.FXML;
    import javafx.scene.control.Button;
    import javafx.event.ActionEvent; 

    public class PrincipalController {
    @FXML
    private Button realizarButton; 
    
    @FXML
    private void realizardenuncia(ActionEvent event) {
        Main.changeScene("Denuncia.fxml"); 
     }
    }

  1° tela de abertura.
  ![image](https://github.com/user-attachments/assets/6fd9bfd0-5286-47eb-ace7-05977494cd90)

  2° tela de Realizar Denúncia.

  ![image](https://github.com/user-attachments/assets/ef59113f-9290-4ef9-a2c7-332b4e4b8bd7)

  3° tela Realizar Denúnica preenchida.

  ![image](https://github.com/user-attachments/assets/514ec5b1-e674-4dba-a544-5919d2f08efe)

  4° Relatório gerado após o envio.

  ![image](https://github.com/user-attachments/assets/6f97eaa2-0f28-456b-976a-11e085235b83)




