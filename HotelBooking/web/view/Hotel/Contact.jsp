<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Hotel Del Luna</title>
        <!--<script src="mycode.js"></script>-->
        <!-- Bootstrap -->
        <link href="${pageContext.request.contextPath}/Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!--CSS-->
        <link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/CSS/ContactStyle.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/CSS/FooterStyle.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/CSS/HeaderStyle.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>

        <div class="container">
            <!--Nội dung Menu-->
            <jsp:include page="Header.jsp"></jsp:include>
                <div class="Banner">
                    <p>Contact US</p>
                </div>
                <!-- Contact -->
                <div class="row Contact">
                    <div class="col-md-8">
                        <form action="">
                            <h2>Comment Or Complaints To Us</h2>
                            <table>
                                <tr>
                                    <td><input type="text" placeholder="Fullname"></td>
                                </tr>
                                <tr>
                                    <td><input type="text" placeholder="Email"></td>
                                </tr>
                                <tr>
                                    <td><input type="text" placeholder="Number phone"></td>
                                </tr>
                                <tr>
                                    <td><input type="text" placeholder="Address"></td>
                                </tr>
                                <tr>
                                    <td><textarea cols="55" rows="8" placeholder="Comment"></textarea></td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="submit" value="Send">
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>

                    <div class="col-md-4">
                        <h1>Contact Information </h1>
                        <h3>DEL LUNA HOTEL</h3>
                        <p><span class="glyphicon glyphicon-earphone"></span> Phone : 09xxxxxxxx</p>
                        <p> <span class="glyphicon glyphicon-equalizer"></span> Address : 50-82 Bui Vien Street, <br> Pham Ngu Lao Ward, District 1, Ho Chi Minh City Copyright. <br> All rights Reserved.
                        </p>
                        <p><span class="glyphicon glyphicon-envelope"></span> Email: Delluna@gamil.com</p>
                    </div>
                </div>
            <jsp:include page="Footer.jsp"></jsp:include>
        </div>

    </body>

</html>