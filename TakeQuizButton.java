package application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TakeQuizButton {
  Button takeQuizButton;
  Scene takeButtonQuizScene;
  Scene questionScreen;
  Scene mainScene;
  Stage primaryStage;
  BorderPane root;
  Button helper;
  Button next;
  int maxQuestions; // num questions user wants to take
  int qNum;
  ComboBox<String> topic;
  String topicTested;
  ArrayList<QuestionNode> questionList;
  QuizGraph quiz;

  /**
   * Scene that stores the scene to takeQuiz
   * 
   * @param primaryStage - main user stage
   * @param mainScene - main user scen
   * @param qNum - num question user is on
   * @param quiz - quizgraph
   */
  protected TakeQuizButton(Stage primaryStage, Scene mainScene, int qNum, QuizGraph quiz) {

    this.quiz = quiz;
    root = new BorderPane();
    this.qNum = qNum;
    this.mainScene = mainScene;
    this.primaryStage = primaryStage;


    // set top
    HBox top = new HBox();
    helper = new Button("help");
    top.getChildren().add(helper);
    top.setAlignment(Pos.TOP_RIGHT);
    root.setTop(top);


    // set center
    HBox hbox = new HBox();
    VBox vbox = new VBox();
    VBox topicBox = new VBox();
    Label whatTopic = new Label("What Topic?");
    whatTopic.setAlignment(Pos.CENTER);
    topic = new ComboBox<String>();
    Set<String> topics = quiz.getAllTopics();
    for (String t : topics) {
      topic.getItems().add(t);
    }
    topic.scaleShapeProperty();
    Label HowManyQuestions = new Label("How Many Questions?");
    HowManyQuestions.setAlignment(Pos.CENTER);
    TextField numQuestion = new TextField();// takes in user number of questions to take
    numQuestion.setPrefColumnCount(1);
    numQuestion.setPrefHeight(1);
    HBox buttonHBox = new HBox();
    Button back = new Button("Back");
    back.setTranslateY(15);
    next = new Button("Next");
    next.setTranslateY(15);
    next.setTranslateX(45);
    buttonHBox.getChildren().addAll(back, next);
    back.setOnAction(e -> primaryStage.setScene(mainScene)); // goes back to main scene
    topicBox.getChildren().addAll(whatTopic, topic, HowManyQuestions, numQuestion, buttonHBox);
    hbox.getChildren().add(topicBox);
    hbox.setAlignment(Pos.CENTER);
    vbox.getChildren().add(hbox);
    vbox.setAlignment(Pos.CENTER);

    root.setCenter(vbox);


    // set bottom

    Label numQLabel = new Label("Number of Questions in Database: " + quiz.questionNum());
    numQLabel.setAlignment(Pos.BOTTOM_LEFT);
    numQLabel.setFont(new Font("Times New Roman", 20));
    root.setBottom(numQLabel);

    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        topicTested = topic.getValue();
      }
    };

    takeButtonQuizScene = new Scene(root, 800, 400);
    next.setOnAction(e -> {
      HandleButton(numQuestion.getText(), quiz);
    });
    topic.setOnAction(event);

  }

  /**
   * gets the scene created by class
   * 
   * @return
   */
  public Scene getScene() {
    return takeButtonQuizScene;
  }


  /**
   * handles the next button action and goes to question screen
   * 
   * @param numQuestions
   * @param quiz
   */
  private void HandleButton(String numQuestions, QuizGraph quiz) {
    try {
      questionList = quiz.getTopicQuestions(topicTested); // get Arraylist of questions based on
                                                          // topic selected
      Collections.shuffle(questionList); // shuffle question Array list so quiz is random
      primaryStage.setScene(new QuestionScreen(primaryStage, mainScene, this.qNum,
          Integer.valueOf(numQuestions), quiz, questionList, 0).getScene());
    } catch (NumberFormatException e1) {
      boolean answer = Warning.display("WARNING!",
          "  You did not type in a number, Please Type in a Number  ", false);
    } catch (Exception e2) {
      boolean answer = Warning.display("WARNING!",
          "  No topic selected or there are no questions for topic yet.  \n  Please select a topic or"
              + " go back and add question to topic.  ",
          false);
    }
  }

}
