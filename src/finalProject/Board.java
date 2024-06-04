package finalProject;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private Tile[][] tiles;

    public Board() {
        tiles = new Tile[4][4];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j] = new Tile();
                

                }
            }
        }
    

    public Tile[] getRow(int rowIndex) {
        return tiles[rowIndex];
    }

    public void setRow(int rowIndex, Tile[] row) {
        tiles[rowIndex] = row;
    }

    public Tile[] getColumn(int columnIndex) {
        Tile[] column = new Tile[4];
        for (int i = 0; i < 4; i++) {
            column[i] = tiles[i][columnIndex];
        }
        return column;
    }

    public void setColumn(int columnIndex, Tile[] column) {
        for (int i = 0; i < 4; i++) {
            tiles[i][columnIndex] = column[i];
        }    
    }

    public Tile getTileAt(int x, int y) {
        return tiles[x][y];
    }

    public List<Tile> getAvailableSpace() {
        final List<Tile> list = new ArrayList<Tile>(16);
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                if (tile.isEmpty()) {
                    list.add(tile);
                }
            }
        }
        return list;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

}
