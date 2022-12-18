package lab4;

public class example3 {
    public static void main(String[] args) {
        int [][] mass = {
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2}
        };

        for (int[] ints : mass) {
            for (int j = 0; j < 5; j++)
                System.out.print(ints[j]);
            System.out.println();
        }

    }
}
