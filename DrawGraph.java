import java.io.*;
import java.util.*;

public class DrawGraph {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String s = "";
        if (sc.hasNextLine()) {
            s = sc.nextLine().trim();
        }

        if (s.isEmpty()) {
            return;
        }

        String[] vertices = s.split("\\s+");
        int n = vertices.length;

        PrintWriter out = new PrintWriter("graph.dot");

        out.println("digraph G {");
        out.println("  node [shape=circle];");

        for (int i = 0; i < n; i++) {
            int left = (2 * i + 1) % n;
            int right = (2 * i + 2) % n;

            out.println("  \"" + vertices[i] + "\" -> \"" + vertices[left] + "\";");
            out.println("  \"" + vertices[i] + "\" -> \"" + vertices[right] + "\";");
        }

        out.println("}");
        out.close();

        ProcessBuilder pb = new ProcessBuilder(
                "C:\\Program Files\\Graphviz\\bin\\dot.exe",
                "-Tpng",
                "graph.dot",
                "-o",
                "graph.png"
        );

        pb.inheritIO();
        Process p = pb.start();
        p.waitFor();

        System.out.println("Created graph.png");
    }
}