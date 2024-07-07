import java.util.*;

public class CardsInIncreasingOrder {
    public static int[] revealCards(int[] deck) {
        Arrays.sort(deck);
        int[] array = new int[deck.length];
        Queue<Integer> indexes = new LinkedList<>();

        for (int i = 0; i < deck.length; i++) {
            indexes.add(i);
        }

        for (int card : deck) {
            array[indexes.poll()] = card;
            if (!indexes.isEmpty()) {
                indexes.add(indexes.poll());
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] deck1 = {17, 13, 11, 2, 3, 5, 7};
        int[] result1 = revealCards(deck1);
        System.out.println(Arrays.toString(result1));

        int[] deck2 = {1, 1000};
        int[] result2 = revealCards(deck2);
        System.out.println(Arrays.toString(result2));
    }
}
