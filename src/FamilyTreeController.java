import javax.swing.*;

public class FamilyTreeController {
    private FamilyTree partialFamilyTree;
    private FamilyTree familyTree;

    public void initialize(){
        partialFamilyTree = new FamilyTree();
        familyTree = new FamilyTree();
    }

    public void insertFirstFamilyTreeNode(String name, PersonType personType){
        switch(personType){
            case CHILD:
                if(partialFamilyTree.getRoot()==null){
                    partialFamilyTree.insert(name, personType);
                    familyTree.setRoot(partialFamilyTree.getRoot());
                }
                break;
            case FATHER:
                if(partialFamilyTree.getRoot().getFather()==null){
                    partialFamilyTree.insert(name, personType);
                }
                break;
            case MOTHER:
                if(partialFamilyTree.getRoot().getMother()==null){
                    partialFamilyTree.insert(name,personType);
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ungültiger Personentyp.", "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    public void updateTree(PersonType personType){
        switch(personType){
            case CHILD:
                partialFamilyTree.setRoot(familyTree.search(familyTree.getRoot(), partialFamilyTree.getRoot()));
                //familyTree.inOrderTraversal(familyTree.getRoot());
            break;
            case FATHER:
                partialFamilyTree.setRoot(partialFamilyTree.getRoot().getFather());
            break;
            case MOTHER:
                partialFamilyTree.setRoot(partialFamilyTree.getRoot().getMother());
            break;
            default:
                JOptionPane.showMessageDialog(null, "Ungültiger Personentyp.", "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
            break;
        }
    }

    public FamilyTree getPartialFamilyTree() {
        return partialFamilyTree;
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }
}
