<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Form</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="form_box">
        <p align="center" style="font-size:25px" >Please introduce user data below</p>

        <div align="center" style="text-align:center">
            <form name="personForm" method="POST" action="personServlet">
                First Name:<br>
                <input type="text" align="center" name="firstName" style="text-align: left"/> <br/>
                Last Name:<br>
                <input type="text" align="center" name="lastName" style="text-align: left"/> <br/>
                Age:
                <select name="age" class="age_txt" style="text-align: left;">
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="24">24</option>
                    <option value="28">28</option>
                    <option value="29">29</option>
                    <option value="32">32</option>
                    <option value="35">35</option>
                    <option value="38">38</option>
                    <option value="41">41</option>
                    <option value="45">45</option>
                    <option value="51">51</option>
                    <option value="54">54</option>
                    <option value="57">57</option>
                    <option value="64">64</option>
                    <option value="65">65</option>
                    <option value="72">72</option>
                    <option value="91">91</option>
                </select>
                Database to write:
                <select name="database">
                    <option value="PostgreSQL">PostgreSQL</option>
                    <option value="MariaDB">MariaDB</option>
                    <option value="Both">Both</option>
                </select>

                <input type="submit" class="btn" value="Register" align="center" name="submitBtn"/>

                <input type="submit" class="btn" align="center" name="listBtn" value="List Users" />
            </form>
        </div>

    </div>

</body>
</html>