package bb;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Contatore cont = new Contatore();
		Incrementatore inc = new Incrementatore(cont);
		
		int tn = 0;
		int t = 0;
		int n;
		Scanner num = new Scanner(System.in);
		System.out.println("Quanti Thread vuoi creare oltre al Main?");
		try
		{
			t = num.nextInt();
		}
		catch(Exception e) {
			System.out.println("\nNon e' un numero");
			return;
		}
		
		System.out.println("Scrivi un numero?");
		try
		{
			n = num.nextInt();
			inc.getN(n);
			
		}
		catch(Exception e) {
			System.out.println("\nNon e' un numero");
			return;
		}
		
		if(t%2 == 0) {
			int z= t/2;
			while(z > 0) {
				t = 2;
				while(t>0) {
					t--;
					tn++;
					Thread thread = new Thread(inc, "Thread-" + tn);
					thread.start();
					try {
		                thread.join();
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
				}
				cont = new Contatore();
				inc = new Incrementatore(cont);
				inc.getN(n);
				z--;
			}
		} else {
			int z= (t-1)/2;
			while(z > 0) {
				t = 2;
				while(t>0) {
					t--;
					tn++;
					Thread thread = new Thread(inc, "Thread-" + tn);
					thread.start();
					try {
		                thread.join();
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
				}
				cont = new Contatore();
				inc = new Incrementatore(cont);
				inc.getN(n);
				z--;
			}
			tn++;
			Thread thread = new Thread(inc, "Thread-" + tn);
			thread.start();
			try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
	}

}
