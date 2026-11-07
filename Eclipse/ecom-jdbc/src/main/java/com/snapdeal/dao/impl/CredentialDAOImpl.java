package com.snapdeal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.snapdeal.dao.CredentialDAO;
import com.snapdeal.util.DBConnection;

public class CredentialDAOImpl
        implements CredentialDAO {

    private static final String SAVE =
            "INSERT INTO user_credentials(customer_id,username,password) VALUES(?,?,?)";

    private static final String LOGIN =
            "SELECT * FROM user_credentials WHERE username=? AND password=?";
    
    private static final String ADMIN_LOGIN =
    	    "SELECT * FROM user_credentials "
    	  + "WHERE username=? "
    	  + "AND password=? "
    	  + "AND role='ADMIN'";
    
    @Override
    public boolean validateAdminLogin(
            String username,
            String password) {

        try(Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            ADMIN_LOGIN)) {

            ps.setString(1,
                    username);

            ps.setString(2,
                    password);

            ResultSet rs =
                    ps.executeQuery();

            return rs.next();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean saveCredentials(
            Long customerId,
            String username,
            String password) {

        try(Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            SAVE)) {

            ps.setLong(1,
                    customerId);

            ps.setString(2,
                    username);

            ps.setString(3,
                    password);

            return ps.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean validateLogin(
            String username,
            String password) {

        try(Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            LOGIN)) {

            ps.setString(
                    1,
                    username);

            ps.setString(
                    2,
                    password);

            ResultSet rs =
                    ps.executeQuery();

            return rs.next();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }
}