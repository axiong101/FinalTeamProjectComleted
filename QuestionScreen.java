package application;

import java.util.ArrayList;
import java.util.Collections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class QuestionScreen {
  Scene questionScreen;
  Scene correctScreen;
  BorderPane root;
  int qNum;
  private Stage primaryStage;
  private Scene mainScene;
  private int maxQuestions;
  AnswerButton answerA;
  AnswerButton answerB;
  AnswerButton answerC;
  AnswerButton answerD;
  AnswerButton answerE;
  QuizGraph quiz;
  ArrayList<QuestionNode> questionList;
  QuestionNode questionTested;
  int totalCorrect;
  Image image;

  /**
   * Scene that is displays the question and answers that go with question and Also an image if
   * applicable
   * 
   * @param primaryStage
   * @param mainScene
   * @param qNum
   * @param maxQuestions
   * @param quiz
   * @param questionList
   * @param totalCorrect
   */
  protected QuestionScreen(Stage primaryStage, Scene mainScene, int qNum, int maxQuestions,
      QuizGraph quiz, ArrayList<QuestionNode> questionList, int totalCorrect) {

    this.totalCorrect = totalCorrect;
    this.quiz = quiz;
    this.questionList = questionList;
    root = new BorderPane();
    this.qNum = qNum;
    this.primaryStage = primaryStage;
    this.mainScene = mainScene;
    this.maxQuestions = maxQuestions;
    this.qNum++;
    try {
      questionTested = questionList.get(qNum - 1); // get the question in array list
    } catch (IndexOutOfBoundsException e) {
    }

    // setTop
    HBox topLabel = new HBox();
    topLabel.setAlignment(Pos.CENTER);
    Label questionLabel = new Label("Question");
    questionLabel.setFont(new Font("Times New Roman", 40));
    Label questionNum = new Label(Integer.toString(qNum));
    questionNum.setFont(new Font("Times New Roman", 40));
    topLabel.getChildren().addAll(questionLabel, questionNum);
    root.setTop(topLabel);


    // setCenter
    VBox center = new VBox();
    Label question = new Label("Question: " + questionTested.getQuestion());
    ArrayList<AnswerNode> answerList = this.questionTested.getAnswerList();

    question.setFont(new Font("Times New Roman", 30));
    if (questionTested.TorF()) { // Does this if true or false question
      answerA = new AnswerButton(answerList.get(0));
      answerA.setFont(new Font("Times New Roman", 20));
      answerB = new AnswerButton(answerList.get(1));
      answerB.setFont(new Font("Times New Roman", 20));
      center.getChildren().addAll(question, answerA, answerB);

      answerA.setOnAction(e -> handleButton(answerA.getBoolean()));
      answerB.setOnAction(e -> handleButton(answerB.getBoolean()));

    } else { // does this if multiple choice question
      Collections.shuffle(answerList);
      answerA = new AnswerButton(answerList.get(0));
      answerA.setFont(new Font("Times New Roman", 20));
      answerB = new AnswerButton(answerList.get(1));
      answerB.setFont(new Font("Times New Roman", 20));
      answerC = new AnswerButton(answerList.get(2));
      answerC.setFont(new Font("Times New Roman", 20));
      answerD = new AnswerButton(answerList.get(3));
      answerD.setFont(new Font("Times New Roman", 20));
      answerE = new AnswerButton(answerList.get(4));
      answerE.setFont(new Font("Times New Roman", 20));
      center.getChildren().addAll(question, answerA, answerB, answerC, answerD, answerE);

      answerA.setOnAction(e -> handleButton(answerA.getBoolean()));
      answerB.setOnAction(e -> handleButton(answerB.getBoolean()));
      answerC.setOnAction(e -> handleButton(answerC.getBoolean()));
      answerD.setOnAction(e -> handleButton(answerD.getBoolean()));
      answerE.setOnAction(e -> handleButton(answerE.getBoolean()));
    }
    root.setLeft(center);

    // setLeft

    // get image and display if there is an image
    if (questionTested.getImage() != null && !questionTested.getImage().equals("none")) {
      image = new Image(questionTested.getImage());
      ImageView imageV = new ImageView(image);
      imageV.setFitHeight(200); 
      imageV.setFitWidth(200);
      imageV.setPreserveRatio(true);
      root.setCenter(imageV);
    }

    questionScreen = new Scene(root, 800, 400);

  }

  public Scene getScene() {
    return questionScreen;
  }

  /**
   * handles the action when button is pressed, goes to correct screen
   * @param correct
   */
  private void handleButton(boolean correct) {
    if (correct) {
      totalCorrect++;
    }
    correctScreen = new CorrectScreen(primaryStage, mainScene, qNum, maxQuestions, correct, quiz,
        questionList, totalCorrect).getScene();
    primaryStage.setScene(correctScreen);
  }
}
