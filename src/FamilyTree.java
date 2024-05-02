public class FamilyTree {
    private FamilyTreeNode root;
    public FamilyTree(){
        root = null;
    }

    public void insert(String name, PersonType personType){
        if (root == null){
            root = new FamilyTreeNode(name);
        } else if(personType==PersonType.FATHER){
            root.setFather(new FamilyTreeNode(name));
        } else {
            root.setMother(new FamilyTreeNode(name));
        }
    }

    public FamilyTreeNode search(FamilyTreeNode currentlyViewedNode, FamilyTreeNode nodeToCompare){

            if (currentlyViewedNode == null) {
                return null;
            }

            if ((currentlyViewedNode.getFather() != null && currentlyViewedNode.getFather() == nodeToCompare) || (currentlyViewedNode.getMother() != null && currentlyViewedNode.getMother() == nodeToCompare)) {
                return currentlyViewedNode;
            }

            FamilyTreeNode leftResult = search(currentlyViewedNode.getFather(), nodeToCompare);
            if (leftResult != null) {
                return leftResult;
            }

            return search(currentlyViewedNode.getMother(), nodeToCompare);
    }


    public void inOrderTraversal(FamilyTreeNode node){
        if(node != null){

            inOrderTraversal(node.getMother());
            System.out.println(node.getName());
            inOrderTraversal(node.getFather());
        }

    }

    public FamilyTreeNode getRoot(){
        return root;
    }

    public void setRoot(FamilyTreeNode root) {
        this.root = root;
    }
}
