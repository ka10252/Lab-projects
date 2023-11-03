import java.util.*;

public class bestrelayteam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numPlayers = sc.nextInt();
        sc.nextLine();

        // generate list of runners
        Runner[] runners = new Runner[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            String name = sc.next();
            double time1 = sc.nextDouble();
            double time2 = sc.nextDouble();
            runners[i] = new Runner(name, time1, time2);
        }

        Arrays.sort(runners);

        ArrayList<Runner> finalteam = new ArrayList<Runner>();
        double finaltime = 1000;

        for (int j = 0; j < numPlayers; j++) {
            // store temporary record in temptime and tempteam
            ArrayList<Runner> tempteam = new ArrayList<Runner>();
            double temptime = 0;
            // add first runner to the arraylist
            tempteam.add(runners[j]);
            temptime = temptime + runners[j].getTime1();
            // sorting runners by time taken as leg 2,3,4
            Runner[] runners234 = new Runner[numPlayers - 1];
            System.arraycopy(runners, 0, runners234, 0, j);
            System.arraycopy(runners, j + 1, runners234, j, numPlayers - j - 1);
            Arrays.sort(runners234, Comparator.comparingDouble(Runner::getTime2));
            tempteam.addAll(Arrays.asList(runners234[0], runners234[1], runners234[2]));
            temptime = temptime + runners234[0].getTime2() + runners234[1].getTime2() + runners234[2].getTime2();
            if (temptime < finaltime) {
                finaltime = temptime;
                finalteam = new ArrayList<Runner>(tempteam);
            }

        }

        System.out.printf("%.2f\n", finaltime);
        for (int l = 0; l < finalteam.size(); l++) {
            System.out.println(finalteam.get(l).getName());
        }

    }
}
