<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>support</title>
</head>
<body>
<h1>support</h1>
<h2>Tasks</h2>
<table>
<thead>
<tr><th>#</th><th>title</th></tr>
</thead>
<tbody>
<#list tasks as task>
<tr><th>${task.id}</th><td>${task.title}</td></tr>
</#list>
</tbody>
</table>
</body>
</html>