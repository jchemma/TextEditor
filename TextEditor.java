import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextEditor extends Application{
    
    Stage window;
    Scene scene;
    TextArea textArea;
    Boolean saved = false;
    
    public static void main(String[]args){
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception{
        window = stage;
        
        //Menubar that will be located at the top of the page
        MenuBar menuBar = new MenuBar();
        
        //File option on Menu Bar
        Menu file = new Menu("File");
        
        //File Options
        
        //New
        MenuItem newFileItem = new MenuItem("New");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> {
            System.out.println("Closing...");
            if(saved){
                window.close();
            }
        });
        
        //Open
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem separatorFile = new SeparatorMenuItem();
        file.getItems().addAll(openMenuItem,newFileItem,separatorFile,exit);
        
        //Edit option on menuBar
        Menu edit = new Menu("Edit");
        
        //Edit Options
        MenuItem editMenuItem = new MenuItem("Undo");
        MenuItem cutEditItem = new MenuItem("Cut");
        MenuItem copyEditItem = new MenuItem("Copy");
        MenuItem pasteEditItem = new MenuItem("Paste");
        MenuItem separator = new SeparatorMenuItem();
        edit.getItems().addAll(editMenuItem,separator,cutEditItem,copyEditItem,pasteEditItem);
        
        //TextArea
        textArea = new TextArea();
        
        //Add menu options to menuBar
        menuBar.getMenus().addAll(file,edit);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(menuBar,textArea);
        
        scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }
    
}