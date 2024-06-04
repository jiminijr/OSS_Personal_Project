package finalProject;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class InitialScreen extends JPanel {

    private JPanel contentPane;
    private CardLayout cardLayout; 
    private String name; 
    public String playerName;

	
	/**
	 * Create the frame.
	 */
	private final JLabel lblNewLabel_1 = new JLabel("");
	private JTextField textField;
	private JButton btnNewButton;

	
	public InitialScreen(CardLayout cardLayout, JPanel contentPane) {
	    this.cardLayout = cardLayout;
	    this.contentPane = contentPane;
	    this.setFocusable(true);
	    this.requestFocusInWindow();
         
        setBackground(new Color(61, 40, 99));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBounds(100, 100, 500,700);
        setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBackground(new Color(238, 238, 238));
        lblNewLabel.setBounds(0, 5, 500, 500);
        lblNewLabel.setIcon(new ImageIcon(InitialScreen.class.getResource("/finalProject/images/gameTitle.gif")));
        add(lblNewLabel);
        lblNewLabel_1.setBounds(70, 510, 359, 103);
        lblNewLabel_1.setIcon(new ImageIcon(InitialScreen.class.getResource("/finalProject/images/pleaseEnterYourNickname.png")));
        add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setBackground(new Color(255, 250, 240));
        textField.setBounds(96, 595, 208, 41);
        add(textField);
        textField.setColumns(20);
        textField.setFont(new Font("times new roman", Font.ITALIC, 30));
        textField.setHorizontalAlignment(JTextField.CENTER);
        btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField != null) {
                    String playerName = textField.getText();
                    PlayerName.getInstance().setName(playerName);
                    cardLayout.show(contentPane, "menu");
                }
            }
        });

        btnNewButton.setBackground(new Color(255, 215, 0));
        btnNewButton.setIcon(new ImageIcon(InitialScreen.class.getResource("/finalProject/images/Start.png")));
        btnNewButton.setBounds(312, 595, 117, 41);
        add(btnNewButton);
        
    }
    
}
