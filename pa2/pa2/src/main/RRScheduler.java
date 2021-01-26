/*
 * Name: JO SUNG HYEON
 * Student ID #: 2016147008
 */

/* 
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class RRScheduler implements IRRScheduler {
    /*
     * Add some variables you will use. 
     */
	CDLList scheduler = new CDLList();
	boolean direction = true;
	
    @Override
    public void insert(int id) {
        /*
        * Function input:
        *  + id: the job id to insert
        *
        * Job: 
        *  Insert the job at the back of the scheduler.
        */
	    scheduler.insert(id);
    }

    @Override
    public void done() { 
        /*
        * Function input: Nothing
        *
        * Job:
        *  One time segment passes and the job processed is deleted
        */
    	if(!scheduler.isEmpty()) {
    		if(direction) {
    			scheduler.rotateForward();
        		scheduler.delete();
        	}
        	if(!direction && !scheduler.isEmpty()) {
        		scheduler.rotateBackward();
        		scheduler.delete_next();
        	}
    	} 	
    }
    

    @Override
    public void timeflow(int n) {
        /*
        * Function input:
        *  + n: An integer.
        *
        * Job:
        *  Simulate n time segments.
        */
    	if(!scheduler.isEmpty() ) {
    		if(direction){
        		for(int i = 0; i < n; i++) {
        			scheduler.rotateForward();
        		}
        	}
        	if(!direction){
        		for(int i = 0; i < n; i++) {
        			scheduler.rotateBackward();
        		}
        	}

    	}
    }
// 1 2 3 4 5 -> 
    @Override
    public void changeDirection() {
        /*
        * Function input: Nothing
        *
        * Job:
        *  Change the direction of the scheduler.
        */
    	
    	direction = !direction;
    	
    }// 1 2 3 4 5 -> 1 5 4 3 2 

    @Override
    public int currentJob() throws IllegalStateException {
        /*
        * Function input: Nothing
        *
        * Job:
        *  Return the current job.
        */
    	
    	if(scheduler.isEmpty()) {
    		throw new IllegalStateException("sorry.");
    	}    	
        return scheduler.getHead().getValue();
    }
}
