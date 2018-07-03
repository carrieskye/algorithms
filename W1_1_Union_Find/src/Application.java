import java.util.Scanner;

import dataStructures.UF;

public class Application {
	
	
	public static void main(String[] args) {
		runUF("/data/tinyUF.txt");
	}
	
	public static void runUF(String data) {
		Scanner fileScanner = new Scanner(Application.class.getResourceAsStream(data));
		int n = fileScanner.nextInt();
		UF uf = new UF(n);
		while (fileScanner.hasNextInt()) {
			int p = fileScanner.nextInt();
			int q = fileScanner.nextInt();
			if (!uf.connected(p, q)) {
				uf.union(p, q);
				System.out.println(p + " " + q);
			}
		}
		fileScanner.close();
		System.out.println(uf.count() + " components");
	}

}