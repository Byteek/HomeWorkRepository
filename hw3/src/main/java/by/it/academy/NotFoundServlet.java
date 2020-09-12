package by.it.academy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/notfound")
public class NotFoundServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String id = request.getParameter("id");

        try {
            writer.println("<h2>Not Found: enter your id in command line! (Format: secondhello?id=1)</h2>");
        } finally {
            writer.close();
        }
    }
}