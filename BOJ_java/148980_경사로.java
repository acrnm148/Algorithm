import java.io.*;
import java.util.*;

public class Main {
	
	static int map1[][], map2[][], N, L, ans;
	static boolean isDown;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map1 = new int[N][N];
		map2 = new int[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map1[i][j] = num;
				map2[j][i] = num;
			}
		}
		// 입력 끝
		
		solution(map1);
		solution(map2);
		System.out.println(ans);
	}
	
	static void solution(int[][] map) {
		for (int i=0; i<N; i++) {
			int cnt = 1;
			boolean isOk = true;
			for (int j=0; j<N-1; j++) {
				int last = map[i][j];
				int now = map[i][j+1];
				int gap = Math.abs(now-last);
				
				if (gap == 0) {
					cnt++;
				} 
				else if (gap == 1) {
					if (now > last) { //오르막길
						if (cnt >= L) {
							cnt = 1;
							continue;
						}
						else {
							isOk = false;
							break;
						}
					}
					else if (now < last) {	//내리막길
						if (j+L >= N ) {
							isOk = false;
							break;
						}
						for (int k=1; k<=L; k++) {
							if (map[i][j+k] != now) {
								isOk = false;
								break;
							}
						}
						if (!isOk) break;
						cnt = 0;	//주의점1) 0인 이유 : 경사로 아예 처음부터 다시 시작해야 함
						j += L-1;	//주의점2) L-1인 이유 : j는 last 좌표로 맞춰야 함
					}
				} 
				else if (gap >= 2){
					isOk = false;
					break;
				}
			}
			if (isOk) {
				ans++;
			}
		}
	}
}






