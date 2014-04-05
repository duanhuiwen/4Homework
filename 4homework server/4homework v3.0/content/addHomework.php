<?php
session_start();
require_once('../classes/Group.php');
require_once('../classes/Homework.php');
require_once('../classes/SQLQuery.php');
if(!$_SESSION['loggedin']){
	header( 'Location: check_auth.php' );
}
$title  = $_POST['title'];
$group_id = $_POST['group_id'];
$due = $_POST['due'];
$desc = $_POST['desc'];
$author = $_POST['author'];
$key = $_POST['key'];

$homework = new Homework();
$homework->setHomework($title,$due,$desc,$key,$author,$group_id);
 $group_id;
header( "Location:main.php?group_id=$group_id" ); 
?>
