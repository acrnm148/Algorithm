package boj;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 조합
 * */
public class BOJ_15686치킨배달_prof {

	static int N, M, min;
	static List<int[]> house, src, tgt; // 집 좌표, 치킨집 , 조합으로 선택한 치킨집
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		house = new ArrayList<>();
		src = new ArrayList<>(); //전체 치킨집
		tgt = new ArrayList<>(); //선택된 치킨집 M개

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n =  Integer.parseInt(st.nextToken());
				if (n == 1) {
					house.add(new int[] {i, j});
				}
				else if (n == 2) {
					src.add(new int[] {i, j});
				}
			}
		}
		min = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(min);
	}
	
	
	static void comb(int srcIdx, int tgtIdx) {
		//1. 기저조건
		if (tgtIdx == M) { //M개를 뽑는다
			//현재 치킨집 조합을 기준으로 모든 집에서 최단거리 치킨집을 계산해서 모두 더한다 -> 그 합의 최소값 선택
			int sum = 0; //치킨 거리의 합
			int size = house.size();
			for (int i = 0; i < size; i++) { //모든 집 각각에 대해서 고려
				int distance = Integer.MAX_VALUE;
				int[] h = house.get(i); //i번째 집의 치킨 거리
										//이 집으로부터 선택된 M개의 치킨집 거리를 계산해서 최소값을 선택
				for (int j = 0; j < M; j++) {
					int[] c = tgt.get(j);
					distance = Math.min(distance, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
				}
				sum += distance; // 현재 M개 치킨집의 치킨거리 누적합
			}
			//합의 최소거리 구함 - 최소값 갱신
			min = Math.min(sum, min);
			return;
		}
		
		if (srcIdx == src.size()) return;
		
		//배열이 아닌  리스트이므로 true false가 아닌 삭제로 해줌
		tgt.add(src.get(srcIdx)); 
		comb(srcIdx+1, tgtIdx+1);
		tgt.remove(src.get(srcIdx));
		comb(srcIdx+1, tgtIdx);
		
	}	
	
}
