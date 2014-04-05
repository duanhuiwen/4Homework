



<?php
require_once('../classes/SQLQuery.php');
//require_once('../setting/dbsettings.php');
session_start();

$group_id = $_GET['group_id'];
$queryer = new SQLQuery();
if($queryer->isGroupExist($group_id)){
	$_SESSION['loggedin'] = true;
	header( "Location: main.php?group_id=$group_id" ); 
	
	//echo "window.location.href=\"main.php?group_id=".$group_id."\"";
}else if(!$_SESSION['loggedin']){
	header( "refresh:2;url=index.php" ); 
	echo "Access denied! You will be direct to login page in 2 seconds";
}else{
		header( "refresh:2;url=index.php" ); 
	echo "Access denied! You will be direct to login page in 2 seconds";
	
}



?>
