import java.util.*;

class Researcher {
    int arrive;
    int leave;

    Researcher(int arrive, int stay) {
        this.arrive = arrive;
        this.leave = arrive + stay;
    }
}

public class workstations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Researcher> researchers = new PriorityQueue<>(Comparator.comparingInt(o -> o.arrive));
        for (int i = 0; i < n; i++) {
            researchers.add(new Researcher(sc.nextInt(), sc.nextInt()));
        }
        PriorityQueue<Integer> locks = new PriorityQueue<>();
        int unlockings = 0;

        while (!researchers.isEmpty()) {
            Researcher researcher = researchers.poll();
            // Check if the workstation is locked due to inactivity
            while (!locks.isEmpty() && locks.peek() + m < researcher.arrive) {
                locks.poll();
            }
            if (!locks.isEmpty() && locks.peek() <= researcher.arrive && researcher.arrive <= locks.peek() + m) {
                // Reuse an unlocked workstation
                locks.poll();
                unlockings++;
            }
            locks.add(researcher.leave);
        }
        System.out.println(unlockings);
    }
}
