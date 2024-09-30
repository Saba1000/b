package bb;

public class Contatore {
	private int cont = 0;
	
	public synchronized void incrementa() {
		cont++;
		System.out.println(Thread.currentThread().getName() + "-Contatore: " + cont);
	}
}
