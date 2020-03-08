package sftwaretest.lab01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class Pocket {
	public Map<Integer,Integer> cash = null;
	public Object[] faceAcount;
	public Integer[] combinationScheme;
	
	public void init() {
		Map<Integer,Integer> cash = new HashMap<Integer,Integer>();
		cash.put(50, 1);
		cash.put(20, 1);
		cash.put(10, 1);
		cash.put(5, 2);
		cash.put(1,3);
		
		this.setCash(cash);
		this.faceAcount = cash.keySet().toArray();
		Arrays.sort(faceAcount);
		combinationScheme = new Integer[cash.size()+1];
		Arrays.fill(combinationScheme, 0);
	}
	
	public boolean getCombination(Integer goal) {
		if(goal >= 0) {
			
			// 对于大于0 的输入，依次判断最大面值的个数
			for(int i = faceAcount.length-1 ; i >= 0 ; i--) {
				
				Integer acount = (Integer) faceAcount[i];
				if(goal.compareTo(acount) == 0) {
					
					combinationScheme[i] = 1;
					return true;
					
				}else if(goal.compareTo(acount) > 0) {
					if(goal / acount == 1) {
						goal -= acount;
						combinationScheme[i] = 1;
					}else {
						Integer temp = Math.min(goal / acount, cash.get(acount));
						combinationScheme[i] = temp;
						goal -= acount * temp;
					}
				}
			}
			// 0 可以有组合，且组合为全部 0
			// 组合的最后位置存放差值
			combinationScheme[combinationScheme.length-1] = goal;
			if(goal == 0)
				return true;
			else
				return false;
		}else {
			Arrays.fill(combinationScheme, -1);
			return false;
		}
		
	}
}
