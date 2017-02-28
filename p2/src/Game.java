public class Game{

    /**
     * A list of all jobs currently in the queue.
     */
    private ListADT<Job> list;
    /**
     * Whenever a Job is completed it is added to the scoreboard
     */
    private ScoreboardADT scoreBoard;
    private int timeToPlay;
    private JobSimulator jobSimulator;

    /**
     * Constructor. Initializes all variables.
     * @param seed
     * seed used to seed the random number generator in the Jobsimulator class.
     * @param timeToPlay
     * duration used to determine the length of the game.
     */
    public Game(int seed, int timeToPlay){
        /**
         * TODO: Initializes all member variables
         */
    	jobSimulator = new JobSimulator(seed); 
    	this.timeToPlay = timeToPlay; 
    	list = new JobList(); 
    	scoreBoard = new Scoreboard(); 
    }

    /**
     * Returns the amount of time currently left in the game.
     * @returns the amount of time left in the game.
     */
    public int getTimeToPlay() {
        //TODO: return the amount of time left
        return timeToPlay;
    }

    /**
     * Sets the amount of time that the game is to be executed for.
     * Can be used to update the amount of time remaining.
     * @param timeToPlay
     *        the remaining duration of the game
     */
    public void setTimeToPlay(int timeToPlay) {
        //TODO: Setter for amount of time to play
    	this.timeToPlay = timeToPlay;
    }

    /**
     * States whether or not the game is over yet.
     * @returns true if the amount of time remaining in
     * the game is less than or equal to 0,
     * else returns false
     */
    public boolean isOver(){
        //TODO: check if the game is over or not
        return (timeToPlay <= 0);
    }
    /**
     * This method simply invokes the simulateJobs method
     * in the JobSimulator object.
     */
    public void createJobs(){
        //TODO: Invoke the simulator to create jobs
    	jobSimulator.simulateJobs(list, timeToPlay);
    }

    /**
     * @returns the length of the Joblist.
     */
    public int getNumberOfJobs(){
        //TODO: Get the number of jobs in the JobList
        return list.size();
    }

    /**
     * Adds a job to a given position in the joblist.
     * Also requires to calculate the time Penalty involved in
     * adding a job back into the list and update the timeToPlay
     * accordingly
     * @param pos
     *      The position that the given job is to be added to in the list.
     * @param item
     *      The job to be inserted in the list.
     */
    public void addJob(int pos, Job item){
        /**
         * TODO: Add a job in the list
         * based on position
         */
    	list.add(pos, item);
    }

    /**
     * Adds a job to the joblist.
     * @param item
     *      The job to be inserted in the list.
     */
    public void addJob(Job item){
        //TODO: Add a job in the joblist
    	list.add(item);
    }

    /**
     * Given a valid index and duration,
     * executes the given job for the given duration.
     *
     * This function should remove the job from the list and
     * return it after applying the duration.
     *
     * This function should set duration equal to the
     * amount of time remaining if duration exceeds it prior
     * to executing the job.
     * After executing the job for a given amount of time,
     * check if it is completed or not. If it is, then
     * it must be inserted into the scoreBoard.
     * This method should also calculate the time penalty involved in
     * executing the job and update the timeToPlay value accordingly
     * @param index
     *      The job to be inserted in the list.
     * @param duration
     *      The amount of time the given job is to be worked on for.
     */
    public Job updateJob(int index, int duration){
        //TODO: As per instructions in comments
    	if(index != 0){
    		timeToPlay -= index; 
    	}
    	timeToPlay -= duration; 
    	//Job toDo = list.get(index); 
    	Job toDo = list.remove(index); 
    	System.out.println(toDo.getTimeUnits());
    	if(duration > toDo.getTimeUnits()){
    		duration = toDo.getTimeUnits(); 
    	}
    	toDo.setTimeUnits(toDo.getTimeUnits() - duration);
    	if(toDo.getSteps() == 0){
    		scoreBoard.updateScoreBoard(toDo);
    		System.out.println("Job completed! Current Score: " + getTotalScore());
    	}
    	else{
    		int pos = 0; 
    		pos = GameApp.getIntegerInput("At what position would you like to insert the job back into the list?"); 
    		this.addJob(pos, toDo);
    	}
        return null;
    }

    /**
     * This method produces the output for the initial Job Listing, IE:
     * "Job Listing
     *  At position: job.toString()
     *  At position: job.toString()
     *  ..."
     *
     */
    public void displayActiveJobs(){
        //TODO: Display all the active jobs
    	java.util.Iterator<Job> jItr = list.iterator();
    	System.out.println("Job Listing");
    	int pos = 0; 
		while(jItr.hasNext()){
			Job displayJob = jItr.next();
			System.out.println("At position: " + pos + " " + displayJob.toString());
			pos++; 
		}

    }

    /**
     * This function simply invokes the displayScoreBoard method in the ScoreBoard class.
     */
    public void displayCompletedJobs(){
        //TODO: Display all the completed jobs
    	scoreBoard.displayScoreBoard();
    }

    /**
     * This function simply invokes the getTotalScore method of the ScoreBoard class.
     * @return the value calculated by getTotalScore
     */
    public int getTotalScore(){
        //TODO: Return the total score accumulated
    	return scoreBoard.getTotalScore();
    }
}