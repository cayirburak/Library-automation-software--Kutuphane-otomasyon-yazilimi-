package kütüphane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import kütüphane.personel_giris_yap.Butonu_dinle;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class secenekler extends JFrame {
	
	JButton btnNewButton_10;
	JButton btnNewButton_9;
	JButton btnNewButton_8;
	JButton btnNewButton_7;
	JButton btnNewButton_6;
	JButton btnNewButton_5;
	JButton btnNewButton_4;
	JButton btnNewButton_3;
	JButton btnNewButton_2;
	JButton btnNewButton_1;
	JButton btnNewButton;

	public static JFrame frame;
    JLabel lblNewLabel = new JLabel("New label");
	private String ad;

	public secenekler(String ad) {
		initialize(ad);
		
	}

	public void initialize(String ad) {
		frame = new JFrame();
		frame.setBounds(100, 100, 690, 617);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		this.frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		
		lblNewLabel.setBounds(31, 27, 207, 14);
		lblNewLabel.setText("Personel : "+ad);
		
		
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton = new JButton("Kitap Ekleme");
		btnNewButton.setBounds(105, 88, 169, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Kitap Silme");
		btnNewButton_1.setBounds(398, 88, 169, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Kitap Listeleme");
        btnNewButton_2.setBounds(105, 160, 169, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("T\u00FCm Kitaplar\u0131 Listeleme");
		btnNewButton_3.setBounds(398, 160, 169, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Ki\u015Fi Arama");
		btnNewButton_4.setBounds(105, 226, 169, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Personel Kay\u0131t \u0130\u015Flemi");
		btnNewButton_5.setBounds(398, 226, 169, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("Ki\u015Fi Kay\u0131t \u0130\u015Flemi");
		btnNewButton_6.setBounds(105, 295, 169, 23);
		frame.getContentPane().add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("Ki\u015Fi Silme \u0130\u015Flemi");
		btnNewButton_7.setBounds(398, 295, 169, 23);
		frame.getContentPane().add(btnNewButton_7);
		
		btnNewButton_8 = new JButton("Kitap \u00D6d\u00FCn\u00E7 Verme");
		btnNewButton_8.setBounds(105, 357, 169, 23);
		frame.getContentPane().add(btnNewButton_8);
		
		btnNewButton_9 = new JButton("Kitap \u0130ade \u0130\u015Flemi");
        btnNewButton_9.setBounds(398, 357, 169, 23);
		frame.getContentPane().add(btnNewButton_9);
		
		btnNewButton_10 = new JButton("Program\u0131 Kapat");
		btnNewButton_10.setBounds(258, 470, 154, 34);
		frame.getContentPane().add(btnNewButton_10);
		
		Butonu_dinle bt_dinle10 = new Butonu_dinle();
		btnNewButton_10.addActionListener(bt_dinle10);
		
		Butonu_dinle bt_dinle9 = new Butonu_dinle();
		btnNewButton_9.addActionListener(bt_dinle9);
		
		Butonu_dinle bt_dinle8 = new Butonu_dinle();
		btnNewButton_8.addActionListener(bt_dinle8);
		
		Butonu_dinle bt_dinle7 = new Butonu_dinle();
		btnNewButton_7.addActionListener(bt_dinle7);
		
		Butonu_dinle bt_dinle6 = new Butonu_dinle();
		btnNewButton_6.addActionListener(bt_dinle6);
		
		Butonu_dinle bt_dinle5 = new Butonu_dinle();
		btnNewButton_5.addActionListener(bt_dinle5);
		
		Butonu_dinle bt_dinle4 = new Butonu_dinle();
		btnNewButton_4.addActionListener(bt_dinle4);
		
		Butonu_dinle bt_dinle3 = new Butonu_dinle();
		btnNewButton_3.addActionListener(bt_dinle3);
		
		Butonu_dinle bt_dinle2 = new Butonu_dinle();
		btnNewButton_2.addActionListener(bt_dinle2);
		
		Butonu_dinle bt_dinle1 = new Butonu_dinle();
		btnNewButton_1.addActionListener(bt_dinle1);
		
		Butonu_dinle bt_dinle = new Butonu_dinle();
		btnNewButton.addActionListener(bt_dinle);
	}
	
	public class Butonu_dinle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnNewButton_10){
					    System.exit(0);
			}
			else if(e.getSource()==btnNewButton_9){
				frame.setVisible(false);
				kitap_iade yeni=new kitap_iade();
			}
			else if(e.getSource()==btnNewButton_8){
				frame.setVisible(false);
				kitap_odunc yeni=new kitap_odunc();
			}
			else if(e.getSource()==btnNewButton_7){
				frame.setVisible(false);
				kisi_silme yeni=new kisi_silme();
			}
			else if(e.getSource()==btnNewButton_6){
				frame.setVisible(false);
				kisi_kayit yeni=new kisi_kayit();
			}
			else if(e.getSource()==btnNewButton_5){
				frame.setVisible(false);
				personel_kayit yeni=new personel_kayit();
			}
			else if(e.getSource()==btnNewButton_4){
				frame.setVisible(false);
				kisi_ara yeni = new kisi_ara();
			}
			else if(e.getSource()==btnNewButton_3){
				frame.setVisible(false);
				tum_kitaplar yeni = new tum_kitaplar();
				  
			}
			else if(e.getSource()==btnNewButton_2){
				frame.setVisible(false);
				kitap_ara yeni = new kitap_ara();
				
			}
			else if(e.getSource()==btnNewButton_1){
				frame.setVisible(false);
				kitap_silme yeni = new kitap_silme();
			
			}
			else if(e.getSource()==btnNewButton){
				frame.setVisible(false);
				kitap_ekleme yeni = new kitap_ekleme();
			
			}
		}
	}

}
