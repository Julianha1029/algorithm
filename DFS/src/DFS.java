import java.util.*;
import java.io.*;
public class DFS {

	static int[][] a;
	static int n, m;
	static int dr[] = {0, 0, -1, 1};
	static int dc[] = {-1, 1, 0, 0};
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		m = in.nextInt();
		a = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = in.nextInt();
			}
		}
		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 1) {
					dfs(i, j);
					ans++;
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	public static void dfs(int r, int c) {
		a[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr<0||nr>=n||nc<0||nc>=m)
				continue;
			if (a[nr][nc] == 1)
				dfs(nr, nc);
		}
	}
}
