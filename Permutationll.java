package leetcodequestion;

import java.util.*;

public class Permutationll {
	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        DFS(new ArrayList<Integer>(), 0, nums);
        return ans;
    }
    
    void DFS(List<Integer> tmp, int k, int[] nums){
        if (k == nums.length){
            ans.add(tmp);
            return;
        }
        
        for (int i = 0; i < k+1; i++){
            List<Integer> newTmp = new ArrayList<Integer>(tmp);
            if (i == 0 || i >= 1 && nums[k] != tmp.get(i-1)){
                newTmp.add(i, nums[k]);
                DFS(newTmp, k+1, nums);
            }
            else{
                return;
            }
        }
    }
    
}
