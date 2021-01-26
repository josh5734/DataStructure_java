/*
 * Name: Jo sung hyeon
 * Student ID #: 2016147008
 */

/* 
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class CDLList implements ICDLList {
    private Node head;
    public int size;
  
    
    
    public CDLList() {
   	    head = null;
    	size = 0;
   	    
   	 
    }
    
    @Override
    public void insert(int value) {
        /*
         * Function input:
         *  + value: An integer to be inserted.
         * 
         * Job:
         *  Insert the given integer to the list.
         */
    	Node newNode = new Node(value);
    	
    	if(isEmpty()) {
    		head = newNode;
    		head.next = head;
    		head.prev = head;
    		
    	} else {
    		newNode.prev = head.prev;
    		newNode.next = head;
    		head.prev.next = newNode;
    		head.prev = newNode;
    		
    	}size++;
    }

    @Override
    public void delete() throws IllegalStateException {
        /*
         * Function input: Nothing
         * 
         * Job:
         *  Delete the previous node of the head.
         */
    	
    	if(isEmpty()) {
    		throw new IllegalStateException("this list is empty");
    	} 
    	if(size == 1) head = null;
    	else {
    		head.prev = head.prev.prev;
    		head.prev.next = head;
    			
    	}
    	size--;
    }
    
    public void delete_next() throws IllegalStateException {
    	if(isEmpty()) {
    		throw new IllegalStateException("this list is empty");
    	} 
    	if(size == 1) head = null;
    	else {
    		head.next = head.next.next;
    		head.next.prev = head;
    			
    	}
    	size--;
    }

    @Override
    public Node getHead() throws IllegalStateException {
        /*
         * Function input: Nothing
         * 
         * Job:
         *  return the reference of the head. If none, raise an exception.
         */
    	if(isEmpty()) {
    		throw new IllegalStateException("the list is empty");
    	}    	
        return head;
    }

    @Override
    public void rotateForward() throws IllegalStateException {
        /*
         * Function input: Nothing
         * 
         * Job:
         *  Rotate the list forward. If none, raise an exception.
         */
    	if(isEmpty()) {
    		throw new IllegalStateException("the list is empty");
    	}
    	head = head.next;
    	
    }

    @Override
    public void rotateBackward() throws IllegalStateException {
        /*
         * Function input: Nothing
         * 
         * Job:
         *  Rotate the list backward. If none, raise an exception.
         */
    	if(isEmpty()) {
    		throw new IllegalStateException("the list is empty");
    	}
    	head = head.prev;
    	
    }

    @Override
    public int size() {
        /*
         * Function input: Nothing
         * 
         * Job:
         *  Return the size of the list
         */
        return size;
    }

    @Override
    public boolean isEmpty() {
        /* You do not have to edit this function. */
        return size() == 0;
    }
    
   
    

}
