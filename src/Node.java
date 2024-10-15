public class Node {

    int value;
    Node up = null;
    Node down = null;
    Node left = null;
    Node right = null;

    public Node(int value) {this.value = value;}

    public void setNeighbours(Node[][] mapa, int x, int y) {
        for (Direction direction : Direction.values()) {
            switch (direction) {
                case UP:
                    if (checkPositionExists(mapa, x, y - 1)){
                        up = mapa[x][y - 1];
                    }
                    break;
                case DOWN:
                    if (checkPositionExists(mapa, x, y + 1)){
                        down = mapa[x][y + 1];
                    }
                    break;
                case LEFT:
                    if (checkPositionExists(mapa, x - 1, y)){
                        left = mapa[x - 1][y];
                    }
                    break;
                case RIGHT:
                    if (checkPositionExists(mapa, x + 1, y)){
                        right = mapa[x + 1][y];
                    }
                    break;
            }
        }
    }

    private boolean checkPositionExists(Node[][] mapa, int x, int y ) {
        return x >= 0 && y >= 0 && x <= mapa.length && y <= mapa[x].length;
    }

}
