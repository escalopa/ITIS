<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Welcome!</title>
    <meta charset="utf-8"/>

</head>
<body>

<script type="application/javascript">
    async function get_cars() {
        let url = 'lab10rest/cars';
        let response = await fetch(url);

        let commits = await response.json(); // читаем ответ в формате JSON

        alert(commits[0].author.login);
    }
</script>

<h1>Welcome</h1>

<div>

<table>
    <#list lstDriver as lst>
        <tr>
            <td>${lst.driver_id}</td><td>${lst.name}</td><td>${lst.model}</td>
        </tr>
    </#list>
</table>
</div>
<p>
</body>
</html>