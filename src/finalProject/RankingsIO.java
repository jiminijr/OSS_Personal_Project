package finalProject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Player Class
class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

// Ranking Class
class Ranking {
    private static Ranking instance;
    private List<Player> players;
    private String filename = "ranking.txt";
    private int highestScore = 0;

    private Ranking() {
        this.players = new ArrayList<>();
        loadPlayers();
        updateHighestScoreFromPlayers();
    }

    public static Ranking getInstance() {
        if (instance == null) {
            instance = new Ranking();
        }
        return instance;
    }

    public int getHighestScore() {
        return highestScore;
    }

    private void updateHighestScoreFromPlayers() {
        for (Player player : players) {
            if (player.getScore() > highestScore) {
                highestScore = player.getScore();
            }
        }
    }

    public void updateHighestScore(int score) {
        if (score > highestScore) {
            highestScore = score;
        }
    }

    public void addPlayer(Player player) {
        boolean playerExists = false;
        for (Player p : players) {
            if (p.getName().equals(player.getName())) {
                if (player.getScore() > p.getScore()) {
                    p.score = player.getScore();
                }
                playerExists = true;
                break;
            }
        }
        if (!playerExists) {
            this.players.add(player);
        }
        updateHighestScore(player.getScore());
        savePlayers();
    }

    public void printRanking(JTextArea textArea) {
        Collections.sort(players, Comparator.comparingInt(Player::getScore).reversed());

        StringBuilder rankingString = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {
            rankingString.append((i + 1))
                    .append("  ")
                    .append(players.get(i).getName())
                    .append(" ")
                    .append(players.get(i).getScore())
                    .append("\n");
        }
        textArea.setText(rankingString.toString());
    }

    private void savePlayers() {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(players);
            System.out.println("Players saved to file: " + filename);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    void loadPlayers() {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            players = (ArrayList<Player>) ois.readObject();
            System.out.println("Players loaded from file: " + filename);
        } catch (FileNotFoundException e) {
            players = new ArrayList<>();
            System.out.println("File not found, creating new player list.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void initializeRanking() {
        players = new ArrayList<>();
        highestScore = 0;
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(players);
            System.out.println("Ranking file initialized: " + filename);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

public class RankingsIO extends JPanel {
    private JTextArea textArea;
    private Ranking ranking = Ranking.getInstance();

    public RankingsIO(CardLayout cardLayout, JPanel contentPane) {
    	setBackground(new Color(61, 40, 99));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBounds(100, 100, 500, 700);
        setLayout(null);

        JButton btnNewButton = new JButton();
        btnNewButton.setIcon(new ImageIcon(RankingsIO.class.getResource("/finalProject/images/Rankings2.png")));
        btnNewButton.setBounds(58, 32, 422, 114);
        add(btnNewButton);
        btnNewButton.setOpaque(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setFocusPainted(false);

        JButton btnBackToMenu = new JButton();
        btnBackToMenu.setIcon(new ImageIcon(RankingsIO.class.getResource("/finalProject/images/BackToMenu.png")));
        btnBackToMenu.setBounds(154, 574, 198, 43);
        add(btnBackToMenu);
        btnBackToMenu.setOpaque(false);
        btnBackToMenu.setBorderPainted(false);
        btnBackToMenu.setFocusPainted(false);

        this.textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(88, 194, 310, 338);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 24));

        textArea.setForeground(Color.WHITE);
        textArea.setBackground(new Color(61, 40, 99));
        add(textArea);

        btnBackToMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "menu");
            }
        });

        ranking.printRanking(textArea);
    }
}
