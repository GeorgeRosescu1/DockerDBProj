package main.java;

import model.Person;
import servlets.PersonFormServlet;

import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

//        Connection connectionP, connectionM;
//        Scanner scanner = new Scanner(System.in);
//        String firstname = null, lastname = null;
//        int age;
//        String insertQuery;
//        Person person = new Person();
//        int choose;
//        boolean incorrect;
//        incorrect = false;
//        connectionM = null;
//        connectionP = null;
//        age=0;
//        choose=0;
//
//
//        if (age <= 0)
//            age = 1; //by default
//        switch (choose) {
//
//            case 1: { //PostgreSQL
//
//                break;
//            }
//            case 2: { //MariaDB
//                try {
//                    try {
//                        Class.forName("org.mariadb.Driver");
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                    connectionM = DriverManager.getConnection("jdbc:mariadb://localhost:3306/persons", "root", "maria");
//                    Statement statement = connectionM.createStatement();
//                    insertQuery = String.format("INSERT INTO persons (lastname, firstname, age) VALUES ('%s', '%s', %d)", lastname, firstname, age);
//                    statement.execute(insertQuery);
//                    ResultSet resultSet = statement.executeQuery("Select * from persons");
//                    while (resultSet.next()) {
//                        person.setId(resultSet.getInt("id"));
//                        person.setLastName(resultSet.getString("lastname"));
//                        person.setFirstName(resultSet.getString("firstname"));
//                        person.setAge(resultSet.getInt("age"));
//                    }
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                break;
//            }
//            case 3: { //Both
//                try {
//                    try {
//                        Class.forName("org.postgresql.Driver");
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                    try {
//                        Class.forName("org.mariadb.Driver");
//                    } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                    connectionP = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgrdb", "postgrdb", "postgrdb");
//                    Statement statement = connectionP.createStatement();
//                    insertQuery = String.format("INSERT INTO persons (lastname, firstname, age) VALUES ('%s', '%s', %d)", lastname, firstname, age);
//                    statement.execute(insertQuery);
//                    ResultSet resultSet = statement.executeQuery("Select * from persons");
//                    while (resultSet.next()) {
//                        person.setId(resultSet.getInt("id"));
//                        person.setLastName(resultSet.getString("lastname"));
//                        person.setFirstName(resultSet.getString("firstname"));
//                        person.setAge(resultSet.getInt("age"));
//                    }
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//
//                try {
//                    connectionM = DriverManager.getConnection("jdbc:mariadb://localhost:3306/persons", "root", "maria");
//                    Statement statement = connectionM.createStatement();
//                    insertQuery = String.format("INSERT INTO persons (lastname, firstname, age) VALUES ('%s', '%s', %d)", lastname, firstname, age);
//                    statement.execute(insertQuery);
//                    ResultSet resultSet = statement.executeQuery("Select * from persons");
//                    while (resultSet.next()) {
//                        person.setId(resultSet.getInt("id"));
//                        person.setLastName(resultSet.getString("lastname"));
//                        person.setFirstName(resultSet.getString("firstname"));
//                        person.setAge(resultSet.getInt("age"));
//                    }
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//
//                break;
//            }
//            default:
//                incorrect = true;
//                System.out.println("Incorrect input!");
//                break;
//        }
//        if (incorrect == false)
//            System.out.println(person.getId() + ". " + person.getLastName() + " " + person.getFirstName() + " aged: " + person.getAge());

    }
}