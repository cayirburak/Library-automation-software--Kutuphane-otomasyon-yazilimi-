package kütüphane;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import kütüphane.kitap_odunc.Butonu_dinle;

import javax.swing.JButton;

public class kitap_iade {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	JButton btnNewButton_1;
	JButton btnNewButton;
	
	String TC;
	String barkod;

	public kitap_iade() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 684, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		this.frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Kitap \u0130ade Sistemi");
		lblNewLabel.setBounds(290, 36, 146, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Kitab\u0131 iade edecek ki\u015Finin TC nosunu giriniz :");
		lblNewLabel_1.setBounds(52, 120, 284, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u0130ade edilecek kitab\u0131n barkodunu giriniz :");
		lblNewLabel_2.setBounds(52, 225, 284, 17);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(346, 117, 239, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(346, 222, 239, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("\u0130ade et");
		btnNewButton.setBounds(245, 304, 172, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("AnaMenu");
		btnNewButton_1.setBounds(245, 363, 172, 23);
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
					TC=textField.getText();
					barkod=textField_1.getText();
                    kisi.kitapIade(TC , barkod);
                    
                  }
				catch(Exception a){
					 JOptionPane.showMessageDialog(null, "Bir hata meydana geldi", "HATA", 0);
                }
			}
                else if(e.getSource()==btnNewButton_1){
				try{
						secenekler.frame.setVisible(true);//seçenekler penceresini tekrar görünür yaptýk.
						frame.dispose();//kitapara penceresini kapattýk.
                   }
				catch(Exception a){
					
                }
			}

	   }
   }

}
