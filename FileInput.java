import java.io.*;

public class FileInput {
    public static void main(String[] args) {
        String filePath = "readme.txt";

        System.out.println("File Size    FileReader Time (ms)    InputStreamReader Time (ms)");

        for (int sizeMB : new int[]{1, 100, 500}) {
            generateLargeFile(filePath, sizeMB * 1024 * 1024);


            long startTime = System.nanoTime();
            try (FileReader fr = new FileReader(filePath)) {
                while (fr.read() != -1) {}
            } catch (IOException e) {
                e.printStackTrace();
            }
            long fileReaderTime = (System.nanoTime() - startTime) / 1_000_000;


            startTime = System.nanoTime();
            try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
                while (isr.read() != -1) {}
            } catch (IOException e) {
                e.printStackTrace();
            }
            long inputStreamReaderTime = (System.nanoTime() - startTime) / 1_000_000;


            System.out.println(sizeMB + "MB         " + fileReaderTime + " ms           " + inputStreamReaderTime + " ms");
        }
    }


    private static void generateLargeFile(String filePath, int size) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < size; i++) {
                writer.write("A");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}