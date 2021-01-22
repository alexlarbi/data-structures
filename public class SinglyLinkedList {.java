public class SinglyLinkedList {
  /** Head refer to the front of the list */
  private Node head;

  /** Size of SinglyLinkedList */
  private int size;

  /** Init SinglyLinkedList */
  public SinglyLinkedList() {
    head = null;
    size = 0;
  }

  /**
   * Init SinglyLinkedList with specified head node and size
   *
   * @param head the head node of list
   * @param size the size of list
   */
  public SinglyLinkedList(Node head, int size) {
    this.head = head;
    this.size = size;
  }

  /**
   * Inserts an element at the head of the list
   *
   * @param x element to be added
   */
  public void insertHead(int x) {
    insertNth(x, 0);
  }

  /**
   * Insert an element at the tail of the list
   *
   * @param data element to be added
   */
  public void insert(int data) {
    insertNth(data, size);
  }

  /**
   * Inserts a new node at a specified position of the list
   *
   * @param data data to be stored in a new node
   * @param position position at which a new node is to be inserted
   */
  public void insertNth(int data, int position) {
    checkBounds(position, 0, size);
    Node newNode = new Node(data);
    if (head == null) {
      /* the list is empty */
      head = newNode;
      size++;
      return;
    } else if (position == 0) {
      /* insert at the head of the list */
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

  /** Deletes a node at the head */
  public void deleteHead() {
    deleteNth(0);
  }

  /** Deletes an element at the tail */
  public void delete() {
    deleteNth(size - 1);
  }

  /** Deletes an element at Nth position */
  public void deleteNth(int position) {
    checkBounds(position, 0, size - 1);
    if (position == 0) {
      Node destroy = head;
      head = head.next;
      destroy = null; /* clear to let GC do its work */
      size--;
      return;
    }
    Node cur = head;
    for (int i = 0; i < position - 1; ++i) {
      cur = cur.next;
    }

    Node destroy = cur.next;
    cur.next = cur.next.next;
    destroy = null; // clear to let GC do its work

    size--;
  }
