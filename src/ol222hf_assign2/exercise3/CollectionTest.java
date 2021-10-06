/**
 * CollectionTest.java
 * Date: 06 oct 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise3;

import ol222hf_assign2.exercise2.ArrayIntList;
import ol222hf_assign2.exercise2.ArrayIntStack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

/** 
 * Tests for the ArrayIntList and ArrayIntStack classes.
 * The testmethods' names explains what is tested.
 * Roughly follows this pattern: MethodName_OptionalTestDetails_ExpectedResult 
 */
public class CollectionTest {
    // add()
    @Test
    public void Add_Once_ShouldReturnSizeOfOne() {
        ArrayIntList SUT = new ArrayIntList();
        final int input = 5;
        SUT.add(input);
        assertEquals(1, SUT.size());
    }
    
    @Test
    public void Add_TooManyItems_ShouldThrowOutOfMemoryError() {
        ArrayIntList SUT = new ArrayIntList();
        assertThrows(OutOfMemoryError.class, () -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                SUT.add(i);
            }
        });
    }

    // get()
    @Test
    public void Get_AtIndexZeroWhenEmpty_ShouldThrowIndexOutOfBoundsException() {
        ArrayIntList SUT = new ArrayIntList();
        final int index = 0;
        assertThrows(IndexOutOfBoundsException.class, () -> {
            SUT.get(index);
        });
    }

    @Test
    public void Get_AtZeroIndex_ShouldReturnZero() {
        ArrayIntList SUT = new ArrayIntList();
        final int start = 0;
        final int end = 5;

        for (int i = start; i <= end; i++) {
            SUT.add(i);
        }

        assertEquals(start, SUT.get(start));
    }  

    @Test
    public void Get_AtLastIndex_ShouldReturnFive() {
        ArrayIntList SUT = new ArrayIntList();
        final int start = 0;
        final int end = 5;

        for (int i = start; i <= end; i++) {
            SUT.add(i);
        }

        assertEquals(end, SUT.get(end));
    }  
    
    // addAt()
    @Test
    public void AddAt_OccupiedIndex_ShouldIncreaseSize() {
        ArrayIntList SUT = new ArrayIntList();
        for (int i = 0; i < 8; i++) {
            SUT.add(i);
        }

        final int initialSize = SUT.size();
        SUT.addAt(50, 4);
        assertEquals(initialSize + 1, SUT.size());
    }

    @Test
    public void AddAt_OccupiedIndex_ShouldPlaceAtCorrectIndex() {
        ArrayIntList SUT = new ArrayIntList();
        for (int i = 0; i < 8; i++) {
            SUT.add(i);
        }

        final int input = 50;
        final int index = 4;

        SUT.addAt(input, index);
        assertEquals(SUT.indexOf(input), index);
        assertEquals(SUT.get(index), input);
    }
    
    @Test
    public void AddAt_OutOfBoundsIndex_ShouldThrowIndexOutOfBoundsException() {
        ArrayIntList SUT = new ArrayIntList();
        final int input = 50;
        final int outOfBoundsLowIndex = 0;

        assertThrows(IndexOutOfBoundsException.class, () -> {
            SUT.addAt(input, outOfBoundsLowIndex);
        });
        
        
        for (int i = 0; i < 10; i++) {
            SUT.add(i);
        }

        final int outOfBoundsHighIndex = 20;
        assertThrows(IndexOutOfBoundsException.class, () -> {
            SUT.addAt(input, outOfBoundsHighIndex);
        });
    }

    // remove()
    @Test 
    public void Remove_AtIndexZeroWhenEmpty_ShouldThrowIndexOutOfBoundsException() {
        ArrayIntList SUT = new ArrayIntList();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            SUT.remove(0);
        });
    }

    @Test
    public void Remove_AtIndexFour_ShouldRemoveItem() {
        ArrayIntList SUT = new ArrayIntList();

        for (int i = 1; i <= 10; i++) {
            SUT.add(i);
        }

        final int integerToRemove = 5;
        SUT.remove(SUT.indexOf(integerToRemove));
        assertEquals(-1, SUT.indexOf(integerToRemove));
    }
    
    // indexOf()
    @Test
    public void IndexOf_ShouldReturnMinusOne() {
        ArrayIntList SUT = new ArrayIntList();
        assertEquals(-1, SUT.indexOf(5));
    }
    
    @Test
    public void IndexOf_ShouldReturnZero() {
        ArrayIntList SUT = new ArrayIntList();
        final int input = 5;
        SUT.add(input);
        assertEquals(0, SUT.indexOf(input));
    }
    
    // isEmpty()
    @Test
    public void IsEmpty_ArrayIntList_ShouldReturnTrue() {
        ArrayIntList SUT = new ArrayIntList();
        assertTrue(SUT.isEmpty());
    }
    
    @Test
    public void IsEmpty_ArrayIntList_ShouldReturnFalse() {
        ArrayIntList SUT = new ArrayIntList();
        final int input = 5;
        SUT.add(input);
        assertFalse(SUT.isEmpty());
    }

    @Test
    public void IsEmpty_ArrayIntStack_ShouldReturnTrue() {
        ArrayIntStack SUT = new ArrayIntStack();
        assertTrue(SUT.isEmpty());
    }
    
    @Test
    public void IsEmpty_ArrayIntStack_ShouldReturnFalse() {
        ArrayIntStack SUT = new ArrayIntStack();
        final int input = 5;
        SUT.push(input);
        assertFalse(SUT.isEmpty());
    }

    // size()
    @Test
    public void Size_ArrayIntList_ShouldHaveSizeOfTen() {
        ArrayIntList SUT = new ArrayIntList();

        final int items = 10;
        for (int i = 1; i <= items; i++) {
            SUT.add(i);
        }

        assertEquals(items, SUT.size());
    }
    
    @Test
    public void Size_ArrayIntStack_ShouldHaveSizeOfTen() {
        ArrayIntStack SUT = new ArrayIntStack();

        final int items = 10;
        for (int i = 1; i <= items; i++) {
            SUT.push(i);
        }

        assertEquals(items, SUT.size());
    }

    // push()
    @Test
    public void Push_Once_ShouldReturnSizeOfOne() {
        ArrayIntStack SUT = new ArrayIntStack();
        final int input = 5;
        SUT.push(input);
        assertEquals(1, SUT.size());
    }
    
    @Test
    public void Push_TooManyItems_ShouldThrowOutOfMemoryError() {
        ArrayIntStack SUT = new ArrayIntStack();
        assertThrows(OutOfMemoryError.class, () -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                SUT.push(i);
            }
        });
    }

    // pop()
    @Test 
    public void Pop_WhenEmpty_ShouldThrowIndexOutOfBoundsException() {
        ArrayIntStack SUT = new ArrayIntStack();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            SUT.pop();
        });
    }
    
    @Test
    public void Pop_ShouldDecreaseSizeByOne() {
        ArrayIntStack SUT = new ArrayIntStack();
        final int itemsToAdd = 10;

        for (int i = 1; i <= itemsToAdd; i++) {
            SUT.push(i);
        }

        SUT.pop();
        assertEquals(itemsToAdd - 1, SUT.size());
    }
    
    @Test
    public void Pop_ShouldReturnTen() {
        ArrayIntStack SUT = new ArrayIntStack();
        final int itemsToAdd = 10;

        for (int i = 1; i <= itemsToAdd; i++) {
            SUT.push(i);
        }

        assertEquals(itemsToAdd, SUT.pop());
    }

    // peek()
    @Test 
    public void Peek_WhenEmpty_ShouldThrowIndexOutOfBoundsException() {
        ArrayIntStack SUT = new ArrayIntStack();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            SUT.peek();
        });
    }

    @Test
    public void Peek_ShouldNotDecreaseSize() {
        ArrayIntStack SUT = new ArrayIntStack();
        final int itemsToAdd = 10;

        for (int i = 1; i <= itemsToAdd; i++) {
            SUT.push(i);
        }

        SUT.peek();
        assertEquals(itemsToAdd, SUT.size());
    }
}
