<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Del Luna Management</title>
        <!--java Script-->
        <script src="${pageContext.request.contextPath}/JavaScript/ManagementCode.js"></script>
        <!-- Bootstrap -->
        <link href="${pageContext.request.contextPath}/Bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/CSS/ManagementStyle/OrderWaitStyle.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/CSS/ManagementStyle/MenuStyle.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="row main">
            <jsp:include page="Menu.jsp"></jsp:include>

                <div class="col-md-10 right">
                    <div class="row title">
                        <div class="col-md-4">
                            <h3><span class="glyphicon glyphicon-align-justify"></span>Information Of Customer</h3>
                        </div>
                        <div class="col-md-4 Search">
                            <span class=" glyphicon glyphicon-search"></span> <input type="text" placeholder="Search">
                        </div>
                    </div>
                    <div class="row information">
                        <div class="Banner">
                            <ul>
                                <li>
                                    <a  href="InformationOfCustomerWait">Orders Wait</a>
                                </li>
                                <li><a 
                                    <c:if test="${title eq \"hadRoom\"}">
                                        style="background-color: #e9d1d1; color: red; padding: 3%;"
                                    </c:if>
                                    href="InformationOfCustomerHadRoom">Orders Have Room</a>
                            </li>
                        </ul>
                    </div>
                    <div class="content col-md-8">
                        <table>
                            <tr>
                                <td>Customer Name</td>
                                <td>Phone Number</td>
                                <td>No Of Rooms</td>
                                <td>Room Type</td>
                                <td>Check-in</td>
                                <td>Check-out</td>
                                <td>Rented</td>
                                <td>Details</td>
                            </tr>
                            <c:forEach items="${orders}" var="o">
                                <tr>
                                    <td>${o.customer.customerName}</td>
                                    <td>${o.customer.phone}</td>
                                    <td>${o.noOfRoom}</td>
                                    <td>${o.department.deptName}</td>
                                    <td>${o.checkIn}</td>
                                    <td>${o.checkOut}</td>
                                    <td>${o.isRented()?"Yes":"No"}</td>
                                    <td><a href="ChangeInformationOfCustomer?orderWaitID=${o.orderWaitID}">Details</a></td>
                                </tr>
                            </c:forEach>
                        </table>

                        <div id="paggingBottom" class="pageLine" style=" margin: 1%; float: right;">
                        </div>
                        <script>
                            generatePagger('paggingBottom',${requestScope.pageIndex},${requestScope.totalPage}, '${requestScope.url}', 2);
                        </script>
                    </div>
                    <c:if test="${o != null}">
                        <div class="detail col-md-4">
                            <form action="ChangeInformationOfCustomer" method="POST">
                                <c:if test="${flag eq \"false\"}">
                                    <p style="color: red;">Please check the room. The number of rooms is
                                        different from the number of rooms the customer wants!</p>
                                    </c:if>
                                <table>
                                    <tr>
                                        <td><input type="hidden" name="oID" value="${o.orderWaitID}"></td>
                                        <td><input type="hidden" name="customerID" value="${o.customer.customerID}"></td>
                                    </tr>
                                    <tr>
                                        <td>Name:</td>
                                        <td class="up"><input name="customerName" type="text" value="${o.customer.customerName}"></td>
                                    </tr>
                                    <tr>
                                        <td>Phone:</td>
                                        <td class="up"><input name="phone" type="text" value="${o.customer.phone}"></td>
                                    </tr>
                                    <tr>
                                        <td>Email:</td>
                                        <td class="up"><input name="email" type="text" value="${o.customer.email}"></td>
                                    </tr>
                                    <tr>
                                        <td>Check-in:</td>
                                        <td class="up"><input name="checkIn" type="date" value="${o.checkIn}"></td>
                                    </tr>
                                    <tr>
                                        <td>Check-out:</td>
                                        <td class="up"><input name="checkOut" type="date" value="${o.checkOut}"></td>
                                    </tr>
                                    <tr>
                                        <td>Room type:</td>
                                        <td class="up">
                                            <select name="deptName">
                                                <c:forEach items="${roomModel}" var="r">
                                                    <option 
                                                        ${r.deptName eq o.department.deptName? "selected=\"selected\"" : ""}
                                                        value="${r.deptName}">${r.deptName}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Number of rooms:</td>
                                        <td class="up">
                                            <select name="noOfRoom">
                                                <option ${o.noOfRoom == 1 ? "selected=\"selected\"" : ""} value="1">1</option>
                                                <option ${o.noOfRoom == 2 ? "selected=\"selected\"" : ""} value="2">2</option>
                                                <option ${o.noOfRoom == 3 ? "selected=\"selected\"" : ""} value="3">3</option>
                                                <option ${o.noOfRoom == 4 ? "selected=\"selected\"" : ""} value="4">4</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Choose room: </td>
                                        <td>
                                            <c:forEach items="${roomByName}" var="r">
                                                <input name="deptID" type="checkbox" 
                                                       ${r.deptID}
                                                       value="${r.deptID}"> ${r.deptID}
                                            </c:forEach>
                                        </td>
                                    </tr>
                                </table>
                                <c:if test="${notic}">
                                    <p style="color: red; font-weight: bold">Insert done!</p>
                                </c:if>
                                <div class="control">
                                    <button class="save" name="update" type="submit">Update</button>
                                    <button class="del" name="delete" type="submit">Delete</button>
                                </div>
                            </form>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
