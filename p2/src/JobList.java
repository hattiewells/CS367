import java.util.Iterator;

public class JobList implements ListADT<Job> {
	private Listnode<Job> head;  
	private int numItems; 
	
	public JobList(){
		head = new Listnode<Job>(null); 
		numItems = 0; 
	}
	
	public Iterator<Job> iterator() {
		Iterator<Job> jobIter = new JobListIterator(head); 
		
		return jobIter;
	}

	@Override
	public void add(Job item) {
		Listnode<Job> tmp = head; 
		for(int i = 0; i < numItems; i++){
			tmp = tmp.getNext();
		}
		tmp.setNext(new Listnode<Job>(item));
		numItems++; 
	}

	@Override
	public void add(int pos, Job item) {
		Listnode<Job> tmp = head; 
		if(pos == 0){
			tmp.getNext().setNext(new Listnode<Job>(item));
		}
		else{
			for(int i = 0; i < pos; i++){
				tmp = tmp.getNext();
			}
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
		Job retJob = null; 
		Listnode<Job> tmp = head; 
		for(int i = 0; i < pos + 1; i++){
			tmp = tmp.getNext();
			retJob = tmp.getData(); 
		}
		return retJob;
	}

	@Override
	public boolean isEmpty() {
		return (numItems == 0);
	}

	@Override
	public Job remove(int pos) {
		Job remove = this.get(pos); 
		Listnode<Job> removeNode = head; 
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
