package kütüphane;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import kütüphane.kisi_silme.Butonu_dinle;

import javax.swing.JButton;

public class kitap_odunc {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	JButton btnNewButton_1 ;
	JButton btnNewButton ;
	
	String TC;
	String barkod;

	public kitap_odunc() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 623, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kitap \u00D6d\u00FCn\u00E7 Verme Sistemi");
		lblNewLabel.setBounds(244, 31, 193, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Kitab\u0131 alan ki\u015Finin TC nosunu giriniz :");
		lblNewLabel_1.setBounds(79, 86, 205, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Al\u0131nan kitab\u0131n barkodunu giriniz :");
		lblNewLabel_2.setBounds(79, 154, 205, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(340, 83, 160, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(340, 151, 160, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("\u00D6d\u00FCn\u00E7 ver");
		btnNewButton.setBounds(226, 219, 145, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("AnaMenu");
		btnNewButton_1.setBounds(226, 276, 145, 23);
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
                    kisi.kitapOdunc(TC , barkod);
                    JOptionPane.showMessageDialog(null, "Ödünç verme iþlemi gerçekleþtirildi", "Bilgi", 1);
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
					 JOptionPane.showMessageDialog(null, "Bir hata meydana geldi", "HATA", 0);
					
				}
			}

	   }
   }

}
