package finalProject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import finalProject.Game.Direction;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;



public class Play2048 extends JPanel {
    private CardLayout cardLayout;
    private JPanel contentPane;
    private JPanel gridPanel;
    private Game game;
    private Tile[][] board;
    private JLabel[][] labels = new JLabel[4][4];
    private JTextField textField;
    private Ranking ranking = Ranking.getInstance();

        public Play2048(CardLayout cardLayout, JPanel contentPane) {
          this.cardLayout = cardLayout;
          this.contentPane = contentPane;

            this.game = new Game();
            this.board = game.getBoard();

          
          setBackground(new Color(61, 40, 99));
          setBorder(new EmptyBorder(5, 5, 5, 5));
          setBounds(100, 100, 500,700);

  
          // Game2048 패널에 BorderLayout을 사용합니다.
          setLayout(new BorderLayout());
  
          JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(61, 40, 99));
        centerPanel.setBorder(new EmptyBorder(100, 100, 100, 00)); // 내부 여백 설정
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(null);
          
  
          gridPanel = new JPanel();
          gridPanel = new JPanel(new GridLayout(4, 4, 5, 5)); // 그리드를 위한 패널 생성
          gridPanel.setBackground(new Color(61, 40, 99)); // 배경 색상 설정
          gridPanel.setBounds(0, 125, 490, 409);
  
         labels = new JLabel[4][4]; // 4x4 크기의 블록 배열 생성
  
          // 그리드에 블록과 레이블 생성
         for (int row = 0; row < 4; row++) {
        	    for (int col = 0; col < 4; col++) {
        	        Tile tile = board[row][col];
        	        JLabel label = new JLabel("", SwingConstants.CENTER);

        	        labels[row][col] = label; // JLabel 객체를 배열에 추가합니다.
        	        gridPanel.add(label); // JLabel 객체를 그리드 패널에 추가합니다.

        	        
        	        label.setFont(new Font("Arial", Font.BOLD, 24));
        	        label.setOpaque(true);
        	        label.setIcon(tile.getImageIcon());
        	        label.setHorizontalAlignment(JLabel.CENTER);
        	        label.setText(tile.getValue() == 0 ? "" : Integer.toString(tile.getValue()));
        	        label.setForeground(tile.getForeground());

  
                  gridPanel.add(label); // 레이블을 그리드 패널에 추가합니다.
              }
          }
       
          centerPanel.requestFocusInWindow();

          contentPane.setFocusable(true);
          centerPanel.setLayout(null);


          centerPanel.add(gridPanel); // 그리드 패널을 중앙에 추가합니다.
  
          add(centerPanel); // 중앙 패널을 게임 패널의 중앙에 추가합니다.
          
          JButton btnNewButton = new JButton("New Game");
          btnNewButton.setIcon(new ImageIcon(Play2048.class.getResource("/finalProject/images/newGame.png")));
          btnNewButton.setBounds(19, 574, 130, 29);
          centerPanel.add(btnNewButton);
          btnNewButton.setBackground(Color.white);
          btnNewButton.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
                    reset(); 
            	}
            });
  
          btnNewButton.setOpaque(false);
          btnNewButton.setBorderPainted(false);
          btnNewButton.setFocusPainted(false);
          
          JButton btnNewButton_1 = new JButton("Menu");
          btnNewButton_1.setIcon(new ImageIcon(Play2048.class.getResource("/finalProject/images/BackToMenu.png")));
          btnNewButton_1.setBounds(334, 574, 150, 29);
          centerPanel.add(btnNewButton_1);
          btnNewButton_1.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		cardLayout.show(contentPane, "menu");
          	}
          });
          btnNewButton_1.setBackground(Color.white);
          btnNewButton_1.setOpaque(false);
          btnNewButton_1.setBorderPainted(false);
          btnNewButton_1.setFocusPainted(false);
          
          
          textField = new JTextField();
          textField.setEditable(false);
          textField.setBounds(360, 87, 103, 26);
          centerPanel.add(textField);
          textField.setColumns(10);

          
          JLabel lblNewLabel_1 = new JLabel("Your Score");
          lblNewLabel_1.setForeground(Color.WHITE);
          lblNewLabel_1.setBounds(292, 92, 67, 16);
          centerPanel.add(lblNewLabel_1);
          
          JButton btnNewButton_2 = new JButton("New button");
          btnNewButton_2.setIcon(new ImageIcon(Play2048.class.getResource("/finalProject/images/2048Title.png")));
          btnNewButton_2.setBounds(19, 6, 197, 107);
          centerPanel.add(btnNewButton_2);
          btnNewButton_2.setOpaque(false);
          btnNewButton_2.setBorderPainted(false);
          btnNewButton_2.setFocusPainted(false);
          

          InputMap inputMap = gridPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
          ActionMap actionMap = gridPanel.getActionMap();

          inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "Action.up");
          actionMap.put("Action.up", new AbstractAction() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  game.move(Direction.UP);
                  update();
              }
          });

          inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "Action.down");
          actionMap.put("Action.down", new AbstractAction() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  game.move(Direction.DOWN);
                  update();
              }
          });

          inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "Action.left");
          actionMap.put("Action.left", new AbstractAction() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  game.move(Direction.LEFT);
                  update();
              }
          });

          inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "Action.right");
          actionMap.put("Action.right", new AbstractAction() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  game.move(Direction.RIGHT);
                  update();
              }
          });
        }
        
        
        private void reset() {
            // reset the game board
            game.resetGame();

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    for (int row = 0; row < 4; row++) {
                        for (int col = 0; col < 4; col++) {
                            Tile tile = board[row][col];

                            JLabel label = labels[row][col];
                            label.setIcon(null);  // reset icon
                            label.setText("");    // reset text
                            label.setForeground(null);  // reset color
                        }
                    }

                    // redraw panel
                    textField.setText("0");  // reset score
                    gridPanel.repaint();
                }
            });
        }

        private void update() {
            // gameboard update
            this.board = game.getBoard();

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    for (int row = 0; row < 4; row++) {
                        for (int col = 0; col < 4; col++) {
                            Tile tile = board[row][col];

                            JLabel label = labels[row][col];
                            label.setIcon(tile.getImageIcon());
                            label.setText(tile.getValue() == 0 ? "" : Integer.toString(tile.getValue()));
                            label.setForeground(tile.getForeground());
                        }
                    }
                    //redraw panel
                   textField.setText(String.valueOf(game.score));
                   gridPanel.repaint();
                   displayGameOverPopup();
                }
            });
        }
        
        private void displayGameOverPopup() {
            if (game.hasLost()) {
                ImageIcon icon = new ImageIcon(getClass().getResource("/finalProject/images/GameOver.gif"));
                JOptionPane.showMessageDialog(this, "Game over!", "Game Over", JOptionPane.INFORMATION_MESSAGE, icon);
            }
}
}




    

    
    
   


