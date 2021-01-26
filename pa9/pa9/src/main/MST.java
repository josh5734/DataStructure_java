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

public final class MST implements IMST {
	final int M = Integer.MAX_VALUE;
	int[][] matrix;
	int size;
	boolean[] visited;
	int[] distance;
	int edges;
	
    public MST(String filename) {
    	File file = new File(filename);
    	try{
    		FileReader fr = new FileReader(file);
        	BufferedReader br = new BufferedReader(fr);
        	String[] firstLine;
        	firstLine = br.readLine().split(" ");
        	int n1 = Integer.parseInt(firstLine[0]);
        	edges = Integer.parseInt(firstLine[1]);
        	// matrix initialization
        	matrix = new int[n1][n1];
        	size = n1;
        	
        	for(int i = 0; i < size; i ++) {
        		for(int j = 0 ; j < size; j++) {
        			matrix[i][j] = M;
        		}
        	}
        	
        	String line = "";
    		while((line = br.readLine()) != null) {
    			// directed graph의 edge 정보 입력
    		    String[] edge;
    		    edge = line.split(" ");
    		    int start = Integer.parseInt(edge[0]);
    		    int end = Integer.parseInt(edge[1]);
    		    int cost = Integer.parseInt(edge[2]);
    			matrix[start][end] = cost;
    			matrix[end][start] = cost;
    		}
    		
    	}catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}catch (IOException e) {
    		e.printStackTrace();
		}
    	visited = new boolean[size];
    	distance = new int[size];
    }

    @Override
    public int[] shortestPath(int u, int v) {
        visited = new boolean[size];
    	distance = new int[size];
    	int[] path = new int[size];
    	
    	for(int i = 0; i < size; i++) {
    		distance[i] = M;
    		path[i] = -1;
    	}
    	distance[u] = 0;
    	visited[u] = true;
    	path[u] = u;
    	
    	for(int i = 0; i < size; i++) {
    		if(!visited[i] && matrix[u][i] != M) {
    			distance[i] = matrix[u][i];
    			path[i] = u;
    		}
    	}
    	
    	
    	for(int i = 0; i < size; i++) {
    		int curr = getSmallestNode(distance, visited);
    		visited[curr] = true;
    
			if(distance[curr] == M) {
				break;
			}
    		
    		for(int j = 0; j < size; j++) {
    			if(!visited[j] && matrix[curr][j] != M) {
    				if(distance[j] > distance[curr] + matrix[curr][j]) {	
    					distance[j] = distance[curr] + matrix[curr][j];
    					path[j] = curr;
    				}
    			}
    		}
    	}
    	int[] result = new int[size];
    	for(int i = 0; i < size; i++) {
    		result[i] = -1;
    	}
    	int pointer = v;
    	int temp = size-1;
    	while(true) {
    		if(path[pointer] != -1 && u != pointer) {
    			result[temp--] = pointer;
    			pointer = path[pointer];
    		}else {
    			result[temp--] = u;
    			break;
    		}
    	}
    	int start = 0;
    	for(int i = 0; i < size; i++) {
    		if(result[i] != -1) {
    			start = i;
    			break;
    		}
    	}
    	int[] final_path = new int[size - start];
    	for(int i = 0; i < final_path.length; i++) {
    		final_path[i] = result[i+start];
    	}
    	return final_path;
    }

    @Override
    public int findMST() {
    	int cost = 0;
    	int[][] C= new int[size][size];
    	for(int i = 0; i < size; i++) {
    		for(int j = 0; j < size; j++) {
    			C[i][j] = matrix[i][j];
    		}
    	}
    	int[][] E = minEdges(C);
    	
    	
    	
    	int[][] T = new int[size-1][2];
    	
    	T = kruskal(E, size, T);
    	
    	for(int i = 0; i < size-1;i++) {
    		System.out.print(T[i][0] +" "+ T[i][1]+" ");
    	}System.out.println();

    	for(int i = 0; i < size-1; i++) {
    		cost += matrix[T[i][0]][T[i][1]];
    	}
    	
        return cost;
    }

    
    public int getSmallestNode(int[] distance, boolean[] visited) {
    	int minValue = M;
    	int index = 0;
    	for(int i = 0; i < size; i ++) {
    		if(!visited[i] && distance[i] != M) {
    			if(distance[i] < minValue) {
        			minValue = distance[i];
        			index = i;
    			}
    		}
    	}
    	return index;
    }
    
    public void showSP(int start, int end) {
    	int[] p = shortestPath(start, end);
    	for(int i = 0; i < p.length; i++) {
    		if(i != p.length-1) System.out.print(p[i] + " -> ");
    		else System.out.print(p[i]);
    	}System.out.println();
    }
    
    public int[][] kruskal(int[][] E, int n, int[][] T) {
    	int edgeCount = 0;
    	int cursor = 0;
    	int v1, v2;
    	int s1, s2;
    	int[] nodes = new int[size];
    	for(int i = 0; i < size; i++) nodes[i] = i;
    	
    	while(edgeCount < size-1) {
    		v1 = E[cursor][0];
    		v2 = E[cursor][1];
    		s1 = nodes[v1];
    		s2 = nodes[v2];
    		
    		if(s1 != s2) {
    			for(int j = 0; j < size; j++) {
    				if(nodes[j] == s2) {
    					nodes[j] = s1;
    				}
    			}
    			
    			T[edgeCount][0] = v1;
    			T[edgeCount][1] = v2;
    			edgeCount++;
    		}
    		cursor++;
    	}
    	return T;
    }
    
    public int[][] minEdges(int[][] graph) {
    	
    	int[][] E = new int[edges][2];
    	
    	for(int i = 0; i < edges; i++) {
    		int m1 = 0;
        	int m2 = 0;
    		
        	int l = graph.length;
        	int maxValue = M;
        	for(int j = 0; j < l; j++) {
        		for(int k = 0; k < l; k++) {
        			if(j != k && maxValue > graph[j][k]) {
        				maxValue = graph[j][k];
        				m1 = j;
        				m2 = k;
        			}
        		}
        	}
        	graph[m1][m2] = M;
        	graph[m2][m1] = M;
        	
        	E[i][0] = m1;
        	E[i][1] = m2;
    	}
    	
    	
    	return E;
    }
}
