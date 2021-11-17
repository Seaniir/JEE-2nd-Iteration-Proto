package com.example.jee_2nd_proto;
import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyJDBCServlet")
public class MyJDBC extends HttpServlet
{
    static ArrayList<String> nameArray = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        this.main(null);
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        String listString = String.join(", ", nameArray);
        resp.getWriter().write(listString);
    }

    public static void main(String[] args)
    {
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM tbl21157");

            while (resultSet.next()) {
                nameArray.add(resultSet.getString("name"));
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
