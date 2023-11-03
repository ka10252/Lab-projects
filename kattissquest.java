import java.util.*;
import java.io.*;

public class kattissquest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(br.readLine());
        TreeMap<Long, PriorityQueue<Long>> quests = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String[] commands = br.readLine().split(" ");
            String command = commands[0];
            if (command.equals("add")) {
                long energy = Long.parseLong(commands[1]);
                long gold = Long.parseLong(commands[2]);
                quests.computeIfAbsent(energy, k -> new PriorityQueue<Long>(Collections.reverseOrder())).add(gold);
            } else if (command.equals("query")) {
                long X = Long.parseLong(commands[1]);
                long totalGold = 0;
                while (!quests.isEmpty() && X >= quests.firstKey() && X >= 0) {
                    Long consumeE = quests.floorKey(X);
                    PriorityQueue<Long> consumeG = quests.get(consumeE);
                    totalGold += consumeG.poll();
                    if (consumeG.isEmpty()) {
                        quests.remove(consumeE);
                    }
                    X -= consumeE;
                }
                pw.write(totalGold + "\n");
            }
        }
        pw.close();
    }
}
