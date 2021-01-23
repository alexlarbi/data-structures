public class DoublyLinkedList {
  
  private Link head;
  private Link tail;
  private int size;

  // Constructor
  public DoublyLinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  // Constructs a list from elements in the array
  public DoublyLinkedList(int[] array) {
    if (array == null) throw new NullPointerException();
    for (int i : array) {
      insertTail(i);
    }
    size = array.length;
  }

  public void insertHead(int x) {
    Link newLink = new Link(x); 
    if (isEmpty()) 
    tail = newLink;
    else head.previous = newLink; 
    newLink.next = head; 
    head = newLink; 
    ++size;
  }

  public void insertTail(int x) {
    Link newLink = new Link(x);
    newLink.next = null; 
    if (isEmpty()) { 
      tail = newLink;
      head = tail;
    } else {
      tail.next = newLink; 
      newLink.previous = tail; 
      tail = newLink;
    }
    ++size;
  }

  public void insertElementByIndex(int x, int index) {
    if (index > size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    if (index == 0) {
      insertHead(x);
    } else {
      if (index == size) {
        insertTail(x);
      } else {
        Link newLink = new Link(x);
        Link previousLink = head; 
        for (int i = 1; i < index; i++) { 
          previousLink = previousLink.next;
        }
        
        previousLink.next.previous = newLink;
        newLink.next = previousLink.next;
        newLink.previous = previousLink;
        previousLink.next = newLink;
      }
    }
    ++size;
  }

  public Link deleteHead() {
    Link temp = head;
    head = head.next; 

    if (head == null) {
      tail = null;
    } else {
      head.previous =
          null; 
    }
    --size;
    return temp;
  }


  public Link deleteTail() {
    Link temp = tail;
    tail = tail.previous; 

    if (tail == null) {
      head = null;
    } else {
      tail.next = null; 
    }
    --size;
    return temp;
  }

  public void delete(int x) {
    Link current = head;

    while (current.value != x) { 
      if (current != tail) {
        current = current.next;
      } else { 
        throw new RuntimeException("Element does not exist.");
      }
    }

    if (current == head) deleteHead();
    else if (current == tail) deleteTail();
    else { 
      current.previous.next = current.next; 
      current.next.previous = current.previous; 
    }
    --size;
  }

  public void insertOrdered(int x) {
    Link newLink = new Link(x);
    Link current = head;
    while (current != null && x > current.value) 
    current = current.next;

    if (current == head) insertHead(x);
    else if (current == null) insertTail(x);
    else { 
      newLink.previous = current.previous;
      current.previous.next = newLink; 
      newLink.next = current; 
      current.previous = newLink; 
    }
    ++size;
  }

  public void deleteNode(Link z) {
    if (z.next == null) {
      deleteTail();
    } else if (z == head) {
      deleteHead();
    } else { 
      z.previous.next = z.next; 
      z.next.previous = z.previous;
    }
    --size;
  }

  public static void removeDuplicates(DoublyLinkedList l) {
    Link linkOne = l.head;
    while (linkOne.next != null) { 
      Link linkTwo = linkOne.next; 
      while (linkTwo.next != null) {
        if (linkOne.value == linkTwo.value) 
        l.delete(linkTwo.value); 
        linkTwo = linkTwo.next; 
      }
      linkOne = linkOne.next; 
    }
  }

  public void clearList() {
    head = null;
    tail = null;
    size = 0;
  }

  public boolean isEmpty() {
    return (head == null);
  }

}


class Link {

  public int value;
  public Link next;

  public Link previous;

  public Link(int value) {
    this.value = value;
  } 
}