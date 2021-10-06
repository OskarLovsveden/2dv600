package ol222hf_assign2.exercise2;

public class CollectionMain {
    public static void main(String[] args) {
        testArrayIntList();
        testArrayIntStack();
    }

    private static void testArrayIntStack() {
        // Create a new ArrayIntStack.
        ArrayIntStack myIntStack = new ArrayIntStack();

        // Add
        final int RANGE_START = 1;
        final int RANGE_END = 8;
        System.out.println("Push numbers to the ArrayIntStack ranging from "+RANGE_START+" to "+RANGE_END+".");
        for (int i = RANGE_START; i <= RANGE_END; i++) {
            myIntStack.push(i);
        }
        System.out.println("Result: "+myIntStack+"\n");
        
        // Pop
        System.out.println("Pop: "+myIntStack.pop());
        System.out.println("Pop: "+myIntStack.pop());
        System.out.println("Result: "+myIntStack+"\n");
        
        // Peek
        System.out.println("Peek: "+myIntStack.peek());
        System.out.println("Result: "+myIntStack+"\n");
    }

    private static void testArrayIntList() {
        // Create a new ArrayIntList.
        ArrayIntList myIntList = new ArrayIntList();

        // Add
        final int RANGE_START = 1;
        final int RANGE_END = 8;
        System.out.println("Add numbers to the ArrayIntList ranging from "+RANGE_START+" to "+RANGE_END+".");
        for (int i = RANGE_START; i <= RANGE_END; i++) {
            myIntList.add(i);
        }
        System.out.println("Result: "+myIntList+"\n");
        
        // Add at
        final int VALUE_TO_ADD = 50;
        final int INDEX_TO_ADD_AT = 3;
        System.out.println("Add the number "+VALUE_TO_ADD+" at index "+INDEX_TO_ADD_AT+".");
        myIntList.addAt(VALUE_TO_ADD, INDEX_TO_ADD_AT);
        System.out.println("Result: "+myIntList+"\n");
        
        // Remove
        final int INDEX_TO_REMOVE = 3;
        System.out.println("Remove item at index "+INDEX_TO_REMOVE+".");
        myIntList.remove(INDEX_TO_REMOVE);
        System.out.println("Result: "+myIntList+"\n");
        
        // Get
        final int INDEX_TO_GET = 4;
        System.out.println("Get value on index "+INDEX_TO_GET+" results in: "+myIntList.get(INDEX_TO_GET)+"\n");
        
        // IndexOf
        final int VALUE_TO_GET_INDEX_OF = 3;
        System.out.println("Get index of integer "+VALUE_TO_GET_INDEX_OF+" results in: "+myIntList.indexOf(VALUE_TO_GET_INDEX_OF)+"\n");
    }
}
