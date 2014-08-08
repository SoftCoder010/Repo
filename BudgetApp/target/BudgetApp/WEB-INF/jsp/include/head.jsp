<%--
  Created by IntelliJ IDEA.
  User: lapostol
  Date: 8/5/2014
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head></head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
    </script>

    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/bootstrap-combined.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
    <%--<script src="<c:url value='' />"></script>--%>

<script>
    function showInputAccordingly(){
        switch($('#budgetType').val()){
            case "MONTHLY":
                $('.budgetDay2').addClass("hidden");
                $('.budgetMonth').addClass("hidden");
                break;
            case "BI_MONTHLY":
                $('.budgetDay2').removeClass("hidden");
                $('.budgetMonth').addClass("hidden");
                break;
            case "ONE_TIME":
                $('.budgetDay2').addClass("hidden");
                $('.budgetMonth').removeClass("hidden");
                break;
        }
    }
    $(document).ready(function() {

    $('#newCategoryForm').submit(function(event) {
        var name = $('#categoryName').val();
        var allocated_budget = $('#allocatedBudgetValue').val();
        var json = { "name" : name, "allocated_budget" : allocated_budget};
        $.ajax({
            url: $("#newCategoryForm").attr( "action"),
            data: JSON.stringify(json),
            type: "POST",

            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function(category) {
                var respContent = "";
                respContent += "<span class='success'>Category was created: [";
                respContent += category.name + " : ";
                respContent += category.allocated_budget +  "]</span>";
                window.location.href = "${pageContext.request.contextPath}/index.htm";
            }
        });
        event.preventDefault();
    });

        $('#newBudgetForm').submit(function(event) {
            var budgetName = $('#budgetName').val();
            var budgetValue = $('#budgetValue').val();
            var budgetType = $('#budgetType').val();
            var budgetDay1 = $('#budgetDay1').val();
            var budgetDay2 = $('#budgetDay2').val();
            var budgetMonth =  $('#budgetMonth').val();

            var json = { "name" : budgetName, "type" : budgetType, "value" : budgetValue,
                "day1" : "2", "day2" : "1", "month" : "4" };
            alert(JSON.stringify(json));
            $.ajax({
                url: $("#newBudgetForm").attr( "action"),
                data: JSON.stringify(json),
                type: "POST",

                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Accept", "application/json");
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function(budget) {
                    var respContent = "";
                    respContent += "<span class='success'>Budget was created: [";
                    respContent += budget.name + " : ";
                    respContent += budget.value + " : ";
                    respContent += budget.type + " : ";
                    respContent += budget.day1 + " : ";
                    respContent += budget.day2 + " : ";
                    respContent += budget.month +  "]</span>";
                    alert(respContent)
                    window.location.href = "${pageContext.request.contextPath}/index.htm";
                }
            });
            event.preventDefault();
        });



});
</script>
    <title>Home page</title>
</head>
