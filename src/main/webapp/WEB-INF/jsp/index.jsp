<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<head>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/jquery.min.1.10.2.js"></script>
    <title>websql</title>
</head>
<body>
this is a jsp page!
<br>
websql
</body>
<script>
    var db = openDatabase('testDB', '1.0', 'Test DB', 2 * 1024 * 1024);
    db.transaction(function (context) {
                  context.executeSql('CREATE TABLE IF NOT EXISTS testTable (id unique, name)');
                  // context.executeSql('INSERT INTO testTable (id, name) VALUES (0, "Byron")');
                  // context.executeSql('INSERT INTO testTable (id, name) VALUES (1, "Casper")');
                  // context.executeSql('INSERT INTO testTable (id, name) VALUES (2, "Frank")');
               });

    db.transaction(function (context) {
        context.executeSql('delete from testTable');
    });

    /*db.transaction(function (context) {
        context.executeSql('update testTable set name="Frank1" where id=2', [], function (context, results) {

        });
    });*/

    db.transaction(function (context) {
        context.executeSql('SELECT * FROM testTable', [], function (context, results) {
            var len = results.rows.length, i;
            console.log('Got '+len+' rows.');
            for (i = 0; i < len; i++){
                console.log('id: '+results.rows.item(i).id);
                console.log('name: '+results.rows.item(i).name);
            }
        });
    });
</script>



</html>

