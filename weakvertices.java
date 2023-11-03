import java.util.*;

public class weakvertices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == -1) {
                break;
            }
            sc.nextLine();

            HashMap<Integer, List<Integer>> edges = new HashMap<>();

            for (int i = 0; i < n; i++) {
                List<Integer> neighbors = new ArrayList<>();
                String[] matrix = sc.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    if (matrix[j].equals("1")) {
                        neighbors.add(j);
                    }
                }
                edges.put(i, neighbors);
            }

            List<Integer> weaks = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (isWeak(i, edges)) {
                    weaks.add(i);
                }
            }

            for (int i = 0; i < weaks.size(); i++) {
                System.out.print(weaks.get(i));
                if (i < weaks.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        sc.close();
    }

    public static boolean isWeak(int x, HashMap<Integer, List<Integer>> edges) {
        List<Integer> neighbors = edges.get(x);

        for (int i : neighbors) {
            if (i != x) {
                for (int j : edges.get(i)) {
                    if (j != i && j != x && edges.get(j).contains(x)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
