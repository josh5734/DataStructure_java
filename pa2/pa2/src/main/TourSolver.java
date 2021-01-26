/*
 * Name: Jo sung hyeon
 * Student ID #: 2016147008
 */

/* 
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class TourSolver implements ITourSolver {
    /*
     * Add some variables you will use.
     */
	int[] row = {2,1,-1,-2,-2,-1,1,2};
	int[] col = {1,2,2,1,-1,-2,-2,-1};
	
	int n;
	int m;
	int[] visited_array;
	int[] answer;
	int[][] visited;
	
    @Override
    public int[] solve(Board board) {
        /*
        * Function input:
        *  + board: A board with some missing squares.
        *
        * Job:
        *  Return a seqence of knight's tour solution on the given board.
        *  If there is no solution, return an empty sequence.
        */
    	this.n = board.getWidth();
    	this.m = board.getHeight();
    	this.visited_array = new int[n*m];
    	this.visited = new int[n][m];
    	this.answer = new int[n*m];
    	for(int i = 0; i<n; i++) {
    		for(int j = 0; j < m; j++) {
    			visited[i][j] = -1;
    		}
    	}
    	visited[0][0] = 0;
    	solution(0,0,1,visited, row,col);
    
    	
    	int cnt = 0;
    	while(cnt < n*m) {
    		for(int i = 0; i < n; i++) {
        		for(int j = 0; j < m; j++) {
        			if(visited[i][j] == cnt)
        				answer[cnt] = i*m+j;			
        		}
        	}cnt++;
    	}
    	
    	if(answer.length > 1 && answer[1] == 0)
    		return new int[] {};
    	return answer;

    }
    boolean solution(int x, int y, int move, int[][] visited, int[] row, int[] col) {
    	int k, next_x, next_y;
    	if(move == n*m) return true;
    	
    	for(k = 0; k < 8; k++) {
    		next_x = x + row[k];
    		next_y = y + col[k];

    		if(available(next_x, next_y, visited)) {
    			visited[next_x][next_y] = move;
    			
    			//System.out.printf("%d %d\n", next_x, next_y);
    			if(solution(next_x,next_y,move+1,visited,row,col)) {
    				return true;    				
    			}
    			else {
    				visited[next_x][next_y] = -1;    				
    			}
    		}
    	}
    	return false;
    }
  

 

    boolean available(int x, int y, int visited[][]) { 
    	if (x >= 0 && x < n && y >= 0 && y < m) {
    		if(visited[x][y] == -1) {
    			return true;
    		}
    	}
    	return false;

//        return (x >= 0 && x < n && y >= 0 && y < m)visited[x][y] == -1); 

    } 
   
}
