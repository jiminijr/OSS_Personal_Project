package finalProject;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextArea;

// Player Class
class Player implements Serializable {
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
    List<Player> players;
    String filename = "ranking.txt";  // file name
    private int highestScore = 0; 

    private Ranking() {
        this.players = new ArrayList<>();
        loadPlayers();  // get player from file
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

    public void updateHighestScore(int score) {
        if (score > highestScore) {
            highestScore = score;
        }
    }


    public void addPlayer(Player player) {
        this.players.add(player);
        savePlayers();  // save player
    }

    public void printRanking(JTextArea textArea) { //print ranking
        Collections.sort(players, Comparator.comparingInt(Player::getScore).reversed());

        StringBuilder rankingString = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {
            rankingString.append((i + 1))
            		.append(" ")
                    .append(players.get(i).getName())
                    .append(" ")
                    .append(players.get(i).getScore())
                    .append("\n");
        }
        textArea.setText(rankingString.toString());
    }

    // save players into file
    private void savePlayers() {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(players);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    //get players from file
    private void loadPlayers() {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            players = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            players = new ArrayList<>();  // if the file doesn't exsist, make new one
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }
}

public class RankingsIO extends JPanel {
    private JTextArea textArea;
    private Ranking ranking = Ranking.getInstance();
	public RankingsIO(CardLayout cardLayout, JPanel contentPane) {
		 setBackground(new Color(61, 40, 99));
	        setBorder(new EmptyBorder(5, 5, 5, 5));
	        setBounds(100, 100, 500,700);
	        setLayout(null);
	      

	        
	        JButton btnNewButton = new JButton("New button");
	        btnNewButton.setIcon(new ImageIcon(RankingsIO.class.getResource("/finalProject/images/Rankings2.png")));
	        btnNewButton.setBounds(58, 32, 422, 114);
	        add(btnNewButton);
	          btnNewButton.setOpaque(false);
	          btnNewButton.setBorderPainted(false);
	          btnNewButton.setFocusPainted(false);
	          
	          JButton btnNewButton_1 = new JButton("New button");
	          btnNewButton_1.setIcon(new ImageIcon(RankingsIO.class.getResource("/finalProject/images/BackToMenu.png")));
	          btnNewButton_1.setBounds(154, 574, 198, 43);
	          add(btnNewButton_1);
	          btnNewButton_1.setOpaque(false);
	          btnNewButton_1.setBorderPainted(false);
	          btnNewButton_1.setFocusPainted(false);
	          
	          this.textArea = new JTextArea();
	          textArea.setEditable(false);
	          textArea.setBounds(88, 194, 310, 338);  
	          add(textArea);

				 btnNewButton_1.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
			                cardLayout.show(contentPane, "menu");
			            }
			        });

			        // Print ranking when panel is created
			        ranking.printRanking(textArea);
			    }
			}

	
