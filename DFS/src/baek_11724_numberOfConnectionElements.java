import java.io.*;
import java.util.*;
public class baek_11724_numberOfConnectionElements {

	static ArrayList<Integer>[] a;
	static boolean[] visit;
	static int n, m;
	static Scanner in;
	static int result;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(System.in);
			init();
			result = solve();
			System.out.println(result);
			in.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		visit = new boolean[n+1];
		a = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int n1 = in.nextInt();
			int n2 = in.nextInt();
			a[n1].add(n2);
			a[n2].add(n1);
		}
	}
	
	static int solve() {
		for (int i = 1; i <= n; i++) {
			for (int x: a[i]) {
				if (!visit[x]) {
					dfs(x);
					result++;
				}
			}
		}
		return result;
	}
	
	static void dfs(int x) {
		if (visit[x])
			return;
		visit[x] = true;
		for (int y: a[x]) {
			if (!visit[y])
				dfs(y);
		}
	}
}
