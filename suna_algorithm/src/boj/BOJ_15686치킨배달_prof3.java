package boj;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * NP + Comb + Memoization
 * */
public class BOJ_15686치킨배달_prof3 {

	static int N, M, min;
	static List<int[]> house, src; // 집 좌표, 치킨집 , 조합으로 선택한 치킨집
	static int[] index; // np()에 의해서 가장 작은 값 --> 가장 큰 값으로 갱신되어 가는 배열, src에서 어느 인덱스가 선택되었는지를 표현
	static int[][] memoi; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		house = new ArrayList<>();
		src = new ArrayList<>(); //전체 치킨집

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// input처리를 하면서 house, chicken 집의 번호를 구한다
		int houseNo = 0;
		int chickenNo = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n =  Integer.parseInt(st.nextToken());
				if (n == 1) {
					house.add(new int[] {houseNo++, i, j});
				}
				else if (n == 2) {
					src.add(new int[] {chickenNo++, i, j});
				}
			}
		}
		
		//houseNo, chickenNo <= 개수
		memoi = new int[houseNo][chickenNo];
		for (int i = 0; i < houseNo; i++) {
			for (int j = 0; j < chickenNo; j++) {
				memoi[i][j] = Math.abs(house.get(j)[1] - src.get(j)[1]) + Math.abs(house.get(j)[2] - src.get(j)[2]);
			}
		}
		
		
		//np + comb 위한 index 배열 생성
		int srcSize = src.size();
		index = new int[srcSize];
		
		for (int i = srcSize-M; i < srcSize; i++) {// 치킨집 개수만큼 돈다
			index[i] = 1; //M개 뽑았다 치고 남은 자리에 전부 1 넣어줌
		}
		
		//min = Integer.MAX_VALUE;

		int size = house.size();
		while (true) {
			//dist 계산 --> 합 -> min 갱신
			int sum = 0; //치킨 거리의 합
			for (int i = 0; i < size; i++) { //모든 집 각각에 대해서 고려
				int distance = Integer.MAX_VALUE;
				int[] h = house.get(i); //i번째 집의 치킨 거리
										//이 집으로부터 선택된 M개의 치킨집 거리를 계산해서 최소값을 선택
				for (int j = 0; j < index.length; j++) {
					if (index[j] == 1) {
						int[] c = src.get(j);
						distance = Math.min(distance, memoi[ h[0] ][ c[0] ]);
					}
				}
				sum += distance; // 현재 M개 치킨집의 치킨거리 누적합
			}
			//합의 최소거리 구함 - 최소값 갱신
			min = Math.min(sum, min);
			
			if (!np()) break;
		}
		
		System.out.println(min);
	}
	
	/* 넥스트 퍼미테이션 - 조합에서 써보자
	 * np() 와 swap()은 커플
	 * */
	private static boolean np() {
	    int[] src = index;
	    int i = src.length - 1;
	    while( i>0 && src[i-1]>=src[i] ) --i;
	    
	    if( i == 0 ) return false;
	    
	    int j = src.length - 1;
	    while(src[i-1]>=src[j]) --j;
	    swap(src,i-1,j);
	    
	    // reverse
	    int k = src.length - 1;
	    while(i<k) {
	        swap(src,i++,k--);            
	    }
	    return true;
	}


	private static void swap(int num[],int i,int j) {
	    int temp = num[i];
	    num[i] = num[j];
	    num[j] = temp;
	}
	
	
}
