<html>
<head>
    <title>Insurance Details App</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<script type="text/javascript">
function submit() {
    var url = window.location.origin +'/searchdata';
    var isValid = isValidate();
	 if(!isValid) {
	    $.ajax({
        	      type: 'post',
        	      url: url,
        	      data: {
        	        prodName: $('#cars').val(),
        	        modelFrom: parseInt($('#modelFrom').val()),
        	        modelTo: parseInt($('#modelTo').val()),
        	        brands: $('#brands').val(),
        	      },
        	      success: function (response) {
        	    	  $('#result').show();
        	    	  var tr = "";
        	    	  if(response == null || response == undefined || response.length == 0) {
        	    		  tr += "<tr><td colspan='9'>No data available.</td></tr>"
        	    	  }
        	    	  $.each( response, function( key, value ) {
        	    		  tr += '<tr><td class="col-md-4 text-center">' + value.Company + '</td>';
        	    		  tr += '<td class="col-md-4 text-center">' + value.Product + '</td>';
        	    		  tr += '<td class="col-md-4 text-center">' + value.Amount + '</td>';
        	    		  tr += '<td class="col-md-4 text-center">' + value.ModelFrom + '</td>';
        	    		  tr += '<td class="col-md-4 text-center">' + value.ModelTo + '</td>';
        	    		  tr += '<td class="col-md-4 text-center">' + value.BrandsCovered + '</td>';
        	    		  tr += '<td class="col-md-4 text-center">' + value.TAXPercentage + '</td>';
        	    		  tr += '<td class="col-md-4 text-center">' + (value.Amount +(value.Amount * value.TAXPercentage/100)) + '</td>';
        	    		  tr += '<td class="col-md-4 text-center">' + value.takaful + '</td></tr>';
        	    		});
        	    	  $('#products').html(tr);

        	      },
        	      error: function () {
        	        alert("error");
        	      }
        	   });
	 }
}

function isValidate() {

	         var isModelFrom = false;
	         var isModelTo = false;
	         var isBrandsEmpty = false;

             if($('#modelFrom').val() == "select") {
                alert("Select Model from");
                isModelFrom = true;
             }
             if($('#modelTo').val() == "select") {
                  alert("Select Model to");
                  isModelTo = true;
              }
             if($('#brands').val() == "select") {
                  alert("Select Brands covered");
                  isBrandsEmpty = true;
              }
              if($('#modelFrom').val() != "select" && $('#modelTo').val() != "select" && $('#brands').val() != "select") {
                isModelFrom = false;
                isModelTo = false;
                isBrandsEmpty = false;
              }

              if(isModelFrom || isModelTo || isBrandsEmpty) {
                return true
              }else {
                return false;
              }
	   }
</script>
<div class="container" style="margin:50px">
<div class="row text-center"><p>Please select insurance details :</p></div>
    <div class="row text-center">
        <table>
        	<tr><td>Select Product Name</td>
        	<td> 
        	<select id="cars">
			  <option value="carInsurance">Car Insurance</option>
			</select>
        	</td>
        	</tr>
        	<tr><td>Model From</td>
        	<td> 
        		<select id="modelFrom">
        			<option value="select">Select model from</option>
			  		<option value="1999">1999</option>
			  		<option value="2000">2000</option>
			  		<option value="2002">2002</option>
			  		<option value="2003">2003</option>
			  		<option value="2004">2004</option>
			  		<option value="2005">2005</option>
			  		<option value="2007">2007</option>
			  		<option value="2010">2010</option>
				</select>
        	</td>
        	</tr>
        	<tr><td>Model To</td>
        	<td> 
        		<select id="modelTo">
        			<option value="select">Select model to</option>
			  		<option value="2015">2015</option>
			  		<option value="2017">2017</option>
			  		<option value="2018">2018</option>
			  		<option value="2020">2020</option>
				</select>
        	</td>
        	</tr>
        	<tr><td>Brands Covered</td>
        	<td> 
        		<select id="brands">
        			<option value="select">Select brands</option>
			  		<option value="Hyundai">Hyundai</option>
			  		<option value="Opel">Opel</option>
			  		<option value="Toyota">Toyota</option>
			  		<option value="Nissan">Nissan</option>
			  		<option value="Fiat">Fiat</option>
			  		<option value="Mercedes">Mercedes</option>
			  		<option value="BMW">BMW</option>
			  		<option value="Peagut">Peagut</option>
			  		<option value="KIA">KIA</option>
			  		<option value="Mitsubishi">Mitsubishi</option>
			  		<option value="Honda">Honda</option>	
				</select>
        	</td>
        	</tr>
        	<tr><td>
        	<button  id="submit" onclick="javascript:submit();">
        	Search
        	</button>
        	</td></tr>
        </table> 
    </div>
    <div id="result" style="display: none;">
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
		         <th><strong>Total Price Include TAX</strong></th>
		         <th><strong>Takaful</strong></th>
            </tr>
             <tbody id="products">
             
             </tbody>
        </table>
    </div>
	</div>
    </div>
</div>
</body>
</html>
