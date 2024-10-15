import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Node[][] nudes = new Node[0][0];

        short[][] mapaTmp = new short[0][0];

        File map = new File("map.txt");

        try {
            Scanner sc = new Scanner(map);
            int lineNumber = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (nudes.length < 1) {
                    nudes = new Node[line.length()][line.length()];
                }

                for (int i = 0; i < line.length(); i++) {

                    short znak = (short) line.charAt(i);
                    Node node;

                    if (znak == (short) '1') {
                        node = new Node(1);
                    } else if (znak == (short) '0') {
                        node = new Node(0);
                    } else if (znak == (short) 'S') {
                        node = new Node(2);
                    } else if (znak == (short) 'E') {
                        node = new Node(3);
                    } else {
                        throw new RuntimeException("Wrong map");
                    }

                    nudes[lineNumber][i] = node;

                }
                lineNumber++;
            }

            for (int x = 0; x < nudes.length; x++) {
                for (int y = 0; y < nudes[x].length ; y++) {
                    nudes[x][y].setNeighbours(nudes, x, y);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
