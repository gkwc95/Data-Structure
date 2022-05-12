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
                sum += nums[j];
        }
        return sum;
    }
}

/* Explanation
n=1		n=2			n=3			Deriving n=3 from n=2 and n=1
a e i o u	aa ee ii oo uu		aaa eee iii ooo uuu	5: 5+4+3+2+1 = 15
1 1 1 1 1	ae ei io ou		aae eei iio oou 	4: 15-5 = 10
		ai eo iu		aai eeo iiu ouu		3: 10-4 = 6
		ao eu			aao eeu ioo		4: 6-3 = 3
		au			aau eii iou		1: 3-2 = 1
		5  4  3  2  1		aee eio iuu		sum = 15+10+6+3+1 = 35
					aei eiu
					aeo eoo
					aeu eou
					aii euu
					aio
					aiu
					aoo
					aou
					auu
					15   10   6   3   1  
*/	
