/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionpaie;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Oop
 */
public class Main extends Application {
    
    public static Parent root1 ;
    public static Scene scene1 ;
    public static Stage primaryStage1 ;
    public static Parent root2 ;
    public static Scene scene2 ;
    public static Stage primaryStage2 ;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       
        root1 = FXMLLoader.load(getClass().getResource("AuthentifcationFXML.fxml"));        
        scene1 =new Scene(root1); 
        Main.primaryStage1=primaryStage ;
        this.primaryStage1.setScene(scene1);
        this.primaryStage1.show();
        
        root2= FXMLLoader.load(getClass().getResource("AuthentifcationFXML.fxml"));        
        scene2 =new Scene(root2); 
        Main.primaryStage2=new Stage()  ;
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
