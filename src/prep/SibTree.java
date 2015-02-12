package prep;

public class SibTree {
  SibTreeNode root;
  int size; // Number of nodes
  
  SibTree() {
    this.root = null;
    this.size = 0;
  }
  
  private class SibTreeNode {
    int item;
    SibTreeNode parent;
    SibTreeNode firstChild;
    SibTreeNode nextSibling;

    public void visit() {
      System.out.println(this.item);
    }

    public void preOrder() {
      this.visit();

      if (firstChild != null) {
        firstChild.preOrder();
      }

      if (nextSibling != null) {
        nextSibling.preOrder();
      }

    }
     
     public void postOrder() {
      if (firstChild != null) {
        firstChild.preOrder();
      }

      this.visit();

      if (nextSibling != null) {
        nextSibling.postOrder();
      }
     }
    }
    
    public static void main(String[] args) {}
    
}