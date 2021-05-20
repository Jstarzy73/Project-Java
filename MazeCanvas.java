import java.util.*;
import java.io.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.input.*;

public class MazeCanvas extends Canvas {

   String file;
   int mazeArr[][] = new int[21][21]; 
   GraphicsContext gc = getGraphicsContext2D();
   
   KeyCode press;
   int Y1, X1;
   
   int X;
   int Y = 0;
   
   public MazeCanvas(){
      super(525,525);
     
      try
      {
         Scanner scan = new Scanner(new File("MazeData.txt"));      
         //Creating the board
          for(int e= 0; e< 21; e++) 
          {   
             for(int i = 0; i < 21; i++)
             {
               int number = scan.nextInt();
               mazeArr[i][e] = number;
             }	
          }
      }
      catch(FileNotFoundException FNFE) {
         System.out.println("File not found");
      }
            draw(gc);
   }
   //Where everything is being drawn in 
   public void draw(GraphicsContext gc) {
      for(int i = 0; i < 21; i++){  
         
         for(int e= 0; e< 21; e++){
               if (mazeArr[i][e] == 0){
               
                  gc.setFill(Color.WHITE);
               }                                            
               if (mazeArr[i][e] == 1){
                  gc.setFill(Color.BLACK);
               }      
               gc.fillRect(i*25, e*25, 25, 25);
         }
      }
      
      for(int i = 0; i < 21; i++) {
           if(mazeArr[i][0]==0) {
              X = i*25;
           }              
      }
        
      gc.setFill(Color.GREEN);
      gc.fillRect(X, 0, 25, 25);
              
   }          
   public void moveBox(KeyCode press) {
         this.press=press;
         
         gc.setFill(Color.GREEN);
         gc.clearRect(X, Y, 25, 25);
         
         Y1 = Y/25;
         X1 = X/25;
         //Move up
         if (press == KeyCode.UP) {  
            if (Y > 0)
            {
               if (mazeArr[X1][(Y1)-(1)] == 0)
               {
               Y = Y - 25;
               }
            }   
         }
        //Move down
         if (press == KeyCode.DOWN) {  
            if (Y < 500)
            {
               if (mazeArr[X1][(Y1)+(1)] == 0)
               {
               Y = Y + 25;
               }
            }   
         } 
         //Move left
         if (press == KeyCode.LEFT) {  
             if (X > 0)
             {
                if (mazeArr[(X1)-(1)][(Y1)] == 0)
                {
                X = X - 25;
                }
             }   
         } 
         //Move right
         if (press == KeyCode.RIGHT) {   
             if (X < 500)
             {
                if (mazeArr[(X1)+(1)][(Y1)] == 0)
                {
                X = X + 25;
                }
             }  
         }
     
        gc.setFill(Color.GREEN);
        gc.fillRect(X, Y, 25, 25);
         
        if (Y/25 == 20){ 
           if (mazeArr[X1][Y1] == 0)
           {
           System.out.println("You Win!!!");
           }
        }          
   }  
}   
  