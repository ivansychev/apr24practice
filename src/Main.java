import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by ivans on 24/04/2017.
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Files.lines(Paths.get("rec/in1.txt"))
                            .map(line -> line.split(" "))
                            .flatMap(Arrays::stream)
                            .mapToInt(Integer::parseInt)
                            .filter(x -> x > 0 && x%2==0)
                            .forEach(System.out::println);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
