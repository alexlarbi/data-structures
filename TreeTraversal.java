import java.util.LinkedList;

class Node {
  Node left, right;
  int data;

  public Node(int data) {
    this.data = data;
  }

  public void insert(int value) {
    if (value < data) {
      if (left == null) {
        left = new Node(value);
      } else {
        left.insert(value);
      }
    } else {
      if (right == null) {
        right = new Node(value);
      } else {
        right.insert(value);
      }
    }
  }

  public void printInOrder() {
    if (left != null) {
      left.printInOrder();
    }
    System.out.print(data + " ");
    if (right != null) {
      right.printInOrder();
    }
  }

  public void printPreOrder() {
    System.out.print(data + " ");
    if (left != null) {
      left.printPreOrder();
    }
    if (right != null) {
      right.printPreOrder();
    }
  }

  public void printPostOrder() {
    if (left != null) {
      left.printPostOrder();
    }
    if (right != null) {
      right.printPostOrder();
    }
    System.out.print(data + " ");
  }

  public void printLevelOrder() {
    LinkedList<Node> queue = new LinkedList<>();
    queue.add(this);
    while (queue.size() > 0) {
      Node head = queue.remove();
      System.out.print(head.data + " ");
      if (head.left != null) {
        queue.add(head.left);
      }
      if (head.right != null) {
        queue.add(head.right);
      }
    }
  }
}