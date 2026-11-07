package com.snapdeal.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CredentialDAOImplTest {

    private final CredentialDAOImpl credentialDAO =
            new CredentialDAOImpl();

    @Test
    void testSaveCredentials() {

        boolean result =
                credentialDAO.saveCredentials(
                        1L,
                        "testuser123",
                        "password123");

        assertTrue(result);
    }

    @Test
    void testValidateLogin_Valid() {

        boolean result =
                credentialDAO.validateLogin(
                        "testuser123",
                        "password123");

        assertTrue(result);
    }

    @Test
    void testValidateLogin_Invalid() {

        boolean result =
                credentialDAO.validateLogin(
                        "invaliduser",
                        "invalidpass");

        assertFalse(result);
    }

    @Test
    void testValidateAdminLogin_Valid() {

        boolean result =
                credentialDAO.validateAdminLogin(
                        "Daiwik",
                        "daiwik@123");

        assertTrue(result);
    }

    @Test
    void testValidateAdminLogin_InvalidPassword() {

        boolean result =
                credentialDAO.validateAdminLogin(
                        "Daiwik",
                        "wrongpassword");

        assertFalse(result);
    }

    @Test
    void testValidateAdminLogin_InvalidUser() {

        boolean result =
                credentialDAO.validateAdminLogin(
                        "wrongadmin",
                        "daiwik@123");

        assertFalse(result);
    }
}