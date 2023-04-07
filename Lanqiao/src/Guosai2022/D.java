package Guosai2022;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] desktop = gene(N, M);
//        showT(desktop);
//        System.out.println();
//        Windows w1 = new Windows(4, 1, 1, 3, 5);
//        w1.move(-1, 1);
//        showT(w1.draw(desktop));

        Map<Integer, Windows> map = new HashMap<>();
        int max = 0;
        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            String cz = sc.next();
            if (cz.equals("new")) {
                int pid = sc.nextInt();
                int n = sc.nextInt(); int m = sc.nextInt();
                int hi = sc.nextInt(); int wi = sc.nextInt();
                map.put(pid, new Windows(++max, n, m, hi, wi));
            } else if(cz.equals("resize")) {
                int pid = sc.nextInt();
                int n = sc.nextInt();
                int m = sc.nextInt();
                map.get(pid).resize(n, m);
            } else if(cz.equals("move")) {
                int pid = sc.nextInt();
                int n = sc.nextInt();
                int m = sc.nextInt();
                map.get(pid).move(n, m);
            } else if(cz.equals("close")) {
                int pid = sc.nextInt();
                map.get(pid).setClose(true);
            } else {
                int pid = sc.nextInt();
                map.get(pid).setClose(false);
                map.get(pid).setLevel(++max);
            }
        }
        Windows[] windows = new Windows[map.size()];
        int idx = 0;
        for (Integer integer : map.keySet()) {
            windows[idx++] = map.get(integer);
        }
        Arrays.sort(windows, new Comparator<Windows>() {
            @Override
            public int compare(Windows o1, Windows o2) {
                return o1.getLevel() - o2.getLevel();
            }
        });
        for (Windows window : windows) {
            desktop = window.draw(desktop, N + 1, M + 1);
        }
        showT(desktop);

    }
    public static void showT(char[][] t) {
        for (int i = 1; i < t.length; i++) {
            char[] chars = t[i];
            for (int i1 = 1; i1 < chars.length; i1++) {
                System.out.print(chars[i1]);
            }
            System.out.println();
        }
    }
    static class Windows{
        int pid;
        int n; int m;
        int hi; int wi;
        boolean closed = false;

        public Windows(int pid, int n, int m, int hi, int wi) {
            this.pid = pid;
            this.n = n + 1;
            this.m = m + 1;
            this.hi = hi;
            this.wi = wi;
        }
        public void resize(int hi, int wi) {
            this.hi = hi;
            this.wi = wi;
        }
        public void move(int n, int m) {
            this.n += n;
            this.m += m;
        }

        public void setClose(boolean i) {
            this.closed = i;
        }

        public char[][] draw(char[][] t, int N, int M) {
            if (closed) return t;
            int rig = m - 1 + wi , bot = n - 1 + hi;
            boolean nd0 = n > 0;
            boolean md0 = m > 0;
            boolean rxn = rig <= M;
            boolean bxm = bot <= N;
            if (nd0 && md0)
                t[n][m] = '+';
            if (nd0 && rxn)
                t[n][rig] = '+';
            if (bxm && md0)
                t[bot][m] = '+';
            if (bxm && rxn)
                t[bot][rig] = '+';
            for(int i = m + 1; i < Math.min(rig, M); i++) {
                if (nd0)
                    t[n][i] = '-';
                if (bxm)
                    t[bot][i] = '-';
            }
            for (int i = n + 1; i < Math.min(bot, N); i++) {
                if (md0)
                    t[i][m] = '|';
                if (rxn)
                    t[i][rig] = '|';
            }
            for (int x = m + 1; x < Math.min(rig, M); x++) {
                for (int y = n + 1; y < Math.min(bot, N); y++){
                    if (x > 0 && y > 0)
                        t[y][x] = ' ';
                }
            }
            return t;
        }
        public void setLevel(int l) {
            this.pid = l;
        }

        public int getLevel() {
            return pid;
        }
    }
    public static char[][] gene(int N, int M) {
        char[][] t = new char[N + 1][M + 1];
        for (int i = 1; i < (N + 1); i++) {
            for (int i1 = 1; i1 < (M + 1); i1++) {
                t[i][i1] = '.';
            }
        }
        return t;
    }

}
