/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworldjavafx;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Phillip
 */
public class HelloWorldJavaFX extends Application {
    
    private int posicaoX, posicaoY;
    
    MediaPlayer mediaplayer;
    
    public static void main(String[] args){
        launch(args);
    }
    
    public void start(Stage theStage){
        theStage.setTitle("Canvas Example");
        Media musicFile = new Media(this.getClass().getResource("/music/ParodiaGodOfWar.mp3").toExternalForm());
        //Media musicFile = new Media("/HelloWorldJavaFX/music/ParodiaGodOfWar.mp3");
        mediaplayer = new MediaPlayer(musicFile);
        mediaplayer.setVolume(0.1);
        //mediaplayer.setAutoPlay(true);
        
        
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);
        
        
        Canvas canvas = new Canvas(800, 500);
        root.getChildren().add(canvas);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
        gc.setFont(theFont);
        gc.fillText("Hello World!", 60, 50);
        gc.strokeText("Hello World!", 60, 50);
        
        Image kratos = new Image("/img/kratos.png");
        Image back = new Image("/img/godback.png");
        Image abacaxi = new Image("/img/abacaxi.png");
        Image nostemosabacaxi = new Image("/img/nostemosabacaxi.png");
        
        
        
        posicaoX = 140;
        posicaoY = 100;
        
        new AnimationTimer(){
           
            public void handle(long currentNanoTime)
            {
                theScene.setOnKeyPressed((KeyEvent e) ->{
                    if(e.getCode() == KeyCode.LEFT){
                        gc.clearRect(0, 0, 800, 500);
                        posicaoX = posicaoX - 10;
                        
                    }
                    else if(e.getCode() == KeyCode.RIGHT){
                        gc.clearRect(0, 0, 800, 500);
                        posicaoX = posicaoX + 10;
                    }
                    else if(e.getCode() == KeyCode.UP){
                        gc.clearRect(0, 0, 800, 500);
                        posicaoY = posicaoY - 10;
                    }
                    else if(e.getCode() == KeyCode.DOWN){
                        gc.clearRect(0, 0, 800, 500);
                        posicaoY = posicaoY + 10;
                    }
                    System.out.println(posicaoX);
                    System.out.println(posicaoY);
                    if(posicaoX >= 600 && posicaoX <= 700 && posicaoY >= 40 && posicaoY <= 80){
                        gc.drawImage(nostemosabacaxi, 0, 0, 800, 500);
                        mediaplayer.play();
                        stop();
                        
                    }
                });
                // background image clears canvas
                gc.drawImage(back, 0, 0, 800, 500);
                gc.drawImage(abacaxi, 650, 60, 100, 150);
                gc.drawImage(kratos, posicaoX, posicaoY, 100, 250);
            }
        }.start();
        //ImageView teste = new ImageView(kratos);
        
        //root.getChildren().add(teste);
        theStage.show();
        
    }
    
}
