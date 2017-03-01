
public class Scoreboard implements ScoreboardADT {
	
	//create a jobList called list
	private JobList list; 
	
	//iterator to get through list
	private java.util.Iterator<Job> jItr;
	
	public Scoreboard(){
		
		//Initialize list to a job list
		list = new JobList();
	}
	
	@Override
	public int getTotalScore() {
		
		//Starting score is 0
		int retScore = 0;  
		
		//iterator for list of jobs
		jItr = list.iterator();
		
		//while there is a next job calculate score for current job
		while(jItr.hasNext()){
			retScore += jItr.next().getPoints();
			
			//System.out.println("how many items");
		}
		
		return retScore;
	}

	@Override
	public void updateScoreBoard(Job job) {
		
		//add a job to "list" when it is completed
		list.add(job);
	}

	@Override
	public void displayScoreBoard() {
		
		/* displays completed jobs
		 * using iterator through the list of Jobs
		 * that are completed
		 */
		System.out.println("Total Score: " + this.getTotalScore());
		System.out.println("The jobs completed: "); 
		jItr = list.iterator();
		while(jItr.hasNext()){
			Job displayJob = jItr.next(); 
			System.out.println("Job Name: " + displayJob.getJobName());
			System.out.println("Points earned for this job: " + displayJob.getPoints());
			System.out.println("--------------------------------------------");
		}

	}

}
