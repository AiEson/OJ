public class 跳跃游戏IV {
    public static void main(String[] args) {

    }

    static class Solution {
        public int minJumps(int[] arr) {
            int cnt = 0;
            int len = arr.length;
            if (len == 1) return 0;
            if (len == 2) return 1;
            int nowPoi = 0, tarPoi = -1;
            l1: while (nowPoi != len - 1) {
                int nowNum = arr[nowPoi];
                for (int i = len - 1; i > nowPoi; i--) {
                    if (nowNum == arr[i]) {
                        //跳转！
                        nowPoi = i;
                        continue l1;
                    }
                }
                //没有相同的，
            }


            return -1;
        }
    }
}
