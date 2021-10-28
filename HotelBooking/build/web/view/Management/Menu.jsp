<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-2 left">
    <div>
        <p><i class="glyphicon glyphicon-certificate"></i>Del Luna</p>
    </div>
    <div>
        <ul>
            <li><a 
                    <c:if test="${tagMenu eq \"home\"}">
                        style="background-color: gray; color: white;padding: 3%;"
                    </c:if>
                    href="Home"><span class="glyphicon glyphicon-home"></span> Home</a></li>
            <li><a 
                    <c:if test="${tagMenu eq \"check-rent\"}">
                        style="background-color: gray; color: white;padding: 3%;"
                    </c:if>
                    href="RoomEmpty"><span class="glyphicon glyphicon-refresh"></span> Rent - Check out</a></li>
            <li><a 
                    <c:if test="${tagMenu eq \"order\"}">
                        style="background-color: gray; color: white;padding: 3%;"
                    </c:if>
                    href="InformationOfCustomerWait"><span class="glyphicon glyphicon-user"></span> Information Of Customer</a></li>
            <li><a
                    <c:if test="${tagMenu eq \"xxx\"}">
                        style="background-color: gray; color: white;padding: 3%;"
                    </c:if>
                    href="#"><span class="glyphicon glyphicon-play-circle"></span> Booking History</a></li>
            <li><a href="../login"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
        </ul>
    </div>
</div>


