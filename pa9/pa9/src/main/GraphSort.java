/*
* Name:JO SUNG HYEON	
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

public final class GraphSort implements IGraphSort {
	int[][] matrix;
	int size;
	boolean[] visited;
	boolean[] onVisiting;
    public GraphSort(String filename) {
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
    	visited = new boolean[size];
    	onVisiting = new boolean[size];
    }

    @Override
    public boolean cycle() {
        for(int i = 0; i < size; i++) {
        	visited = new boolean[size];
        	onVisiting = new boolean[size];
        	if(checkCycle(i,visited,onVisiting)) return true;
        }
        return false;
    }

    @Override
    public int[] topologicalOrder() {
    	int[] result = new int[size];
    	int[] degree = new int[size];
    	int[] traverse = new int[size];
    	
    	Queue q = new Queue(size);

    	// degree 채우기
    	for(int i = 0; i < size; i++) {
    		for(int j = 0; j < size; j++) {
    			if(matrix[i][j] == 1)
    				degree[j]++;
    		}
    	}
    	int start = 0;
    	for(int i = 0; i < size; i++) {
    		if(degree[i] == 0) {
    			q.insert(i);
    			traverse[start++] = i;
    		}
    	}
    	
    	for(int i = 0; i < size; i++) {
    		int sour = q.pop();
    		result[i] = sour;
    		for(int j = 0; j < size; j++) {
    			if(matrix[sour][j] == 1) {
    				degree[j]--;
    				if(degree[j] == 0) {
    					q.insert(j);
    					traverse[start++] = j;
    				}
    			}
    		}
    	}
    	return traverse;   
    }
    
    
    public boolean checkCycle(int start, boolean[] visited, boolean[] onVisiting) {
    	visited[start] = true;
    	onVisiting[start] = true;
    	
    	for(int i = 0; i < size; i++) {
    		if(!visited[i] && matrix[start][i] == 1) {
    			if(checkCycle(i,visited, onVisiting)) {
    				return true;
    			}
    		}
    		else if(visited[i] && matrix[start][i] == 1)
    			if(onVisiting[i])
    				return true;
    	}
    	onVisiting[start] = false;
    	return false;
    }

    public void topoShow() {
    	int[] arr = topologicalOrder();
    	for(int way : arr)
    		System.out.print(way+ " ");
    	System.out.println();
    }
}

class Queue{
	
	int[] q;
	int size;
	int rear = -1;
	int front = -1;
	
	public Queue(int size){
		this.size = size;
		this.q = new int[size];
	}
	
	public void insert(int value) {
		q[++rear] = value;
	}
	public int pop() {
		++front;
		return q[front];
	}
	
	public boolean isEmpty() {
		return front == rear ? true : false;
	}
	
}
