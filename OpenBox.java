
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class OpenBox{
    public static void display(TextArea textArea){
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(filter);
        File file = fileChooser.showOpenDialog(stage);
        
        try(Scanner fileReader = new Scanner(file)) {
            while(fileReader.hasNextLine()){
                textArea.appendText(fileReader.nextLine()+"\n");
            }
            fileReader.close();
        }catch(FileNotFoundException e){
            System.out.println("No");
        }
    }
}