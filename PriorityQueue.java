
public class PriorityQueue{

    int[] heap;
    int size;

    //Constructor
    public PriorityQueue(int maxSize){
        heap = new int[maxSize];
        size = 0;
    }

    public void push(int val){
        if(size == heap.length) 
            throw new IllegalArgumentExpection();
        
        //Put val in next available spot
        int pos = size;
        heap[pos] = val;
        
        //While child is less than parent, swap
        while(pos > 0){
            //Get parent and compare values
            int parent = ((pos+1) / 2) - 1;
            if(heap[parent] > heap[pos]) break;
            swapIndicies(parent, pos);
            pos = parent;
        }

        size++;
    } 

    public int pop(){
        if(size == 0) 
            throw new IllegalArgumentExpection();
        
        //Save top of the heap
        int toReturn = heap[0];

        //Move top element to bottom
        heap[0] = heap[size - 1];
        size--;

        //Move down top element to correct spot
        int pos = 0;

        //Swap with children
        while(pos < size / 2) { 
            int leftChild = pos * 2 + 1;
            int rightChild = leftChild + 1;

            //Rightchild exists and is greater than leftChild
            if(rightChild < size && heap[leftChild] < heap[rightChild]) { 
                swapIndicies(pos, rightChild);
                pos = rightChild;
            }else{
                //Same but with left child
                if(heap[pos] >= heap[leftChild]) 
                    break;
                swapIndicies(pos, leftChild);
                pos = leftChild;
            }
          
        }
        return toReturn;
    }

    private void swapIndicies(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    } 

}
