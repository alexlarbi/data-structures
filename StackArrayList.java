public class StackArrayList {

  private ArrayList<Integer> stack;

  // Constructor 
  public StackArrayList() {
    stack = new ArrayList<>();
  }

  public void push(int value) {
    stack.add(value);
  }

  public int pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }

    
    return stack.remove(stack.size() - 1);
  }

  public boolean isEmpty() {
    return stack.isEmpty();
  }


}