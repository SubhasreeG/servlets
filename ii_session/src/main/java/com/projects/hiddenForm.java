package com.projects;

import java.io.PrintWriter;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class hiddenForm extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String cssTag="<link rel='stylesheet' type='text/css' href='./style.css'>";
        out.println("<head><title>Servlet Home Page</title>"+cssTag+"</head>");
        out.println("<body>");
        //getting value submitted in form from HTML file
        String user = request.getParameter("user");
        String age = request.getParameter("Age");
        String mail = request.getParameter("mail");
        //creating a new hidden form field
        out.println("<div class='wrapper'><form action='hiddenSessionTrack'>");
        out.println("<h2>Welcome "+user+"</h2><h2> Age: " + age +"</h2><h2> Mail id:" + mail+"</h2><h3> Click to send </h3>");
        out.println("<input type='hidden' name='user' value='"+user+"'>");
        out.println("<input type='hidden' name='age' value='"+age+"'>");
        out.println("<input type='hidden' name='mail' value='"+mail+"'>");
        out.println("<input type='submit' class='btn-primary' value='click' >");
        out.println("</form></div>");
    }
}
