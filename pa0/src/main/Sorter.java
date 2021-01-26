/*
 * Name: JO SUNG HYEON
 * Student ID #: 2016147008 
 */

/* 
 * Do NOT import any additional packages/classes.
 * If you (un)inte0ntionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public class Sorter implements ISorter {
	public Sorter() { ; }
	
	@Override
	public int[] ascending(int[] a) {
		int size = a.length;
        int min; 
        int temp;
        
        for(int i=0; i<size-1; i++){ 
            min = i;
            for(int j=i+1; j<size; j++){
                if(a[min] > a[j]){
                    min = j;
                }
            }
            temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
        return a;
    }






	@Override
	public int[] descending(int[] a) {
		/*
		 * Input:
		 *  - an integer array A
		 *
		 * Output: a sorted array A in *descending* order.
		*/
		int size = a.length;
        int max; 
        int temp;
        
        for(int i=0; i<size-1; i++){ 
            max = i;
            for(int j=i+1; j<size; j++){
                if(a[max]  < a[j]){
                    max = j;
                }
            }
            temp = a[max];
            a[max] = a[i];
            a[i] = temp;
        }
		return a;
	}
} 

		