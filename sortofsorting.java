import java.util.*;

public class sortofsorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int num = sc.nextInt();
            sc.nextLine();

            if (num == 0) {
                break;
            }

            String[] names = new String[num];

            for (int j = 0; j < num; j++) {
                names[j] = sc.nextLine();
            }

            Arrays.sort(names, new nameComparator());

            for (String name : names) {
                System.out.println(name);
            }

            System.out.println();
        }
        sc.close();
    }
}
