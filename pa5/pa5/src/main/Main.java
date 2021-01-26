
public class Main {
	public static void main(String[] args) {
	      IHash<Integer> h = new BounceHash<Integer>(new HashFn1(), new ResizeFn1(), 4);
	        for(int i=1; i<10; i++) {
	            h.put(2*i);
	            h.put(5*i);
	         }
	      System.out.println(h.show());
	      //h.remove(13);
	      
//        
//        System.out.println(h.size());
//        System.out.println(h.tablesize());
//        
//        // h = [15,6,13,11] but need to resize so,
//        System.out.println(h.show());//{ 15, null, null, null, 11, null, 13, 6 })));
//  
//		
		
		
		
		
		
		
		
		
//		IHash<Integer> h = new BounceHash<Integer>(new HashFn1(), new ResizeFn1(), 4);
//        h.put(13); //h_1(13)=1, h_2(13)=3
//        h.put(77); //h_1(77)=1, h_2(77)=3
//        h.put(4); //h_1(4)=0, h_2(4)=1
//        System.out.println(h.size());// is(3));
//        System.out.println(h.tablesize()); //is(4));
//        System.out.println(h.show());// { 4, 77, null, 13 })));
//
//        h.put(10); //h_1(10)=2, h_2(10)=1
//        System.out.println(h.tablesize());// is(8));
//        System.out.println(h.show());//{ null, 77, 10, null, 4, 13, null, null })));
 
		
		
		
		
		
		
		
		
		
		
		
		
//		IHash<Integer> h = new BounceHash<Integer>(new HashFn1(), new ResizeFn1(), 7);
//		//System.out.println(h.tablesize());
//		 h.put(10);
//         h.put(3);
//         System.out.println(h.show()); // { null, 10, null, 3, null, null, null })));
//
//         h.put(11); //h_1(11)=4, h_2(11)=1
//         h.put(32); //h_1(32)=4, h_2(32)=4
//         System.out.println(h.exists(4)); //false
//         System.out.println(h.exists(10));//true
//         System.out.println(h.show());//  { 3, 11, null, 10, 32, null, null })));
//    
//     
	}
}

class HashFn1 implements IBounceHashFunction<Integer> {
    int offset = 0;

    public int hash1(Integer i, int length) {
        return ((i + offset) % length);
    }

    public int hash2(Integer i, int length) {
        return (((i + offset) / length) % length);
    }

    public void changeHashFn(int tablesize) {
        offset++;
    }
}

class ResizeFn1 implements IResizeFunction {
    public boolean checkResize(int tablesize, int numItems) {
        if (numItems > tablesize * 0.8) {
            return true;
        }
        return false;
    }

    public int extendTable(int tablesize) {
        return tablesize * 2;
    }
}

/*
class HashFn1 implements IHashFunction<Integer> {
    public int hash(Integer i, int length) {
        return (i % length);
    }
}

class ResizeFn1 implements IResizeFunction {
    public boolean checkResize(int tablesize, int numItems) {
        if (numItems > tablesize * 0.8) {
            return true;
        }
        return false;
    }

    public int extendTable(int tablesize) {
        return tablesize * 2;
    }
}*/

