
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TextEditor{
    private String name = "Untitled";
    private static int count = 0;
    
    public TextEditor(){
        if(count != 0){
            name = name+count;
        }
    }
    
    public void display(){
        
        Stage window = new Stage();
        BorderPane borderPane = new BorderPane();
        TextArea textArea = new TextArea();
        
        MenuBar menuBar = new MenuBar();
        
        Menu file = new Menu("File");
        MenuItem newFileItem = new MenuItem("New");
        newFileItem.setOnAction(e -> {
            new TextEditor().display();
        });
        MenuItem openFileItem = new MenuItem("Open");
        openFileItem.setOnAction(e -> {
            OpenBox.display(textArea);    
        });
        MenuItem saveFileItem = new MenuItem("Save");
        MenuItem saveAsFileItem = new MenuItem("Save As");
        MenuItem closeFileItem = new MenuItem("Close");
        file.getItems().addAll(newFileItem, openFileItem, saveFileItem, saveAsFileItem, closeFileItem);
        
        Menu edit = new Menu("Edit");
        MenuItem undoEditItem = new MenuItem("Undo");
        MenuItem redoEditItem = new MenuItem("Redo");
        MenuItem cutEditItem = new MenuItem("Cut");
        MenuItem copyEditItem = new MenuItem("Copy");
        MenuItem pasteEditItem = new MenuItem("Paste");
        MenuItem deleteEditItem = new MenuItem("Delete");
        MenuItem preferencesEditItem = new MenuItem("Preferences");
        edit.getItems().addAll(undoEditItem, redoEditItem, cutEditItem, copyEditItem, pasteEditItem, deleteEditItem, preferencesEditItem);
        
        Menu help = new Menu("Help");
        MenuItem about = new MenuItem("About");
        help.getItems().addAll(about);
        
        menuBar.getMenus().addAll(file, edit, help);
        borderPane.setTop(menuBar);
        
        
        borderPane.setCenter(textArea);
        
        Scene scene = count==0?new Scene(borderPane):new Scene(borderPane, 900, 600);
        if(count == 0){
            window.setMaximized(true);
        }
        
        window.setScene(scene);
        window.setTitle(name);
        count++;
        window.show();
    }
}