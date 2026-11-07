/*
 * package com.snapdeal.model;
 * 
 * public class Customer {
 * 
 * // Instance Variable private int customerId; private String customerName;
 * private String email; private String mobileNumber; private String address;
 * 
 * // Constructor public Customer(String _CustomerName, String _email, String
 * _mobileNumber, String _address) {
 * 
 * this.customerName = _CustomerName; this.email = _email; this.mobileNumber =
 * _mobileNumber; this.address = _address;
 * 
 * }
 * 
 * // Constructor for retrieving an existing customer public Customer(int
 * customerId, String customerName, String email, String mobileNumber, String
 * address) { this.customerId = customerId; this.customerName = customerName;
 * this.email = email; this.mobileNumber = mobileNumber; this.address = address;
 * }
 * 
 * // Getter and Setters public String getCustomerName() { return customerName;
 * }
 * 
 * public void setCustomerName(String customerName) { this.customerName =
 * customerName; }
 * 
 * public String getEmail() { return email; }
 * 
 * public void setEmail(String email) { this.email = email; }
 * 
 * public String getMobileNumber() { return mobileNumber; }
 * 
 * public void setMobileNumber(String mobileNumber) { this.mobileNumber =
 * mobileNumber; }
 * 
 * public String getAddress() { return address; }
 * 
 * public void setAddress(String address) { this.address = address; }
 * 
 * public int getCustomerId() { return customerId; }
 * 
 * // TO string override
 * 
 * @Override public String toString() { return "Customer [customerId=" +
 * customerId + ", customerName=" + customerName + ", email=" + email +
 * ", mobileNumber=" + mobileNumber + ", address=" + address + "]"; }
 * 
 * }
 */



package com.snapdeal.model;

import java.util.Objects;

public class Customer extends AuditEntity {

    private Long customerId;
    private String customerName;
    private String email;
    private String mobile;
    private String address;

    public Customer() {
    }

    public Customer(Long customerId,
                    String customerName,
                    String email,
                    String mobile,
                    String address) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {

        return String.format(
                "%-5d %-20s %-30s %-15s %-25s",
                customerId,
                customerName,
                email,
                mobile,
                address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }
}