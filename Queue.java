class Queue {
  private static final int DEFAULT_CAPACITY = 10;

  private int maxSize;
  private int[] arr;
  private int front;
  private int back;
  private int nItems;

  // Initialize with DEFAULT_CAPACITY
  public Queue() {
    this(DEFAULT_CAPACITY);
  }

  // Constructor
  public Queue(int size) {
    maxSize = size;
    arr = new int[size];
    front = 0;
    back = -1;
    nItems = 0;
  }

  //Inserts element at back of Q, returns boolean
  public boolean insert(int x) {
    if (isFull()) return false;
    back = (back + 1) % maxSize;
    arr[back] = x;
    nItems++;
    return true;
  }

  public int remove() {
    if (isEmpty()) {
      return -1;
    }
    int temp = arr[front];
    front = (front + 1) % maxSize;
    nItems--;
    return temp;
  }

  public int peekFront() {
    return arr[front];
  }

  public int peekBack() {
    return arr[back];
  }

  public boolean isEmpty() {
    return nItems == 0;
  }

  public boolean isFull() {
    return nItems == maxSize;
  }
   
  public int getSize() {
    return nItems;
  }

}