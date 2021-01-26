/*
* Name:JO SUNG HYEON
* Student ID#:2016147008
*/

import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
/*
* Do NOT use any external packages/classes.
* If you (un)intentionally use them we did not provide,
* you will get 0.
* Also do NOT use auto-import function on IDEs.
* If the import statements change, you will also get 0.
*/

public final class Hash<K> implements IHash<K> {
    /*
    * Use some variables for your implementation.
    */
	
	int tablesize;
	int numItem;
	IHashFunction<K> h;
	IResizeFunction ex;
	List<K> hashtable;
    K DEFUNCT;
	
	
    public Hash(IHashFunction<K> h, IResizeFunction ex, int tablesize) {
        /*
         * Constructor
         * This function is an initializer for this class.
         * Input:
         *  + IHashFunction<K> h:
         *      int h.hash(K key, int tablesize): returns an integral hash value of key.
         *  + IResizeFunction ex:
         *      boolean ex.checkResize(int tablesize, int numItems): returns 'true' if the table must be extended for containing 'numItems' items. Otherwise, returns 'false'.
         *      int ex.extendTable(int tablesize): returns new tablesize for extended table.
         *  + tablesize: the initial table size of the hash table.
        */
    	numItem = 0;
    	this.h = h;
    	this.ex = ex;
    	this.tablesize = tablesize;
    	hashtable = new ArrayList<K>(tablesize);
    	
    	for(int i = 0; i < tablesize; i++) {
    		hashtable.add(null);
    	}
    
    }

    @Override
    public void put(K key) {
        /**
         * Input:
         * + key: A key to be added 
         * 
         * Job:
         *  Add the key into the hashtable.
         *  If the table must be extended, extend the table and retry adding the key.
         *  If the key is already in the hashtable, ignore the request.
         *  To decide whether two keys are equal,
         *  you must use _key.equals_ method.
         */
    	
    	int hashValue = h.hash(key, tablesize);
    	int idx = hashValue % tablesize;
 
    	boolean checkRight = false;
    	if(!exists(key)) {
    		
    		for(int i = idx ; i < tablesize; i++) {
    			if(isAvailable(hashtable,i)) {
    				checkRight = true;
    				hashtable.remove(i);
            		hashtable.add(i,key);
            		numItem++;
            		break;
            	}
    		}
    		
    		if(!checkRight) {
    			for(int i = 0; i < idx; i++) {
    				if(isAvailable(hashtable, i)) {
    					hashtable.remove(i);
                		hashtable.add(i,key);
                		numItem++;
                		break;
                	
    				}
    			}
    		}
    	}
    	if(ex.checkResize(tablesize, numItem)) {
    		extendTable();
    	}
    	
    	
    }

    @Override
    public void remove(K key) throws IllegalStateException {
        /*
        * Input:
        *  + key: A key to be removed
        *
        * Job:
        *  Delete the key from the hash table.
        *  If the table does not have a key, silently ignore the request.
        *  To decide whether two keys are equal,
        *  you must use _key.equals_ method.
        */
    	if(!exists(key)) {
    		throw new IllegalStateException();
    	}
    	
    	for(int i = 0; i < tablesize; i++) {
    		if(hashtable.get(i) != null) {
    			if(hashtable.get(i).equals(key)) {
        			hashtable.remove(i);
        			hashtable.add(i,DEFUNCT);
        			numItem--;
        			break;
        		}
    		}
    	}
    	
    }

    @Override
    public boolean exists(K key) {
        /*
        * Input:
        *  + key: A key to be checked
        *
        * Job:
        *  Return true if the key is in the table; false otherwise.
        *  To decide whether two keys are equal,
        *  you must use _key.equals_ method.
        */
    	//int hashValue = h.hash(key, tablesize);
    	//int idx = hashValue % tablesize;
   
    	for(int i = 0; i < tablesize; i++) {
    		if(hashtable.get(i) != null) {
    			if(hashtable.get(i).equals(key)) {
    				return true;
    			}
    		}
    	}
        return false;
    }

    @Override
    public int size() {
        /*
        * Job:
        *  Return the number of items in the hashtable.
        */
        return numItem;
    }

    @Override
    public int tablesize() {
        /*
        * Job:
        *  Return the size of current hashtable.
        */
        return tablesize;
    }

    @Override
    public List<K> show() {
        /*
        * Job:
        *  Return the items in the hashtable.
        *  The list index must be the bucket index of the item.
        *  If a bucket has no item, assign null.
        *  Note that you can use ArrayList.
        */
    	if(size() == 0) {
    		return null;
    	}
        return hashtable;
    }


	boolean isAvailable(List<K> table, int j) {
		return(table.get(j) == null || table.get(j) == DEFUNCT);
		}
	
	
	void extendTable() {
		
		List<K> oldtable = hashtable;
		tablesize = ex.extendTable(tablesize);
		
		
		hashtable = new ArrayList<K>(tablesize);
		
		for(int i = 0; i < tablesize; i++) {
			hashtable.add(null);
		}
		numItem = 0;
		
		for(K x: oldtable) {
			if(x != null) {
				put(x);
			}
		}
	}
}
