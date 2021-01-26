/*
 * Name: Jo sung hyeon
 * Student ID #: 2016147008 
 */

/* 
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class Set implements ISet { 
    /*
     * Add some variables you will use.
     */
	
	public Array array; //Array -> Array.java 파일에서 Array class에서 Array 타입의 array를 만들어라. --> array는 Array class를 가지고 있으니까 그 안에 있는 메서드나 변수를 사용 가능 , array.arr -> 앞에 array는 우리가 만든 array class 
	
    public Set() {
        /*
         * Constructor 
         * This function is an initializer for this class.
         */
    	this.array = new Array();
    }
    
    @Override
    public void insert(int value) {
        /*
         * Function input:
         *  + value: An integer to be inserted.
         * 
         * Job:
         *  Insert the integer if it does not exist.
        */
  
    	boolean flag = false;
    	for(int i = 0; i < array.array.length;i++) {
    		if(array.array[i] == value) {
    			flag = true;
    			break;
    		}
    	
    	}
    	if(!flag) {
    		array.insert(value);
    	}
    }

    	
    @Override
    public void delete(int value) throws IllegalStateException {
        /**
         * Function input:
         *  + value: An integer to be deleted
         * 
         * Job:
         *  Delete the integer from the set.
         *  Raise an exception if it does not exist.
         */
    	
    	array.delete(value);
    }
    

    @Override
    public void union(ISet set) {
        /**
         * Function input:
         *  + set: A set to be unioned
         * 
         * Job:
         *  Union the other set to this set
         */
    	int[] get_array = set.show();
    	int size = get_array.length;
    	
    	for(int i = 0; i < size; i++) {
    		this.insert(get_array[i]);         
    	}
    	
    	for(int j = 0; j < array.size();j++) {
    		for(int k = j+1; k < array.size();k++) {
    			if(array.array[k] == array.array[j]) {
    				array.delete(array.array[k]);
    				break;
    			}break;
    		}
    	}
    }

    @Override
    public void intersection(ISet set) {
        /**
         * Function input:
         *  + set: A set to be intersectioned
         * 
         * Job:
         *  Intersect the other set to this set
         */
    	boolean check;
    	int[] get_array = set.show(); 
    	int size = get_array.length;
    	for(int i = 0; i < array.size(); i++) {
    		check = false;
    		for(int j = 0; j < size; j++) {
    			if(array.array[i] == get_array[j]) {
    				check = true;
    				break;
    			} 
    		}if(!check) {
    			array.delete(array.array[i]);
    			i--;
    		}
    	}
    }

    @Override
    public void subtraction(ISet set) {
        /**
         * Function input:
         *  + set: A set to be subtracted
         * 
         * Job:
         *  Subtract the other set from this set
         */
    	int[] get_array = set.show();
    	int size = get_array.length;

    	for(int i = 0; i < array.size(); i++) {
    		for(int j = 0; j < size; j++) {
    			if(array.array[i] == get_array[j]) {
    				array.delete(get_array[j]);
    				i--;
    				break;
    			}
    		} 
    	}
    }

    @Override
    public int[] show() {
        /**
         * Function input: Nothing
         * 
         * Job:
         *  Return the elements of the set as an array.
    	*/
    	
    	int[] ans = new int[array.size()];
    	for(int i = 0; i < array.size(); i++) {
    		ans[i] = array.atIndex(i);
    	}
    	return ans;
    }
}
