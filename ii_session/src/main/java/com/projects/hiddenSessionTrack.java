package com.projects;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class hiddenSessionTrack extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String cssTag="<link rel='stylesheet' type='text/css' href='./style.css'>";
        out.println("<head><title>Servlet Home Page</title>"+cssTag+"</head>");
        out.println("<body>");
        out.println("<div class='wrapper'>");
        //getting parameter from the hidden field
        String user = request.getParameter("user");
        String age = request.getParameter("age");
        String mail = request.getParameter("mail");
        out.println("<h1>Welcome "+user + "</h1>");
        out.println("<h2>Received hidden info</h2> <h2> Age: "+age+ "</h2>");
        out.println("<h2>Received hidden info</h2> <h2> Mail id: "+mail+ "</h2>");

        out.println("</div></body>");
    }
}
