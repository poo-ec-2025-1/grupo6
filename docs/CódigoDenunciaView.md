Código da classe DenunciaView para inicialização da interface gráfica da aplicação JavaFx carregando e exibindo a interface de usuario
definido no arquivo Denuncia.fxml

    import javafx.application.Application;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.stage.Stage;
    import java.io.IOException;
    import java.net.URL;
    import java.nio.file.Paths;

     public class DenunciaView extends Application {
     private FXMLLoader loader;
     @Override
     public void start(Stage primaryStage) {
        this.loader = new FXMLLoader();
        
        try {
            URL fxmlUrl = Paths.get("resources/Denuncia.fxml").toUri().toURL();
            if (fxmlUrl == null) {
                System.err.println("Erro: Arquivo FXML não encontrado! Verifique o caminho: resources/Denuncia.fxml");
                return;
            }
            this.loader.setLocation(fxmlUrl);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar o arquivo FXML: " + e.getMessage());
        }
    }
    
    public void setController(DenunciaController controller) {
        if (this.loader == null) {
            System.err.println("Erro: FXMLLoader não inicializado antes de setController.");
            return;
        }
        this.loader.setController(controller);
    }
    
    public static void main(String[] args) {
        launch(args);
       }
    }
