package finalProject;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HowToPlayScreen extends JPanel {
	private JPanel contentPane;
	private CardLayout cardLayout; 
	public HowToPlayScreen(CardLayout cardLayout, JPanel contentPane) {
		this.cardLayout = cardLayout;
	    this.contentPane = contentPane;
	    setBackground(new Color(61, 40, 99));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBounds(100, 100, 500,700);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{130, 230, 130, 0};
        gridBagLayout.rowHeights = new int[]{20, 0, 0, 0, 20, 20, 93, 0, 20, 20, 20, 20, 20, 20, 20};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(HowToPlayScreen.class.getResource("/finalProject/images/HowToPlayGIF.png")));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 6;
        add(lblNewLabel, gbc_lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(HowToPlayScreen.class.getResource("/finalProject/images/Playing2048gif.gif")));
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 7;
        add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.setIcon(new ImageIcon(HowToPlayScreen.class.getResource("/finalProject/images/BackToMenu.png")));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "menu");
        	}
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 9;
        add(btnNewButton, gbc_btnNewButton);
        btnNewButton.setBackground(Color.white);
        btnNewButton.setOpaque(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setFocusPainted(false);

	}

}
