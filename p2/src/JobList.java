import java.util.Iterator;

public class JobList implements ListADT<Job> {
	
	//create list node to begin, will hold job objects
	private Listnode<Job> head;  
	private int numItems; 
	
	public JobList(){
		
		//set header node to null
		head = new Listnode<Job>(null); 
		numItems = 0; 
	}
	
	public Iterator<Job> iterator() {
		Iterator<Job> jobIter = new JobListIterator(head); 
		return jobIter;
	}

	@Override
	public void add(Job item) {
		
		//temporary list of jobs to iterate through so we don't mess it up
		Listnode<Job> tmp = head; 
		
		//get iterator to the last node in order to add to it
		for(int i = 0; i < numItems; i++){
			tmp = tmp.getNext();
		}
		
		//add new job to end of list
		tmp.setNext(new Listnode<Job>(item));
		
		//added an item so number of items is one higher
		numItems++; 
	}

	@Override
	public void add(int pos, Job item) {
		
		//temporary list of jobs to iterate through so we don't mess it up
		Listnode<Job> tmp = head; 
		
		//if we need to add to beginning of list it's a special case
		if(pos == 0){
			
			//put item in first position (after header node)
			tmp.getNext().setNext(new Listnode<Job>(item));
		}
		
		//for any other position add to the specified place
		else{
			
			//find get next until at position
			for(int i = 0; i < pos; i++){
				tmp = tmp.getNext();
			}
			
			//place item at spot
			tmp.setNext(new Listnode<Job>(item, tmp.getNext()));
		}
	}

	@Override
	public boolean contains(Job item) {
		// TODO Auto-generated method stub
		
		
		return false;
	}

	@Override
	public Job get(int pos) {
		
		//job we will return
		Job retJob = null; 
		
		//temporary list of jobs to iterate through
		Listnode<Job> tmp = head; 
		
		//get to position and set job to return
		for(int i = 0; i < pos + 1; i++){
			tmp = tmp.getNext();
			retJob = tmp.getData(); 
		}
		return retJob;
	}

	@Override
	public boolean isEmpty() {
		
		//will return true if number of items is 0
		return (numItems == 0);
	}

	@Override
	public Job remove(int pos) {
		
		//job instance to remove
		Job remove = this.get(pos); 
		
		//list of jobs ??????
		Listnode<Job> removeNode = head; 
		
		//list of jobs to iterate through
		Listnode<Job> tmp = head;
		

		if(pos == 0){
			
			//System.out.println(tmp.getNext().getData());
			
			tmp.setNext(tmp.getNext().getNext());
			numItems--; 
		}
		else{
			while(removeNode.getData() != remove){
				removeNode = removeNode.getNext(); 
			}
			for(int i = 0; i < pos; i++){
				tmp = tmp.getNext();
			}
			//System.out.println(tmp.getData().getJobName());
			tmp.setNext(removeNode.getNext()); 
			numItems--; 
		}
		return remove; 
	}

	@Override
	public int size() {
		return numItems;
	}
	
}
