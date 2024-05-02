import javax.swing.*;
import java.awt.*;

public class Main {
    public static FamilyTreeController familyTreeController;
    static MainMenu mainMenu;
    public static void main(String[]args){
        familyTreeController = new FamilyTreeController();
        familyTreeController.initialize();
        mainMenu = new MainMenu();
    }
}
