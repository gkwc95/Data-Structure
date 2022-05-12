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
/*
	Example {1,1,2}
	i = 0; we get the first number: 1 and add it in to every position of the remaining number: output: 1 1 2, 1 1 2, 1 2 1
	Iterate through the array by doing the same process and we will get all the permutations.
	
	To remove duplicate, we will check if the number added to that position is equal to the number at position - 1.
	If it is true we will stop the process.
	
	For example, we get k = 0, and the remainding numbers in the array is 1 2. We will call the remainder number array, int[] tmp = []{1, 2}
	i = 0 We add num[k] to the zero position and we get 1 1 2.
	i = 1 We check num[k] == tmp [i-1], its true does we stop there.
	
	https://www.youtube.com/watch?v=K6vqgAEyfng&ab_channel=HuifengGuan <= in chinese
*/
}
