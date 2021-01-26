/*
 * Name: Jo sung hyeon
 * Student ID #: 2016147008
 */

/* 
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */


public final class Array implements IArray {
    /*
     * Add some variables you will use.
     */
	 boolean sorted;
	 public int[] array;
	 int size;
	 boolean flag = false;
	 
    public Array() {
        /*
         * Constructor 
         * This function is an initializer for this class.
         */
        array = new int[2];
        size = 0;
        sorted = false;
    }
    
	
    @Override
    public void insert(int value) {
        /*
         * Function input:
         *  + value: An integer to be inserted.
         * 
         * Job:
         *  Insert the given integer according to the state of the array.
         *  - unsorted: insert the integer as the last element of the array.
         *  - sorted: insert the integer at the position that makes the array sorted in ascending order.
         */
	    
    
    	if (size == array.length){
            int[] new_array = new int[array.length*2];
            for (int i = 0 ; i < array.length ; i++){
                new_array[i] = array[i];
            }
            array = new_array;
        }

        // sorted?
        if (sorted) {
        	int idx = 0;
        	for(int i = 0; i < size; i++) {
        		if(array[i] <= value && array[i+1] >= value) {
        			idx = i+1;
        			break;
        		}
        	}
        	for(int i = idx; i <= size; i++) {
        		array[i+1] = array[i];
        	}
        	array[idx] = value;
        	
        }else{
            // unsorted
            array[size] = value;
           
        }
        size++;
    }
    
    @Override
    public void delete(int value) throws IllegalStateException {
        /*
         * Function input:
         *  + value: An integer to delete.
         * 
         * Job:
         *   Delete the first element that has the given integer as its value.
         *   If there is no such element, raise an exception.
         */
    	boolean check = false;//[1,2]
    	for(int i=0; i < size; i++) {
    		if(value == array[i]) {
    			check = true;
    			for(int j = i; j < size-1; j++) {
    				array[j] = array[j+1];	
    			}
    			size--;
    			break;
    		}	
    	}
    	if (!check) {
    		throw new IllegalStateException("Invalid index: " + value);
    	}
    }

    @Override
    public int search(int value) throws IllegalStateException {
        /*
         * Function input:
         *  + value: An integer to search.
         * 
         * Job:
         *  Return the first index of the element with the given value.
         *  If there is no such element, raise an exception.
         */
    	
    	for(int i=0; i < size; i++) {
    		if(value == array[i]) {
        		flag = true;
    			return i;
    		}
    	}
    	if(!flag) {
    		throw new IllegalStateException("Invalid index: " + value);
    	}
    	return -1;
    }

    @Override
    public void sort() {
        /**
         * Function input: Nothing
         * 
         * Job:
         *  Change the state of the array to sorted.
         *  Sort the elements in the array in ascending order.
         */
    	for(int i = 1; i < size; i++) {
    		int c = i;
    		do {
    			int root = (c-1) /2;
    			if(array[root] < array[c]) {
    				int temp = array[root];
    				array[root] = array[c];
    				array[c] = temp;
    			}
    			c = root;
    		}while(c != 0);
    	}
    	for(int i = size-1; i >=0; i--) {
    		int temp = array[0];
    		array[0] = array[i];
    		array[i] = temp;
    		int root = 0;
    		int c = 1;
    		do {
    			c = 2*root + 1;
    			if(c < i -1  && array[c] < array[c + 1]) {
    				c++;
    			}
    			if(c < i && array[root] < array[c]) {
    				temp = array[root];
    				array[root] = array[c];
    				array[c] = temp;
    			}
    			root = c;
    		}while(c<i);
    	}
    	sorted = true;
    }

    @Override
    public void unsort() {
        /**
         * Function input: Nothing
         * 
         * Job:
         *  Change the state of the array to unsorted.
         */
    	sorted = false;
    	
    }

    @Override
    public int atIndex(int index) throws IndexOutOfBoundsException {
        /**
         * Function input:
         *  + index: An integer to find the element at that position
         * 
         * Job:
         *  Return the value of the element at the given index.
         */
    	if (index >= size || index < 0) {
    		throw new IndexOutOfBoundsException("Invalid index: " + index);
    	}else {
        return array[index];
    	}
    }

    @Override
    public int size() {
        /*
        * Function input: Nothing
        *
        * Job:
        *  Return the number of elements in this array.
        */
        return size;
    }

    @Override
    public boolean isSorted() {
        /**
         * Function input: Nothing
         * 
         * Job:
         *  Return true if the array is sorted and false otherwise.
         */
    	for(int i = 1; i < size; i++) {
    	       if(array[i-1] > array[i]){
    	             sorted = false;
    	             break;
    	       	}
    	}
    	return sorted;
    	
    }

    @Override
    public boolean isEmpty() {
        /* You do not have to edit this function. */
        return size() == 0;
    }

}
