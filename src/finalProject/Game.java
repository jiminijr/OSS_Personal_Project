package finalProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class Game {
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public interface GameEventListener {
        void onGameOver();
        void onTileMerged();
    }

    private GameEventListener eventListener;

    public void setEventListener(GameEventListener listener) {
        this.eventListener = listener;
    }

    private boolean hasWon = false; // Variable to store whether the player has won
    private boolean hasLost = false; // Variable to store whether the player has lost
    public int score = 0; // Game score
    private String lastDirection = ""; // Variable to store the last direction moved
    private Board gameBoard; // Game board
    String player;

    public Game() {
        gameBoard = new Board(); // Create a new game board
        resetGame(); // Initialize the game
    }

    public boolean hasWon() {
        return hasWon;
    }

    public boolean hasLost() {
        return hasLost;
    }

    public void setWon(boolean won) {
        hasWon = won;
    }

    public void setLost(boolean lost) {
        hasLost = lost;
        if (lost && eventListener != null) {
            eventListener.onGameOver();
        }
    }

    public void resetGame() {
        score = 0;
        hasWon = false;
        hasLost = false;
        gameBoard = new Board();
        addTile();
        addTile();
    }

    private void addTile() {
        // Code for adding a tile to the game board

        // Find all empty spaces on the game board
        List<int[]> emptySpaces = new LinkedList<>();
        for (int i = 0; i < gameBoard.getTiles().length; i++) {
            for (int j = 0; j < gameBoard.getTiles()[0].length; j++) {
                if (gameBoard.getTiles()[i][j].isEmpty()) {
                    emptySpaces.add(new int[]{i, j});
                }
            }
        }

        // If there are empty spaces, randomly select one and place a tile (either 2 or 4) on that position
        if (emptySpaces.size() > 0) {
            int index = (int) (Math.random() * emptySpaces.size()) % emptySpaces.size();
            int[] emptyPosition = emptySpaces.get(index);
            gameBoard.getTiles()[emptyPosition[0]][emptyPosition[1]] = new Tile(Math.random() < 0.9 ? 2 : 4);
        }
    }

    public void move(Direction direction) {
        // Code for moving the tiles in the specified direction

        // Store the last direction moved
        lastDirection = direction.name().toLowerCase();
        boolean isReversed = (direction == Direction.DOWN || direction == Direction.RIGHT);
        boolean needAddTile = false;

        // Move and merge the tiles in each line
        for (int i = 0; i < 4; i++) {
            Tile[] line = null;
            switch (direction) {
                case UP:
                case DOWN:
                    line = gameBoard.getColumn(i);
                    break;
                case LEFT:
                case RIGHT:
                    line = gameBoard.getRow(i);
                    break;
            }

            // Reverse the line if necessary
            if (isReversed) {
                line = reverse(line);
            }

            // Move the tiles in the line
            Tile[] moved = moveLine(line);

            // Merge the tiles in the line
            Tile[] merged = mergeLine(moved);

            // Reverse the line back if necessary
            if (isReversed) {
                merged = reverse(merged);
            }

            // Update the game board with the moved and merged line
            switch (direction) {
                case UP:
                case DOWN:
                    gameBoard.setColumn(i, merged);
                    break;
                case LEFT:
                case RIGHT:
                    gameBoard.setRow(i, merged);
                    break;
            }

            // Check if a new tile needs to be added
            if (!needAddTile && !compare(line, merged)) {
                needAddTile = true;
            }
        }

        // Add a new tile if necessary
        if (needAddTile) {
            addTile();
        }

        // Check game state after the move
        checkGameState();
    }

    private Tile[] moveLine(Tile[] oldLine) {
        // Code for moving a single line of tiles

        LinkedList<Tile> l = new LinkedList<>();

        // Move the non-empty tiles to the left in the line
        for (int i = 0; i < 4; i++) {
            if (!oldLine[i].isEmpty()) {
                l.addLast(oldLine[i]);
            }
        }

        // Fill the remaining empty positions with empty tiles
        while (l.size() < 4) {
            l.addLast(new Tile());
        }

        // Convert the linked list to an array and return
        return l.toArray(new Tile[4]);
    }

    private Tile[] mergeLine(Tile[] oldLine) {
        // Code for merging a single line of tiles
        LinkedList<Tile> list = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            if (i < 3 && oldLine[i].getValue() == oldLine[i + 1].getValue() && !oldLine[i].isEmpty()) {
                int newValue = oldLine[i].getValue() * 2;
                list.add(new Tile(newValue));
                score += newValue; // update score
                int updatedScore = score;
                onScoreUpdated(updatedScore);
                if (newValue == 2048) {
                    if (eventListener != null) {
                        eventListener.onTileMerged();
                    }
                }
                i++;
            } else {
                list.add(oldLine[i]);
            }
        }

        while (list.size() < 4) {
            list.addLast(new Tile());
        }

        return list.toArray(new Tile[4]);
    }

    private Tile[] reverse(Tile[] line) {
        // Code for reversing the order of tiles in a line
        Tile[] newLine = new Tile[line.length];
        for (int i = 0; i < line.length; i++) {
            newLine[i] = line[line.length - 1 - i];
        }
        return newLine;
    }

    private boolean compare(Tile[] line1, Tile[] line2) {
        // Code for comparing two lines of tiles
        if (line1 == line2) {
            return true;
        } else if (line1.length != line2.length) {
            return false;
        }

        for (int i = 0; i < line1.length; i++) {
            if (line1[i].value != line2[i].value) {
                return false;
            }
        }
        return true;
    }

    public Tile[][] getBoard() {
        return gameBoard.getTiles();
    }

    public void onScoreUpdated(int score) {
        String playerName = PlayerName.getInstance().getName();
        Player player = new Player(playerName, score);
        Ranking.getInstance().addPlayer(player);
    }

    public void checkGameState() {
        for (int i = 0; i < gameBoard.getTiles().length; i++) {
            for (int j = 0; j < gameBoard.getTiles()[0].length; j++) {
                if (gameBoard.getTiles()[i][j].isEmpty()) {
                    return; // If there is an empty space, the game is not over.
                }
            }
        }

        // If there are no empty spaces, then check if any moves can be made.
        for (int i = 0; i < gameBoard.getTiles().length; i++) {
            for (int j = 0; j < gameBoard.getTiles()[0].length; j++) {
                Tile t = gameBoard.getTiles()[i][j];
                // Check all four possible directions
                if ((i < 3 && t.value == gameBoard.getTiles()[i + 1][j].value)
                        || ((i > 0) && t.value == gameBoard.getTiles()[i - 1][j].value)
                        || (j < 3 && t.value == gameBoard.getTiles()[i][j + 1].value)
                        || ((j > 0) && t.value == gameBoard.getTiles()[i][j - 1].value)) {
                    return; // If there is a possible move, the game is not over.
                }
            }
        }

        // If there are no possible moves, then the game is over.
        setLost(true);
    }
}
