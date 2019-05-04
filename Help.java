    
package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Help extends Button{
 
  static boolean answer;
  
   public static boolean helpMethod(String Title, String message) {
     Stage window = new Stage();
     window.initModality(Modality.APPLICATION_MODAL);
     window.setTitle("Help");
     window.setMinWidth(300.0);
     window.setMinHeight(300.0);
     Label assist = new Label();
     assist.setText(message);
     
     Button closeB = new Button("close");
     
     closeB.setOnAction(e -> {
       answer = true;
       window.close();
     });

     VBox layout = new VBox();
     layout.getChildren().addAll(assist, closeB);
     layout.setAlignment(Pos.CENTER);
     Scene scene = new Scene(layout);
     window.setScene(scene);
     window.showAndWait();
     
    return answer;
   }

}