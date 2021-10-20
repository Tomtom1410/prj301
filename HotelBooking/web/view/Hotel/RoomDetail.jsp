<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Hotel Del Luna</title>
        <script src="mycode.js"></script>
        <!-- Bootstrap && CSS-->
        <link href="${pageContext.request.contextPath}/Bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/CSS/HotelStyle/RoomDetailStyle.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/CSS/HotelStyle/FooterStyle.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/CSS/HotelStyle/HeaderStyle.css" rel="stylesheet" type="text/css"/>

    <body>

        <div class="container">
            <jsp:include page="Header.jsp"></jsp:include>
                <div class="Banner">
                    <p>Room Detail</p>
                </div>

                <!-- Slider Content-->
                <div class="row">
                    <div class="col-md-7 col-sm-12 slide">
                        <!-- slider Start-->
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <!-- Wrapper for slides -->
                            <div class="carousel-inner">
                                <div class="item active img-responsive">
                                    <img src="${url_image}" alt="#">
                            </div>
                            <c:forEach items="${room.url}" var="u">
                                <div class="item img-responsive">
                                    <img src="${u}" alt="#">
                                </div>
                            </c:forEach>
                        </div>

                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>
                    </div>
                    <div class="content">
                        <h1>${room.deptName}</h1>
                        <p class="Price">Price: ${room.price} / Day</p>
                        <p>Hotel Del Luna is a motel established in 20xx with 60 rooms of different sizes to suit many needs of customers. System of modern equipment, air-conditioner,
                            television, wooden tables and chairs, wifi wave and shuttle services to tourist attractions. Designed and decorated in a luxurious and noble style. 
                            The equipment and rooms of the motel - hotel are very comfortable and modern to bring satisfaction and comfort to customers during their
                            stay at the hotel room.
                        </p>
                    </div>
                </div>
                <!--slider end-->

                <div class="col-md-3 col-sm-12 booking">
                    <form action="">
                        <table>
                            <tr>
                                <td>Booking now</td>
                            </tr>
                            <tr>
                                <td><input class="in" type="text" placeholder="Name"></td>
                            </tr>
                            <tr>
                                <td><input class="in" type="text" placeholder="Phone Number"></td>
                            </tr>
                            <tr>
                                <td><input class="in" type="text" placeholder="E-mail:"></td>
                            </tr>
                            <tr>
                                <td>
                                    <select class="in" name="" id="">
                                        <option value="">Number of rooms</option>
                                        <option value="">1</option>
                                        <option value="">2</option>
                                        <option value="">3</option>
                                        <option value="">4</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                            <tr>
                                <td>Check-in:</td>
                            </tr>
                            <td><input class="in" type="date" placeholder="E-mail:"></td>
                            </tr>

                            <tr>
                            <tr>
                                <td>Check-out:</td>
                            </tr>
                            <td><input class="in" type="date" placeholder="E-mail:"></td>
                            </tr>


                            <tr>
                                <td><button type="submit">Booking</button></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
            <jsp:include page="Footer.jsp"></jsp:include>
            </div>
            <!-- contianer end-->

            <!--javascript of Bootstrap-->
            <script src="${pageContext.request.contextPath}/Bootstrap/js/Jquery.js"></script>
        <script src="${pageContext.request.contextPath}/Bootstrap/js/bootstrap.min.js"></script>


    </body>

</html>