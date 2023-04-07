package GuoSai2021;

import java.io.*;
import java.nio.Buffer;

public class E大写 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(reader.readLine().toUpperCase());
        writer.flush();
    }
}
