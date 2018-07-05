package dataStructures;

import java.util.Properties;

public class WeightedQuickUnionUF implements UF {
	private int[] parent;
	private int[] size;
	private int count;

	public WeightedQuickUnionUF(Properties properties) {
		int n = Integer.valueOf(properties.getProperty("n"));
		parent = new int[n];
		size = new int[n];
		count = n;
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}

	public void union(int p, int q) {
		if (root(p) == root(q))
			return;
		else if (size[root(p)] < size[root(q)]) {
			parent[root(p)] = root(q);
			size[root(q)] += size[root(p)];
		} else {
			parent[root(q)] = root(p);
			size[root(p)] += size[root(q)];
		}
		count--;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public int count() {
		return count;
	}

	public int root(int p) {
		while (p != parent[p])
			p = parent[p];
		return p;
	}
}
