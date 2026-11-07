package com.snapdeal.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AdminMenuTest {

    @Test
    void testAdminMenuCreation() {

        AdminMenu adminMenu =
                new AdminMenu();

        assertNotNull(adminMenu);
    }
}