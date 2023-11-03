import java.util.*;

public class conformity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> combinations = new HashMap<>();
        int maxcombi = 0;

        for (int i = 0; i < n; i++) {
            int[] courses = new int[5];
            for (int j = 0; j < 5; j++) {
                courses[j] = sc.nextInt();
            }
            Arrays.sort(courses);
            String combi = Arrays.toString(courses);
            combinations.put(combi, combinations.getOrDefault(combi, 0) + 1);
            maxcombi = Math.max(maxcombi, combinations.get(combi));
        }

        int sum = 0;
        for (int count : combinations.values()) {
            if (count == maxcombi) {
                sum += count;
            }
        }

        System.out.println(sum);
    }
}
