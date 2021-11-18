<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<h1>Random Picker</h1>
<div id="mainDiv">
    <button id="goBack" onclick="goBack()"><</button>
    <div id="tablesDiv"></div>
    <div id="studentsDiv"></div>
</div>
<button id="startButton">Start !</button>
<p id="count_num"></p>
<p id="resultName"></p>
<script src="script.js"></script>
</body>
</html>