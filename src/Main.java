import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int[] denoms = {2, 3, 5, 6};
        int amount = 10;

        coinChangeTabCombi(denoms, amount);
    }

    private static void coinChangeTabCombi(int[] denominations, int amt) {
        int[] storage = new int[amt + 1];
        ArrayList<String>[] paths = new ArrayList[amt + 1];

        for (int i = 0; i < paths.length; i++) {
            paths[i] = new ArrayList<>();
        }

        storage[0] = 1;
        paths[0].add("");

        for (int i = 0; i < denominations.length; i++) {
            for (int j = denominations[i]; j <= amt; j++) {
                storage[j] = storage[j] + storage[j - denominations[i]];
                for (String rstr : paths[j - denominations[i]]) {
                    String newStr = rstr + " " + denominations[i];
                    paths[j].add(newStr);
                }
            }
        }

        System.out.println("Ways of paying (using only combinations) rupees " + amt + " are: " + storage[amt]);
        System.out.println("Path is given by: " + paths[amt]);
    }


}
