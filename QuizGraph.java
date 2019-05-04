package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
/**
 * Filename:   QuizGraph.java
 * Project:    Team Project
 * Authors:    Cha Vang, Ger Vang, Alvin Xiong, Kao Yang
 *
 * Semester:   Spring 2019
 * Course:     CS400
 * Lecture:    Andy: 004 
 * 
 * 
 * Due Date:   Before 11:59 pm on May 3
 *
 * 
 * 
 */

public class QuizGraph {
	private TreeMap<String, ArrayList<QuestionNode>> graph; // Tree map of topic type and Arraylist
															// of QuestionNode

	private int questionNum;
	private int topicNum;
	private Set<String> topicSet;

	/*
	 * Default no-argument constructor
	 */
	public QuizGraph() {
		graph = new TreeMap<String, ArrayList<QuestionNode>>();
		questionNum = 0;
		topicNum = 0;
		topicSet = new TreeSet<String>();
	}

	/**
	 * Add new vertex/topic to the graph.
	 *
	 * If vertex/topic is null or already exists, method ends without adding a
	 * vertex or throwing an exception.
	 * 
	 * Valid argument conditions: 1. vertex is non-null 2. vertex is not already in
	 * the graph
	 */
	public void addTopic(String vertex) {
		if (vertex != null && !graph.containsKey(vertex)) {
			graph.put(vertex, new ArrayList<QuestionNode>());
			topicNum++;
		}
	}

	/**
	 * Remove a vertex and all associated edges from the graph.
	 * 
	 * If vertex is null or does not exist, method ends without removing a vertex,
	 * edges, or throwing an exception.
	 * 
	 * Valid argument conditions: 1. vertex is non-null 2. vertex is not already in
	 * the graph
	 */
	public void removeTopic(String vertex) {
		if (vertex != null) {
			if (graph.containsKey(vertex)) {
				graph.remove(vertex);
				topicNum--;
			}
		}
	}

	/**
	 * Add the edge from vertex1 to vertex2 to this graph. (edge is directed and
	 * unweighted) If either vertex does not exist, no edge is added and no
	 * exception is thrown. If the edge exists in the graph, no edge is added and no
	 * exception is thrown.
	 * 
	 * Valid argument conditions: 1. neither vertex is null 2. both vertices are in
	 * the graph 3. the edge is not in the graph
	 */
	public void addQuestion(String topic, QuestionNode question) {
		if (topic != null && question != null) {
			if (graph.containsKey(topic)) {
				if (!graph.get(topic).contains(question)) {
					graph.get(topic).add(question);
					questionNum++;
				}
			} else if (!graph.containsKey(topic)) {
				addTopic(topic);
				addQuestion(topic, question);
			}
		}
	}

	/**
	 * Returns a Set that contains all the vertices
	 * 
	 */
	public Set<String> getAllTopics() {
		return topicSet = new TreeSet<String>(graph.keySet());
	}

	/**
	 * Gets all questions relating to the selected topic
	 * 
	 * @return all questions with the topic
	 */
	public ArrayList<QuestionNode> getTopicQuestions(String topic) {

		return graph.get(topic);
	}

	/**
	 * Returns the amount of questions in the graph.
	 * 
	 * @return questionNum
	 */
	public int questionNum() {
		return questionNum;
	}

	/**
	 * Returns the number of topics in this graph.
	 * 
	 * @return topicNum
	 */
	public int topicNum() {
		return topicNum;
	}

	/**
	 * Returns the graph.
	 * 
	 * @return graph
	 */
	public TreeMap<String, ArrayList<QuestionNode>> getGraph() {
		return graph;
	}
}

