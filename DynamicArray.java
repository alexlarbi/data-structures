public class DynamicArray<E> implements Iterable<E> {

  private int capacity;
  private int size;
  private Object[] elements;

  public DynamicArray(final int capacity) {
    this.size = 0;
    this.capacity = capacity;
    this.elements = new Object[this.capacity];
  }

  // Constructor 
  public DynamicArray() {
    this.size = 0;
    this.capacity = 10;
    this.elements = new Object[this.capacity];
  }

  public int newCapacity() {
    this.capacity *= 2;
    return this.capacity;
  }

  public void add(final E element) {
    if (this.size == this.elements.length) {
      this.elements = Arrays.copyOf(this.elements, newCapacity());
    }

    this.elements[this.size] = element;
    size++;
  }

  public void put(final int index, E element) {
    this.elements[index] = element;
  }

  public E get(final int index) {
    return getElement(index);
  }


  public E remove(final int index) {
    final E oldElement = getElement(index);
    fastRemove(this.elements, index);

    return oldElement;
  }

  public int getSize() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public Stream<E> stream() {
    return StreamSupport.stream(spliterator(), false);
  }

  private void fastRemove(final Object[] elements, final int index) {
    final int newSize = this.size - 1;

    if (newSize > index) {
      System.arraycopy(elements, index + 1, elements, index, newSize - index);
    }

    elements[this.size = newSize] = null;
  }

  private E getElement(final int index) {
    return (E) this.elements[index];
  }