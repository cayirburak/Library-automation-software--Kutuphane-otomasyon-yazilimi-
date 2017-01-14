package kütüphane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class kitap_ekleme {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_4;
	private JButton btnKitabKaydet;
	
	String kitap_adi;
	String yazar;
	String yayin_evi;
	int yayin_yili;
	String ISBN_no;
	
	JButton btnNewButton ;
	private JLabel lblNewLabel_5;

	public kitap_ekleme() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 672, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		this.frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Kitap ad\u0131n\u0131 giriniz :");
		lblNewLabel.setBounds(139, 68, 110, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(317, 65, 177, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Yazar ad\u0131 :");
		lblNewLabel_1.setBounds(139, 131, 110, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(317, 128, 177, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Yay\u0131nevi : ");
		lblNewLabel_2.setBounds(139, 187, 110, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(317, 184, 177, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Yay\u0131n Y\u0131l\u0131 : ");
		lblNewLabel_3.setBounds(139, 251, 110, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(317, 248, 177, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_4 = new JLabel("ISBN_no :");
		lblNewLabel_4.setBounds(139, 306, 110, 17);
		frame.getContentPane().add(lblNewLabel_4); 
		
		textField_4 = new JTextField();
		textField_4.setBounds(317, 304, 177, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		btnKitabKaydet = new JButton("Kitab\u0131 Kaydet");
		btnKitabKaydet.setBounds(235, 389, 162, 23);
		frame.getContentPane().add(btnKitabKaydet);
		
		btnNewButton = new JButton("AnaMenu");
		btnNewButton.setBounds(235, 423, 162, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_5 = new JLabel("Kitap Kay\u0131t \u0130\u015Flemi");
		lblNewLabel_5.setBounds(280, 27, 162, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		
		
		Butonu_dinle bt_dinle = new Butonu_dinle();
		btnKitabKaydet.addActionListener(bt_dinle);
		
		Butonu_dinle bt_dinle1 = new Butonu_dinle();
		btnNewButton.addActionListener(bt_dinle1);
	}
	
	public class Butonu_dinle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnKitabKaydet){
				try{
				kitap_adi = textField.getText();
				yazar = textField_1.getText();
				yayin_evi = textField_2.getText();
				yayin_yili = Integer.parseInt(textField_3.getText());
				ISBN_no = textField_4.getText();
				kitap.kitapKayit(kitap_adi, yazar, yayin_evi, yayin_yili,ISBN_no);
                				
				secenekler.frame.setVisible(true);//seçenekler penceresini tekrar görünür yaptýk.
				frame.dispose();//kitapkayýt penceresini kapattýk.
				}
				catch(Exception a){
					 JOptionPane.showMessageDialog(null, "Eklenirken bir hata meydana geldi", "HATA", 0);
					
				}
			}
			else if(e.getSource()==btnNewButton){
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
