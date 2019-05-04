//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: AnswerType
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

import java.util.Scanner;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class enable the user to choose what type of question they want
 * 
 * @author kyang
 *
 */
public class AnwserType {
  static Scene scene, multiple, trueOrFalse;

  public static void display(String title, String message, QuizGraph graph, String topic,
      String question, Stage primaryStage) {
    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);
    window.setMinWidth(250);

    Label label = new Label();
    label.setText(message);


    Button b1 = new Button("Multiple Choice Questions");
    Button b2 = new Button("True/False");
    b1.setOnAction(e -> {
      // opens a window for user to create their multiple choice
      multiple = new MultipleChoice(window, scene, graph, topic, question).getScene();
      window.setScene(multiple);
    });
    b2.setOnAction(e -> {
      // opens a window for user to create their T/F question
      trueOrFalse = new TrueOrFalse(window, scene, graph, topic, question).getScene();
      window.setScene(trueOrFalse);
    });
    VBox layout = new VBox(10);
    layout.getChildren().addAll(label, b1, b2);
    layout.setAlignment(Pos.CENTER);

    scene = new Scene(layout);
    window.setScene(scene);
    window.showAndWait();

  }
}
