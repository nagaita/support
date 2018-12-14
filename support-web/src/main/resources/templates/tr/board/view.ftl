<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>support</title>
</head>
<body>
<h1>MyTr</h1>
<h2>${board.title}</h2>
<div>
    <a href="/tr/boards/">Back to board list</a>
</div>
<ul>
<#list board.trLists as list>
  <li><p>${list.title}</p>
      <ul>
      <#list list.trCards as card>
          <li>${card.title}</li>
      </#list>
      </ul>
  </li>
</#list>
</ul>
</body>
</html>