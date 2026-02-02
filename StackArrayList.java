import java.util.ArrayList;

/**
 * Implementation of IStack using an ArrayList (dynamic array).
 * 
 * @param <T> the type of elements in this stack
 */
public class StackArrayList<T> implements IStack<T> {
    
    private ArrayList<T> elements;
    
    /**
     * Constructs an empty stack.
     */
    public StackArrayList() {
        elements = new ArrayList<>();
    }
    
    /**
     * Pushes an element onto the top of this stack.
     * 
     * @param value the element to be pushed onto the stack
     */
    @Override
    public void push(T value) {
        elements.add(value);
    }
    
    /**
     * Removes and returns the element at the top of this stack.
     * 
     * @return the element at the top of this stack
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop from an empty stack");
        }
        return elements.remove(elements.size() - 1);
    }
    
    /**
     * Returns the element at the top of this stack without removing it.
     * 
     * @return the element at the top of this stack
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek at an empty stack");
        }
        return elements.get(elements.size() - 1);
    }
    
    /**
     * Tests if this stack is empty.
     * 
     * @return true if this stack contains no elements; false otherwise
     */
    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    
    /**
     * Returns the number of elements in this stack.
     * 
     * @return the number of elements in this stack
     */
    @Override
    public int size() {
        return elements.size();
    }
    
    /**
     * Removes all elements from this stack.
     */
    @Override
    public void clear() {
        elements.clear();
    }
}
