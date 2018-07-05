import java.util.Properties;
import java.util.Scanner;
import dataStructures.UF;
import dataStructures.UFFactory;

public class Application {

	public static void main(String[] args) {
		runUF("/data/tinyUF.txt", "WeightedQuickUnionUF");
	}

	public static void runUF(String data, String className) {
		Scanner fileScanner = new Scanner(Application.class.getResourceAsStream(data));
		Properties properties = new Properties();
		properties.setProperty("n", String.valueOf(fileScanner.nextInt()));
		UF uf = UFFactory.createUF(className, properties);
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