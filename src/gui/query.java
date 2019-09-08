/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static gui.Gui.con;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akash
 */
public class query extends JPanel {
    static JFrame f1,f2,f3;    
    public query()
    {
                        f1=new JFrame();
                        f1.setBounds(0,0,500,500);
                        f1.setLayout(new BorderLayout());
                      
                        f2=new JFrame();
                        f2.setBounds(0,0,500,500);
                        f2.setLayout(new BorderLayout());
                        
                        f3=new JFrame();
                        f3.setLayout(new BorderLayout());
                        
    }
     public static void query1() throws SQLException
{                      
                        DefaultListModel model=new DefaultListModel();
                        JList jl=new JList(model);
                        JScrollPane pane=new JScrollPane(jl);
                        
                        pane.setVisible(true);
                                                                    
                        //Database now
                        String query="SELECT *FROM TITLE";
                        Statement stat=con.createStatement();                                                
                        System.out.println("Successfully Connected to database");
                        ResultSet result=stat.executeQuery(query);
                        System.out.println("First Query");
                        while(result.next())
                        {
                            model.addElement(result.getString("NAME"));
                            System.out.println(result.getString("NAME"));                            
                        }    
                        f1.add(pane);
                        f1.setVisible(true);
                       
}
    public static void query2(String letter) throws SQLException, IOException
{
        JTextField tf=new JTextField(20);
    JLabel l=new JLabel("Enter author name here : ");
    DefaultListModel model=new DefaultListModel();
    JList jl=new JList(model);
    JScrollPane pane=new JScrollPane(jl);
    f2.setLayout(new FlowLayout());
    f2.add(l);
    f2.add(tf);
    f2.setVisible(true);
    
        tf.addKeyListener(new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            String a;            
            if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    String query="SELECT *FROM TITLE";
    Statement stat=null;
                try {
                    stat = con.createStatement();
                } catch (SQLException ex) {
                    Logger.getLogger(query.class.getName()).log(Level.SEVERE, null, ex);
                }
    ResultSet result = null;
                try {
                    result = stat.executeQuery(query);
                } catch (SQLException ex) {
                    Logger.getLogger(query.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    while(result.next())
                    {
                        a = result.getString("NAME");
                        if (a.contains(tf.getText()) )
                        {
                            model.addElement("ISBN: "+result.getString("ISBN#")+ ",Name: "+result.getString("NAME"));
                            System.out.println(result.getString("ISBN#"));
                        }
                    }           } catch (SQLException ex) {
                    Logger.getLogger(query.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
        }
    });

        
        pane.setVisible(true);
    f2.add(pane);
}
    /**
     *
     * @throws SQLException
     */    
   
    
    //String conames[]={"NAME","PUBLISHER","AUTHOR","SUMMARY_OF_TITLE","NO_OF_PAGES","NO_OF_COPIES","YEAR_PUBLISHED","GENRE","EDITION_OF_TITLE","ISBN#","REVIEWS"}; 
    
    @SuppressWarnings("empty-statement")
    public static void query3() throws SQLException
{               
            f3=new JFrame();
            JPanel j=new JPanel();
            JScrollPane jp=new JScrollPane();
    
        String query="select * from TITLE";
        JTable t1=new JTable();
        DefaultTableModel dm=new DefaultTableModel();
        Statement st=con.createStatement();   
        ResultSet rs=st.executeQuery(query);
        ResultSetMetaData rsmd=rs.getMetaData();
        //Coding to get columns-
        int cols=rsmd.getColumnCount();
        String c[]=new String[cols];
        for(int i=0;i<cols;i++){
            c[i]=rsmd.getColumnName(i+1);
            dm.addColumn(c[i]);
        }
        //get data from rows
        Object row[]=new Object[cols];
        while(rs.next())
                {
                for(int i=0;i<cols;i++){
                    row[i]=rs.getString(i+1);
                }
            dm.addRow(row);
        }
        t1.setModel(dm);            
            



}  

public void insert_query(String title,String author,int isbn) throws SQLException
{
Statement stat;
stat = con.createStatement();
stat.execute("INSERT INTO TITLE (NAME,AUTHOR,isbn#) "
                                + "VALUES ('"+title+"','"+author+"',"+isbn+")");
}

}
