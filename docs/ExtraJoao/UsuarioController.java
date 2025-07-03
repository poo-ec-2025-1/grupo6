import javafx.stage.Stage;
import javafx.event.Event;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class UsuarioController
{
    UsuarioView usuarioView;
    Stage stage;
    Usuario usuario;
    public TextField textFieldUsuario;
    public TextField textFieldSenha;
    
    /**
     * Construtor para objetos da classe IMCController
     */
    public UsuarioController()
    {
        this.stage = new Stage();
        this.usuarioView = new UsuarioView();
        this.usuarioView.setController(this);
    }
    
    public void iniciar() throws Exception {
        this.usuarioView.start(this.stage);
        this.stage.show();
    }
    
}
