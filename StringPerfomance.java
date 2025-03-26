public class StringPerfomance {
    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 1_000_000}; // Different dataset sizes

        System.out.println("Operations Count    String (ms)    StringBuilder (ms)    StringBuffer (ms)");

        for (int N : sizes) {

            long startTime = System.nanoTime();
            String str = "";
            for (int i = 0; i < N; i++) {
                str += "a";
            }
            long stringTime = (System.nanoTime() - startTime) / 1_000_000;


            startTime = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append("a");
            }
            long stringBuilderTime = (System.nanoTime() - startTime) / 1_000_000;


            startTime = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < N; i++) {
                sbf.append("a");
            }
            long stringBufferTime = (System.nanoTime() - startTime) / 1_000_000;


            System.out.println(N + "                  " +
                    (stringTime > 1_800_000 ? "Unusable (>30 min)" : stringTime + " ms") + "       " +
                    stringBuilderTime + " ms             " +
                    stringBufferTime + " ms");
        }
    }
}