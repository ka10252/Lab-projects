import java.util.*;

public class peasoup {
    public static void main(String[] args) {
        // read the input information from test file
        Scanner sc = new Scanner(System.in);
        // the first given number is the number of restaurants
        int numOfRestaurants = sc.nextInt();
        sc.nextLine();

        // default set for each restaurant is that they don't have
        // both pea soup & pancakes
        // can change into true afterwards if both of them are
        // included in menu
        boolean both = false;

        // repeat loop as many as number of the restaurants
        for (int i = 0; i < numOfRestaurants; i++) {
            int numOfMenu = sc.nextInt();
            sc.nextLine();
            String restaurantName = sc.nextLine();

            boolean hasPeasoup = false;
            boolean hasPancakes = false;

            for (int j = 0; j < numOfMenu; j++) {
                String menu = sc.nextLine();
                if (menu.equals("pea soup")) {
                    hasPeasoup = true;
                }
                if (menu.equals("pancakes")) {
                    hasPancakes = true;
                }
            }

            if (hasPeasoup && hasPancakes) {
                System.out.print(restaurantName);
                both = true;
                break;
            }
        }

        if (!both) {
            System.out.print("Anywhere is fine I guess");
        }
    }
}
