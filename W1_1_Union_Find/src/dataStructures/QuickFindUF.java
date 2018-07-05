package dataStructures;

import java.util.Properties;

public class QuickFindUF implements UF {
	private int[] id;
	private int count;

	public QuickFindUF(Properties properties) {
		int n = Integer.valueOf(properties.getProperty("n"));
		id = new int[n];
		count = n;
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	public void union(int p, int q) {
		int idP = id[p];
		int idQ = id[q];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == idP)
				id[i] = idQ;
		}
		count--;
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	public int count() {
		return count;
	}
}