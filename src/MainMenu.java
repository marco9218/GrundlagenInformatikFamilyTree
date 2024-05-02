import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
    private  String programTitle, beginningButtonLabel, endingButtonLabel, fatherButtonLabel, motherButtonLabel,
            childButtonLabel, programInformationMessage, userInput;
    private  JButton beginningButton, endingButton, fatherButton, motherButton, childButton;
    private JPanel menuPanel, childPanel, parentsPanel;
    private TextField childTextField, fatherTextField, motherTextField;
    private JLabel childTextFieldLabel, fatherTextFieldLabel, motherTextFieldLabel;
    //private Enum personTypeChild, personTypeFather, personTypeMother;

    public MainMenu(){
        initializeStrings();
        drawMainMenu();
        showInputDialog(PersonType.CHILD);
        childTextField.setText(Main.familyTreeController.getPartialFamilyTree().getRoot().getName());
    }

    private void clearUserInput(){
        userInput = null;
    }

    private void createBeginnButton(){
        beginningButton = new JButton(beginningButtonLabel);
        menuPanel.add(beginningButton);
        beginningButton.addActionListener(this);
    }

    private void createChildButton(){
        childButton = new JButton(childButtonLabel);
        menuPanel.add(childButton);
        childButton.addActionListener(this);
    }

    private void createFatherButton(){
        fatherButton = new JButton(fatherButtonLabel);
        menuPanel.add(fatherButton);
        fatherButton.addActionListener(this);
    }

    private void createMotherButton(){
        motherButton = new JButton(motherButtonLabel);
        menuPanel.add(motherButton);
        motherButton.addActionListener(this);
    }

    private void createEndingButton(){
        endingButton = new JButton(endingButtonLabel);
        menuPanel.add(endingButton);
        endingButton.addActionListener(this);
    }

    private void createChildTextField(){
        childTextFieldLabel = new JLabel("Kind");
        childPanel.add(childTextFieldLabel);
        childTextField = new TextField(10);
        childPanel.add(childTextField);
        childTextField.setEditable(false);
    }

    private void createFatherTextField(){
        fatherTextFieldLabel = new JLabel("Vater");
        parentsPanel.add(fatherTextFieldLabel);
        fatherTextField = new TextField(10);
        fatherTextField.setEditable(false);
        parentsPanel.add(fatherTextField);
    }

    private void createMotherTextField(){
        motherTextFieldLabel = new JLabel("Mutter");
        parentsPanel.add(motherTextFieldLabel);
        motherTextField = new TextField(10);
        motherTextField.setEditable(false);
        parentsPanel.add(motherTextField);
    }

    private void drawMainMenu(){
        //mainMenu = new JFrame(programTitle);
        setSize(500, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuPanel = new JPanel();
        childPanel = new JPanel();
        parentsPanel = new JPanel();
        createChildButton();
        createFatherButton();
        createMotherButton();
        createBeginnButton();
        createEndingButton();
        createChildTextField();
        createFatherTextField();
        createMotherTextField();
        this.getContentPane().add("North", menuPanel);
        this.getContentPane().add("Center", childPanel);
        this.getContentPane().add("South", parentsPanel);
        setVisible(true);
    }

    private void initializeStrings(){
        programTitle = "Stammbaum";
        beginningButtonLabel = "Anfang";
        endingButtonLabel = "Ende";
        fatherButtonLabel = "Vater";
        motherButtonLabel = "Mutter";
        childButtonLabel = "Kind";
        programInformationMessage = "Test";
        userInput = null;
    }

    private void showInputDialog(PersonType personType){
        while (userInput == null || userInput.trim().isEmpty()) {
            userInput = JOptionPane.showInputDialog(null,"Gib einen Namen ein:");
            if (userInput == null || userInput.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Gib zumindest ein Zeichen ein.", "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
            }
        }
        Main.familyTreeController.insertFirstFamilyTreeNode(userInput, personType);
        updateTextFields();
        clearUserInput();
    }

    private void updateTextFields(){
        if(Main.familyTreeController.getPartialFamilyTree().getRoot()!=null){
        childTextField.setText(Main.familyTreeController.getPartialFamilyTree().getRoot().getName());
        }
        if(Main.familyTreeController.getPartialFamilyTree().getRoot().getFather()!=null){
        fatherTextField.setText(Main.familyTreeController.getPartialFamilyTree().getRoot().getFather().getName());
        } else {
            fatherTextField.setText(null);
        }
        if(Main.familyTreeController.getPartialFamilyTree().getRoot().getMother()!=null){
            motherTextField.setText(Main.familyTreeController.getPartialFamilyTree().getRoot().getMother().getName());
        } else {
            motherTextField.setText(null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==childButton){
            if(Main.familyTreeController.getPartialFamilyTree().getRoot()==Main.familyTreeController.getFamilyTree().getRoot()) {
                JOptionPane.showMessageDialog(null, "Du hast hier die oberste Ebene des Stammbaumes bereits erreicht.", "Ungültige Eingabe", JOptionPane.PLAIN_MESSAGE);
            }
            else {
                Main.familyTreeController.updateTree(PersonType.CHILD);
                updateTextFields();
            }
        }
        else if(e.getSource()==fatherButton){
            if(Main.familyTreeController.getPartialFamilyTree().getRoot().getFather()==null){
            showInputDialog(PersonType.FATHER);
            } else {
                Main.familyTreeController.updateTree(PersonType.FATHER);
                updateTextFields();
            }
        }
        else if(e.getSource()==motherButton){
            if(Main.familyTreeController.getPartialFamilyTree().getRoot().getMother()==null){
            showInputDialog(PersonType.MOTHER);
            } else {
                Main.familyTreeController.updateTree(PersonType.MOTHER);
                updateTextFields();
            }
        }
        else if(e.getSource()==beginningButton){
            Main.familyTreeController.getPartialFamilyTree().setRoot(Main.familyTreeController.getFamilyTree().getRoot());
            updateTextFields();
        }
        else if(e.getSource()==endingButton){
            this.dispose();
        }
    }
}
