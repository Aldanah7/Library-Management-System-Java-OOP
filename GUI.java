
package pkg3_2i2_townlibrarysystem;
import java.util.ArrayList; 
import javafx.application.Application; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.TextArea; 
import javafx.scene.layout.GridPane; 
import javafx.scene.paint.Color; 
import javafx.scene.text.Font; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text; 
import javafx.stage.Stage; 
 
public class GUI extends Application { 
 
    @Override 
    public void start(Stage primaryStage) { 
 
        GridPane grid = new GridPane(); 
        grid.setAlignment(Pos.CENTER); 
        grid.setHgap(10); 
        grid.setVgap(15); 
        grid.setPadding(new Insets(10)); 
 
        Text msg = new Text("Welcome to the App"); 
        msg.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20)); 
        msg.setFill(Color.RED); 
        grid.add(msg, 0, 0, 2, 1); 
 
        TextArea area = new TextArea(); 
        area.setEditable(false); 
        area.setPrefHeight(200); 
        grid.add(area, 0, 1, 2, 1); 
 
        Button btnBorrow = new Button("Show Borrow Sessions"); 
        grid.add(btnBorrow, 0, 2); 
        btnBorrow.setOnAction(new EventHandler<ActionEvent>() { 
            @Override 
            public void handle(ActionEvent event) { 
                ArrayList<BorrowSession> list = Main.BorrowList; 
                if (list == null || list.isEmpty()) { 
                    area.setText("No borrow sessions available."); 
                    return; 
                } 
                String s = ""; 
                for (BorrowSession session : list) { 
                    s += session + "\n"; 
                } 
                area.setText(s); 
            } 
        }); 
 
        Button btnCheckout = new Button("Show Checkouts"); 
        grid.add(btnCheckout, 1, 2); 
        btnCheckout.setOnAction(new EventHandler<ActionEvent>() { 
            @Override 
            public void handle(ActionEvent event) { 
                ArrayList<BookCheckout> list = Main.itemList; 
                if (list == null || list.isEmpty()) { 
                    area.setText("No checkouts available."); 
                    return; 
                } 
                String s = ""; 
                for (BookCheckout checkout : list) { 
                    s += checkout + "\n"; 
                } 
                area.setText(s); 
            } 
        }); 
 
        Scene scene = new Scene(grid, 400, 350); 
        primaryStage.setTitle("Town Library"); 
        primaryStage.setScene(scene); 
        primaryStage.setResizable(false); 
        primaryStage.show(); 
    } 
 
    public static void main(String[] args) { 
        launch(args); 
    } 
}