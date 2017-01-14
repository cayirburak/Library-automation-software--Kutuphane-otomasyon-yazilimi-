package k�t�phane;

import java.sql.Connection;
import java.time.temporal.ChronoUnit;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class kisi {
		
	    private String tcNo;
		public String ad;
		public String soyAd;
		private String mail;
		public String kitapAl�sDate;
		public String kitapD�n�sDate;
		public float ceza;
		long fark;
		static Scanner klavye3 = new Scanner(System.in);
		
		public kisi(String tcNo, String ad, String soyAd, String mail, String kitapAl�sDate, String kitapD�n�sDate,
				float ceza) {
		
			this.tcNo = tcNo;
			this.ad = ad;
			this.soyAd = soyAd;
			this.mail = mail;
			this.kitapAl�sDate = kitapAl�sDate;
			this.kitapD�n�sDate = kitapD�n�sDate;
			this.ceza = ceza;
		}
		
	
		public kisi(){
			
		}
		
		public String getTcNo() {
			return tcNo;
		}
		public void setTcNo(String tcNo) {
			this.tcNo = tcNo;
		}
		public String getMail() {
			return mail;
		}
		public void setMail(String mail) {
			this.mail = mail;
		}
        
					public static String kisiAra(String ara){

						try{
							String myDriver = "com.mysql.jdbc.Driver";
					        String db = "jdbc:mysql://localhost/kutuphane?useUnicode=yes&characterEncoding=UTF-8";
					        Class.forName(myDriver);
					        Connection conn = DriverManager.getConnection(db, "root", "");
					        
					        Statement st = conn.createStatement();
                            String ara_sorgusu = "SELECT * FROM kisi WHERE TC_no='"+ara+"'";
					        ResultSet rs = st.executeQuery(ara_sorgusu);
					  
					       boolean deneme=rs.next();
					       if(deneme==true)
					          {

					        	String s_adi = rs.getString("kisi_adi");
					        	String s_soyadi = rs.getString("kisi_soyadi");
					        	String s_mail = rs.getString("mail");
					        	String s_alis = rs.getString("al�s_tarihi");
					        	String s_donus = rs.getString("donus_tarihi");
					        	String s_ceza = rs.getString("ceza");
					        	String s_kitap = rs.getString("alinan_kitap");
					        	
					        	
					            String sonuc ="Ki�i Ad� : "+s_adi +"\n"+
					                              "Ki�i Soyad� : "+s_soyadi +"\n"+
					                              "Ki�i Maili : "+s_mail +"\n"+
					                              "Kitap al�� tarihi : "+s_alis +"\n"+
					                              "Kitap d�n�� tarihi : "+s_donus +"\n"+
					                              "Ki�i cezas� : "+s_ceza +"\n"+
					                              "Ald��� kitab�n barkodu : "+s_kitap +"\n"
					                              ;
					            
					            return sonuc;
					          }
					       else{
					    	   return "ki�i bulunamad�..";
					           }
							}
							
							catch(Exception a){
								return "hata";
								
							}

					}

					public static void kisiSil(String sil){

			    	 try{
							String myDriver = "com.mysql.jdbc.Driver";
					        String db = "jdbc:mysql://localhost/kutuphane?useUnicode=yes&characterEncoding=UTF-8";
					        Class.forName(myDriver);
					        Connection conn = DriverManager.getConnection(db, "root", "");
					        
					        Statement st = conn.createStatement();
                            String tumu = "delete from kisi where TC_no='"+sil+"'";
					        
					        int sor = st.executeUpdate(tumu);
							        if(sor==1){
							        	JOptionPane.showMessageDialog(null, "Ki�i silme i�lemi ba�ar�l� �ekilde ger�ekle�ti", "Bilgi", 1);
							        }
							        else{
							        	JOptionPane.showMessageDialog(null, "Silinecek ki�i bulunamad�", "Hata", 0);
							        }
					    				    
							}
							
							catch(Exception a){
								System.err.println("Hata ! ");
						        System.err.println(a.getMessage());
							}
			    	 
			     }
		
		public static void kisiKayit(String ad,String soyAd,String tcNo,String mail){
			
			kisi temp = new kisi();
			
			temp.kitapAl�sDate = "0";
			temp.kitapD�n�sDate = "0"; 
			temp.ceza = 0;
			
			temp.ad=ad;
			temp.soyAd=soyAd;
			temp.mail=mail;
			temp.tcNo=tcNo;

			try{
				String myDriver = "com.mysql.jdbc.Driver";
		        String db = "jdbc:mysql://localhost/kutuphane?useUnicode=yes&characterEncoding=UTF-8";
		        Class.forName(myDriver);
		        Connection conn = DriverManager.getConnection(db, "root", "");
		        
		        Statement st = conn.createStatement();
		       
		        String sorgu2 =  "INSERT INTO kisi(TC_no , kisi_adi , kisi_soyadi , mail , al�s_tarihi , donus_tarihi , ceza , alinan_kitap)"
	                + "VALUES ('"+temp.tcNo+"','"+temp.ad+"','"+temp.soyAd+"','"+temp.mail+"','"+temp.kitapAl�sDate+"','"+temp.kitapD�n�sDate+"',"+temp.ceza+" , '"+0+"')";
		        int sor = st.executeUpdate(sorgu2);
			    st.close();
			    JOptionPane.showMessageDialog(null, "Kay�t i�lemi ger�ekle�tirildi.", "Bilgi", 1);
				}
				
				catch(Exception a){
					System.err.println("Hata ! ");
			        System.err.println(a.getMessage());
				}
			
		
		}
		
		public static void kitapOdunc(String tc , String barkod){ 
			DateTimeFormatter sekil = DateTimeFormatter.ofPattern("dd MM yyyy");
			LocalDate now = LocalDate.now();
			LocalDate sonra;

			try{
				String myDriver = "com.mysql.jdbc.Driver";
		        String db = "jdbc:mysql://localhost/kutuphane?useUnicode=yes&characterEncoding=UTF-8";
		        Class.forName(myDriver);
		        Connection conn = DriverManager.getConnection(db, "root", "");
		        
		        String simdi = String.valueOf(sekil.format(now));
				sonra = now.plusDays(15);
			    String donus = String.valueOf(sekil.format(sonra));
				
                Statement st = conn.createStatement();
		        float ata = (float) 0;
		        String sorgu2 =  "UPDATE kisi SET al�s_tarihi='"+simdi+"' , donus_tarihi='"+donus+"' , alinan_kitap='"+barkod+"', ceza="+ata+" WHERE TC_no='"+tc+"'";
		        String sorgu3 = "UPDATE kitap SET odunc="+1+" WHERE barkod='"+barkod+"'";
		        String sorgu4 = "select odunc from kitap";
		        int sor = st.executeUpdate(sorgu2);
		        int sor2 = st.executeUpdate(sorgu3);
		    
			    st.close();
				}
				
				catch(Exception a){
					System.err.println("Hata ! ");
			        System.err.println(a.getMessage());
				}
	
		}
		
		public static void kitapIade(String tc , String barkod){
			DateTimeFormatter sekil = DateTimeFormatter.ofPattern("d/MM/yyyy");
			LocalDate now = LocalDate.now();
			LocalDate sonra;

			try{
				String myDriver = "com.mysql.jdbc.Driver";
		        String db = "jdbc:mysql://localhost/kutuphane?useUnicode=yes&characterEncoding=UTF-8";
		        Class.forName(myDriver);
		        Connection conn = DriverManager.getConnection(db, "root", "");
		        
		        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		        Statement st = conn.createStatement();
		       
		        String tarih = "SELECT donus_tarihi FROM kisi";
		        ResultSet rs = st.executeQuery(tarih);
		        while(rs.next()){
		        	 String s_tarih = rs.getString("donus_tarihi");
		        	 String once = s_tarih;
		        	
		        	 SimpleDateFormat myFormat2 = new SimpleDateFormat("dd MM yyyy");
		        	 String inputString2 = "25 01 2017";
		        	 Date date1 = myFormat2.parse(once);
		        	 Date now2 = new Date();
		        	 String date2 = myFormat2.format(now2);
		        	 Date date3 = myFormat2.parse(date2);
		        	 Date date4 = myFormat2.parse(inputString2);
		 		
			 		   long diff = date4.getTime() - date1.getTime();
			 		   long fark = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			 		   float ceza_puani = (float) (fark * 0.1);
			 		 
			 		 	JOptionPane.showMessageDialog(null, "D�n�� tarihi ile bug�n aras�ndaki g�n fark� : " + fark, "Bilgi", 1);
			 		   
			 		   System.out.println("Ceza : " + ceza_puani + "TL");
			 		  JOptionPane.showMessageDialog(null, "Ceza : " + ceza_puani + "TL" , "Bilgi", 1);
			 		   String ceza_ekle = "UPDATE kisi SET ceza="+ceza_puani+" WHERE TC_no='"+tc+"' ";
			 		   int ceza_yaz = st.executeUpdate(ceza_ekle);
		        	 
		        	 break;
		        }
                String sorgu2 =  "UPDATE kisi SET al�s_tarihi='"+0+"' , donus_tarihi='"+0+"' , alinan_kitap='"+0+"' WHERE TC_no='"+tc+"'";
		        String sorgu3 = "UPDATE kitap SET odunc="+0+" WHERE barkod='"+barkod+"'";
		        int sor = st.executeUpdate(sorgu2);
		        int sor2 = st.executeUpdate(sorgu3);
		        if(sor==1){
		        	
		        	JOptionPane.showMessageDialog(null, "�ade etme i�lemi ger�ekle�tirildi", "Bilgi", 1);
		        	
		        }
		        else{
		        	System.out.println("! ��lem ger�ekle�tirilemedi..");
		        }
			    st.close();
				}
				
				catch(Exception a){
					System.err.println("Hata ! ");
			        System.err.println(a.getMessage());
				}
			
	    }		
}
