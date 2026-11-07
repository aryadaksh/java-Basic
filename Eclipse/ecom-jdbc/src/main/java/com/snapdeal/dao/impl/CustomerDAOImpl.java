package com.snapdeal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.snapdeal.dao.CustomerDAO;
import com.snapdeal.model.Customer;
import com.snapdeal.util.DBConnection;

public class CustomerDAOImpl implements CustomerDAO {

	private static final String INSERT = "INSERT INTO customers(customer_name,email,mobile,address)"
			+ " VALUES(?,?,?,?)";

	private static final String UPDATE = "UPDATE customers SET customer_name=?, email=?, mobile=?, address=? WHERE customer_id=?";

	private static final String DELETE = "DELETE FROM customers WHERE customer_id=?";

	private static final String FIND_BY_ID = "SELECT * FROM customers WHERE customer_id=?";

	private static final String FIND_BY_EMAIL = "SELECT * FROM customers WHERE email=?";

	private static final String FIND_ALL = "SELECT * FROM customers";

	@Override
	public boolean save(Customer customer) {

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(INSERT)) {

			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getMobile());
			ps.setString(4, customer.getAddress());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(Customer customer) {

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(UPDATE)) {

			ps.setString(1, customer.getCustomerName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getMobile());
			ps.setString(4, customer.getAddress());
			ps.setLong(5, customer.getCustomerId());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delete(Long customerId) {

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(DELETE)) {

			ps.setLong(1, customerId);

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Optional<Customer> findById(Long customerId) {

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(FIND_BY_ID)) {

			ps.setLong(1, customerId);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {

					Customer customer = new Customer();

					customer.setCustomerId(rs.getLong("customer_id"));

					customer.setCustomerName(rs.getString("customer_name"));

					customer.setEmail(rs.getString("email"));

					customer.setMobile(rs.getString("mobile"));

					customer.setAddress(rs.getString("address"));

					return Optional.of(customer);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

	@Override
	public Optional<Customer> findByEmail(String email) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(FIND_BY_EMAIL)) {

			ps.setString(1, email);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {

					Customer customer = new Customer();

					customer.setCustomerId(rs.getLong("customer_id"));

					customer.setCustomerName(rs.getString("customer_name"));

					customer.setEmail(rs.getString("email"));

					customer.setMobile(rs.getString("mobile"));

					customer.setAddress(rs.getString("address"));

					return Optional.of(customer);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

	@Override
	public List<Customer> findAll() {

		List<Customer> customerList = new ArrayList<>();

		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(FIND_ALL);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				Customer customer = new Customer();

				customer.setCustomerId(rs.getLong("customer_id"));

				customer.setCustomerName(rs.getString("customer_name"));

				customer.setEmail(rs.getString("email"));

				customer.setMobile(rs.getString("mobile"));

				customer.setAddress(rs.getString("address"));

				customerList.add(customer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customerList;
	}

}
