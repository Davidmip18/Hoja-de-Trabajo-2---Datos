import java.util.ArrayList;


public class StackArrayList<T> implements IStack<T> {
    
    private ArrayList<T> elements;
    
    
    public StackArrayList() {
        elements = new ArrayList<>();
    }
    
    
    @Override
    public void push(T value) {
        elements.add(value);
    }
    
   
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop from an empty stack");
        }
        return elements.remove(elements.size() - 1);
    }
    
    
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek at an empty stack");
        }
        return elements.get(elements.size() - 1);
    }
    
   
    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    
    
    @Override
    public int size() {
        return elements.size();
    }
    
   
    @Override
    public void clear() {
        elements.clear();
    }
}
