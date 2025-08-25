import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Programming17_03 {
    private static final String FILE_NAME = "Exercise17_03.dat";

    public static void main(String[] args){
        try {
            //1) Append 100 random integers to the binary file (creat if missing)
            writeRandomInts(FILE_NAME, 100);

            //2) Read all integers from the file and print their sum
            long sum = sumAllInts(FILE_NAME);
            System.out.println("Sum of all integers in " + FILE_NAME + "=" + sum);
        } catch (IOException ex) {
            System.err.println("I/O error: " + ex.getMessage());
        }
    }
    /** Appends 'count' random integers (0-999) to FILE_NAME using DataOutputStream.*/
    public static void writeRandomInts(String fileName, int count) throws IOException {
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName, true)))) {
            ThreadLocalRandom rng = ThreadLocalRandom.current();
            for (int i = 0; i < count; i++) {
                out.writeInt(rng.nextInt(1000)); // 0 ..999
            }
            out.flush();
        }
    }
    /** reads all ints from FILE_NAME using DataInputStream and returns their sum.*/
    public static long sumAllInts(String fileName) throws IOException {
        long sum = 0L;
        int readCount = 0;
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            while (true) {
                int value = in.readInt(); // throws EOFException at end
                sum += value;
                readCount++;
            }
        } catch (EOFException eof) {
            System.out.println("Read" + readCount + "integers from" + fileName + ".");
        }
        return sum;
    }
}
