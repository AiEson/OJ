import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class Temp {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new TreeMap<>();
        map.put(1, 2);
        map.put(3, 2);
        map.put(2, 1);
        for (Integer integer : map.keySet()) {
            System.out.println(integer + " " + map.get(integer));
        }
    }


}
