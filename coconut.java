import java.util.*;

public class coconut {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        int syllable = Integer.parseInt(input[0]);
        int numplayers = Integer.parseInt(input[1]);

        // four status
        // "s1" = hand folded
        // "s2" = fist
        // "s3" = palm down
        // "s4" = behind back

        Queue<Player> players = new LinkedList<>();
        for (int i = 1; i < numplayers + 1; i++) {
            players.add(new Player(i, "s1"));
            players.add(new Player(i, "s1"));
        }

        boolean split = false;

        // until one last player is remaining
        while (players.size() > 1) {
            for (int i = syllable; i > 1; i--) {
                Player player = players.peek();

                // no change for players who are not touched the last
                if (player.getStatus() == "s1") {
                    // skip two hands which is folded
                    players.add(players.remove());
                    players.add(players.remove());
                } else {
                    players.add(players.remove());
                }

                // part2 ("s1"->"s2") change status of the other hand to "s2"
                if (split) {
                    players.peek().setStatus("s2");
                    split = false;
                }

            }

            Player lastplayer = players.peek();
            if (lastplayer.getStatus() == "s1") {
                // part1 ("s1"->"s2") change status of one hand to "s2"
                lastplayer.setStatus("s2");
                split = true;
            } else if (lastplayer.getStatus() == "s2") {
                lastplayer.setStatus("s3");
                // next player begins counting
                players.add(players.remove());
            } else { // if getStatus == "s3"
                players.remove(); // setStatus = "s4", which is quit the game
            }
        }
        System.out.println(players.peek().getId());
    }
}