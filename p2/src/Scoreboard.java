
public class Scoreboard implements ScoreboardADT {
	private JobList list; 
	private java.util.Iterator<Job> jItr;
	
	public Scoreboard(){
		list = new JobList();
	}
	@Override
	public int getTotalScore() {
		int retScore = 0;  
		jItr = list.iterator();
		while(jItr.hasNext()){
			retScore += jItr.next().getPoints();
			System.out.println("how many items");
		}
		
		return retScore;
	}

	@Override
	public void updateScoreBoard(Job job) {
		list.add(job);
	}

	@Override
	public void displayScoreBoard() {
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
