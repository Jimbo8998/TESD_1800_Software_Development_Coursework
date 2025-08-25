import java.io.*;
import java.nio.file.*;
import java.util.concurrent.ThreadLocalRandom;

public class Exercise17_01 {

    public static void main(String[] args) {
        Path path = Paths.get("Exercise17_01.txt");
        boolean append = Files.exists(path);

        try (PrintWriter out = new PrintWriter(new FileWriter(path.toFile(), true))) {

            // If the file already has content, start on a new line before appending
            if (append && Files.size(path) > 0) {
                out.println();
                }
                for (int i = 0; i < 100; i++) {
                    if (i > 0) out.print(" ");
                    out.print(ThreadLocalRandom.current().nextInt(0, 1000)); // 0-999
                }
                System.out.println("Wrote 100 integerss to " + path.toAbsolutePath());
            } catch (IOException e) {
                System.err.println( "I/O error: " + e.getMessage());
            }
        }
    }
