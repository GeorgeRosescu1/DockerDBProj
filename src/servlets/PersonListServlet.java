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
import java.util.ArrayList;

@WebServlet(name = "personListServlet", urlPatterns = "/personListServlet")
public class PersonListServlet extends HttpServlet {

    PersonRepository personRepository = new PersonRepository();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Person> personArrayList = personRepository.getPersonArrayListPost();
        req.setAttribute("listUsers", personArrayList);
        ArrayList<Person> personArrayListM = personRepository.getPersonArrayListMaria();
        req.setAttribute("listUsersMar", personArrayListM);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        System.out.println("Now in PersonListServlet Get Method");


        String str1 = req.getParameter("backBtn");

        System.out.println("backBtn este: " + str1);

        if (req.getParameter("backBtn") != null) {
            servlets.PersonFormServlet personFormServlet = new servlets.PersonFormServlet();
            personFormServlet.doGet(req, resp);
        } else
            requestDispatcher.forward(req, resp);

        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servlets.PersonFormServlet personFormServlet = new servlets.PersonFormServlet();
        personFormServlet.doGet(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
