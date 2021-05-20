import javafx.event.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.application.*;
import javafx.stage.*;

public class MazeApplication extends Application{

   KeyCode press; 
   MazeCanvas MazeC = new MazeCanvas();
   
   //Sets up the stage to drawn in
   public void start(Stage stage){
      //Created flow pane
      FlowPane fp = new FlowPane(); 
      fp.getChildren().add(MazeC);
      Scene scene = new Scene(fp, 525, 525); 
      stage.setTitle("Maze Game");
      stage.setScene(scene);
      stage.show();
      MazeC.requestFocus();
      //allow keylistener to work
      fp.setOnKeyPressed(new KeyListenerDown());
      
    }

   //launches the canvas
   public static void main(String[] args) {
      launch(args);
   }
   //Key lisnter to listen the what being press
   public class KeyListenerDown implements EventHandler<KeyEvent> {
      public void handle(KeyEvent event) {
         press = event.getCode();
         MazeC.moveBox(press);
      }
   }   

}