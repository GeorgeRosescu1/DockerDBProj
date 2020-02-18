package servlets;

import model.Person;
import repository.PersonRepository;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "personServlet", urlPatterns = "/personServlet")
public class PersonFormServlet extends HttpServlet {


    PersonRepository personRepository = new PersonRepository();
    servlets.PersonListServlet personListServlet = new servlets.PersonListServlet();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("index.jsp");
        String str1 = req.getParameter("listBtn");
        System.out.println("Now in PersonServlet Get Method");
        System.out.println("listBtn este: " + str1);
        if (req.getParameter("listBtn") != null) {
            servlets.PersonListServlet personListServlet = new servlets.PersonListServlet();
            personListServlet.doGet(req, resp);
        } else
            requestDispatcher.forward(req, resp);
        ;
        printWriter.close();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String age = req.getParameter("age");
        System.out.println("Now in PersonServlet Post Method");
        String database = req.getParameter("database");
        System.out.println(database);
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAge(Integer.valueOf(age));

        if (database.equals("PostgreSQL")) { //PostgreSQL
            personRepository.insert(person, 1);
        } else if (database.equals("MariaDB")) { //MariaDB
            System.out.println("Now write in MariaDB");
            personRepository.insert(person, 2);
        } else { //Both

        }
        doGet(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
