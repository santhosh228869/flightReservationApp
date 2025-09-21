<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Flight</title>
</head>
<body>
	<h2>Flight Search Result</h2>


	<table border="1">
		<tr>
			<th>Airline</th>
			<th>departureCity</th>
			<th>arrivalCity</th>
			<th>DepartureTime</th>
			<th>SelectFlight</th>
		</tr>
		<c:forEach items="${findFlights}" var="findFlights">
			<tr>
				<td>${findFlights.operatingAirline}</td>
				<td>${findFlights.departureCity}</td>
				<td>${findFlights.arrivalCity}</td>
				<td>${findFlights.estimatedDepartureTime}</td>
				<td><a href="showCompleteReservation?flightId=${findFlights.id}">Select</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>