import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Stack;

public class MaxHeap {
	      
	    private static final int d= 2;
	    private Pasageri[] heap;
	    private int heapSize;
		private ArrayList<String> lista_afisare;
		private int lists = 0;
		public PrintWriter writer;
	      
	    /**
	     * This will initialize our heap with default size.
	     * @throws IOException 
	     */
	    public MaxHeap(int capacity) throws IOException{
	        heapSize = 0;
	        heap = new Pasageri[ capacity+1];
	        Arrays.fill(heap, new Pasageri("", "", 50, new Ticket("e"), false, false) {
	        	@Override
	        	public int calculatePoints() {
	        		return 0;
	        	}
	        });
	        File file = new File("queue.out");
	        writer = new PrintWriter(file);
	    }
	      
	    /**
	     *  This will check if the heap is empty or not
	     *  Complexity: O(1)
	     */
	    public boolean isEmpty(){
	        return heapSize==0;
	    } 
	      
	    private int parent(int i){
	        return (i-1)/d;
	    }
	      
	    private int kthChild(int i,int k){
	        return d*i  +k;
	    }
	      
	    /**
	     *  This will insert new element in to heap
	     *  Complexity: O(log N)
	     *  As worst case scenario, we need to traverse till the root
	     */
	    public void insert(Pasageri x){
	        heap[heapSize++] = x;
	        heapifyUp(heapSize-1);
	    }
	      
	    /**
	     *  This will delete element at index x
	     *  Complexity: O(log N)
	     *
	     */
	    
	    public void embark() {
	    	embark(0);
	    }
	    
	    public void embark(int x){
	        if(isEmpty())
	            throw new NoSuchElementException("Heap is empty, No element to delete");
	        
	        heap[x] = heap[heapSize -1];
	        heapSize--;
	        heapifyDown(x);
	    }
	  
	    /**
	     *  This method used to maintain the heap property while inserting an element.
	     * 
	     */
	    private void heapifyUp(int i) {
	        Pasageri temp = heap[i];
	        while(i>0 && temp.getTotal_priority() > heap[parent(i)].getTotal_priority()){
	            heap[i] = heap[parent(i)];
	            i = parent(i);
	        }
	        heap[i] = temp;
	    }
	      
	    /**
	     *  This method used to maintain the heap property while deleting an element.
	     * 
	     */
	    private void heapifyDown(int i){
	        int child;
	        Pasageri temp = heap[i];
	        while(kthChild(i, 1) < heapSize){
	            child = maxChild(i);
	            if(temp.getTotal_priority() < heap[child].getTotal_priority()){
	                heap[i] = heap[child];
	            }else
	                break;
	              
	            i = child;
	        }
	        heap[i] = temp;
	    }
	  
	    private int maxChild(int i) {
	        int leftChild = kthChild(i, 1);
	        int rightChild = kthChild(i, 2);
	          
	        return heap[leftChild].getTotal_priority()>=heap[rightChild].getTotal_priority()?leftChild:rightChild;
	    }
	      
	    /**
	     *  This method used to print all element of the heap
	     * 
	     */
	    public void list(int pos) 
		{ 
			Stack<Integer> stack = new Stack<Integer>();
			int i = pos;
			stack.push(i);
			
			while(stack.isEmpty() == false) {
				i = (int) stack.pop();
				lista_afisare.add(heap[i].id);
				if(kthChild(i,2) < heapSize)
					stack.push(kthChild(i,2));
				if(kthChild(i,1) < heapSize)
					stack.push(kthChild(i,1));
			}
		} 
		public void list() throws FileNotFoundException   {
			lista_afisare = new ArrayList<String>();
			if(lists == 0)
				lists ++;
			else if(lists != 0) {
				lists++;
				writer.print("\n");
			}
			list(0);
			for(int i = 0; i < lista_afisare.size(); i++) {
				if(i != lista_afisare.size() - 1)
					writer.print(lista_afisare.get(i) + " ");
				else
					writer.print(lista_afisare.get(i));
			}
		}
		public void insert(Pasageri element, int prioritate) {
			insert(element);
		}
	    /**
	     *  This method returns the max element of the heap.
	     *  complexity: O(1)
	     */
	     public Pasageri findMax(){
	         if(isEmpty())
	             throw new NoSuchElementException("Heap is empty.");
	         return heap[0];
	     }
	}