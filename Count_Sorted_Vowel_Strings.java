package leetcodequestion;
import java.util.Arrays;

public class Count_Sorted_Vowel_Strings {
	public int countVowelStrings(int n) {
        if (n == 1) return 5;
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int sum = 5;
        for (int i = 2; i <= n; i++){
            int[] tmp = new int[5];
            for (int j = 0; j < 5 ; j++){
                if (j == 0) tmp[0] = sum;
                else {
                    tmp[j] = tmp[j-1] - nums[j-1];
                }
            }
            nums = Arrays.copyOf(tmp, 5);
            sum = 0;
            for (int j = 0; j < 5; j++)
                sum+=nums[j];
        }
        return sum;
    }
}
