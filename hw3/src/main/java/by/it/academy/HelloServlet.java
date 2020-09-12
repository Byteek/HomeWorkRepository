package by.it.academy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String name = request.getParameter("user_name");
        if (name == null || "".equals(name.trim())) {
            writer.println("Enter your name");
            writer.println("<input type=\"button\" onclick=\"history.back();\" value=\"Back\"/>\n");
            return;
        }
        String phoneNumber = request.getParameter("phone_number");
        if (phoneNumber == null || "".equals(phoneNumber.trim())) {
            writer.println("Enter your phone number");
            writer.println("<input type=\"button\" onclick=\"history.back();\" value=\"Back\"/>\n");
            return;
        }
        String email = request.getParameter("email");
        if (email == null || "".equals(email.trim())) {
            writer.println("Enter your email");
            writer.println("<input type=\"button\" onclick=\"history.back();\" value=\"Back\"/>\n");
            return;
        }

        try {
            writer.println("<p>Name: " + name + "</p>");
            writer.println("<p>Phone number: " + phoneNumber + "</p>");
            writer.println("<p>Email: " + email + "</p>");

        } finally {
            writer.close();
        }
    }
}