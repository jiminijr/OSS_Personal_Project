package finalProject;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MenuScreen extends JPanel {

	private JPanel contentPane;
	private CardLayout cardLayout; 

	public MenuScreen(CardLayout cardLayout, JPanel contentPane) {
        setBackground(new Color(61, 40, 99));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBounds(100, 100, 500,700);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{130, 230, 130, 0};
        gridBagLayout.rowHeights = new int[]{20, 0, 0, 20, 20, 93, 20, 20, 20, 20};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(MenuScreen.class.getResource("/finalProject/images/2048AnimatedEdition.gif")));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 0;
        add(lblNewLabel, gbc_lblNewLabel);
        
        btnNewButton.setIcon(new ImageIcon(MenuScreen.class.getResource("/finalProject/images/HowToPlay2048.png")));
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "howToPlay");
        	}
        });
        gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 4;
        add(btnNewButton, gbc_btnNewButton);
        btnNewButton.setBackground(Color.white);
        btnNewButton.setOpaque(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setFocusPainted(false);
        
        
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setOpaque(true);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_1.setIcon(new ImageIcon(MenuScreen.class.getResource("/finalProject/images/Play2048Game.png")));
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton_1.gridx = 1;
        gbc_btnNewButton_1.gridy = 5;
        add(btnNewButton_1, gbc_btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "play");
        	}
        });
        btnNewButton_1.setBackground(Color.white);
        btnNewButton_1.setOpaque(false);
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setFocusPainted(false);
        
        
        
        JButton btnNewButton_3 = new JButton("");
        btnNewButton_3.setIcon(new ImageIcon(MenuScreen.class.getResource("/finalProject/images/Rankings.png")));
        GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
        gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton_3.gridx = 1;
        gbc_btnNewButton_3.gridy = 6;
        add(btnNewButton_3, gbc_btnNewButton_3);
        btnNewButton_3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
    		cardLayout.show(contentPane, "rankings");
    	}
    });
        btnNewButton_3.setBackground(Color.white);
        btnNewButton_3.setOpaque(false);
        btnNewButton_3.setBorderPainted(false);
        btnNewButton_3.setFocusPainted(false);
        
        
        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.setIcon(new ImageIcon(MenuScreen.class.getResource("/finalProject/images/Quit.png")));
        GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
        gbc_btnNewButton_2.fill = GridBagConstraints.VERTICAL;
        gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton_2.gridx = 1;
        gbc_btnNewButton_2.gridy = 7;
        add(btnNewButton_2, gbc_btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        	             System.exit(0);
        	}
        });
        btnNewButton_2.setBackground(Color.white);
        btnNewButton_2.setOpaque(false);
        btnNewButton_2.setBorderPainted(false);
        btnNewButton_2.setFocusPainted(false);

	}

}
