import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int[] denoms = {2, 3, 5, 6};
        int amount = 10;

        coinChangeTabCombi(denoms, amount);
        coinChangeTabPerm(denoms, amount);
    }


    // the major difference in the two approaches is the way the effect of a denomination is applied over the storage array

    private static void coinChangeTabCombi(int[] denominations, int amt) {
        int[] storage = new int[amt + 1];
        ArrayList<String>[] paths = new ArrayList[amt + 1];

        for (int i = 0; i < paths.length; i++) {
            paths[i] = new ArrayList<>();
        }

        storage[0] = 1;
        paths[0].add("");

        // Here we apply the effect of each denomination to the whole storage array,
        // and only then start applying the effect of the next denomination
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


    private static void coinChangeTabPerm(int[] denominations, int amt) {
        int[] storage = new int[amt + 1];
        ArrayList<String>[] paths = new ArrayList[amt + 1];

        for (int i = 0; i < paths.length; i++) {
            paths[i] = new ArrayList<>();
        }

        storage[0] = 1;
        paths[0].add("");

        // Here we apply the effects of all the denominations on every element of the storage array,
        // and only then move on to the next element
        for (int j = 1; j <= amt; j++) {
            for (int i = 0; i < denominations.length; i++) {
                if (j >= denominations[i]) {
                    storage[j] = storage[j] + storage[j - denominations[i]];
                    for (String rstr : paths[j - denominations[i]]) {
                        String newStr = rstr + " " + denominations[i];
                        paths[j].add(newStr);
                    }
                    
                }
                
            }
            
        }

        System.out.println("Ways of paying (including permutations) rupees " + amt + " are: " + storage[amt]);
        System.out.println("Path is given by: " + paths[amt]);
    }

}
