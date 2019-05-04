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

import java.awt.Window;
import java.io.File;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MultipleChoice {
  Scene scene1, questionSaved;
  AnswerNode a1, a2, a3, a4, a5;
  QuestionNode q1;
  String answer1, answer2, answer3, answer4, answer5;
  HBox Hb1 = new HBox(2);
  HBox Hb2 = new HBox(2);
  HBox Hb3 = new HBox(2);
  HBox Hb4 = new HBox(2);
  HBox Hb5 = new HBox(2);
  boolean c1, c2, c3, c4, c5;
  String correctOrWrong[] = {"Correct", "Wrong"};
  ComboBox<String> cb1 = new ComboBox<String>(FXCollections.observableArrayList(correctOrWrong));
  ComboBox<String> cb2 = new ComboBox<String>(FXCollections.observableArrayList(correctOrWrong));
  ComboBox<String> cb3 = new ComboBox<String>(FXCollections.observableArrayList(correctOrWrong));
  ComboBox<String> cb4 = new ComboBox<String>(FXCollections.observableArrayList(correctOrWrong));
  ComboBox<String> cb5 = new ComboBox<String>(FXCollections.observableArrayList(correctOrWrong));
  static FileChooser fileChooser = new FileChooser();
  String image = "none";

  MultipleChoice(Stage window, Scene scene, QuizGraph graph, String topic, String question) {
    VBox Vb = new VBox(7);
    Vb.setPadding(new Insets(20, 50, 50, 50));
    Vb.setSpacing(10);
    Label topLabel = new Label("Create your multiple choice");

    // textfield for user to enter their answer choices
    TextField tf1 = new TextField();
    TextField tf2 = new TextField();
    TextField tf3 = new TextField();
    TextField tf4 = new TextField();
    TextField tf5 = new TextField();
    Button openButton = new Button("Add A Picture");
    Hb1.getChildren().addAll(tf1, cb1);
    Hb2.getChildren().addAll(tf2, cb2);
    Hb3.getChildren().addAll(tf3, cb3);
    Hb4.getChildren().addAll(tf4, cb4);
    Hb5.getChildren().addAll(tf5, cb5);

    // create action event
    openButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(final ActionEvent e) {
        File file = fileChooser.showOpenDialog(window); // user choose a file
        if (file != null) {
          image = file.getName();
          Warning.display("Success", "Sucessfully Saved Image To Question", false);
        }
      }
    });
    // Create action event
    EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if (cb1.getValue().equals("Correct")) { // user choose which one is correct/wrong
          c1 = true;
        } else {
          c1 = false;
        }
      }
    };
    // Create action event
    EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if (cb2.getValue().equals("Correct")) { // user choose which one is correct/wrong
          c2 = true;
        } else {
          c2 = false;
        }
      }
    };
    // Create action event
    EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if (cb1.getValue().equals("Correct")) { // user choose which one is correct/wrong
          c3 = true;
        } else {
          c3 = false;
        }
      }
    };
    // Create action event
    EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if (cb4.getValue().equals("Correct")) { // user choose which one is correct/wrong
          c4 = true;
        } else {
          c4 = false;
        }
      }
    };

    EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if (cb5.getValue().equals("Correct")) { // user choose which one is correct/wrong
          c5 = true;
        } else {
          c5 = false;
        }
      }
    };



    // Set on action
    cb1.setOnAction(event1);
    cb2.setOnAction(event2);
    cb3.setOnAction(event3);
    cb4.setOnAction(event4);



    Button b1 = new Button("Done");
    Button b2 = new Button("Back");
    b1.setOnAction(e -> {
      answer1 = tf1.getText(); //
      answer2 = tf2.getText();
      answer3 = tf3.getText();
      answer4 = tf4.getText();
      answer5 = tf5.getText();
      a1 = new AnswerNode(answer1, c1);
      a2 = new AnswerNode(answer2, c2);
      a3 = new AnswerNode(answer3, c3);
      a4 = new AnswerNode(answer4, c4);
      a5 = new AnswerNode(answer5, c5);

      q1 = new QuestionNode(question, a1, a2, a3, a4, a5, false, image);
      graph.addQuestion(topic, q1); // save question node into designated topic
      questionSaved = new QuestionSaved(window, scene1).getScene();
      window.setScene(questionSaved);
    });
    b2.setOnAction(e -> {
      window.close();
    });
    b1.setTranslateX(150);
    b1.setTranslateY(30);

    Vb.getChildren().addAll(topLabel, Hb1, Hb2, Hb3, Hb4, Hb5, openButton, b1, b2);

    scene1 = new Scene(Vb);
  }

  public Scene getScene() {
    return scene1;

  }
}
