//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: AddQuestion
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

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class enable user to write and choose their topic as well as writing their 
 * question
 * @author kyang
 *
 */
public class AddQuestion {
   Scene scene1; 
   static String topic; 
   public static QuizGraph display(Stage primaryStage, QuizGraph graph) {
         //creates a new pop up window
         Stage window = new Stage();
         window.initModality(Modality.APPLICATION_MODAL);
         window.setTitle("Add Question");
         window.setMinWidth(250);

            VBox vb = new VBox();
            vb.setPadding(new Insets(100, 100, 100, 100));
            vb.setSpacing(10);
            
            Label topLabel = new Label("What Topic?");
            vb.getChildren().add(topLabel);

            ComboBox<String> cb = new ComboBox();
            cb.getItems().addAll(graph.getAllTopics()); //pre-load topics that are already made
            vb.getChildren().add(cb);

            Button b1 = new Button("Create new Topic");
            Button b3 = new Button("Back To Menu");
        
            vb.getChildren().addAll(b1,b3); 
            b3.setOnAction(e -> window.close());
            b1.setOnAction(e -> {
              topic = NewTopic.display("New Topic", "New Topic");
              if(topic.equals("")) {
                return; 
              }
              if(graph.getAllTopics().contains(topic)) { //no duplicate topic
                return; 
              }
              cb.getItems().add(topic);  
              graph.addTopic(topic); 
            });
            
                
            Label label = new Label("Type Your Question");
         
            vb.getChildren().add(label);
            
            TextField tf = new TextField();
            vb.getChildren().add(tf);
            Button b2 = new Button("Add");
            vb.getChildren().add(b2);
            b2.setOnAction(e -> {
              if(tf.getText().isEmpty() || cb.getValue() == null) { //make sure there is user input
                Warning.display("Warning", "Question field or topic selection is blank, please enter a question or select a topic", false);
              return; 
              }
              String question = tf.getText(); 
              String userTopic = cb.getValue(); 
              
              //open a pop up window for user to choose what type of question they want
              AnwserType.display("Anwser Type", "Anwser Type", graph, userTopic, question, primaryStage);
        
            });
            // Adding VBox to the scene
            Scene scene1 = new Scene(vb);
            window.setScene(scene1);
            window.showAndWait();
           
          return graph; 
       }

    }