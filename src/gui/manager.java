/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import static gui.Gui.con;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author Akash
 */
public class manager {
    
    static private String title;
    static private String AUTHOR;
    static private int isbn;
    static private String PUBLISHER;  
    static private String SUMMARY_OF_TITLE; 
    static private int NO_OF_PAGES;
    static private int NO_OF_COPIES;
    static private int YEAR_PUBLISHED;  
    static private String GENRE;  
    static private int EDITION_OF_TITLE;  
    static private String REVIEWS;
    
    
    private final JFrame f;
    private static JPanel jp1,jp2,jp3;
    private static JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    private static JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    private static JButton jb;     
    
    public manager() throws SQLException
    {
    f=new JFrame();
    jp1=new JPanel();
    jp2=new JPanel();
    jp3=new JPanel();
    
    jp1.setLayout(new BoxLayout(jp1,BoxLayout.Y_AXIS));
    jp2.setLayout(new BoxLayout(jp2,BoxLayout.Y_AXIS));
    jp3.setLayout(new FlowLayout());
    
    t1=new JTextField(30);
     t2=new JTextField(30);
      t3=new JTextField(30);
       t4=new JTextField(30);
        t5=new JTextField(30);
         t6=new JTextField(30);
          t7=new JTextField(30);
           t8=new JTextField(30);
            t9=new JTextField(30);
             t10=new JTextField(30);
              t11=new JTextField(30);
    
    
    l1=new JLabel("1.Name                                                               ");
    l2=new JLabel("2.Publisher");
    l3=new JLabel("3.Author");
    l4=new JLabel("4.Summary of Title");
    l5=new JLabel("5.No. of Pages");
    l7=new JLabel("6.Years Published");
    l8=new JLabel("7.Genre");
    l9=new JLabel("8.Edition of Title");
    l10=new JLabel("9.ISBN Number(PK)");
    l11=new JLabel("10.Reviews");
    l6=new JLabel("6.No. of Copies");
    
    jb=new JButton("INSERT BOOK");
   
    jp1.add(l1);
    jp1.add(l2);
    jp1.add(l3);
    jp1.add(l4);
    jp1.add(l5);
    jp1.add(l6);
    jp1.add(l7);
    jp1.add(l8);
    jp1.add(l9);
    jp1.add(l10);
    jp1.add(l11);
    jp1.add(jb);
   // jp1.setAlignmentY(0);

    jp2.add(t1);
    jp2.add(t2);
    jp2.add(t3);
    jp2.add(t4);
    jp2.add(t5);
    jp2.add(t6);
    jp2.add(t7);
    jp2.add(t8);
    jp2.add(t9);
    jp2.add(t10);
    jp2.add(t11);
    
    jp3.add(jp1);
    jp3.add(jp2);
    
    f.add(jp3);
    f.setVisible(true);
    f.pack();
    manager.manager_query();    
    }

    public static void setTitle(String title) {
        manager.title = title;
    }

    public static void setAUTHOR(String AUTHOR) {
        manager.AUTHOR = AUTHOR;
    }

    public static void setIsbn(int isbn) {
        manager.isbn = isbn;
    }

    public static void setPUBLISHER(String PUBLISHER) {
        manager.PUBLISHER = PUBLISHER;
    }

    public static void setSUMMARY_OF_TITLE(String SUMMARY_OF_TITLE) {
        manager.SUMMARY_OF_TITLE = SUMMARY_OF_TITLE;
    }

    public static void setNO_OF_PAGES(int NO_OF_PAGES) {
        manager.NO_OF_PAGES = NO_OF_PAGES;
    }

    public static void setNO_OF_COPIES(int NO_OF_COPIES) {
        manager.NO_OF_COPIES = NO_OF_COPIES;
    }

    public static void setYEAR_PUBLISHED(int YEAR_PUBLISHED) {
        manager.YEAR_PUBLISHED = YEAR_PUBLISHED;
    }

    public static void setGENRE(String GENRE) {
        manager.GENRE = GENRE;
    }

    public static void setEDITION_OF_TITLE(int EDITION_OF_TITLE) {
        manager.EDITION_OF_TITLE = EDITION_OF_TITLE;
    }

    public static void setREVIEWS(String REVIEWS) {
        manager.REVIEWS = REVIEWS;
    }
   
    
    
    public static void insert_query() throws SQLException
{
Statement stat;
stat = con.createStatement();
stat.execute("INSERT INTO TITLE (NAME,PUBLISHER, AUTHOR, SUMMARY_OF_TITLE, NO_OF_PAGES, NO_OF_COPIES,YEAR_PUBLISHED,  GENRE,  EDITION_OF_TITLE, ISBN#, REVIEWS)"
                                + "VALUES ('"+title+"','"+PUBLISHER+"','"+AUTHOR+"','"+SUMMARY_OF_TITLE+"',"+NO_OF_PAGES+","+NO_OF_COPIES+","+YEAR_PUBLISHED+",'"+GENRE+"',"+EDITION_OF_TITLE+","+isbn+",'"+REVIEWS+"')");
}

    public static void manager_query() throws SQLException
    {
        
        jb.addActionListener(new ActionListener() {

            String title;
             String AUTHOR;
             int isbn;
            String PUBLISHER;  
            String SUMMARY_OF_TITLE; 
            int NO_OF_PAGES;
            int NO_OF_COPIES;
            int YEAR_PUBLISHED;  
            String GENRE;  
            int EDITION_OF_TITLE;  
            String REVIEWS;
                
            @Override
            public void actionPerformed(ActionEvent e) {
                title= t1.getText();
                PUBLISHER=t2.getText();
                AUTHOR=t3.getText();
                SUMMARY_OF_TITLE=t4.getText();
                NO_OF_PAGES=Integer.parseInt(t5.getText());
                NO_OF_COPIES=Integer.parseInt(t6.getText());
                YEAR_PUBLISHED=Integer.parseInt(t7.getText());
                GENRE=t8.getText();
                EDITION_OF_TITLE=Integer.parseInt(t9.getText());
                isbn=Integer.parseInt(t10.getText());
                REVIEWS=t11.getText();
                                
                manager.setAUTHOR(AUTHOR);
                manager.setEDITION_OF_TITLE(EDITION_OF_TITLE);
                manager.setGENRE(GENRE);
                manager.setREVIEWS(REVIEWS);
                manager.setNO_OF_COPIES(NO_OF_COPIES);
                manager.setNO_OF_PAGES(NO_OF_PAGES);
                manager.setTitle(title);
                manager.setYEAR_PUBLISHED(YEAR_PUBLISHED);
                manager.setPUBLISHER(PUBLISHER);
                manager.setIsbn(isbn);
                manager.setTitle(title);
                try {
                    //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    manager.insert_query();
                    System.out.print("YOU ARE COOOOOLLLL");
                } catch (SQLException ex) {
                    Logger.getLogger(manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        
        
        
        
        
        
        
        
    }      
}
