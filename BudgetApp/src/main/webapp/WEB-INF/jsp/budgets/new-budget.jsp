<%--
  Created by IntelliJ IDEA.
  User: lapostol
  Date: 8/5/2014
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/jsp/include/head.jsp" %>
<body>
<div class="container">

    <h1>Manage your budget</h1>
    <%@ include file="/WEB-INF/jsp/include/navigation.jsp" %>

    <div class="row">
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">Create a budget</div>
                <div class="panel-body">
                    <form:form role="form" id="newBudgetForm"
                               action="${pageContext.request.contextPath}/budgets/create.json" commandName="budget">
                        <div class=" has-success has-feedback">
                            <label for="budgetName">Budget name</label>
                            <form:input  path="name" id="budgetName" class="form-control" cssStyle="height: 40px"
                                        placeholder="Enter budget name"></form:input>

                            <label id="lBudgetValue" for="budgetValue">Budget value</label>
                            <form:input type="text" path="value" class="form-control" cssStyle="height: 40px" id="budgetValue"
                                        placeholder="Enter budget value"></form:input>

                            <label  for="budgetType">Budget type</label>
                            <form:select onchange="showInputAccordingly();" path="type" id="budgetType" cssStyle="height: 40px" class="form-control"
                                        placeholder="Enter budget type">
                                    <form:option value="MONTHLY" >Monthly</form:option>
                                    <form:option value="BI_MONTHLY" >Bi-monthly</form:option>
                                    <form:option value="ONE_TIME">One time</form:option>
                            </form:select>

                            <label for="budgetDay1">Budget receiving day1</label>
                            <form:input type="number" min="1" max="31" path="day1" id="budgetDay1"  cssStyle="height: 40px" class="form-control"
                                        placeholder="Day when budget is received"></form:input>

                            <label class="hidden budgetDay2" for="budgetDay2">Budget receiving day1 2</label>
                            <form:input type="number" min="1" max="31" path="day2" id="budgetDay2"  cssStyle="height: 40px" class="form-control hidden budgetDay2"
                                        placeholder="Second day1 when budget is received"></form:input>

                            <label class="hidden budgetMonth" for="budgetMonth">Budget receiving month</label>
                            <form:input type="number" min="1" max="12" path="month" id="budgetMonth" cssStyle="height: 40px" class="form-control hidden budgetMonth"
                                        placeholder="Month when budget is received"></form:input>
                            <div class="row">
                                <div class="col-md-4">
                                    <form:button  class="btn btn-primary btn-block" type="submit">Create</form:button>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>

    </div>

    <a href="${pageContext.request.contextPath}/index.html">Home page</a>

</div>
</body>
</html>