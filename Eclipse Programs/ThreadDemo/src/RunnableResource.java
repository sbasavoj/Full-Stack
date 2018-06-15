
public class RunnableResource implements Runnable{

	@Override
	public void run() {
		int i=0;
		while(i<50){
			Thread t=Thread.currentThread();
			if(t.getName().equals("Thread-0"))			
				System.out.print((i++)*2+" ");
			else if(t.getName().equals("Thread-1"))
				//while(i<50)
				System.out.print((i++)*2+1+" ");	
		}
	}

}
