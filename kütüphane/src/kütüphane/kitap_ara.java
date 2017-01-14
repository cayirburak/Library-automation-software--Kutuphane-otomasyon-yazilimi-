package kütüphane;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import kütüphane.kitap_silme.Butonu_dinle;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class kitap_ara {

	private JFrame frame;
	private JTextField textField;
	
	JButton btnNewButton;
	String ISBN;
	JTextArea textArea;
	JButton btnNewButton_1;

	public kitap_ara() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 821, 637);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Aranacak kitab\u0131n ISBN no'sunu giriniz");
		lblNewLabel.setBounds(331, 89, 233, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(335, 112, 161, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Kitab\u0131 Ara");
		btnNewButton.setBounds(366, 167, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(187, 220, 453, 211);
		frame.getContentPane().add(textArea);
		
		btnNewButton_1 = new JButton("Ana Men\u00FC");
		btnNewButton_1.setBounds(335, 532, 145, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		Butonu_dinle bt_dinle = new Butonu_dinle();
		btnNewButton.addActionListener(bt_dinle);
		
		Butonu_dinle bt_dinle2 = new Butonu_dinle();
		btnNewButton_1.addActionListener(bt_dinle2);
	}
	
	public class Butonu_dinle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnNewButton){
				try{
					ISBN = textField.getText();
					String don = kitap.kitapAra(ISBN);
					textArea.setText(don);

				}
				catch(Exception a){
					 JOptionPane.showMessageDialog(null, "Aranýrken bir hata meydana geldi", "HATA", 0);
					
				}
			}
			
			else if(e.getSource()==btnNewButton_1){
				try{
					
				secenekler.frame.setVisible(true);//seçenekler penceresini tekrar görünür yaptýk.
				frame.dispose();//kitapara penceresini kapattýk.
				
				}
				catch(Exception a){
					 JOptionPane.showMessageDialog(null, "bir hata meydana geldi", "HATA", 0);
					
				}
			}
	   }
   }
}
