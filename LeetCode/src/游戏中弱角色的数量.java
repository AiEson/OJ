import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 游戏中弱角色的数量 {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfWeakCharacters(new int[][]{{7,7},{1,2},{9,7},{7,3},{3,10},{9,8},{8,10},{4,3},{1,5},{1,5}}));
    }
    static class Solution {
        public int numberOfWeakCharacters(int[][] properties) {
            Arrays.sort(properties,(o1,o2)->o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0]);
            int cnt=0;
            int max=-1;
            int n=properties.length;
            for(int i=0;i<n;i++){
                if(max>properties[i][1]){
                    cnt++;
                }
                max=Math.max(max,properties[i][1]);

            }
            return cnt;
        }
    }
}
