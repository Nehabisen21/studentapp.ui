package com.srk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srk.dao.StudentDAO;
import vo.Student;

@WebServlet("/viewStudents")
public class ViewStudents extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  

        List<Student> list = StudentDAO.getAllStudents();  

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Students List</title>");
        out.println("<link href='https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap' rel='stylesheet'>");
        out.println("<style>");
        out.println("body { font-family: 'Roboto', sans-serif; background: #f4f6f8; margin: 0; padding: 20px; }");
        out.println(".container { max-width: 1000px; margin: auto; background: #fff; padding: 30px; border-radius: 12px; box-shadow: 0 8px 16px rgba(0,0,0,0.1); }");
        out.println("h1 { text-align: center; margin-bottom: 30px; color: #333; }");
        out.println("a.button { display: inline-block; margin-bottom: 20px; text-decoration: none; background: #007bff; color: white; padding: 10px 18px; border-radius: 8px; font-weight: bold; }");
        out.println("a.button:hover { background: #0056b3; }");
        out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
        out.println("th, td { padding: 12px 15px; border-bottom: 1px solid #ddd; text-align: left; }");
        out.println("th { background-color: #007bff; color: white; }");
        out.println("tr:hover { background-color: #f1f1f1; }");
        out.println("a.edit, a.delete { text-decoration: none; padding: 6px 12px; border-radius: 6px; font-weight: bold; }");
        out.println("a.edit { background-color: #28a745; color: white; }");
        out.println("a.edit:hover { background-color: #218838; }");
        out.println("a.delete { background-color: #dc3545; color: white; }");
        out.println("a.delete:hover { background-color: #c82333; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<a href='index.jsp' class='button'>Register Student</a>");
        out.println("<h1>Students List</h1>");
        out.println("<table>");
        out.println("<tr><th>Student ID</th><th>Name</th><th>Address</th><th>Age</th><th>Qualification</th><th>Percentage</th><th>Year Passed</th><th>Edit</th><th>Delete</th></tr>");

        for(Student student : list){  
            out.println("<tr>");
            out.println("<td>" + student.getStudentId() + "</td>");
            out.println("<td>" + student.getStudentName() + "</td>");
            out.println("<td>" + student.getStudentAddr() + "</td>");
            out.println("<td>" + student.getAge() + "</td>");
            out.println("<td>" + student.getQualification() + "</td>");
            out.println("<td>" + student.getPercentage() + "</td>");
            out.println("<td>" + student.getYearPassed() + "</td>");
            out.println("<td><a href='editStudent?stdId=" + student.getStudentId() + "' class='edit'>Edit</a></td>");
            out.println("<td><a href='deleteStudent?stdId=" + student.getStudentId() + "' class='delete'>Delete</a></td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

        out.close();  
    }
}
