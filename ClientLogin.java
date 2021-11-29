import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * ClientLogin - Allows clients to login to connect with other members
 * Name: Anthony, Justin, Isaac, Charan
 * Course/Section: ISTE-121-02
 */

public class ClientLogin extends Application implements EventHandler<ActionEvent> {
   // Window objects
   Stage stage = null;
   Scene scene = null;
   VBox root = null;
   
   // GUI Components
   private TextField tfIPAddress = new TextField();
   private TextField tfPort = new TextField();
   private TextField tfName = new TextField();
   private TextField tfPass = new TextField();
   private String strPort = null;
   private String strIP = null;
   private String strName = null;
   private Button btnConnect = new Button("Connect");
   private Button btnGetNames = new Button("Send Message");
   private TextArea taMessages = new TextArea();
   
   // Networking
   private Socket socket = null;
   private static final int SERVER_PORT = 35672;
   private PrintWriter pwt = null;
   private Scanner scn = null;
     
   /**
    * Main program ... 
    * @args - command line arguments (ignored)
    */
   public static void main(String[] args) {
      launch(args);
   }
   
   /** constructor */
   public void start(Stage _stage) {
      // Window set up
      stage = _stage;
      stage.setTitle("Client Login");
      final int WIDTH = 500;
      final int HEIGHT = 500;
      final int X = 50;
      final int Y = 100;
      stage.setX(X);
      stage.setY(Y);
      stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
         public void handle(WindowEvent evt) { System.exit(0); }
      });
      
      // Draw the GUI
      root = new VBox();
      
      HBox hbTop = new HBox(10);
      hbTop.getChildren().addAll(new Label("IP Address"), tfIPAddress, new Label("Port"), tfPort, btnConnect);
      
      HBox hbBot = new HBox();
      hbBot.setAlignment(Pos.CENTER);
      hbBot.getChildren().addAll(btnGetNames);
      
      root.getChildren().addAll(hbTop, taMessages, hbBot);
      for(Node n: root.getChildren()) {
         VBox.setMargin(n, new Insets(10));
      }
      
      // Handle button clicks
      btnConnect.setOnAction(this);
      btnGetNames.setOnAction(this);
      
      // Set the scene and show the stage
      scene = new Scene(root, WIDTH, HEIGHT);
      stage.setScene(scene);
      stage.show();   
      
      // Adjust settings
      taMessages.setPrefHeight(HEIGHT - hbTop.getPrefHeight() - hbBot.getPrefHeight());
      tfIPAddress.setPrefColumnCount(12);
      tfPort.setPrefColumnCount(7); 
      taMessages.setWrapText(true);
   }
   
   /** Button handler */
   public void handle(ActionEvent ae) {
      switch(((Button)ae.getSource()).getText()) {
         case "Send Message":
            doSendMessage();
            break;
         case "Connect":
            doConnect();
            break;
         case "Disconnect":
            doDisconnect();
            break;
      }
   }
   
    public void doSendMessage() {
         if(taMessages.isEmpty(true))
         {
            System.out.println("Message not typed");
            break;
         }
         //check if message is typed in the box
         // if yes, continue bla bla bla
         // else, report error and dont do anything else
    }
    
    public void doConnect() {
         if(strPort.isEmpty(true) || strIP.isEmpty(true))
         {
            if(strPort.isValid(true) || strIP.isValid(true) // this probably doesn't work we need to figure this out cause idk what to do here
            {
            }
            else
            {
               System.out.println("Either the IP or the Port is not valid");
               break;
            }
         }
         else
         {
            System.out.println("Either the IP or the Port is not typed.");
            break;
         }
         //check if IP and Port are filled out
         //if so, check if valid
            // if valid, connect
            // if not valid, report error dont do anything else
         //if not, report error, dont do anything
    }
    
//    public void doDisconnect() {
         //check if connected is true
         //if true, set it to false and remove IP/PORT
         //if false, report error and do nothing
//    }
   
}