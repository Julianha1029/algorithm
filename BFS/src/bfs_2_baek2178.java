import java.util.*;
import java.io.*;

public class bfs_2_baek2178 {
	
	static Scanner in;
	static int[][] a;
	static int n, m;
	static Queue<Integer> q;
	static int[] dx = {-1, 1, 0, 0,};
	static int[] dy = {0, 0, -1, 1};
	
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
			String temp = in.next();
			for (int j = 0; j < m; j++) {
				a[i][j] = temp.charAt(j) - '0';
			}
		}
		q = new LinkedList<Integer>();
	}
	
	static int solve() {
		return bfs(0, 0);
	}
	
	static int bfs(int x, int y) {
		a[x][y] = 2;
		q.add(x);
		q.add(y);
		int ans = 0;
		while (!q.isEmpty()) {
			x = q.poll();
			y = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (a[nx][ny] == 1) {
					q.add(nx);
					q.add(ny);
					a[nx][ny] = a[x][y] + 1;
				}
				if (nx == (n-1) && ny == (m-1)) {
					ans = a[nx][ny]-1;
					break;
				}
			}
			if (ans != 0)
				break;
		}
		return ans;
	}

}
