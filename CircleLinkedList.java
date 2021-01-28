public class CircleLinkedList<E> {
  private static class Node<E> {
    Node<E> next;
    E value;

    private Node(E value, Node<E> next) {
      this.value = value;
      this.next = next;
    }
  }

  private int size;
  private Node<E> head = null;

  //Constructor
  public CircleLinkedList() {
    head = new Node<E>(null, head);
    size = 0;
  }

  public int getSize() {
    return size;
  }

  public void append(E value) {
    if (value == null) {
      throw new NullPointerException("Cannot add null");
    }
    head.next = new Node<E>(value, head);
    size++;
  }

  public E remove(int pos) {
    if (pos > size || pos < 0) {
      throw new IndexOutOfBoundsException("Invalid position entry");
    }

    Node<E> before = head;
    for (int i = 1; i <= pos; i++) {
      before = before.next;
    }
    Node<E> destroy = before.next;
    E saved = destroy.value;

    before.next = before.next.next;
    destroy = null;
    size--;
    return saved;
  }
}