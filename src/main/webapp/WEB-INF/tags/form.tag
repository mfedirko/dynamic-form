<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@tag description="Dynamic form template" pageEncoding="UTF-8"%>
<%@tag import="com.example.exmpl1.presentation.forms.BaseForm" %>

<%@ attribute name="model" required="true" type="com.example.exmpl1.presentation.forms.BaseForm"%>
<%@ attribute name="modelAttrName" required="true" type="java.lang.String" %>
<%@ attribute name="action" required="true" type="java.lang.String" %>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<table>
<springForm:form action="${action}" cssClass="" modelAttribute="${modelAttrName}" method="post" >

    <c:forEach var="rowData" items="${model.fieldLayout()}">
        <div class="row">
            <c:forEach var="cellData" varStatus="loop" items="${rowData}" >
                <div class="col">
                <c:if test="${cellData != null}">
                        <c:set var="fld" value="${cellData}"/>
                        <label class="fieldLabel" for="${fld}"><spring:message code="${model.getLabelCode(fld)}" text="${fld}"/> </label>
                        <c:set var="fieldType" value="${model.getFieldDetail(fld).getFieldType()}"/>
                        <c:set var="isRequired" value="${model.getFieldDetail(fld).isRequired()}"/>
                        <c:set var="requiredAttr" value="${isRequired ? 'required' : ''}"/>
                        <c:if test="${isRequired}">
                            <span ><font style="color: red;">* </font></span>
                        </c:if>
                        <c:choose>
                            <c:when test="${fieldType == 'TEXT'}">
                                <springForm:input cssClass="form-control" required="${requiredAttr}" path="${fld}" />
                            </c:when>
                            <c:when test="${fieldType == 'TEXT_AREA'}">
                                <springForm:textarea cssClass="form-control" required="${requiredAttr}" path="${fld}" />
                            </c:when>
                            <c:when test="${fieldType == 'NUMBER'}">
                                <springForm:input cssClass="form-control" type="number"  required="${requiredAttr}" path="${fld}" />
                            </c:when>
                            <c:when test="${fieldType == 'CHECKBOX'}">
                                <springForm:checkbox cssClass="form-control" required="${requiredAttr}" path="${fld}" />
                            </c:when>
                            <c:when test="${fieldType == 'SELECT_OPTIONS'}">
                                <springForm:select cssClass="form-control" required="${requiredAttr}" path="${fld}">
                                    <springForm:options items="${model.getField(fld).values()}" itemLabel="labelName" />
                                </springForm:select>
                            </c:when>
                            <c:when test="${fieldType == 'PASSWORD'}">
                                <springForm:input cssClass="form-control" required="${requiredAttr}" path="${fld}" type="password"/>
                            </c:when>
                        </c:choose>

                        <springForm:errors path="${fld}"/>
                </c:if>
                </div>


            </c:forEach>
        </div>

    </c:forEach>

<div class="row">
    <div class="col">
    <button class="btn btn-primary" type="submit">Submit</button>
    </div>
</div>
</springForm:form>
</table>

</body>
</html>