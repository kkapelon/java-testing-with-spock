<#include "../common/header.html" parse=false>
<#include "../common/nav.ftl">

<div class="colmask leftmenu">
	<div class="colleft">
		<div class="col1">
			<!-- Column 1 start -->
			<h2>New Product details</h2>
			<form method="post" action="add-product.html">
			
			<#if (errors??)>
			<p class="error">
			${errors}
			</p>
			</#if>
			<#if (success??)>
			<p><span class="ok">
			${success}.</span>  See <a href="products.html">all products</a>
			</p>
			</#if>
			
			<p>Please fill in the following properties:</p>
			Name: <input size="30" name="productName"  value="${productName}" />
			</p>
			<p>
			Price: <input size="7" name="productPrice" value="${productPrice}" />
			</p>
			
			<input id="createProductButton" type="submit" value="Add this product"/>
			</form>



			
			
			
			<!-- Column 1 end -->
		</div>
		<div class="col2">
		<#include "../common/sidebar.ftl">
		</div>
	</div>
</div>
<#include "../common/footer.html" parse=false>

