import java.util.*;

public class 德州扑克 {
    static Map<Character, Integer> colorMap = new HashMap<>(4), valueMap = new HashMap<>();
    public static void main(String[] args) {
        initMap();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("S0"));
        cards.add(new Card("S4"));
        cards.add(new Card("C0"));
        cards.add(new Card("D3"));
        cards.add(new Card("S3"));
        cards.add(new Card("SA"));
        cards.add(new Card("SJ"));
        System.out.println("同花顺：" + isSameColorFlush(cards));
        System.out.println("顺子：" + isFlush(cards));
        System.out.println("皇家同花顺：" + isRoyarFlush(cards));
        System.out.println("四条：" + fourKind(cards));
        System.out.println("三带一对：" + fullHouse(cards));
        System.out.println("同花：" + isSameColor(cards));
        System.out.println("两对：" + twoPairs(cards));
        System.out.println(Integer.MAX_VALUE);
    }
    private static void initMap() {
        char[] chs = new char[]{'2', '3','4','5','6','7','8','9','0','J','Q','K','A'};
        for (int i = 0; i < chs.length; i++) {
            valueMap.put(chs[i], i + 1);
        }
        colorMap.put('S', 1);
        colorMap.put('H', 2);
        colorMap.put('C', 3);
        colorMap.put('D', 4);
    }
    // 同花
    private static boolean isSameColor(List<Card> cards) {
        Map<Integer, Integer> map = getColorCountMap(cards);
        for (Integer integer : map.keySet()) {
            if (map.get(integer) >= 5) return true;
        }
        return false;
    }
    // 通过数量查找元素的Value
    private static int getCntByCount(List<Card> cards, int cnts) {
        Map<Integer, Integer> map = getValueCountMap(cards);
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == cnts) return integer;
        }
        return -1;
    }
    private static Map<Integer, Integer> getValueCountMap(List<Card> cards) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Card card : cards) {
            int n = map.getOrDefault(card.getValue(), 0);
            map.put(card.getValue(), n+1);
        }
        return map;
    }
    private static Map<Integer, Integer> getColorCountMap(List<Card> cards) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Card card : cards) {
            int n = map.getOrDefault(card.getColor(), 0);
            map.put(card.getColor(), n+1);
        }
        return map;
    }
    // 三同。
    private static boolean threeKind(List<Card> cards) {
        int value = getCntByCount(cards, 3);
        if (value == -1) return false;
        return true;
    }
    // 两对
    private static boolean twoPairs(List<Card> cards) {
        Map<Integer, Integer> map = getValueCountMap(cards);
        int cnt = 0;
        for (Integer integer : map.keySet()) {
            if (map.get(integer) >= 2) ++cnt;
        }
        return cnt >= 2;
    }
    private static boolean pairs(List<Card> cards) {
        Map<Integer, Integer> map = getValueCountMap(cards);
        int cnt = 0;
        for (Integer integer : map.keySet()) {
            if (map.get(integer) >= 2) ++cnt;
        }
        return cnt >= 1;
    }
    // 三带一对
    private static boolean fullHouse(List<Card> cards) {
        int value = getCntByCount(cards, 3);
        if (value == -1) return false;
        Map<Integer, Integer> map = getValueCountMap(cards);
        for (Integer integer : map.keySet()) {
            if (map.get(integer) != value && map.get(integer) >= 2) return true;
        }
        return false;
    }

    // 四个相同
    private static boolean fourKind(List<Card> cards) {
        cards.sort(Comparator.comparingInt(Card::getValue));
        for (int i = 0; i < cards.size() - 3; i++) {
            if (cards.get(i).getValue() == cards.get(i + 3).getValue()) return true;
        }
        return false;
    }

    private static int getFlushScore(List<Card> cards) {
        int score = 0;
        List<Card> cardFlushList = new ArrayList<>(5);
        // Royal
        List<Integer> ret = new ArrayList<>();
        cards.sort(Comparator.comparingInt(Card::getValue));
        for (Card card : cards) {
            ret.add(card.getValue());
        }
        l1: for (int j = 0; j < 2; j++) {
            int min =  cards.get(j).getValue();
            for (int i = 0; i < 5; i++) {
                if (!ret.contains(i + min)){
                    System.out.println("查找失败，没有顺子！");
//                    return false;
                    continue l1;
                }
                
            }
        }
        return 1;
    }
    // 顺子
    private static boolean isFlush(List<Card> cards) {
        List<Integer> ret = new ArrayList<>();
        cards.sort(Comparator.comparingInt(Card::getValue));
        for (Card card : cards) {
            ret.add(card.getValue());
        }
        l1: for (int j = 0; j < 2; j++) {
            int min =  cards.get(j).getValue();
            for (int i = 0; i < 5; i++) {
                if (!ret.contains(i + min)){
                    System.out.println("查找失败，没有顺子！");
//                    return false;
                    continue l1;
                }
                return true;
            }
        }
        return false;
    }
    private static boolean isSameColorFlush(List<Card> cards) {
        if (!isFlush(cards)) return false;
        // 统计最多的花色
        int mostColor = getMostColor(cards);
//        System.out.println("最多花色为：" + mostColor);
        cards.sort(Comparator.comparingInt(Card::getColor));
        showCards(cards);
        int colorIdx = -1;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getColor() == mostColor) {
                colorIdx = i;
                break;
            }
        }
        for (int i = colorIdx; i < (5) + colorIdx; i++) {
            if (!(mostColor == cards.get(i).getColor())) return false;
        }
        return true;
    }
    private static boolean isRoyarFlush(List<Card> cards) {
        if (!isSameColorFlush(cards)) return false;
        System.out.println(cards.get(0).getValue());
        return cards.get(0).getValue() == valueMap.get('0');
    }
    private static void showCards(List<Card> cards) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Card card : cards) {
            stringBuffer.append(card.getColor() + "+" + card.getValue() + " ");
        }
        System.out.println(stringBuffer);
    }
    private static int getMostColor(List<Card> cards) {
        int[] colors = new int[4];
        int max = -1, idx = 0;
        for (Card card : cards)
            ++colors[card.getColor() - 1];
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] > max) {
                 idx = i;
                 max = colors[i];
            }
        }
        return idx + 1;
    }
    static class Card{
        int color, value;
        Card(String in) {
            char[] tmp = in.toCharArray();
            this.color = colorMap.get(tmp[0]);
            this.value = valueMap.get(tmp[1]);
        }

        public int getColor() {
            return color;
        }

        public int getValue() {
            return value;
        }
    }

}
