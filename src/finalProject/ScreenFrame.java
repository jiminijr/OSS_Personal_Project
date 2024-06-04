package finalProject;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.CardLayout;

public class ScreenFrame extends JFrame {

	private JPanel contentPane;
	private CardLayout cardLayout; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenFrame frame = new ScreenFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ScreenFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500,700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(61, 40, 99));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

        
       cardLayout = new CardLayout();
        contentPane.setLayout(cardLayout);

        InitialScreen initialScreen= new InitialScreen(cardLayout, contentPane);
        initialScreen.setBackground(new Color(61, 40, 99));
        contentPane.add(initialScreen, "initial"); 
        
        MenuScreen menuScreen= new MenuScreen(cardLayout, contentPane);
        contentPane.add(menuScreen, "menu"); 
        
        HowToPlayScreen howToPlayScreen= new HowToPlayScreen(cardLayout, contentPane);
        contentPane.add(howToPlayScreen, "howToPlay"); 

        Play2048 play2048 = new Play2048 (cardLayout, contentPane);
        contentPane.add(play2048, "play"); 
        
        RankingsIO rankings = new RankingsIO (cardLayout, contentPane);
        contentPane.add(rankings, "rankings"); 
        
        
        cardLayout.show(contentPane, "initial");
       

	}
	

}
