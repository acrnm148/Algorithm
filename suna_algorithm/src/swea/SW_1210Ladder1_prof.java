package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1210Ladder1_prof {
	
	//왼 - 오 - 위
	static int[] dy = {0,0,-1};
	static int[] dx = {-1,1,0};
	static int[][] ladder = new int[100][100];
	
	static int sy, sx, ans;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			//ladder 초기화 필요X => 매번 테케 처리 시 입력으로 다시 초기화 자동으로
			//첫번째 테케번호는 버린다. 파싱할 필요도 없음
			br.readLine();
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
//					ladder[i][j] = st.nextToken().charAt(0) - '0'; //속도 비슷
		
				}
			}
			
			//sy, sx를 따로 ladder에서 찾는 방법
			sy = 99;
			for (int i = 0; i < 100; i++) {
				if (ladder[99][i] == 2) sx = i;
			}
			
			//탐색 시작 - 시작방향은 위로가면 됨.
			//시작방향은 위
			int dir = 2;
			
			while (true) {
				//위로 탐색할 경우, 왼,오 우선 - 왼,오 이동할 수 없으면 계속 위
				if (dir == 2) {
					for (int d = 0; d < 3; d++) {
						int ny = sy + dy[d];
						int nx = sx + dx[d];
						
						if (ny >= 0 && nx >= 0 && nx < 100 && ladder[ny][nx] == 1) {
							sy = ny;
							sx = nx;
							dir = d; //방향전환(그대로일수도) 갱신해줘야함
							break; //더 for문 반복할 필요 X
						} 
					}
				}
				//왼쪽 또는 오른쪽으로 탐색할 경우, 위 우선, 위로 이동할 수 없으면 계 왼, 오 방향으로 이동
				else if (dir == 0 || dir == 1) {
					// 위 우선
					int ny = sy + dy[2];
					int nx = sx + dx[2];
					if (ny >= 0 && ladder[ny][nx] == 1) { // 위로 갈 수 있으면
						sy = ny;
						sx = nx;
						dir = 2;
					} else {
						sy = sy + dy[dir];
						sx = sx + dx[dir];
					}
				}
				if (sy == 0) {
					ans = sx;
					break;
				}
				
			} //while
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
}
