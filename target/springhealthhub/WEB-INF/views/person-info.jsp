<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>BMI Result</title>
</head>
<body>

<h2>Person Info</h2>

<p>Name: ${person.name}</p>
<p>Year of Birth: ${person.yob}</p>
<p>Weight: ${person.weight} kg</p>
<p>Height: ${person.height} m</p>
<p>BMI: ${person.bmi}</p>
<p>Category: ${person.category}</p>

<hr>
<a href="api/person">View JSON API</a>

</body>
</html>
