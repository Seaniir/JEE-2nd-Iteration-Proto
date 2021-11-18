package com.example.jee_2nd_proto;
import com.google.gson.Gson;

import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetTablesServlet")
public class GetTables extends HttpServlet
{
    static ArrayList<String> nameArray = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        getTablesFromSQL();
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        String listString = new Gson().toJson(nameArray);
        resp.getWriter().write(listString);
    }

    public static void getTablesFromSQL()
    {
        nameArray.clear();
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema = 'students'");

            while (resultSet.next()) {
                nameArray.add(resultSet.getString("table_name"));
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
