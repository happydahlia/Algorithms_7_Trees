import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EveryPath {
    public static void cycle4(int[][] graph) {
       int n = graph.length;
        Set<String> printedCycles = new HashSet<>();
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                for (int c = 0; c < n; c++) {
                    for (int d = 0; d < n; d++) {
                        if (a != b && a != c && a != d &&
                                b != c && b != d &&
                                c != d &&
                                graph[a][b] != 0 &&
                                graph[b][c] !=0 &&
                                graph[c][d] !=0 &&
                                graph[d][a] !=0){
                            Integer[] cycle = {a, b, c, d};
                            Arrays.sort(cycle);
                            String key = Arrays.toString(cycle);
                            if (printedCycles.contains(key)) {
                                continue;
                            }
                            System.out.println(a + " -> " + b + " -> " + c + " -> " + d + " -> " + a);
                            printedCycles.add(key);
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0}
        };
        EveryPath daniel = new EveryPath();
        daniel.cycle4(graph);
    }

}
