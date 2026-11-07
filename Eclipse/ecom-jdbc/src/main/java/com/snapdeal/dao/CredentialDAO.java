package com.snapdeal.dao;

public interface CredentialDAO {

    boolean saveCredentials(
            Long customerId,
            String username,
            String password);

    boolean validateLogin(
            String username,
            String password);
    
    boolean validateAdminLogin(
            String username,
            String password);
}