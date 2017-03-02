/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017 
// PROJECT:          p2
// FILE:             JobListIterator
//
// TEAM:    Team 78
// Authors: (Be sure to check if programming teams are allowed)
// Author1: (name1,email1,netID1,lecture number1)
// Author2: (name2,email2,netID2,lecture number2)
//
// ---------------- OTHER ASSISTANCE CREDITS 
// Persons: Identify persons by name, relationship to you, and email. 
// Describe in detail the the ideas and help they provided. 
// 
// Online sources: avoid web searches to solve your problems, but if you do 
// search, be sure to include Web URLs and description of 
// of any information you find. 
//////////////////////////// 80 columns wide //////////////////////////////////

public class JobListIterator implements java.util.Iterator<Job>{
	private Listnode<Job> jobList; 
	// Number of times called (needed for special case where this is the 
	// first time the iterator is called. 
	private int timesCalled; 
	
	public JobListIterator(Listnode<Job> jobList){
		this.jobList = jobList; 
		timesCalled = 0; 
	}
	
	public boolean hasNext(){
		// If the job to be returned exists or not
		return (jobList != null); 
	}
	
	public Job next(){
		
		Job retJob = null; 
		
		// Name of the job
		String name;
		
		// Number of points, and time units 
		int points, timeUnits; 
		
		// Special case where this is the first job in the list
		if(timesCalled == 0){
			
			timesCalled++; 
			
			//this is not working 
			name = jobList.getNext().getData().getJobName();
			points = jobList.getNext().getData().getPoints();
			timeUnits = jobList.getNext().getData().getTimeUnits();
			retJob = new Job(name, points, timeUnits);
			jobList = jobList.getNext();
			//return retJob;
		
		}// Returns the next job in the list  
		if(hasNext()) { 
			name = jobList.getData().getJobName(); 
			points = jobList.getData().getPoints(); 
			timeUnits = jobList.getData().getTimeUnits(); 
			
			retJob = new Job(name, points, timeUnits); 
			jobList = jobList.getNext();
			//return retJob; 
		}
		return retJob;
	}
	
	// Remove is not supported in this project 
	public void remove(){
		throw new UnsupportedOperationException(); 
	}
}
