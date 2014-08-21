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
    
    public static Parent root ;
    public static Scene scene ;
    public static Stage primaryStage ;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       
        root = FXMLLoader.load(getClass().getResource("AuthentifcationFXML.fxml"));        
        scene =new Scene(root); 
        Main.primaryStage=primaryStage ;
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
