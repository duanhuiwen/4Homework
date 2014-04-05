$(document).ready(function(){
   $("li.remove-button").click(function(event){
	 //$(ul#event.target.id).hide();
	 alert('Target ID in database is: '+event.target.id);
	 var temp = event.target.id;
	 //$("ul#"+temp).empty();
   });
 });