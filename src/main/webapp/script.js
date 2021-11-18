var tableList;
var nameList;

$( document ).ready(function() {
    $.get("GetTablesServlet", function(data, status){
        tableList = JSON.parse(data);
        tableList.forEach(element => ($("#tablesDiv").append("<button id='"+ element +"' onclick=\"getStudentsName(\'" + element + "\');\">" + element.replace(/tbl/g, "") + "</button>")));
    });
})

$("#startButton").click(function ()
{
    $( "#startButton" ).prop( "disabled", true );
    var timeleft = 3;

    var downloadTimer = setInterval(function function1(){
        document.getElementById("count_num").innerHTML = timeleft +
            " "+"seconds remaining";

        if(timeleft <= 0){
            clearInterval(downloadTimer);
            document.getElementById("count_num").innerHTML = ""
            var random = Math.floor(Math.random() * nameList.length);
            $("#resultName").html(nameList[random]);
            nameList.splice(nameList.indexOf($("#resultName").html()), 1);
            $( "#spanList" ).html( nameList.join(", "));
            $( "#startButton" ).prop( "disabled", false );
        }
        timeleft -= 1;
    }, 1000);
});

function getStudentsName(tableName)
{
    console.log("toz");
    $( "#studentsDiv" ).empty();
    $.ajax({
        url: "MyJDBCServlet",
        data: {
            "tableName": tableName
        },
        type: "POST",
        success: function(response) {
            nameList = JSON.parse(response);
            $( "#studentsDiv" ).append( "<span id='spanList'>" + nameList.join(", ") + "</span>" );
            tableList.forEach(elementName => $("#" + elementName).hide());
            $( "#studentsDiv" ).show();
            $( "#goBack" ).show();
            $( "#startButton" ).show();
        },
        error: function(xhr) {

        }
    });
}

function goBack()
{
    tableList.forEach(elementName => $("#" + elementName).show());
    $( "#studentsDiv" ).hide();
    $( "#goBack" ).hide();
    $( "#startButton" ).hide();
}