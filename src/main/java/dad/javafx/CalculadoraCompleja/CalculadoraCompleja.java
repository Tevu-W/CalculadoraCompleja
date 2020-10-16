package dad.javafx.CalculadoraCompleja;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculadoraCompleja extends Application{

	private TextField real1, imagin1, real2, imagin2, resul1, resul2;
	private Label i, suma;
	private ComboBox<String> ops;
	private Separator separator;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		real1 = new TextField();
		real1.setPrefColumnCount(5);
		real1.setText("0");
		
		imagin1 = new TextField();
		imagin1.setPrefColumnCount(5);
		imagin1.setText("0");
		
		real2 = new TextField();
		real2.setPrefColumnCount(5);
		real2.setText("0");
		
		imagin2 = new TextField();
		imagin2.setPrefColumnCount(5);
		imagin2.setText("0");
		
		resul1 = new TextField();
		resul1.setPrefColumnCount(5);
		resul1.setText("0");
		
		resul2 = new TextField();
		resul2.setPrefColumnCount(5);
		resul2.setText("0");
		
		i = new Label();
		i.setText("i");
		
		suma = new Label();
		suma.setText("+");
		
		ops = new ComboBox<String>();
		ops.getItems().addAll("+","-","*","/");
		ops.getSelectionModel().select("+");
		
		separator = new Separator();
		separator.setOrientation(Orientation.HORIZONTAL);
		
		HBox complejo1 = new HBox();
		complejo1.setAlignment(Pos.BASELINE_CENTER);
		complejo1.getChildren().addAll(real1, suma, imagin1, i);
		
		HBox complejo2 = new HBox();
		complejo2.setAlignment(Pos.BASELINE_CENTER);
		complejo2.getChildren().addAll(real2, suma, imagin2, i);
		
		HBox resultadoComplejo = new HBox();
		resultadoComplejo.setAlignment(Pos.BASELINE_CENTER);
		resultadoComplejo.getChildren().addAll(resul1, suma, resul2, i);
		
		VBox vbox1 = new VBox();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}


}
