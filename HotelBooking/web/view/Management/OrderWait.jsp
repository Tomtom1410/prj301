<%-- 
    Document   : OrderWait
    Created on : Oct 20, 2021, 7:35:21 PM
    Author     : Tom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Del Luna Management</title>
        <script src="mycode.js"></script>
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
                    <div class="content col-md-8">
                        <table>
                            <tr>
                                <td>Customer Name</td>
                                <td>Phone Number</td>
                                <td>No Of Rooms</td>
                                <td>Room Type</td>
                                <td>Check-in</td>
                                <td>Check-out</td>
                                <td>Details</td>

                            </tr>

                            <tr>
                                <td>Mr A</td>
                                <td>01234568</td>
                                <td>4</td>
                                <td>xxx</td>
                                <td>12/12/2012</td>
                                <td>14/12/2012</td>
                                <td><a href="#">Details</a></td>

                            </tr>
                        </table>
                    </div>

                    <div class="detail col-md-4">
                        <form action="">
                            <table>
                                <tr>
                                    <td>Name:</td>
                                    <td class="up"><input type="text" value="Mr A"></td>
                                </tr>
                                <tr>
                                    <td>Phone:</td>
                                    <td class="up"><input type="text" value="01234568"></td>
                                </tr>
                                <tr>
                                    <td>Check-in:</td>
                                    <td class="up"><input type="date" value="12/12/2012"></td>
                                </tr>
                                <tr>
                                    <td>Check-out:</td>
                                    <td class="up"><input type="date" value="14/12/2012"></td>
                                </tr>
                                <tr>
                                    <td>Room type:</td>
                                    <td class="up"><input type="text" value="abc"></td>
                                </tr>
                                <tr>
                                    <td>Choose room: </td>
                                    <td>
                                        <input type="checkbox"> 101
                                        <input type="checkbox"> 102
                                        <input type="checkbox"> 103
                                        <input type="checkbox"> 104
                                        <input type="checkbox"> 105
                                    </td>
                                </tr>
                            </table>

                            <button type="submit">Save</button>
                            <button type="submit">Delete</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
