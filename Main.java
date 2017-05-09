import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application{

    private Stage window;
    private Scene startScene, kidScene, mainScene;
    private Image upVoteImage = new Image(getClass().getResourceAsStream("upvote.png"));
    private Image downVoteImage = new Image(getClass().getResourceAsStream("downvote.png"));
    private Products products = new Products();
    private ArrayList<Drink> drinks = products.getDrinks();
    private ComboBox<String> comboBox;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        Label welcome = new Label("Welcome to Alcorate!" );
        welcome.setTextFill(Color.WHITE);

        welcome.setFont(new Font("Arial",50));

        Label kidLabel = new Label("Go get an Ice cream instead");
        kidLabel.setAlignment(Pos.CENTER);

        //Button 1
        Button button1 = new Button("I am under the age of 20");
        button1.setOnAction(e ->window.setScene(kidScene));

        //Button 2
        Button button2 = new Button("I am over the age of 20");
        button2.setOnAction(e ->window.setScene(mainScene));

        //Start layout
        StackPane root = new StackPane();
        Scene startScene = new Scene(root, 600, 500);
        startScene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

        VBox startLayout = new VBox(20);
        startLayout.getChildren().addAll(welcome, button1, button2);
        root.setId("pane");
        root.getChildren().add(startLayout);
        startLayout.setAlignment(Pos.CENTER);


        //Kid layout
        VBox kidLayout = new VBox(20);
        kidLayout.getChildren().add(kidLabel);
        kidScene = new Scene(kidLayout, 600, 600);

        //Alcorate layout
        mainScene = new Scene(createContent(drinks), 600, 600);

        window.setScene(startScene);
        window.setTitle("Alcorate");
        window.show();
    }

    public class HBoxCell extends HBox {
        Label label = new Label();
        Label emptyLabel = new Label(" ");

        HBoxCell(String labelText, String buttonText1, String buttonText2, Drink drink) {
            super();

            label.setText(labelText);
            label.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(label, Priority.ALWAYS);


            String downVotes = drink.getDownVotes() + "";
            String upVotes = drink.getUpvotes() + "";


            Button upVote = new Button(upVotes, new ImageView(upVoteImage));
            Button downVote = new Button(downVotes, new ImageView(downVoteImage));

            upVote.setOnAction(e -> updateView("upvote", drink));
            downVote.setOnAction(e -> updateView("downvote", drink));

            this.getChildren().addAll(label, upVote, emptyLabel, downVote);
        }
    }


    public Parent createContent(ArrayList<Drink> drinks) {
        BorderPane layout = new BorderPane();
        HBox hBox = new HBox(20);

        //Drop menu
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Name",
                "Price",
                "%",
                "Year",
                "Most up votes",
                "Most down votes",
                "Best vote ratio"
        );
        comboBox.setPromptText("Sort");
        comboBox.setPadding(new Insets(15,20,15,20));

        //Actions when choosing in the drop menu
        comboBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> window.setScene(mainScene));

        hBox.getChildren().addAll(comboBox);
        hBox.setAlignment(Pos.TOP_RIGHT);

        //layout.getChildren().add(hBox);
        layout.setTop(hBox);

        List<HBoxCell> list = new ArrayList<>();
        for (Drink drink : drinks) {
            list.add(new HBoxCell(drink.getDrinkString(), "Upvote","Downvote", drink));
        }

        ListView<HBoxCell> listView = new ListView<>();
        ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
        listView.setItems(myObservableList);

        layout.setCenter(listView);

        return layout;
    }

    private void updateView(String action, Drink drink){

        if(action.equals("upvote")) {
            drink.upvote();
            refresh();
        }
        else {
            drink.downvote();
            refresh();
        }
    }

    private void refresh() {
        mainScene = new Scene(createContent(drinks), 600, 600);

        window.setScene(mainScene);
        window.setTitle("Alcorate");
        window.show();
    }
}
