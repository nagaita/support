<#import "/spring.ftl" as spring>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>support</title>
</head>
<body>
<h1>MyTr</h1>
<h2>Board List</h2>
<@spring.bind "form"/>
<form action="/tr/boards/" method="POST">
    <div>
        Title: <@spring.formInput "form.title"/>
    </div>
    <div>
        Sort order: <@spring.formInput "form.sortOrder" "" "number"/>
    </div>
    <div>
        <input type="submit" value="Submit">
    </div>
</form>
<ul>
<#list boardList as board>
  <li><a href="/tr/boards/${board.id}">${board.title}</a></li>
</#list>
</ul>
</body>
</html>