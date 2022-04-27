package com.projects;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
 
public class sessionTrackCount extends HttpServlet {
 
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      HttpSession session = request.getSession(true);
         
      Date createTime = new Date(session.getCreationTime());
         
      Date lastAccessTime = new Date(session.getLastAccessedTime());

      String title = "Welcome Back again";
      Integer visitCount = Integer.valueOf(0);
      String visitCountKey = new String("visitCount");
   
      if (session.isNew()) {
         title = "Welcome!";
      } else {
         visitCount = (Integer)session.getAttribute(visitCountKey);
         visitCount = visitCount + 1;
      }
      session.setAttribute(visitCountKey,  visitCount);

      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " +
         "transitional//en\">\n";
      
      String cssTag="<link rel='stylesheet' type='text/css' href='./style.css'>";
      out.println(docType +
         "<html>\n" +
            "<head><title>" + title + "</title>"+cssTag+"</head>\n" +
            
            "<body>\n" +
               "<h2 align = \"center\" color=\"green\">" + title + "</h2>\n" +
               "<h3 align = \"center\">Session Infomation</h3>\n" +
               "<table border = \"1\" align = \"center\">\n" +
                  
                  "<tr bgcolor = \"#949494\">\n" +
                     "  <th>Session info</th><th>value</th></tr>\n" +
                     
                  "<tr bgcolor = \"#FFFFFF\">\n" +
                     "  <td>id</td>\n" +
                     "  <td>" + session.getId() + 
                     "</td></tr>\n" +
                  
                  "<tr bgcolor = \"#949494\">\n" +
                     "  <td>Creation Time</td>\n" +
                     "  <td>" + createTime + "  </td></tr>\n" +
                  
                  "<tr bgcolor = \"#FFFFFF\">\n" +
                     "  <td>Time of Last Access</td>\n" +
                     "  <td>" + lastAccessTime + "  </td></tr>\n" +
                  
                  "<tr bgcolor = \"#949494\">\n" +
                     "  <td>Number of visits</td>\n" +
                     "  <td>" + visitCount + "</td></tr>\n" +
               
               "</table>\n" +
            "</body></html>"
      );
   }
}
