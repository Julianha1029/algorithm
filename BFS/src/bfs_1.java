import java.util.*;
import java.io.*;
public class bfs_1 {
	
	static int[][] a;
	static Queue<Integer> q;
	static int n, m;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Scanner in;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(System.in);
			init();
			int result = solve();
			System.out.println(result);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = in.nextInt();
			}
		}
		q = new LinkedList<Integer>();
	}
	
	static int solve() {
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 1) {
					bfs(i, j);
					ans++;
				}
			}
		}
		return ans;
	}

	static void bfs(int x, int y) {
		q.add(x);
		q.add(y);
		a[x][y] = 0;
		while (!q.isEmpty()) {
			x = q.poll();
			y = q.poll();
			for (int i= 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (a[nx][ny] == 1) {
					q.add(nx);
					q.add(ny);
					a[nx][ny] = 0;
				}
			}
		}
	}
}


//4 5
//1 1 1 1 0
//0 0 0 1 0
//1 1 0 0 0
//0 0 1 1 1