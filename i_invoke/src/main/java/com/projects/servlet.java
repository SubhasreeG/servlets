package com.projects;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet extends HttpServlet
{
 public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException
 {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out=res.getWriter();
    String cssTag="<link rel='stylesheet' type='text/css' href='./style.css'>";
    out.println("<head><title>Servlet Home Page</title>"+cssTag+"</head>");
    out.println("<body>");
    out.print("<div class='wrapper'><h1>Registration Successful</h1>");
    Enumeration<?> e=req.getParameterNames();
    while(e.hasMoreElements())
    {
    String str1=(String)e.nextElement();
    String str2=req.getParameter(str1);
    out.print("<h2>"+str1+"="+str2+"</h2>");
    }
    out.print("</div>");
    out.close();
}
}