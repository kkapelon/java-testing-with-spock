<#include "../common/header.html" parse=false>
<#include "../common/nav.ftl">

<div class="colmask leftmenu">
	<div class="colleft">
		<div class="col1">
			<!-- Column 1 start -->
			<h2>Current products in the warehouse</h2>
			


<p>There are ${allProducts?size} products now.</p>
			
			<table border="1" align="left" width="100%">
			<tr><th>Name</th><th>Price</th><th>Weight</th><th>Stock level</th></tr>
    <#list allProducts as product>
    
    <tr>
        <td>${product.name}</td>
        <td>${product.price}</td>
        <td>${product.weight}</td>
        <td>${product.stock}</td>
    </tr>
    </#list>
    </table>
					
			
			
			<!-- Column 1 end -->
		</div>
		<div class="col2">
		<#include "../common/sidebar.ftl">
		</div>
	</div>
</div>
<#include "../common/footer.html" parse=false>

