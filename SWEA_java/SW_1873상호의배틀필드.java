package swea;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1873상호의배틀필드 {
	
	static char[][] map;
	static int cmdCnt;
	static int[] dir_y = {-1, 1, 0, 0}; //상하좌우
	static int[] dir_x = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int tc = 1; tc <= T; tc++) {
			//입력부
			st = new StringTokenizer(br.readLine()); //st는 공백있을 경우
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int startX = 0;
			int startY = 0;
			int dir = 0;
			map = new char[H][W];
			for (int y = 0; y < H; y++) {
				char[] tmp = br.readLine().toCharArray();
				for (int x = 0; x < W; x++) {
					map[y][x] = tmp[x];
					//전차 찾기
					if (map[y][x] == '^') { //상
						dir = 0;
						startX = x;
						startY = y;
					} else if (map[y][x] == 'v') { //하
						dir = 1;
						startX = x;
						startY = y;
					} else if (map[y][x] == '<') { //좌
						dir = 2;
						startX = x;
						startY = y;
					} else if (map[y][x] == '>') { //우
						dir = 3;
						startX = x;
						startY = y;
					}
				} 
			}
			
			cmdCnt = Integer.parseInt(br.readLine());
			char[] cmd = new char[cmdCnt];
			cmd = br.readLine().toCharArray();
			
//			System.out.println("go");
			//탐색
			int idx = 0;
			while (idx < cmd.length) {
				if (cmd[idx] == 'U') {
					dir = 0;
					if (startY + dir_y[dir] < H && startY + dir_y[dir] >= 0 && map[startY - 1][startX] == '.') {
						map[startY][startX] = '.';
						startY += dir_y[dir];
					}
					map[startY][startX] = '^';
				}
				if (cmd[idx] == 'D') {
					dir = 1;
					if (startY + dir_y[dir] < H && startY + dir_y[dir] >= 0 && map[startY + 1][startX] == '.') {
						map[startY][startX] = '.';
						startY += dir_y[dir];
					}
					map[startY][startX] = 'v';
				}
				if (cmd[idx] == 'L') {
					dir = 2;
					if (startX + dir_x[dir] < W && startX + dir_x[dir] >= 0 && map[startY][startX - 1] == '.') {
						map[startY][startX] = '.';
						startX += dir_x[dir];
					}
					map[startY][startX] = '<';
				}
				if (cmd[idx] == 'R') {
					dir = 3;
					if (startX + dir_x[dir] < W && startX + dir_x[dir] >= 0 &&map[startY][startX + 1] == '.') {
						map[startY][startX] = '.';
						startX += dir_x[dir];
					}
					map[startY][startX] = '>';
				}
				if (cmd[idx] == 'S') {
					int sX = startX;
					int sY = startY;
					int dx = dir_x[dir];
					int dy = dir_y[dir];
					int nextX = sX+ dir_x[dir];
					int nextY = sY+ dir_y[dir];
					while (nextY >= 0 && nextY < H && nextX >= 0 && nextX < W && (map[nextY][nextX] == '*' || map[nextY][nextX] == '-')) { //포탄 둘 좌표 구함
						if (map[nextY][nextX] == '-') {
							if (map[nextY + dy][nextX + dx] == '*') {
								sY += dy;
								sX += dx;
							}
						}
						else if (map[nextY][nextX] == '*') {
							sY += dy;
							sX += dx;
						}
						nextX = sX+ dx;
						nextY = sY+ dy;
					}
					if (map[sY][sX] == '*')
						map[sY][sX] = '.';
				}
				
				//test
//				System.out.println("===="+cmd[idx]);
//				for (int y = 0;y < H; y++) {
//					for (int x = 0;x < W; x++) {
//						System.out.print(map[y][x]);
//					}
//					System.out.println();
//				}
				
				idx++;
			}
			System.out.print("#" + tc + " ");
			for (int y = 0;y < H; y++) {
				for (int x = 0;x < W; x++) {
					System.out.print(map[y][x]);
				}
				System.out.println();
			}
			
		}
		
		
		
	}

}
