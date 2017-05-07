/**
 * Created by Ramtin on 2017-05-07.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ButtonsImages extends Application {
    Drink drink;

    public ButtonsImages() {
        drink = new Drink("Jack Navid", "1377", "Whisky", "95%", 2017);
    }


    @Override
    public void start(Stage primaryStage) {

        Image upVoteImage = new Image(getClass().getResourceAsStream("upvote.png"));
        Image downVoteImage = new Image(getClass().getResourceAsStream("downvote.png"));

        String downVotes = drink.getDownVotes() + "";
        String upVotes = drink.getUpvotes() + "";


        Button upVote = new Button(upVotes, new ImageView(upVoteImage));
        Button downVote = new Button(downVotes, new ImageView(downVoteImage));

        upVote.setOnAction(e -> updateView("upvote", primaryStage));
        downVote.setOnAction(e -> updateView("downvote", primaryStage));


        HBox layout = new HBox(10);
        layout.getChildren().addAll(upVote, downVote);

        Scene scene = new Scene(layout, 280,105);

        primaryStage.setScene(scene);

        primaryStage.show();


    }

    public void updateView(String action, Stage primaryStage) {

        HBox layout = new HBox();

        if(action.equals("upvote"))
        {
            drink.upvote();
            start(primaryStage);
        }
        else {
            drink.downvote();
            start(primaryStage);
        }
    }





    public static void main(String[] args) {
            launch(args);
    }
}
