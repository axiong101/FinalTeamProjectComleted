//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: MultipleChoice
// Files: (a list of all source files used by that program)
// Course: (CS 400, Spring, 2019)
//
// Author: (Kao Yang) (Ger Vang) (Cha Vang) (Alvin Xiong)
// Email: (kyang236@wisc.edu) (gvang7@wisc.edu) (cvang46@wisc.edu) (axiong37@wisc.edu)
// Lecturer's Name: (Andy Kuemmel)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NA
// Partner Email: NA
// Partner Lecturer's Name: NA
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _x__ Write-up states that pair programming is allowed for this assignment.
// _x__ We have both read and understand the course Pair Programming Policy.
// _x__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
package application;

import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TrueOrFalse {
  Scene scene1, questionSaved;
  boolean answer;
  AnswerNode a1, a2;
  QuestionNode q1;
  static FileChooser fileChooser = new FileChooser();
  String image = "none";

  TrueOrFalse(Stage window, Scene scene, QuizGraph graph, String topic, String question) {
    VBox vb = new VBox();
    vb.setPadding(new Insets(20, 50, 50, 50));
    vb.setSpacing(10);
    Label topLabel = new Label("Answer");
    ComboBox cb = new ComboBox();
    cb.getItems().add(true);
    cb.getItems().add(false);
    Button openButton = new Button("Add A Picture");
    Button b3 = new Button("Done");

    openButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(final ActionEvent e) {
        File file = fileChooser.showOpenDialog(window); // user choose file
        if (file != null) {
          image = file.getName();
          Warning.display("Success", "Sucessfully Saved Image To Question", false);
        }
      }
    });
    // Create action event
    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {

        answer = (boolean) cb.getValue();

      }


    };

    // Set on action
    cb.setOnAction(event);
    b3.setOnAction(e -> {
      a1 = new AnswerNode("true", answer);
      a2 = new AnswerNode("false", !answer);
      q1 = new QuestionNode(question, a1, a2, true, image);
      graph.addQuestion(topic, q1);
      questionSaved = new QuestionSaved(window, scene).getScene();
      window.setScene(questionSaved);
    });
    vb.getChildren().addAll(topLabel, cb, openButton, b3);
    scene1 = new Scene(vb);
  }

  public Scene getScene() {
    return scene1;

  }
}
