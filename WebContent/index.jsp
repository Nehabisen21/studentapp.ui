<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Student Registration</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Roboto', sans-serif;
        }

        body {
            background: #f0f4f8;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .form-container {
            background: #ffffff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px;
        }

        h1 {
            text-align: center;
            margin-bottom: 25px;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            font-weight: 600;
            margin-bottom: 5px;
            color: #444;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 14px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 12px;
            width: 100%;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1>Student Registration</h1>
        <form action="registrationController" method="post">
            <div class="form-group">
                <label for="fullname">Student Name</label>
                <input type="text" name="fullname" id="fullname"/>
            </div>
            <div class="form-group">
                <label for="address">Student Address</label>
                <input type="text" name="address" id="address"/>
            </div>
            <div class="form-group">
                <label for="age">Student Age</label>
                <input type="text" name="age" id="age"/>
            </div>
            <div class="form-group">
                <label for="qual">Student Qualification</label>
                <input type="text" name="qual" id="qual"/>
            </div>
            <div class="form-group">
                <label for="percent">Student Percentage</label>
                <input type="text" name="percent" id="percent"/>
            </div>
            <div class="form-group">
                <label for="yop">Year Passed</label>
                <input type="text" name="yop" id="yop"/>
            </div>
            <input type="submit" value="Register"/>
        </form>
    </div>
</body>
</html>
