package boj2.브루트포스_백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615_오목 {

	static int[][] board = new int[20][20]; //0 dummy
	static int[] dy = {-1, 0, 1, 1};
	static int[] dx = {1, 1, 1, 0};
	static boolean isWin;
	
	static int sy, sx;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 1; i <= 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 끝
		
		for (int y = 1; y <= 19; y++) {
			for (int x = 1; x <= 19; x++) {
				if (board[y][x] == 1 || board[y][x] == 2) {
					
					//시작돌 검증
					//0. 범위 벗어나면 continue 1. 해당 방향 이전 좌표에 같은 돌이 있으면 continue
					int py = 0, px = 0, color = 0;
					color = board[y][x];
					for (int d = 0; d < 4; d++) {
						py = y - dy[d];
						px = x - dx[d];
						if ((py >= 1 && py <= 19 && px >= 1 && px <= 19) && board[py][px] == color) continue;
						//방법1 - while
						//check(y, x, d, color);
						
						//방법2 - 재귀
						if (x+4*dx[d] <= 0 || x+4*dx[d] > 19 || y+4*dy[d] <= 0 || y+4*dy[d] > 19) continue;
						sy = y;
						sx = x;
						check2(y, x, d, color, 0);
					}
				}
			}
		}
		//승자가 없을 경우
		if (!isWin) System.out.println(0);
	}

	static void check(int y, int x, int d, int color) {
		int ny = y;
		int nx = x;
		int cnt = 0;
		while (board[ny][nx] == color) {
			cnt++;
			ny += dy[d];
			nx += dx[d];
			if (ny > 19 || ny <= 0 || nx > 19 || nx <= 0) break;
		}
		if (cnt == 5) {
			isWin = true;
			System.out.println(color);
			System.out.println(y + " " + x);
		}
		
	}
	
	
	static void check2(int y, int x, int d, int color, int cnt) {
		
		if (cnt == 5) { //범위가 밖인데 정답일 수도 있다!! 마지막줄까지가 cnt=5일경우를 놓쳤다..
			if (y >= 1 && y <= 19 && x <= 19 && x >= 1) {
				if (board[y][x] != color) {//그럼 승리
					System.out.println(color);
					System.out.println(sy + " " + sx);
					isWin = true;
				}
			}
			else { //이전이 마지막줄이었는데 오목 이긴 경우 (cnt=5인데 다음 좌표가 범위를 벗어나는 경우)
				System.out.println(color);
				System.out.println(sy + " " + sx);
				isWin = true;
			}
			return;
		}
		
		if (board[y][x] != color) {
			return;
		}
		check2(y + dy[d], x + dx[d], d, color, cnt+1);
	}
	
}
