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
                <div class="panel-heading">Create category</div>
                <div class="panel-body">
                    <div class=" has-success has-feedback">
                        <div id="categoryFromResponse"></div>
                        <form:form id="newCategoryForm"
                                   action="${pageContext.request.contextPath}/categories/create.json"
                                   commandName="category">
                            <label for="categoryName">Category name</label>
                            <form:input path="name" id="categoryName" class="form-control" cssStyle="height: 40px"
                                        placeholder="Enter category name"></form:input>
                            <label for="allocatedBudgetValue">Budget value</label>
                            <form:input type="text" path="allocated_budget"  class="form-control" cssStyle="height: 40px"
                                        id="allocatedBudgetValue"
                                        placeholder="Enter allocated value"></form:input>
                            <div class="row">
                                <div class="col-md-4">
                                    <form:button class="btn btn-primary btn-block" type="submit">Create</form:button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <a href="${pageContext.request.contextPath}/index.html">Home page</a>
</div>
</body>
</html>