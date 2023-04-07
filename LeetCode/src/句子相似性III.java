import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class 句子相似性III {
    public static void main(String[] args) {
        System.out.println(new Solution().areSentencesSimilar("A lot of", "A lot of words"));
    }
    static class Solution {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            String[] s1s = sentence1.split(" ");
            String[] s2s = sentence2.split(" ");
            Deque<String> s1 = new ArrayDeque<>(s1s.length);
            s1.addAll(List.of(s1s));
            Deque<String> s2 = new ArrayDeque<>(s2s.length);
            s2.addAll(List.of(s2s));


            while (s1.size() != 0 && s2.size() != 0) {
                if (s1.getFirst().equals(s2.getFirst())) {
                    s1.removeFirst();
                    s2.removeFirst();
                } else if (s1.getLast().equals(s2.getLast())) {
                    s1.removeLast();
                    s2.removeLast();
                }
                else break;
            }
            return s1.size() == 0 || s2.size() == 0;
        }
    }
}
