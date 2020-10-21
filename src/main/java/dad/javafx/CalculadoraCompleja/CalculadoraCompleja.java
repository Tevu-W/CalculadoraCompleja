package dad.javafx.CalculadoraCompleja;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculadoraCompleja extends Application {

	//View
	private TextField real1, imagin1, real2, imagin2, resul1, resul2;
	private ComboBox<String> ops;
	private Separator separator;
	
	//Model
	private Complejo NumeroComplejo1 = new Complejo();
	private Complejo NumeroComplejo2 = new Complejo();
	private Complejo NumeroComplejo3 = new Complejo();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		real1 = new TextField();
		real1.setPrefColumnCount(3);
		real1.setText("0");
		real1.setAlignment(Pos.CENTER);

		imagin1 = new TextField();
		imagin1.setPrefColumnCount(3);
		imagin1.setText("0");
		imagin1.setAlignment(Pos.CENTER);

		real2 = new TextField();
		real2.setPrefColumnCount(3);
		real2.setText("0");
		real2.setAlignment(Pos.CENTER);

		imagin2 = new TextField();
		imagin2.setPrefColumnCount(3);
		imagin2.setText("0");
		imagin2.setAlignment(Pos.CENTER);

		resul1 = new TextField();
		resul1.setPrefColumnCount(3);
		resul1.setText("0");
		resul1.setAlignment(Pos.CENTER);

		resul2 = new TextField();
		resul2.setPrefColumnCount(3);
		resul2.setText("0");
		resul2.setAlignment(Pos.CENTER);

		ops = new ComboBox<String>();
		ops.getItems().addAll("+", "-", "*", "/");
		ops.getSelectionModel().select("+");

		separator = new Separator();
		separator.setOrientation(Orientation.HORIZONTAL);

		HBox complejo1 = new HBox();
		complejo1.setAlignment(Pos.BASELINE_CENTER);
		complejo1.setSpacing(5);
		complejo1.getChildren().addAll(real1, new Label("+"), imagin1, new Label("i"));

		HBox complejo2 = new HBox();
		complejo2.setAlignment(Pos.BASELINE_CENTER);
		complejo2.setSpacing(5);
		complejo2.getChildren().addAll(real2, new Label("+"), imagin2, new Label("i"));

		HBox resultadoComplejo = new HBox();
		resultadoComplejo.setAlignment(Pos.BASELINE_CENTER);
		resultadoComplejo.setSpacing(5);
		resultadoComplejo.getChildren().addAll(resul1, new Label("+"), resul2, new Label("i"));

		VBox vbox1 = new VBox();
		vbox1.setAlignment(Pos.CENTER);
		vbox1.setSpacing(5);
		vbox1.getChildren().addAll(complejo1, complejo2, separator, resultadoComplejo);

		VBox comboVbox = new VBox();
		comboVbox.setAlignment(Pos.CENTER);
		comboVbox.getChildren().addAll(ops);

		HBox root = new HBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(comboVbox, vbox1);

		Scene scene = new Scene(root, 320, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Calculadora Compleja");
		primaryStage.show();
		
		
		//Bindings

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
