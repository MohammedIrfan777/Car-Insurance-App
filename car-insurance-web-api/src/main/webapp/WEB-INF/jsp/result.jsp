<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> Insurance details </title>
<link href="/bootstrap.min.css" rel="stylesheet">
    <script src="/jquery-2.2.1.min.js"></script>
    <script src="/bootstrap.min.js"></script>
</head>
<body>
<div>
<div class="container" style="margin:50px">
    <div class="row text-center"><strong>Insurance Details</strong></div>
    <div align="center">
        <table border="1" cellpadding="7">
            <tr>
	             <th><strong>Company Name</strong></th>
	        	 <th><strong>Product Name</strong></th>
		         <th><strong>Amount</strong></th>
		         <th><strong>Model From</strong></th>
		         <th><strong>Model To</strong></th>
		         <th><strong>Brand recovered</strong></th>
		         <th><strong>Tax Percentage</strong></th>
            </tr>
             <c:forEach var="insurance" items="${insuranceData}">
            <tr>
		            <td class="col-md-4 text-center">${insurance.company}</td>
		            <td class="col-md-4 text-center" >${insurance.product}</td>
		            <td class="col-md-4 text-center">${insurance.amount}</td>
		            <td class="col-md-4 text-center">${insurance.modelFrom}</td> 
		            <td class="col-md-4 text-center">${insurance.modelTo}</td> 
		            <td class="col-md-4 text-center">${insurance.brandsCovered}</td> 
		            <td class="col-md-4 text-center">${insurance.taxPercentage}</td>  
            </tr>
        </c:forEach>
        </table>
    </div>
</div>
</div>
</body>
</html>