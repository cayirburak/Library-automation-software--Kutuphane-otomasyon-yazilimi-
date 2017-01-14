package kütüphane;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import kütüphane.secenekler.Butonu_dinle;

import javax.swing.JButton;

public class kitap_silme {

	private JFrame frame;
	private JTextField textField;
	JButton btnNewButton;
	
	String barkod;
	private JButton btnNewButton_1;

	public kitap_silme() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Silinecek kitab\u0131n barkodunu giriniz :");
		lblNewLabel.setBounds(140, 77, 236, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(140, 115, 164, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Kitap Sil");
		btnNewButton.setBounds(176, 173, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("AnaMen\u00FC");
		btnNewButton_1.setBounds(176, 207, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		Butonu_dinle bt_dinle = new Butonu_dinle();
		btnNewButton.addActionListener(bt_dinle);
		
		Butonu_dinle bt_dinle1 = new Butonu_dinle();
		btnNewButton_1.addActionListener(bt_dinle1);
	}
	
	public class Butonu_dinle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnNewButton){
				try{
					barkod = textField.getText();
					kitap.kitapSil(barkod);
				
				secenekler.frame.setVisible(true);//seçenekler penceresini tekrar görünür yaptýk.
				frame.dispose();//kitapsil penceresini kapattýk.
				}
				catch(Exception a){
					 JOptionPane.showMessageDialog(null, "Silinirken bir hata meydana geldi", "HATA", 0);
					
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
