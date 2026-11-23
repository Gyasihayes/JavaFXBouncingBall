import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;


public class BouncePane extends Pane {
    private Ball ball;
    private MyTimer timer = new MyTimer();
    private final double TWO_PI = 2 * Math.PI;

    public BouncePane() {
        setPrefSize(500, 500);
        ball = new Ball( this.getPrefWidth()/2.0, 15);
        this.getChildren().add(ball);
        timer.start();
    }

    private class MyTimer extends AnimationTimer {
        public void handle( long current ) {
            ball.move();
            checkCollision();
        }
    }

    private void checkCollision() {
        if (ball.getCenterY()+ball.getRadius() >= this.getHeight()) {
            ball.setCenterY(this.getHeight() - ball.getRadius() - 1);
            reflectUpDown(ball);
        }
        else if (ball.getCenterY()-ball.getRadius() <= 0) {
            ball.setCenterY( ball.getRadius() + 1);
            reflectUpDown(ball);
        }
        else if (ball.getCenterX()+ball.getRadius() >= this.getWidth()) {
            ball.setCenterX(this.getWidth() - ball.getRadius() - 1);
            reflectLeftRight(ball);
        }
        else if (ball.getCenterX()-ball.getRadius() <= 0) {
            ball.setCenterX( ball.getRadius() + 1);
            reflectLeftRight(ball);
        }

    }

    private void reflectUpDown(Ball ball ) {
        double dir = 360 - ball.getDirection();
        if (dir > 360) {
            dir -= 360;
        } else if (dir < 0.0) {
            dir += 360;
        }
        ball.setDirection(dir);
    }

    private void reflectLeftRight(Ball ball) {
        double dir = 180 - ball.getDirection();
        if (dir > +360) {
            dir -= 360;
        } else if (dir < 0.0) {
            dir += 360;
        }
        ball.setDirection(dir);
    }

    public void pauseTimer(){
        timer.stop();
    }

    public void startTimer(){
        timer.start();
    }
    public void pauseButton(){
        ball.setSpeed(0);
    }

    public void playButton(){
        ball.setSpeed(8);
    }

    public void speedUp(){
        ball.setSpeed(12);
    }
    public void slowDown(){
        ball.setSpeed(4);
    }

}

