<?php
require("../classes/Homework.php");
require("../classes/Group.php");
require("../classes/SQLQuery.php");


$title = $_POST['title'];
$due = $_POST['due'];
$desc = $_POST['desc'];
$key = $_POST['key'];
$author = $_POST['author'];
$groupID = $_POST['groupID'];

if (isset($title) && isset($due) && isset($desc) && isset($key) && isset($author) && isset($groupID)){
	$homework = new Homework();
	$homewrok->setHomework($title,$due,$description,$key,$author,$group_id);
}

?>