package kütüphane;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import kütüphane.kitap_ara.Butonu_dinle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class tum_kitaplar {

	private JFrame frame;
	
	JTextArea textArea;
	JButton btnNewButton;
	private JScrollPane scrollPane;
	
	public tum_kitaplar() {
		initialize();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		this.frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 62, 819, 664);
		frame.getContentPane().add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		try{
			String myDriver = "com.mysql.jdbc.Driver";
	        String db = "jdbc:mysql://localhost/kutuphane?useUnicode=yes&characterEncoding=UTF-8";
	        Class.forName(myDriver);
	        Connection conn = DriverManager.getConnection(db, "root", "");
	        
	        Statement st = conn.createStatement();
            String tumu = "SELECT * FROM kitap";
	        ResultSet rs = st.executeQuery(tumu);

	       while(rs.next())
	          {
	        
	        	String s_adi = rs.getString("kitap_adi");
	        	String s_yazar = rs.getString("kitap_yazari");
	        	String s_yayinevi = rs.getString("kitap_yayinevi");
	        	String s_yayinyili = rs.getString("yayin_yili");
	        	String s_ISBN = rs.getString("ISBN_no");
	        	String s_barkod = rs.getString("barkod");
	        	int s_odunc = rs.getInt("odunc");
	        	
	        	if(s_odunc==1){
	        		 textArea.append("----->> Kitap Adý : "+s_adi +"\n"+
                              "----->> Kitap Yazari : "+s_yazar +"\n"+
                              "----->> Kitap Yayýnevi : "+s_yayinevi +"\n"+
                              "----->> Kitap Yayýnyýlý : "+s_yayinyili +"\n"+
                              "----->> Kitap ISBN_NO : "+s_ISBN +"\n"+
                              "----->> Kitap barkodu : "+s_barkod +"\n"+
                              "----->> !!!KÝTAP ÖDÜNÇ VERÝLMÝÞTÝR.\n"+
                              "---------------------------------------------------------\n\n");
                              
          }
	        	else{
                              textArea.append("----->> Kitap Adý : "+s_adi +"\n"+
	                          "----->> Kitap Yazari : "+s_yazar +"\n"+
	                          "----->> Kitap Yayýnevi : "+s_yayinevi +"\n"+
	                          "----->> Kitap Yayýnyýlý : "+s_yayinyili +"\n"+
	                          "----->> Kitap ISBN_NO : "+s_ISBN +"\n"+
	                          "----->> Kitap barkodu : "+s_barkod +"\n"+
	                          "----->> ÖDÜNÇ ALINABÝLÝR\n"+
	                          "-------------------------------------------------------------\n\n");
	                              
	        	}
	          }
	       
			}
			
			catch(Exception a){
				System.err.println("Hata ! ");
			
		        System.err.println(a.getMessage());
			}
		
		JLabel lblNewLabel = new JLabel("T\u00FCm Kitaplar listelenmektedir");
		lblNewLabel.setBounds(335, 37, 220, 14);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton = new JButton("Anamen\u00FC");
		btnNewButton.setBounds(335, 737, 141, 23);
		frame.getContentPane().add(btnNewButton);
        Butonu_dinle bt_dinle = new Butonu_dinle();
		btnNewButton.addActionListener(bt_dinle);
	}
	
	public class Butonu_dinle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnNewButton){
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
