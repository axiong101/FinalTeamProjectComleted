package application;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Set;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GraphTest {
  private static QuizGraph graph;

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    graph = new QuizGraph();
  }

  @AfterAll
  static void setUpAfterClass() throws Exception {
    graph = null;
  }

  @Test
  void test001_AddTopic() {
    graph.addTopic("Animals");
    graph.addTopic("Anime");
    graph.addTopic("Movies");
    Set topicSet = graph.getAllTopics();
    if (!topicSet.contains("Animals") || !topicSet.contains("Anime")
        || !topicSet.contains("Movies")) {
      fail("addTopic method did not add a topic when expected to");
    }
  }

  @Test
  void test002_AddQuestions() {
    graph.addTopic("Animals");
    graph.addTopic("Anime");
    graph.addTopic("Movies");
    QuestionNode q1 = new QuestionNode("Main character of Blue Exorcist is?",
        new AnswerNode("Rin Okumura", true), new AnswerNode("wrong1", false),
        new AnswerNode("wrong2", false), new AnswerNode("wrong3", false), new AnswerNode("wrong4", false), false, null);
    graph.addQuestion("Anime", q1);
    ArrayList<AnswerNode> answerList = graph.getTopicQuestions("Anime").get(0).getAnswerList();
    if (!graph.getTopicQuestions("Anime").get(0).getQuestion()
        .equals("Main character of Blue Exorcist is?"))
      fail("addQuestion method did not add a question when expected to");
  }

  @Test
  void test003_getAllTopics() {
    graph.addTopic("Animals");
    graph.addTopic("Anime");
    graph.addTopic("Movies");
    Set topicSet = graph.getAllTopics();
    if (!topicSet.contains("Animals") || !topicSet.contains("Anime")
        || !topicSet.contains("Movies")) {
      fail("addTopic method did not add a topic when expected to");
    }
  }
}
