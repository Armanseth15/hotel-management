package com.hotel.servlet;

import com.hotel.dao.RoomDAO;
import com.hotel.model.Room;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/addRoom")
public class AddRoomServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomNumber = request.getParameter("roomNumber");
        String roomType = request.getParameter("roomType");
        double price = Double.parseDouble(request.getParameter("price"));
        String status = request.getParameter("status");

        Room room = new Room(roomNumber, roomType, price, status);
        RoomDAO dao = new RoomDAO();

        if (dao.addRoom(room)) {
            response.sendRedirect("viewRooms");
        } else {
            response.getWriter().println("Failed to add room");
        }
    }
}