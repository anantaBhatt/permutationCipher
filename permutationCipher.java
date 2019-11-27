import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class permutationCipher {

	private JFrame frame;
	private JTextField textKey;
	//Global Initialization
	String key, message, cipherText, plainText;
    int var1 = 6, var2 = 6;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					permutationCipher window = new permutationCipher();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public permutationCipher() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Permutation Cipher Encryptor & Decryptor");
		frame.getContentPane().setLayout(null);
		
		JLabel lblKey = new JLabel("Enter Key : ");
		lblKey.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblKey.setBounds(40, 31, 90, 14);
		frame.getContentPane().add(lblKey);
		
		textKey = new JTextField();
		textKey.setBounds(155, 29, 147, 20);
		frame.getContentPane().add(textKey);
		textKey.setColumns(20);
		
		JLabel lblPlainText = new JLabel("Cipher Text");
		lblPlainText.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPlainText.setBounds(40, 220, 110, 14);
		frame.getContentPane().add(lblPlainText);
		
		final JTextArea txtCipherText = new JTextArea();
		txtCipherText.setBounds(155, 216, 339, 82);
		frame.getContentPane().add(txtCipherText);
		txtCipherText.setLineWrap(true);
		txtCipherText.setWrapStyleWord(true);
		
		JLabel label = new JLabel("Enter Plaintext : ");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(40, 76, 110, 14);
		frame.getContentPane().add(label);
		
		final JTextArea txtPlainText = new JTextArea();
		txtPlainText.setBounds(155, 72, 339, 82);
		frame.getContentPane().add(txtPlainText);
		txtPlainText.setLineWrap(true);
		txtPlainText.setWrapStyleWord(true);
		
		final JTextArea txtOutPlainText = new JTextArea();
		txtOutPlainText.setWrapStyleWord(true);
		txtOutPlainText.setLineWrap(true);
		txtOutPlainText.setBounds(155, 368, 339, 82);
		txtOutPlainText.setLineWrap(true);
		txtOutPlainText.setWrapStyleWord(true);
		
		JButton btnGenerateCipherText = new JButton("Generate Ciphertext");
		btnGenerateCipherText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					//Button Code Here
				  
			        cipherText = "";

			        char[][] charArray = new char[textKey.getText().length()][txtPlainText.getText().length()];
			       
			        var1 = 0;
			        var2 = 0;
			        for (int i = 0; i < txtPlainText.getText().toCharArray().length; i++) {
			        	charArray[var1][var2] = txtPlainText.getText().toCharArray()[i];
			            if (var1 == (textKey.getText().length() - 1)) {
			            	var1 = 0;
			            	var2 = var2 + 1;
			            }
			            else {
			            	var1++;
			            }
			        } 

			        char t[] = new char[textKey.getText().length()];
			        t = textKey.getText().toCharArray();
			        Arrays.sort(t);

			         for (int j = 0; j < var2; j++) {
			            
			            for (int i = 0; i < textKey.getText().length(); i++) {
			                int position = 0;
			               
			                for (position = 0; position < t.length; position++) {
			                    if (textKey.getText().charAt(i) == t[position]) {
			                        break;
			                    }
			                }
			                cipherText += charArray[position][j];
			            }
			        }
			        plainText = txtPlainText.getText();
			        txtCipherText.setText("");
			        txtCipherText.append(cipherText);
			        
			    }
			
		});
		btnGenerateCipherText.setBounds(155, 165, 200, 33);
		frame.getContentPane().add(btnGenerateCipherText);
		
		JButton btnGeneratePlaintext = new JButton("Decrypt Ciphertext");
		btnGeneratePlaintext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     char[][] charArray = new char[textKey.getText().length()][txtPlainText.getText().length()];
				 char t[] = new char[textKey.getText().length()];
			        t = textKey.getText().toCharArray();
			        Arrays.sort(t);

			         for (int j = 0; j < var2; j++) {
			            
			            for (int i = 0; i < textKey.getText().length(); i++) {
			                int position = 0;
			               
			                for (position = 0; position < t.length; position++) {
			                    if (textKey.getText().charAt(i) == t[position]) {
			                        break;
			                    }
			                }
			                plainText += charArray[position][j];
			            }
			        }
			        txtOutPlainText.setText("");
			        txtOutPlainText.append(plainText);
			
			}
		});
		btnGeneratePlaintext.setBounds(155, 324, 200, 33);
		frame.getContentPane().add(btnGeneratePlaintext);
		
		JLabel lblOutPlainText = new JLabel("Plain Text");
		lblOutPlainText.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOutPlainText.setBounds(40, 380, 110, 14);
		frame.getContentPane().add(lblOutPlainText);
		
		
		frame.getContentPane().add(txtOutPlainText);
		frame.setBounds(100, 100, 559, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
