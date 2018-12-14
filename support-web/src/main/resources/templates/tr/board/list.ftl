<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>support</title>
</head>
<body>
<h1>MyTr</h1>
<h2>Board List</h2>
<ul>
<#list boardList as board>
  <li><a href="/tr/boards/${board.id}">${board.title}</a></li>
</#list>
</ul>
</body>
</html>