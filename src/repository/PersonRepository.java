package repository;

import com.sun.tools.javac.util.List;
import main.java.connection.DBConnector;
import main.java.repository.Repository;
import model.Person;
import utils.MyConstants;

import java.sql.*;
import java.util.ArrayList;

public class PersonRepository implements Repository<Person> {

    MyConstants constants = MyConstants.getInstance();
    Connection connectionP; //PostgreSQL Connection
    Connection connectionM; //MariaDB Connection

    private ArrayList<Person> personArrayListPost;
    private ArrayList<Person> personArrayListMaria = new ArrayList<>();

    public ArrayList<Person> getPersonArrayListPost() {
        personArrayListPost = new ArrayList<>();
        this.get("select * from persons", 1);
        return personArrayListPost;
    }

    public ArrayList<Person> getPersonArrayListMaria() {
        this.get("select * from persons", 2);
        return personArrayListMaria;
    }

    public void setPersonArrayListMaria(ArrayList<Person> personArrayListMaria) {
        this.personArrayListMaria = personArrayListMaria;
    }

    @Override
    public void insert(Person obj, int db) {
        Person person = (Person) obj;
        String lastName;
        String firstName;
        String insertQuery;
        try {
            connectionP = DBConnector.getConnectionP();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connectionM = DBConnector.getConnectionM();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int age;

        lastName = person.getLastName();
        firstName = person.getFirstName();
        age = person.getAge();
        System.out.println("Database selected:" + db);
        if (person.getFirstName().equals("") || person.getLastName().equals("") || person.getLastName().equals(null) || person.getFirstName().equals(null))
            System.out.println("Invalid data!");
        else
            switch (db) { //PostgreSQL
                case 1: {
                    try {
                        System.out.println(connectionP);
                        Statement statement = connectionP.createStatement();
                        insertQuery = String.format("INSERT INTO persons (lastname, firstname, age) VALUES ('%s', '%s', %d)", lastName, firstName, age);
                        statement.execute(insertQuery);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 2: //MariaDB
                {
                    try {
                        Statement statement = connectionM.createStatement();
                        insertQuery = String.format("INSERT INTO persons (lastname, firstname, age) VALUES ('%s', '%s', %d)", lastName, firstName, age);
                        statement.execute(insertQuery);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    break;
                }
                case 3: //Both
                {
                    try {
                        System.out.println(connectionP);
                        Statement statement = connectionP.createStatement();
                        insertQuery = String.format("INSERT INTO persons (lastname, firstname, age) VALUES ('%s', '%s', %d)", lastName, firstName, age);
                        statement.execute(insertQuery);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        Statement statement = connectionM.createStatement();
                        insertQuery = String.format("INSERT INTO persons (lastname, firstname, age) VALUES ('%s', '%s', %d)", lastName, firstName, age);
                        statement.execute(insertQuery);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }


                    break;
                }
                default:
                    System.out.println(constants.INVALID_DATABASE);
                    break;
            }
    }

    @Override
    public Person get(String query, int db) {
        int id;
        String lastName;
        String firstName;
        int age;
        String insertQuery;

        try {
            connectionP = DBConnector.getConnectionP();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connectionM = DBConnector.getConnectionM();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        switch (db) { //PostgreSQL
            case 1: {
                try {
                    System.out.println("Now in get Postgr");
                    Statement statement = connectionP.createStatement();
                    ResultSet resultSet = statement.executeQuery("Select * from persons where lastname <> ''");
                    System.out.println("Passed the select");

                    while (resultSet.next()) {
                        Person person = new Person();
                        person.setId(resultSet.getInt("id"));
                        System.out.println("ID: " + person.getId());
                        person.setLastName(resultSet.getString("lastname"));
                        System.out.println("LastName: " + person.getLastName());
                        person.setFirstName(resultSet.getString("firstname"));
                        person.setAge(resultSet.getInt("age"));
                        personArrayListPost.add(person);
                        System.out.println(person.getId() + " " + person.getFirstName());
                    }
                    System.out.println("List:");
                    for (int i = 0; i < personArrayListPost.size(); i++)
                        System.out.println(personArrayListPost.get(i).getId() + " " + personArrayListPost.get(i).getLastName());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 2: //MariaDB
            {
                try {
                    System.out.println("Now in get Maria");
                    Statement statement = connectionM.createStatement();
                    ResultSet resultSet = statement.executeQuery("Select * from persons where lastname <> ''");
                    while (resultSet.next()) {
                        Person person = new Person();
                        person.setId(resultSet.getInt("id") - 10);
                        person.setLastName(resultSet.getString("lastname"));
                        person.setFirstName(resultSet.getString("firstname"));
                        person.setAge(resultSet.getInt("age"));
                        personArrayListMaria.add(person);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
            default: // no other option
                System.out.println(constants.INVALID_DATABASE);
                break;
        }
        return null;
    }

    @Override
    public List<Person> getAll(int db) {
        return null;
    }
}
