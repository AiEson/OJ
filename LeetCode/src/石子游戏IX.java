public class 石子游戏IX {
    public static void main(String[] args) {
        int[] aaa = {5,1,2,4,3};
        System.out.println(new Solution().stoneGameIX(aaa));
    }

    static class Solution {
        public boolean stoneGameIX(int[] stones) {
            if (stones.length == 1) {
                return false;
            }
            int c0, c1, c2;
            c0 = c1 = c2 = 0;
            for (int stone : stones) {
                switch (stone % 3) {
                    case 0:
                        ++c0;
                        break;
                    case 1:
                        ++c1;
                        break;
                    case 2:
                        ++c2;
                }
            }
            c0 %= 2;
            long score = 0L;
            final long endScore = c1 + c2 * 2L;

            int cnt = c0 % 2;
            if (endScore == 0 && cnt == 0) return false;
            boolean flag = true;
            l1: while(true) {
                if (score == endScore) break;
                switch ((int) (score % 3)) {
                    case 0:
                        if (flag) {
                            //之前没有选择过
                            flag = false;
                            ++cnt;
                            if (c1>0 && c2 > 0) {
                            if (c1 > c2) {
                                score += 2;
                                --c2;
                            } else {
                                ++score;
                                --c1;
                            }
                        } else if (c1 == 0) {
                            score += 2;
                            --c2;
                        } else{
                            ++score;
                            --c1;
                        }
                            continue l1;
                        } else
                            break l1;
                    case 1:
                        //不能选2，只能选1
                        if (c2 > 0) {
                            ++score;
                            --c1;
                        } else {
                            //G! 输了！
                            if (c0 % 2 == 1) {
                                ++cnt;
                                --c0;
                                continue l1;
                            }
                            break l1;
                        }
                        break;
                    case 2:
                        //只能选2
                        if (c2 > 0) {
                            score += 2;
                            --c2;
                        }
                        else {
                            //G! 输了！
                            if (c0 % 2 == 1) {
                                ++cnt;
                                --c0;
                                continue l1;
                            }

                            break l1;
                        }
                        break;
                }
                ++cnt;
            }
            return (cnt) % 2 == 0;
        }
    }
}
