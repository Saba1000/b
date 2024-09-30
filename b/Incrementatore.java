package bb;

public class Incrementatore implements Runnable {
	private Contatore cont;
	private int n;
	private int count = 0;
	
	public void getN(int n) {
		this.n = n;
	}
	
	public Incrementatore(Contatore cont) {
		this.cont = cont;
	}
	
	public void run() {
		if(n%2 == 0) {
			for(int i=0; i<n/2; i++) {
				cont.incrementa();
			}
		} else {
			int s = 1;
			for(int i=0; i<(n-1)/2; i++) {
				cont.incrementa();
			}
			if(count != 1) {
				for(int i=0; i<s; i++) {
					cont.incrementa();
				}
			}
			count = 1;
		}	
	}
}
