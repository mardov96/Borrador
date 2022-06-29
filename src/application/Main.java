package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main extends Application {
	
	@Override
	public void start(Stage escenario) throws Exception {
		
		TextField user = new TextField("Usuario");
		TextField clave = new TextField("Contraseña");
		Button login = new Button("Iniciar sesión");
		Label titulo = new Label("My Qtt Chat");
		
		user.setFont(Font.font("Comic Sans Ms", FontWeight.LIGHT, 14));
		user.setFocusTraversable(false);
		user.setMaxWidth(180);
		
		clave.setFont(Font.font("Comic Sans Ms", FontWeight.LIGHT, 14));
		clave.setFocusTraversable(false);
		clave.setMaxWidth(180);
		
		login.setFont(Font.font("Comic Sans Ms", FontWeight.NORMAL, 14));
		login.setMinHeight(30);
		
		titulo.setFont(Font.font("Comic Sans Ms", FontWeight.EXTRA_BOLD, 18));
		titulo.setStyle("-fx-text-fill: orange");
		
		user.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(user.getText().equals("Usuario")) {
					user.deleteText(0, 7);
				}
			}
		});
		
		clave.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(clave.getText().equals("Contraseña")) {
					clave.deleteText(0, 10);
				}					
			}	
		});
		
		login.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				escenario.close();
				TextField chat = new TextField();
				Button enviar = new Button("Enviar");
				
				HBox chatbox = new HBox(10);
				chatbox.getChildren().addAll(chat, enviar);
				chatbox.setAlignment(Pos.CENTER);
				
				chat.setFont(Font.font("Comic Sans Ms", FontWeight.NORMAL, 14));
				chat.setMinSize(500, 10);
				
				enviar.setFont(Font.font("Comic Sans Ms", FontWeight.BOLD, 14));
				enviar.setMinSize(20, 10);
				
				ScrollPane barra = new ScrollPane();
				barra.setVbarPolicy(ScrollBarPolicy.ALWAYS);
				barra.setPrefSize(570, 300);
				barra.visibleProperty();
				
				AnchorPane panel = new AnchorPane();
				AnchorPane.setBottomAnchor(chatbox, 10d);
				AnchorPane.setRightAnchor(chatbox, 5d);
				AnchorPane.setTopAnchor(barra, 60d);
				AnchorPane.setBottomAnchor(barra, 60d);
				AnchorPane.setRightAnchor(barra, 5d);
				
				panel.getChildren().addAll(chatbox, barra);
				
				Stage escenario2 = new Stage();
				Scene escena2 = new Scene(panel, 900, 600);
				//escenario2.getIcons().add(new Image(""));
				escenario2.setTitle("My QTT Chat ;)");
				escenario2.setScene(escena2);
				escenario2.show();
			}
		});
		
		/*Image imagen = new Image("file: nombre del archivo.(png o jpg)");
		ImageView img = new ImageView(imagen);
		img.setFitWidth(120);
		img.setFitHeight(120);
		img.setPreserveRatio(true);
		img.setSmooth(true);*/
		
		VBox izq = new VBox(15, user, clave, login);
		
		VBox der = new VBox(15, titulo/*, img*/);
		der.setAlignment(Pos.CENTER);		
		
		AnchorPane raiz = new AnchorPane();
		raiz.getChildren().addAll(izq, der);
		AnchorPane.setLeftAnchor(izq, 20d);
		AnchorPane.setTopAnchor(izq, 45d);
		AnchorPane.setRightAnchor(der, 50d);
		AnchorPane.setTopAnchor(der, 20d);
		
		Scene escena = new Scene(raiz, 420, 230);
		//escenario.getIcons().add(new Image(""));
		escenario.setTitle("My QTT Chat ;)");
		escenario.setScene(escena);
		escenario.show();
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
