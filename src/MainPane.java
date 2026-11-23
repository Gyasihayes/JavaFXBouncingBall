import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MainPane extends BorderPane {

    BouncePane bouncePane;
     Button pause = new Button("Pause");
     Button play = new Button("Play");
     Button slow = new Button("Slow Down");
     Button speed = new Button("Speed Up");


    public MainPane(){
        bouncePane = new BouncePane();
        this.setCenter(bouncePane);
        this.setBottom(createCommands());
    }
    private HBox createCommands(){
        play.setOnAction(event -> bouncePane.playButton() );
        pause.setOnAction(event -> bouncePane.pauseButton());
        speed.setOnAction(event -> bouncePane.speedUp() );
        slow.setOnAction(event -> bouncePane.slowDown());


        HBox buttonBar = new HBox(20);
        buttonBar.setAlignment(Pos.BOTTOM_CENTER);
        buttonBar.getChildren().addAll(play, pause, speed, slow);
        return buttonBar;
    }

    public Button getPause() {
        return pause;
    }

    public void setPause(Button pause) {
        this.pause = pause;
    }

    public Button getPlay() {
        return play;
    }

    public void setPlay(Button play) {
        this.play = play;
    }
}
