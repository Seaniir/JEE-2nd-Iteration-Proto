$("#buttonAJAX").click(function (){
    $.get("MyJDBCServlet", function(data, status){
        alert("Data: " + data + "\nStatus: " + status);
    });
})