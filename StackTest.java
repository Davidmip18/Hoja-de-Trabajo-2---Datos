import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    private IStack<Integer> stack;
    
    @Before
    public void setUp() {
        stack = new StackArrayList<>();
    }
    
    @Test
    public void testPushAndPop() {
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        assertEquals(Integer.valueOf(30), stack.pop());
        assertEquals(Integer.valueOf(20), stack.pop());
        assertEquals(Integer.valueOf(10), stack.pop());
    }
    
    @Test
    public void testPeek() {
        stack.push(10);
        stack.push(20);
        
        assertEquals(Integer.valueOf(20), stack.peek());
        assertEquals(2, stack.size()); // peek should not remove element
        assertEquals(Integer.valueOf(20), stack.peek());
    }
    
    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        
        stack.push(10);
        assertFalse(stack.isEmpty());
        
        stack.pop();
        assertTrue(stack.isEmpty());
    }
    
    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        
        stack.push(10);
        assertEquals(1, stack.size());
        
        stack.push(20);
        stack.push(30);
        assertEquals(3, stack.size());
        
        stack.pop();
        assertEquals(2, stack.size());
    }
    
    @Test
    public void testClear() {
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        assertEquals(3, stack.size());
        
        stack.clear();
        
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }
    
    @Test(expected = IllegalStateException.class)
    public void testPopEmptyStack() {
        stack.pop();
    }
    
    @Test(expected = IllegalStateException.class)
    public void testPeekEmptyStack() {
        stack.peek();
    }
    
    @Test
    public void testMultiplePushPop() {
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        
        assertEquals(100, stack.size());
        
        for (int i = 99; i >= 0; i--) {
            assertEquals(Integer.valueOf(i), stack.pop());
        }
        
        assertTrue(stack.isEmpty());
    }
    
    @Test
    public void testGenericWithStrings() {
        IStack<String> stringStack = new StackArrayList<>();
        
        stringStack.push("hello");
        stringStack.push("world");
        
        assertEquals("world", stringStack.pop());
        assertEquals("hello", stringStack.pop());
        assertTrue(stringStack.isEmpty());
    }
}
