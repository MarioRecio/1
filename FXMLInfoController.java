import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FXMLInfoController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField ruta;
    @FXML
    private TextArea resultado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ruta.setText("C:\\holamundo");
    }

    @FXML
    private void ejecutar(ActionEvent event) {

        File f = new File(ruta.getText());
        resultado.setText("");

        if (f.exists()) {
            File[] contenido = f.listFiles();

            for (File c : contenido) {
                String info = "";

                info += "Nombre: " + c.getName() + "\n";
                info += "\t" + "Ruta completa: " + c.getAbsolutePath() + "\n";

                if (c.isDirectory()) {
                    info += "\t" + "Es un directorio" + "\n";
                } else if (c.isFile()) {
                    info += "\t" + "Es un fichero" + "\n";
                }

                if (c.isHidden()) {
                    info += "\t" + "Esta oculto" + "\n";
                } else {
                    info += "\t" + "Esta visible" + "\n";
                }
                resultado.setText(resultado.getText() + info);
            }
        }
        else{
            resultado.setText("No existe");
        }

    }

    @FXML
    private void atras(ActionEvent event) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            this.rootPane.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
