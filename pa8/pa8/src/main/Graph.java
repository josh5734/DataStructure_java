/*
* Name: JO SUNG HYEON
* Student ID#: 2016147008
*/

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
* Do NOT use any external packages/classes.
* If you (un)intentionally use them we did not provide,
* you will get 0.
* Also do NOT use auto-import function on IDEs.
* If the import statements change, you will also get 0.
*/

public final class Graph implements IGraph {
	int[][] matrix;
	int size;
    public Graph(String filename) {
        /*
         * Constructor
         * This function is an initializer for this class.
         */
    	
    	File file = new File(filename);
    	try{
    		FileReader fr = new FileReader(file);
        	BufferedReader br = new BufferedReader(fr);
        	String[] firstLine;
        	firstLine = br.readLine().split(" ");
        	int n1 = Integer.parseInt(firstLine[0]);
        	
        	// matrix initialization
        	matrix = new int[n1][n1];
        	size = n1;
        	
        	String line = "";
    		while((line = br.readLine()) != null) {
    			// directed graph의 edge 정보 입력
    		    String[] edge;
    		    edge = line.split(" ");
    		    int start = Integer.parseInt(edge[0]);
    		    int end = Integer.parseInt(edge[1]);
    			matrix[start][end] = 1;
    		}
    		
    	}catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}catch (IOException e) {
    		e.printStackTrace();
		}
	}
	

    @Override
    public void insertVertex() {
    	// add the vertext at the last of matrix
    	int[][] newMatrix = new int[size+1][size+1];
    	for(int i = 0; i < size; i++) {
    		for(int j = 0; j < size; j++) {
    			newMatrix[i][j] = matrix[i][j];
    		}
    	}
    	matrix = newMatrix;
    	size++;
    }

    @Override
    public void deleteVertex(int n) {
    	int row = size;
    	int col = size;
    	
    	if(n < size) {
    		int[][] removeColMatrix = new int[row][col-1];
        	int[][] removeRowMatrix = new int[row-1][col-1];
        	//remove col
        	for(int i = 0; i < size-1; i++) {
        		for(int j = 0; j < n; j++) {
        			removeColMatrix[i][j] = matrix[i][j];
        		}
        		for(int j = n; j < size -1; j++) {
        			removeColMatrix[i][j] = matrix[i][j+1];
        		}
        	}
        	//remove row
        	for(int i = 0; i < size-1; i++) {
        		for(int j = 0; j < n; j++) {
        			removeRowMatrix[i][j] = removeColMatrix[i][j];
        		}
        		for(int j = n; j < size -1; j++) {
        			removeRowMatrix[i][j] = removeColMatrix[i+1][j];
        		}
        	}
        	matrix = removeRowMatrix;
        	size--;
    	}
    	
    }

    @Override
    public void insertEdge(int u, int v) {
    	matrix[u][v] = 1;
    	
    }

    @Override
    public void deleteEdge(int u, int v) {
    	matrix[u][v] = 0;
    }

    @Override
    public int[][] matrix() {
        return matrix;
    }

    @Override
    public int size() {
        return size;
    }
}