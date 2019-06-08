import java.io.*;
import java.util.*;
public class newDFS {

	static Scanner in;
	static int[][] a;
	static int n, m;
	static int dr[] = {0, 0, -1, 1};
	static int dc[] = {-1, 1, 0, 0};
	static int result;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(System.in);
			init();
			result = solve();
			System.out.println(result);
			in.close();
		}
		catch (Exception e){
			System.out.println(e);
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
	}
	
	static int solve() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 1) {
				dfs(i, j);
				result++;
				}
			}
		}
		return result;
	}
	
	static void dfs(int r, int c) {
		a[r][c] = 0;
		for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr<0||nr>=n||nc<0||nc>=m) {
					continue;
				}
				if (a[nr][nc] == 1)
					dfs(nr, nc);
		}
	}
}
