/*
* Name: JO SUNG HYEON
* Student ID#: 2016147008
*/

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
/*
* Do NOT use any external packages/classes.
* If you (un)intentionally use them we did not provide,
* you will get 0.
* Also do NOT use auto-import function on IDEs.
* If the import statements change, you will also get 0.
*/

public final class SCC implements ISCC {
	int size;
	boolean[] visited;

	List<Integer>[] adjList;
	List<Integer> stack = new ArrayList<>();
	List<List<Integer>> SCC = new ArrayList<>();
	
    public SCC(String filename) {
    	File file = new File(filename);
    	try{
    		FileReader fr = new FileReader(file);
        	BufferedReader br = new BufferedReader(fr);
        	String[] firstLine;
        	firstLine = br.readLine().split(" ");
        	size = Integer.parseInt(firstLine[0]);	
        	
        	adjList = new List[size];
        	for(int i = 0; i < size; i++) {
        		adjList[i] = new ArrayList<Integer>();
        	}
        	String line = "";
    		while((line = br.readLine()) != null) {
    		    String[] edge;
    		    edge = line.split(" ");
    		    int start = Integer.parseInt(edge[0]);
    		    int end = Integer.parseInt(edge[1]);
    			adjList[start].add(end);
    		}
    		
    	}catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}catch (IOException e) {
    		e.printStackTrace();
		}

    	visited = new boolean[size];
    }
    
    @Override
    public boolean path(int u, int v) {
    	boolean pathExist = false;
    	visited = new boolean[size];
    	stack = new ArrayList<>();
    	dfs(u,adjList,visited, stack);
    	if(visited[v] == true) pathExist = true;
    	visited = new boolean[size];
    	return pathExist;
    }

    @Override
    public boolean connectivity() {
    	for(int i = 0; i < size; i++) {
    		for(int j = 0; j < size; j++) {
    			if(!path(i,j)) return false;
    		}
    	}
    	return true;
    }

    @Override
    public List<List<Integer>> findSCC() {
    	int v = adjList.length;
    	//visited = new boolean[v];
    	List<Integer> order = fillOrder(adjList, visited);
    	List<Integer>[] reversedAdjList = getReverse(adjList);
    	
    	visited = new boolean[v];
    	for(int i = 0; i < order.size(); i++) {
    		int l = order.get(i);
    		if(!visited[l]) {
    			List<Integer> comp = new ArrayList<>();
    			dfs(l, reversedAdjList, visited, comp);
    			SCC.add(comp);
    		}
    	}
    	for(List<Integer> components: SCC) {
    		components.sort(null);
    	}
    	SCC = listSort(SCC);
    	return SCC;
    }

    
    public void dfs(int v, List<Integer>[] adjList, boolean[] visited, List<Integer> comp) {
    	visited[v] = true;
    	for(int i = 0; i < adjList[v].size(); i++) {
    		if(!visited[adjList[v].get(i)])
    			dfs(adjList[v].get(i), adjList, visited, comp);
    	}
    	comp.add(0,v);
    }

    
    public List<Integer> fillOrder(List<Integer>[] adjList, boolean[] visited){
    	List<Integer> order = new ArrayList<Integer>();
    	for(int i = 0; i < adjList.length; i++) {
    		if(!visited[i])
    			dfs(i, adjList, visited, order);
    	}
    	return order;
    }
    
    
    public List<Integer>[] getReverse(List<Integer>[] adjList){
    	int v = adjList.length;
    	List<Integer>[] reversedList = new List[v];
    	for(int i = 0; i < v; i++) {
    		reversedList[i] = new ArrayList<Integer>();
    	}
    	for(int i = 0; i < v; i++) {
    		for(int j = 0; j < adjList[i].size(); j++) {
    			reversedList[adjList[i].get(j)].add(i);
    		}
    	}
    	return reversedList;
    }

    public List<List<Integer>> listSort(List<List<Integer>> list) {
    	List<List<Integer>> sortedSCC= new ArrayList<>();
    	for(int i = 0; i < list.size(); i++) {
    		for(int j = list.size() -1; j > i; j--) {
    			if(list.get(i).get(0) > list.get(j).get(0)) {
    				List<Integer> temp = list.get(i);
    				list.set(i, list.get(j));
    				list.set(j, temp);
    			}
    		}
    	}
    	sortedSCC = list;
    	return sortedSCC;
    }
    
}
