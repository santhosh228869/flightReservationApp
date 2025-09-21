<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlightDetail</title>
</head>
<body>
<h2>Flight Detail</h2>

FlightNumber :${flight.flightNumber}<br>
Airline		 :${flight.operatingAirline}<br>
DepartureCity:${flight.departureCity}<br>
ArrivalCity  :${flight.arrivalCity}<br>
DepartureTime:${flight.estimatedDepartureTime}<br>
<h2>Passenger Detail</h2>
<form action="ConfirmReservation" method="post">
<table>
<tr>
<td>First Name</td>
<td><input type="text" name="firstName"/></td>
</tr>
<tr>
<td>Middle Name</td>
<td><input type="text" name="middleName"/></td>
</tr>
<tr>
<td>Last Name</td>
<td><input type="text" name="lastName"/></td>
</tr>
<tr>
<td>Email</td>
<td><input type="text" name="email"/></td>
</tr>
<tr>
<td>Phone No</td>
<td><input type="text" name="phoneNo"/></td>
</tr>
<tr>
<td><input type="hidden" name="flightId" value="${flight.id}"/></td>
</tr>
<tr><h2>Enter The Payment Detail</h2></tr>
<tr>
<td> Name on the card</td>
<td><input type="text" name="nameOfTheCard"/></td>
</tr>
<tr>
<td>Card Number</td>
<td><input type="text" name="cardNumber"/></td>
</tr>
<tr>
<td>Cvv</td>
<td><input type="text" name="cvv"/></td>
</tr>
<tr>
<td>Expiry Date</td>
<td><input type="text" name="expiryDate"/></td>
</tr>
<tr>
<td>Amount</td>
<td><input type="text" name="amount"/></td>
</tr>
<tr>
<td><input type="submit" value="Complete Reservation"/></td>
</tr>

</table>
</form>


</body>
</html>