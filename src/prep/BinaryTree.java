package prep;

/*
 * Entry remove(Object k);
 *   Find a node n with key k
 *   Return null if k not in tree
 *   If n has no children, detach it from parent
 *   If n has one child, move n's child up to take n's place
 *   If n has 2 children,
 *     Let x be node in n's right subtree with smallest key
 *     Remove x - x has no left child and therefore is easily removed
 *     Replace n's key with x's key
 * 
 */

public class BinaryTree {
  BinaryTreeNode root;
  int size;
  
  public Object find(Object k) {
    BinaryTreeNode node = root;
    
    while (node != null) {
      int comp = ((Comparable) k).compareTo(node.entry.key); // If we know the keys are int we can just compare keys each time (this.key > k.key .. etc)
      if (comp < 0) { // The key that we are searching for is less than the one visited so we must go left
        node = node.left;
      } else if (comp > 0) { // The key that we are searching for is greater than the one visited so we must go right
        node = node.right;
      } else {
        return node.entry; // Comparable is a match
      }
    }
    
    return null; // Didn't find anything
  }
  
  public BSTEntry first() {
    BinaryTreeNode node = root;
    
    while (node.left != null) {
      node = node.left;
    }
    return node.entry;
  }
  
  public BSTEntry last() {
    BinaryTreeNode node = root;
    
    while (node.right != null) {
      node = node.right;
    }
    return node.entry;
  }
  
  // Not sure if this is 100% right
  public void insert(Object k, Object v) {
    BinaryTreeNode node = root;
    
    while (node != null) {
      int comp = ((Comparable) k).compareTo(node.entry.key); // If we know the keys are int we can just compare keys each time (this.key > k.key .. etc)
      if (comp < 0) { // The key that we are searching for is less than the one visited so we must go left
        node = node.left;
      } else if (comp > 0) { // The key that we are searching for is greater than the one visited so we must go right
        node = node.right;
      }
    }
    node.entry = new BSTEntry(k, v);
  }
  
  
}

class BinaryTreeNode  {
  BSTEntry entry;
  BinaryTreeNode parent;
  BinaryTreeNode left;
  BinaryTreeNode right;
  
  BinaryTreeNode(BSTEntry entry) {
    this.entry = entry;
  }
  
  public void inorder() {
    if (left !=null) {
      left.inorder();
    }
    this.visit();
    if (right != null) {
      right.inorder();
    }
  }
  
  public BinaryTreeNode visit() {
    System.out.println("Visiting a node: " + this);
    return this;
  }
}

class BSTEntry {
  Object key;
  Object value;
  
  BSTEntry(Object key, Object value) {
    this.key = key;
    this.value = value;
  }
}


/*
public boolean remove(int key) {

// Start at the top of the tree

Node focusNode = root;
Node parent = root;

// When searching for a Node this will
// tell us whether to search to the
// right or left

boolean isItALeftChild = true;

// While we haven't found the Node
// keep looking

while (focusNode.key != key) {

  parent = focusNode;

  // If we should search to the left

  if (key < focusNode.key) {

    isItALeftChild = true;

    // Shift the focus Node to the left child

    focusNode = focusNode.leftChild;

  } else {

    // Greater than focus node so go to the right

    isItALeftChild = false;

    // Shift the focus Node to the right child

    focusNode = focusNode.rightChild;

  }

  // The node wasn't found

  if (focusNode == null)
    return false;

}

// If Node doesn't have children delete it

if (focusNode.leftChild == null && focusNode.rightChild == null) {

  // If root delete it

  if (focusNode == root)
    root = null;

  // If it was marked as a left child
  // of the parent delete it in its parent

  else if (isItALeftChild)
    parent.leftChild = null;

  // Vice versa for the right child

  else
    parent.rightChild = null;

}

// If no right child

else if (focusNode.rightChild == null) {

  if (focusNode == root)
    root = focusNode.leftChild;

  // If focus Node was on the left of parent
  // move the focus Nodes left child up to the
  // parent node

  else if (isItALeftChild)
    parent.leftChild = focusNode.leftChild;

  // Vice versa for the right child

  else
    parent.rightChild = focusNode.leftChild;

}

// If no left child

else if (focusNode.leftChild == null) {

  if (focusNode == root)
    root = focusNode.rightChild;

  // If focus Node was on the left of parent
  // move the focus Nodes right child up to the
  // parent node

  else if (isItALeftChild)
    parent.leftChild = focusNode.rightChild;

  // Vice versa for the left child

  else
    parent.rightChild = focusNode.rightChild;

}

// Two children so I need to find the deleted nodes
// replacement

else {

  Node replacement = getReplacementNode(focusNode);

  // If the focusNode is root replace root
  // with the replacement

  if (focusNode == root)
    root = replacement;

  // If the deleted node was a left child
  // make the replacement the left child

  else if (isItALeftChild)
    parent.leftChild = replacement;

  // Vice versa if it was a right child

  else
    parent.rightChild = replacement;

  replacement.leftChild = focusNode.leftChild;

}

return true;

}
*/