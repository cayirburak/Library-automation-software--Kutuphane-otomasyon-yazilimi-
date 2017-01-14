package kütüphane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class kitap {
	
	public String kitap_adi;
	public String kitap_yazari;
	public String kitap_yayinevi;
	public int yayin_yili;
	public String ISBN_no;
	public String barkod;
	public int kopya_sayisi = 0;

				public static String kitapAra(String ara){
				
					try{
						String myDriver = "com.mysql.jdbc.Driver";
				        String db = "jdbc:mysql://localhost/kutuphane?useUnicode=yes&characterEncoding=UTF-8";
				        Class.forName(myDriver);
				        Connection conn = DriverManager.getConnection(db, "root", "");
				        
				        Statement st = conn.createStatement();

				        String ara_sorgusu = "SELECT * FROM kitap WHERE ISBN_no='"+ara+"'";
				        ResultSet rs = st.executeQuery(ara_sorgusu);
				  
				       boolean deneme=rs.next();
				       if(deneme==true)
				          {
                            String s_adi = rs.getString("kitap_adi");
				        	String s_yazar = rs.getString("kitap_yazari");
				        	String s_yayinevi = rs.getString("kitap_yayinevi");
				        	String s_yayinyili = rs.getString("yayin_yili");
				        	String s_ISBN = rs.getString("ISBN_no");
				        	String s_barkod = rs.getString("barkod");
				        	int s_odunc = rs.getInt("odunc");
				      
				        	String sonuc = "Kitap Adý : "+s_adi +"\n"+
		                              "Kitap Yazari : "+s_yazar +"\n"+
		                              "Kitap Yayýnevi : "+s_yayinevi +"\n"+
		                              "Kitap Yayýnyýlý : "+s_yayinyili +"\n"+
		                              "Kitap ISBN_NO : "+s_ISBN +"\n"+
		                              "Kitap barkodu : "+s_barkod +"\n"
		                              ;
				        	
				        	if(s_odunc==1){
				        		sonuc = sonuc + "\nKitabý bir baþkasý ödünç aldý.";
				        	}
				        	else{
				        		sonuc = sonuc + "\nKitabý ödünç alabilirsiniz";
				        	}
				        	
				        	return sonuc;
                           
				          }
				       else{
				    	 
				    	   String sonuc = "kitap bulunamadi";
				    	   return sonuc;
				           }
						}
						
						catch(Exception a){
							String sonuc = "hata";
							return sonuc;
							
						}
	
				}

	public static void kitapKayit(String kitab_adi,String yazar,String yayin_evi,int yayin_yili,String Isbn_no){
		
		kitap temp = new kitap();
		
		temp.kitap_adi=kitab_adi;
		temp.kitap_yazari=yazar;
		temp.kitap_yayinevi=yayin_evi;
		temp.yayin_yili=yayin_yili;
		temp.ISBN_no=Isbn_no;
	
		try{
			String myDriver = "com.mysql.jdbc.Driver";
	        String db = "jdbc:mysql://localhost/kutuphane?useUnicode=yes&characterEncoding=UTF-8";
	        Class.forName(myDriver);
	        Connection conn = DriverManager.getConnection(db, "root", "");
	        
	        Statement st = conn.createStatement();
             String sorgu3 = "SELECT kitap_adi FROM kitap WHERE kitap_adi='"+temp.kitap_adi+"'";
	        
	        ResultSet rs = st.executeQuery(sorgu3);
	         
	        while (rs.next())
	          {
	        	temp.kopya_sayisi++;

	        	String s_adi = rs.getString("kitap_adi");
   
	          }
	        temp.barkod = barkod_olustur(temp.yayin_yili,temp.kopya_sayisi,temp.ISBN_no);
	        String sorgu2 =  "INSERT INTO kitap(kitap_adi , kitap_yazari , kitap_yayinevi , yayin_yili , ISBN_no , barkod , kitap_kopya_sayisi , odunc)"
	                + "VALUES ('"+temp.kitap_adi+"','"+temp.kitap_yazari+"','"+temp.kitap_yayinevi+"',"+temp.yayin_yili+",'"+temp.ISBN_no+"','"+temp.barkod+"',"+temp.kopya_sayisi+" , "+0+")";

	        int sor = st.executeUpdate(sorgu2);
	        
		    st.close();
			}
			
			catch(Exception a){
				JOptionPane.showMessageDialog(null, "Bir hata meydana geldi!!", "Hata", 0);

			}
		
	
	}

     public static void kitapSil(String barkod){
                try{
					String myDriver = "com.mysql.jdbc.Driver";
			        String db = "jdbc:mysql://localhost/kutuphane?useUnicode=yes&characterEncoding=UTF-8";
			        Class.forName(myDriver);
			        Connection conn = DriverManager.getConnection(db, "root", "");
			        
			        Statement st = conn.createStatement();
			        
                    String tumu = "delete from kitap where barkod='"+barkod+"' ORDER BY kitap_kopya_sayisi DESC LIMIT 1 ";
                    int sor = st.executeUpdate(tumu);
					        if(sor==1){
					        	JOptionPane.showMessageDialog(null, "Silme iþlemi baþarý ile gerçekleþti", "Bilgi", 1);
					        }
					        else{
					        	JOptionPane.showMessageDialog(null, "Girdiðiniz barkod bulunamadý","Bilgi", -1);
					        }
			      	    
					}
					
					catch(Exception a){
						JOptionPane.showMessageDialog(null, "Hata meydana geldi","Bilgi", -1);
					}
	    	 
	     }
	
	public kitap(String kitap_adi, String kitap_yazari, String kitap_yayinevi, int yayin_yili, String iSBN_no,
			String barkod) {
		
		this.kitap_adi = kitap_adi;
		this.kitap_yazari = kitap_yazari;
		this.kitap_yayinevi = kitap_yayinevi;
		this.yayin_yili = yayin_yili;
		ISBN_no = iSBN_no;
		this.barkod = barkod;
	}
	
	public static String barkod_olustur(int yayinyili , int kopya_sayisi , String ISBN_no){
	    return ISBN_no.substring(4,7)+"K"+kopya_sayisi+yayinyili;	
	}
	
	public kitap(){
    }
  
}
