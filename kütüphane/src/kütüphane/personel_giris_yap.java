package kütüphane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class personel_giris_yap {

	 JFrame frame;
	 JTextField textField;
	 JTextField textField_1;
	 JLabel lblKtphaneOtomasyonuGiri;
	 JButton btnGiriYapn;
	 String ad = null;
	
	 String sicil;
	 String sifre;

	public personel_giris_yap() {
		initialize();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setBounds(100, 100, 502, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblSicilNoGiriniz = new JLabel("Personel Sicil NO Giriniz");
		lblSicilNoGiriniz.setBounds(40, 86, 137, 14);
		frame.getContentPane().add(lblSicilNoGiriniz);
		
		textField = new JTextField();
		textField.setBounds(205, 83, 131, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblPersonelifreGiriniz = new JLabel("Personel \u015Eifre Giriniz");
		lblPersonelifreGiriniz.setBounds(40, 117, 155, 17);
		frame.getContentPane().add(lblPersonelifreGiriniz);
		
		textField_1 = new JTextField();
		textField_1.setBounds(205, 114, 131, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnGiriYapn = new JButton("Giri\u015F Yap\u0131n");
		btnGiriYapn.setBounds(205, 145, 131, 23);
		frame.getContentPane().add(btnGiriYapn);
		
		lblKtphaneOtomasyonuGiri = new JLabel("K\u00FCt\u00FCphane Otomasyonu Giri\u015F Ekran\u0131");
		lblKtphaneOtomasyonuGiri.setBounds(163, 26, 370, 14);
		frame.getContentPane().add(lblKtphaneOtomasyonuGiri);
		this.frame.setVisible(true);
		
		Butonu_dinle bt_dinle1 = new Butonu_dinle();
		btnGiriYapn.addActionListener(bt_dinle1);
		
		
	}
	
	public class Butonu_dinle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==btnGiriYapn){
				sicil = textField.getText();
				sifre = textField_1.getText();
			
	     		
	     		if(personel.personelGiris(sicil, sifre)==false){
                JOptionPane.showMessageDialog(null, "Giriþ Baþarýsýz Lütfen sicil no ve þifreyi Kontrol Ediniz!!!", "HATA", 0);//hata mesajý
			    }
	     		else{
	     			ad=personel.ad_getir(sicil);
	     			System.out.println(ad);
	     			secenekler yeni = new secenekler(ad);
	     			
	     			
	     			frame.dispose();
	     		}
			  
			}
		
		}
	
	}
}
