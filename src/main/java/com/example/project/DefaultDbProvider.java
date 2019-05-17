package com.example.project;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.*;
public class DefaultDbProvider {

    public static void creditRequest(String tcNo) throws SQLException, IOException {
        User user=getUser(tcNo);
        String requestResult=user.calculateCredit();
        updateTable(tcNo,requestResult);
        sendSms(user.getTelephone(),requestResult);
    }

    public static void sendSms(String telephone, String creditResult) throws IOException {
//        String userName="Onur";
//        String password="12345";
//        String address="http://127.0.0.1";
//        String port="8083";
          try {
              String Account_ID="AC3da14c21186f3f79fa4fc857d748f711";
              String Account_token="6b8862c96c9ff8c61ff809d0751049fc";
              Twilio.init(Account_ID,Account_token);
              String cellphoneString="14015921012";
              Message message= new MessageCreator(new PhoneNumber(telephone),new PhoneNumber(cellphoneString),creditResult).create();
        }catch (Exception ex) {
            if (ex != null) {
               // +1 (401) 592-1012

            }
        }
    }

    public static void updateTable(String tcNo,String requestResult) throws SQLException {
        Connection conn=getConnectionDB();
        try {
            String SQL = "UPDATE dbo.Users SET basvuru=? WHERE tcNo=?";
            PreparedStatement  stmt = conn.prepareStatement(SQL);
            stmt.setString(1,requestResult);
            stmt.setString(2,tcNo);
            stmt.executeQuery();
            conn.close();
        }catch(Exception ex){
            conn.close();
        }
    }

    public static User getUser(String tcNo )throws SQLException {
        Connection conn=getConnectionDB();
        User user=new User();
        try{
            String SQL = "SELECT *FROM dbo.Users WHERE tcNo=?";
            PreparedStatement stmt = conn.prepareStatement(SQL);
            stmt.setString(1,tcNo);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setMountlyIncome(rs.getInt("mountlyIncome"));
                user.setTelephone(rs.getString("telephone"));
                user.setTcNo(rs.getString("tcNo"));
                user.setCreditScore(rs.getInt("creditScore"));
            }
            conn.close();
            return user;
        }catch (Exception ex){
            conn.close();
            return user;
        }
    }

    public static Connection getConnectionDB(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-BK8E09B\\NIRVANA;databaseName=alldbs;user=sa;password=Onur12345");
            return conn;
        }catch (Exception ex){
            return null;
        }
    }
}
