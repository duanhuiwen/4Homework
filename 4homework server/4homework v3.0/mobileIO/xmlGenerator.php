<?php
require_once('../classes/Group.php');
require_once('../classes/Homework.php');
require_once('../classes/SQLQuery.php');
require_once('../classes/XMLReadWrite.php');
	$group_id = $_GET['group_id'];
    //$writer = new XMLReadWrite()
	
	
	echo header("Content-type:application/xml");

	echo XMLReadWrite::writeXml($group_id);
?>
