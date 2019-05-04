package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoadWarning {
    static String topic;

    public static String display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);

        TextField tf = new TextField();
        Button done = new Button("Done");
        done.setOnAction(e -> {
            if (tf.getText().equals("")) {
                Warning.display("Warning", "No Json File chosen", false);
            } else {
                topic = tf.getText();
                window.close();
            }
        });
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, tf, done);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        // System.out.println(topic);
        return topic;
    }
}