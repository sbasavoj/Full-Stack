
public class MainClass {

	public static void main(String[] args) {
		RunnableResource resource=new RunnableResource();
		Thread t1=new Thread(resource,"Thread-0");
		MyThread t2=new MyThread("Thread-1");
		t1.start();
		t2.start();

	}

}
