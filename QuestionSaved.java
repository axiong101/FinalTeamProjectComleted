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

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class QuestionSaved {
  Scene scene1;

  QuestionSaved(Stage window, Scene scene) {
    HBox hb = new HBox();
    hb.setPadding(new Insets(20, 50, 50, 50));
    hb.setSpacing(10);
    Button b2 = new Button("Back To Adding Question");
    b2.setOnAction(e -> {
      window.close();
    });
    hb.getChildren().addAll(b2);
    scene1 = new Scene(hb);
  }

  public Scene getScene() {
    return scene1;

  }
}
