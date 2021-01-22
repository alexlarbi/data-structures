class Node {
  int value;

  Node next;

  Node() {}

  Node(int value) {
    this(value, null);
  }

  Node(int value, Node next) {
    this.value = value;
    this.next = next;
  }
}

public class SinglyLinkedList {

  private Node head;

  private int size;

  public SinglyLinkedList() {
    head = null;
    size = 0;
  }

  public SinglyLinkedList(Node head, int size) {
    this.head = head;
    this.size = size;
  }


  public void insertHead(int x) {
    insertNth(x, 0);
  }


  public void insert(int data) {
    insertNth(data, size);
  }

  public void insertNth(int data, int position) {
    checkBounds(position, 0, size);
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
      size++;
      return;
    } else if (position == 0) {
      newNode.next = head;
      head = newNode;
      size++;
      return;
    }
    Node cur = head;
    for (int i = 0; i < position - 1; ++i) {
      cur = cur.next;
    }
    newNode.next = cur.next;
    cur.next = newNode;
    size++;
  }

  public void deleteHead() {
    deleteNth(0);
  }

  public void delete() {
    deleteNth(size - 1);
  }

  public void deleteNth(int position) {
    checkBounds(position, 0, size - 1);
    if (position == 0) {
      Node destroy = head;
      head = head.next;
      destroy = null;
      size--;
      return;
    }
    Node cur = head;
    for (int i = 0; i < position - 1; ++i) {
      cur = cur.next;
    }

    Node destroy = cur.next;
    cur.next = cur.next.next;
    destroy = null; 

    size--;
  }

  public void clear() {
    Node cur = head;
    while (cur != null) {
      Node prev = cur;
      cur = cur.next;
      prev = null; 
    }
    head = null;
    size = 0;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }


  public Node getHead() {
    return head;
  }


  public int count() {
    int count = 0;
    Node cur = head;
    while (cur != null) {
      cur = cur.next;
      count++;
    }
    return count;
  }


  public boolean search(int key) {
    Node cur = head;
    while (cur != null) {
      if (cur.value == key) {
        return true;
      }
      cur = cur.next;
    }
    return false;
  }

  public int getNth(int index) {
    checkBounds(index, 0, size - 1);
    Node cur = head;
    for (int i = 0; i < index; ++i) {
      cur = cur.next;
    }
    return cur.value;
  }
}
