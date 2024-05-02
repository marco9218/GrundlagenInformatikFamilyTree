public class FamilyTreeNode {
    private String name;
    private static int idCount=0;
    private int id;
    private FamilyTreeNode father, mother;
    public FamilyTreeNode(String name){
        this.name = name;
        father=mother=null;
        id=idCount;
        idCount++;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FamilyTreeNode getFather() {
        return father;
    }

    public void setFather(FamilyTreeNode father) {
        this.father = father;
    }

    public FamilyTreeNode getMother() {
        return mother;
    }

    public void setMother(FamilyTreeNode mother) {
        this.mother = mother;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
