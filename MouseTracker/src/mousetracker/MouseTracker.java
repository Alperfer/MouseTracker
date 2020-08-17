/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mousetracker;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author alper
 */
public class MouseTracker extends Application {
    int clicks = 0 ;
    @Override
    public void start(Stage primaryStage) {

       BorderPane bp = new BorderPane() ;
       Text txt1 = new Text("X: ") ;
       Text txt2 = new Text("Y: ") ;
       Text txt3 = new Text("---") ;
       Text txt4 = new Text("Clicks: " + clicks) ;
       Text txt5 = new Text("") ;
       HBox hb = new HBox(txt1,txt2,txt3,txt4,txt5) ;
       hb.setSpacing(20);
       bp.setBottom(hb) ;
       Scene sc = new Scene(bp,500,500) ;
       sc.setOnMouseMoved(e -> {
           txt1.setText("X: " + e.getX());
           txt2.setText("Y: " + e.getY()) ;
           txt3.setText("Mouse Moved") ;
       });
       sc.setOnMousePressed(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent e) {
               txt3.setText("Mouse pressed") ;
               clicks++ ;
               txt4.setText("Clicks " + clicks) ;
           }
       });
       sc.setOnMouseDragged(e -> {
           txt1.setText("X: " + e.getX());
           txt2.setText("Y: " + e.getY()) ;
           txt3.setText("Mouse Dragged");
       });
       sc.setOnMouseReleased(e -> {
           txt3.setText("Mouse released") ;
       });
       sc.setOnMouseExited(e -> {
           txt5.setText("Mouse out of bounds") ;
       });
       sc.setOnMouseEntered(e-> {
           txt5.setText("");
       });
       primaryStage.setScene(sc) ;
       primaryStage.setTitle("Mouse Tracker") ;
       primaryStage.show() ;
       
    }
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
