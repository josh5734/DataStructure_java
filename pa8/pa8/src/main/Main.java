import java.util.*;

/*
* Since this file is not a part of submission,
* you can use any class/packages.
*/

public class Main
{
    public static void main(String[] args)
    {
    	
    	/*
    	Graph G1 = new Graph("./src/test/graph1.txt");
    	Graph G2 = new Graph("./src/test/graph2.txt");
    	Graph G3 = new Graph("./src/test/graph3.txt");
    	Graph G4 = new Graph("./src/test/graph4.txt");
    	Graph G5 = new Graph("./src/test/graph5.txt");
    	Graph G6 = new Graph("./src/test/graph6.txt");
    	Graph G7 = new Graph("./src/test/graph7.txt");
    	Graph G8 = new Graph("./src/test/graph8.txt");
    	
    	G6.insertEdge(0, 3);
    	G6.insertEdge(0, 4);
    	G6.insertEdge(0, 5);
    	G6.insertEdge(0, 6);
    	G6.insertVertex();
    	G6.insertVertex();
    	G6.insertVertex();
    	G6.insertVertex();
    	G6.show();
    	G6.deleteEdge(0, 2);
    	G6.deleteVertex(1);
    	G6.deleteVertex(1);
    	G6.deleteVertex(1);
    	G6.deleteVertex(1);
    	G6.deleteVertex(1);
    	G6.deleteVertex(1);
    	G6.deleteVertex(1);
    	G6.deleteVertex(1);
    	G6.deleteVertex(1);
    	G6.deleteVertex(1);
    	G6.deleteVertex(1);
    	G6.insertVertex();
    	G6.insertVertex();
    	G6.insertVertex();
    	G6.show();
    	*/

    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	ISCC G1 = new SCC("./src/test/graph1.txt");
    	ISCC G2 = new SCC("./src/test/graph2.txt");
    	ISCC G3 = new SCC("./src/test/graph3.txt");
        ISCC G4 = new SCC("./src/test/graph4.txt");
        ISCC G5 = new SCC("./src/test/graph5.txt");
        ISCC G6 = new SCC("./src/test/graph6.txt");
        ISCC G7 = new SCC("./src/test/graph7.txt");
        ISCC G8 = new SCC("./src/test/graph8.txt");
        System.out.println("G1�� connectivity�Դϱ�?: " +G1.connectivity());
        System.out.println("G2�� connectivity�Դϱ�?: " +G2.connectivity());
        System.out.println("G3�� connectivity�Դϱ�?: " +G3.connectivity());
        System.out.println("G4�� connectivity�Դϱ�?: " +G4.connectivity());
        System.out.println("G5�� connectivity�Դϱ�?: " +G5.connectivity());
        System.out.println("G6�� connectivity�Դϱ�?: " +G6.connectivity());
        System.out.println("G7�� connectivity�Դϱ�?: " +G7.connectivity());
        System.out.println("G8�� connectivity�Դϱ�?: " +G8.connectivity());
        System.out.println("G1�� findSCC(): " + G1.findSCC());
        System.out.println("G2�� findSCC(): " + G2.findSCC());
        System.out.println("G3�� findSCC(): " + G3.findSCC());
        System.out.println("G4�� findSCC(): " + G4.findSCC());
        System.out.println("G5�� findSCC(): " + G5.findSCC());
        System.out.println("G6�� findSCC(): " + G6.findSCC());
        System.out.println("G7�� findSCC(): " + G7.findSCC());
        System.out.println("G8�� findSCC(): " + G8.findSCC());
        
        
        System.out.println("G6���� Path(1,5) :"+ G6.path(1, 5));
        System.out.println("G6���� Path(0,6) :"+ G6.path(0, 6));
        System.out.println("G6���� Path(4,3) :"+ G6.path(4, 3));
        
        System.out.println("G5���� Path(0,10) :"+ G5.path(0, 10));
        System.out.println("G5���� Path(10,6) :"+ G5.path(10, 6));
        System.out.println("G5���� Path(10,6) :"+ G5.path(10, 6));
        System.out.println("G5���� Path(7,0) :"+ G5.path(7, 0));
        
        int count = 0;
        for(int i=0; i<8; i++)   {
            for(int j=0; j<8; j++) {
               if(G8.path(i,j)) count++;
            }
        }
        System.out.println(count);
      
    }
}