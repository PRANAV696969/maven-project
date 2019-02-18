package com.sample;

import java.sql.*;

public class login {


    public boolean check(String username, String password){

        int flag = 0;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_db","root",null);
            String sql = "SELECT password FROM login WHERE username = ?";
            PreparedStatement statement=con.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet rs=statement.executeQuery();

            while(rs.next()) {
                if(rs.getString(1).equals(password))
                    flag = 1;
            }
            con.close();
        }
        catch
                (Exception e){ System.out.println(e);}

        if(flag == 1)
            return true;
        else
            return false;

    }
}
