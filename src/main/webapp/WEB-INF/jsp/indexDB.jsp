<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<head>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/jquery.min.1.10.2.js"></script>
    <title>indexDB</title>
</head>
<body>
this is a jsp page!
<br>
indexDB1
</body>
<script>
    var db;
    var request=window.indexedDB.open("indexDB","001");

    request.onerror=function (ev) {  };


    request.onupgradeneeded=function (ev) {
        console.log("第一次打开该数据库，或者数据库版本发生变化....");
        //建表
        db=ev.target.result;
        if(!db.objectStoreNames.contains("person")){
            db.createObjectStore("person",{keyPath:'id'})
        }
    };

    //链接数据库
    request.onsuccess=function (ev) {
        //可以拿到数据库对象
        db=ev.target.result;
        var trans = db.transaction(["person"],"readwrite");
        var store = trans.objectStore("person");
        store.add({id:3,name:"fff"});
        store.add({id:4,name:"xxx"});
        store.add({id:5,name:"xxx"});
        store.add({id:6,name:"xxx"});

        var readTrans = db.transaction(["person"],"readonly");
        var cursor = readTrans.objectStore("person").openCursor();

        cursor.onsuccess = function(e) {
            var res = e.target.result;
            if (res) {
                console.log("Key"+res.key);
                console.dir("Data"+JSON.stringify(res.value));
                res.continue();
            }
        }
    };

</script>



</html>

