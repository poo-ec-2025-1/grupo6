**Código da classe "DenunciaController" para o funcionamento de um formulario de denúncia gerenciando a interação com
 o usuaário. No inicio temos as importações dos pacotes javaFx e as conectividades dos componetentes com o arquivo FXML**
 
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
        
        System.out.println("--- Dados da Denúncia ---");
        System.out.println("Nome (Opcional): " + (nome.isEmpty() ? "Não informado" : nome));
        System.out.println("Ambiente Virtual: " + ambienteVirtual);
        System.out.println("Usuário/Grupo Denunciado: " + usuarioDenunciado);
        System.out.println("Descrição: " + descricao);
        System.out.println("Data da Ocorrência: " + data);
        System.out.println("-------------------------");
        
        exibirAlerta(AlertType.INFORMATION, "Denúncia Enviada", "Sua denúncia foi enviada com sucesso!");
    }

  
  **exibirAlerta trabalha como método auxiliar de alerta para o usuario, ajudando no reaproveitamento do código**

    private void exibirAlerta(AlertType tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null); 
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
    
Confirmação de Sucesso!!

![image](https://github.com/user-attachments/assets/a41adc22-d995-47d1-81eb-291d59fe6889)

Messagem de campo vazio

![image](https://github.com/user-attachments/assets/90583799-a2f1-4a1d-a391-4bb667977db7)

Formulario com os dados prontos

![image](https://github.com/user-attachments/assets/366d03b3-38a7-41e3-968d-e2ce0644e3ad)



