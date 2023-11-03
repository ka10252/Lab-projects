import java.util.*;

import javax.smartcardio.Card;

import java.io.*;

public class cardgame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // store first line info in N, T, K
        String str1 = br.readLine();
        String[] strarr1 = str1.split(" ");
        int N = Integer.parseInt(strarr1[0]);
        int T = Integer.parseInt(strarr1[1]);
        int K = Integer.parseInt(strarr1[2]);

        // store Anthony's cards in second line to array cards
        String str2 = br.readLine();
        String[] strarr2 = str2.split(" ");
        int[] cardlist = new int[1000001];
        for (String card : strarr2) {
            int cardtype = Integer.parseInt(card);
            cardlist[cardtype]++;
        }

        // store pricelist of T different card types
        ArrayList<Card> pricelist = new ArrayList<Card>();
        for (int j = 1; j < T + 1; j++) {
            String str3 = br.readLine();
            String[] strarr3 = str3.split(" ");
            int cardtype = j;
            long buy = (2 - cardlist[cardtype]) * Long.parseLong(strarr3[0]);
            long sell = cardlist[cardtype] * Long.parseLong(strarr3[1]);
            pricelist.add(new Card(buy, sell, cardtype));
        }

        Collections.sort(pricelist, new cardComparator());

        // calculate net profit
        long netprofit = 0;

        for (int m = 0; m < K; m++) {
            Card nextCard = pricelist.get(m);
            netprofit -= nextCard.getBuy();
        }

        for (int n = K; n < T; n++) {
            Card nextCard = pricelist.get(n);
            netprofit += nextCard.getSell();
        }

        System.out.println(netprofit);
    }

    public class cardComparator implements Comparator<Card> {

        public int compare(Card c1, Card c2) {
            long c1Value = c1.getBuy() + c1.getSell();
            long c2Value = c2.getBuy() + c2.getSell();
            if (c1Value < c2Value) {
                return -1;
            } else if (c1Value > c2Value) {
                return 1;
            } else {
                if (c1.getBuy() < c2.getBuy()) {
                    return -1;
                } else if (c1.getBuy() > c2.getBuy()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}
