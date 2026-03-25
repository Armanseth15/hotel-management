package com.hotel.dao;

import com.hotel.model.Booking;
import com.hotel.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    public boolean addBooking(Booking booking) {
        boolean status = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO bookings(customer_id, room_id, check_in_date, check_out_date, no_of_days, total_amount, booking_status) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, booking.getCustomerId());
            ps.setInt(2, booking.getRoomId());
            ps.setString(3, booking.getCheckInDate());
            ps.setString(4, booking.getCheckOutDate());
            ps.setInt(5, booking.getNoOfDays());
            ps.setDouble(6, booking.getTotalAmount());
            ps.setString(7, booking.getBookingStatus());

            int i = ps.executeUpdate();
            if (i > 0) {
                status = true;
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public List<Booking> getAllBookings() {
        List<Booking> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT b.booking_id, b.customer_id, b.room_id, c.name, r.room_number, b.check_in_date, b.check_out_date, b.no_of_days, b.total_amount, b.booking_status " +
                    "FROM bookings b " +
                    "JOIN customers c ON b.customer_id = c.customer_id " +
                    "JOIN rooms r ON b.room_id = r.room_id";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Booking b = new Booking();
                b.setBookingId(rs.getInt("booking_id"));
                b.setCustomerId(rs.getInt("customer_id"));
                b.setRoomId(rs.getInt("room_id"));
                b.setCustomerName(rs.getString("name"));
                b.setRoomNumber(rs.getString("room_number"));
                b.setCheckInDate(rs.getString("check_in_date"));
                b.setCheckOutDate(rs.getString("check_out_date"));
                b.setNoOfDays(rs.getInt("no_of_days"));
                b.setTotalAmount(rs.getDouble("total_amount"));
                b.setBookingStatus(rs.getString("booking_status"));
                list.add(b);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Booking getBookingById(int bookingId) {
        Booking booking = null;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT b.*, c.name, r.room_number " +
                    "FROM bookings b " +
                    "JOIN customers c ON b.customer_id = c.customer_id " +
                    "JOIN rooms r ON b.room_id = r.room_id " +
                    "WHERE b.booking_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bookingId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                booking = new Booking();
                booking.setBookingId(rs.getInt("booking_id"));
                booking.setCustomerId(rs.getInt("customer_id"));
                booking.setRoomId(rs.getInt("room_id"));
                booking.setCheckInDate(rs.getString("check_in_date"));
                booking.setCheckOutDate(rs.getString("check_out_date"));
                booking.setNoOfDays(rs.getInt("no_of_days"));
                booking.setTotalAmount(rs.getDouble("total_amount"));
                booking.setBookingStatus(rs.getString("booking_status"));
                booking.setCustomerName(rs.getString("name"));
                booking.setRoomNumber(rs.getString("room_number"));
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booking;
    }

    public void updateBookingStatus(int bookingId, String status) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE bookings SET booking_status=? WHERE booking_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, bookingId);

            ps.executeUpdate();

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}