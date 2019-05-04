package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TotalScore {
  static boolean anwser;
  Stage primaryStage;
  Scene mainScene;
  Scene totalScoreScene;

  /**
   * Creates the totalScore screen that displays the user number of Correct
   * 
   * @param primaryStage
   * @param mainScene
   * @param numTaken
   * @param totalCorrect
   */
  public TotalScore(Stage primaryStage, Scene mainScene, int numTaken, int totalCorrect) {
    this.primaryStage = primaryStage;
    this.mainScene = mainScene;



    // setting a label
    Label score = new Label();
    Label tx = new Label();
    score.setFont(new Font("Times New Roman", 25));
    score.setText("Total Score:");
    double percentCorrect = ((double) totalCorrect / (double) numTaken) * 100.00; // displays user
                                                                                  // percentage
                                                                                  // correct
    tx.setText(Double.valueOf(percentCorrect) + "%");

    Button mainMenu = new Button("Main Menu");


    VBox layout = new VBox();
    layout.getChildren().addAll(score, tx, mainMenu);
    layout.setSpacing(10.0);
    layout.setAlignment(Pos.CENTER);


    totalScoreScene = new Scene(layout, 800, 400);
    mainMenu.setOnAction(e -> primaryStage.setScene(mainScene)); // return to main scene when
                                                                 // clicked
  }

  /**
   * get scene created by this class
   * 
   * @return
   */
  public Scene getScene() {
    return totalScoreScene;
  }

}
