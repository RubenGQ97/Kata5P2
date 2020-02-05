/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata4.view;

/**
 *
 * @author senyo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kata4.model.Mail;

public class MailListReaderBD {

    public static ArrayList<Mail> read() throws ClassNotFoundException, SQLException{
        ArrayList<Mail> mailList = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\senyo\\Documents\\NetBeansProjects\\Kata5P2\\Nueva carpeta\\DB.db");

        
        Statement st = connection.createStatement();

        String query = "SELECT * FROM MAIL";
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            String mail = rs.getString("mail");
            if(!mail.contains("@")){
                continue;
            }
           Mail correo = new Mail(rs.getString("mail"));
           mailList.add(correo);
        }

        return mailList;
    }

}
