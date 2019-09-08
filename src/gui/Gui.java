/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import com.sun.java.swing.plaf.windows.WindowsBorders;
import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author a55shah
 */
public class Gui extends JFrame{
    /**
     * @param args the command line arguments
     */     
//GUI stuff    
    static JFrame j,k;    
    static JPanel jp1,jp2,jp3,main,main1,main2;
    static private JTextField t1,t3,t4,t5;
    static private JPasswordField t2;
    static private JLabel l1,l2,l3,l4,l5,l6;
    static private JButton jb1,jb2;
    public static Connection con;
    public static void main(String[] args) throws SQLException, CloneNotSupportedException, IOException {
        
        getConnection();   
        // TODO code application logic here
        jb1=new JButton("Borrower");
        jb2=new JButton("Manager");
        
        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        main1=new JPanel();
        main2=new JPanel();
        main=new JPanel();
        k=new JFrame("Library Database Main Menu");        
        k.setBounds(0,0,800,400);
        main1.setLayout(new FlowLayout());
        main2.setLayout(new FlowLayout());
        main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));
        jp1.setLayout(new BoxLayout(jp1,BoxLayout.Y_AXIS));
        jp2.setLayout(new BoxLayout(jp2,BoxLayout.Y_AXIS));
        jp3.setLayout(new BoxLayout(jp3,BoxLayout.Y_AXIS));
        k.setDefaultCloseOperation(EXIT_ON_CLOSE);                             
        t1=new JTextField (20);
        t2=new JPasswordField(20);
        l1=new JLabel("Username: ");
        l2=new JLabel("Password: ");
        l3=new JLabel("Enter credentials for ");
        l4=new JLabel("LIBRARY MANAGEMENT SYSTEM");
        l5=new JLabel("*MANAGER");
        l6=new JLabel("*BORROWER");
        jp3.setBorder(new WindowsBorders.DashedBorder(Color.red));
        jp1.add(l4);
        jp1.add(t1);
        jp1.add(t2);        
        jp2.add(l3);
        jp2.add(l1);
        jp2.add(l2);
        jp3.add(l5);
        l6.setBorder(new WindowsBorders.DashedBorder(Color.red));
       
        main1.add(jp3);
        main1.add(jp2);
        main1.add(jp1);
        main2.add(l6);
        main2.add(jb1);
        main1.add(jb2);
        main.add(main1);
        main.add(main2);
        k.add(main);
        k.setVisible(true);
        k.pack();
        
        t1.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                //l4.setText("LIBRARY MANAGEMENT SYSTEM");
            }

            @Override
            public void keyPressed(KeyEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String username;
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                 username=t1.getText();
                 if(!username.equals("admin"))
                    l4.setText("WRONG USERNAME ,TRY AGAIN");
                 else if(username.equals("admin"))
                     l4.setText("Username Correct , Now Enter Password");
                }                                    
            }

            @Override
            public void keyReleased(KeyEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        t2.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                //l4.setText("LIBRARY MANAGEMENT SYSTEM");
            }

            @Override
            public void keyPressed(KeyEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                String password;
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                 password=t2.getText();
                 if(!password.equals("admin"))
                    l4.setText("WRONG PASSWORD ,TRY AGAIN");
                 else if(password.equals("admin"))
                 { l4.setText("Password Correct , Welcome");
                    
                } 
                
                }                                   
            }

            @Override
            public void keyReleased(KeyEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
       jb2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(t1.getText().equals("admin")&&t1.getText().equals(t2.getText()))    
                try {
                        //call manager frame
                        manager m=new manager();
                    } catch (SQLException ex) {
                        Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                    }



                //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        
        
        
        
        jb1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    menu();
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });             
            }
public static void getConnection() throws SQLException
    {       		
                if(con == null)
		{
                    
			String host = "jdbc:oracle:thin:@localhost:1521:orcl";
			String uName = "nmaier";
			String uPass = "Iittrtd1";
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch(ClassNotFoundException e){
				System.out.println("Where is your Oracle JDBC Driver?");
			}
			con = DriverManager.getConnection(host, uName, uPass);
			
                }
		else
			System.out.println("Error: Already Connected");
    }
    
    
public static void menu() throws SQLException, IOException
{
    
    final query q=new query();
    Scanner s=new Scanner(System.in);
    int choice;
  /*  String letter;
    letter = "";*/
    
        j=new JFrame("Borrower Menu");
        j.setBounds(150,150,300,200);     
       // j.setDefaultCloseOperation(EXIT_ON_CLOSE);
        j.setLayout(new FlowLayout());  
    JButton jb1,jb2,jb3;
    jb1=new JButton("Display all titles");
    jb2=new JButton("Search according to author name");
    jb3=new JButton("Display entire Book Database");
    j.add(jb1);
    j.add(jb2);
    j.add(jb3);    
    j.setVisible(true);
    j.pack();
    jb1.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {              
                query.query1();
                //System.out.println("1");
            } catch (SQLException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }        
        }
    });
    jb2.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                query.query2("");                            
            } catch (SQLException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }
    });
    jb3.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                query.query3();
            } catch (SQLException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    
}

}
