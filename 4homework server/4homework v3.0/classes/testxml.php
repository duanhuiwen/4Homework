<?php


require_once('../classes/Group.php');
require_once('../classes/Homework.php');
require_once('../classes/SQLQuery.php');
$group_id = "TJ10S1";
	$group = new Group($group_id);
	$list = $group->getHomeworksByGroup();
	$xml = new DomDocument('1.0','UTF-8');
	$xml->formatOutput =true;
	$root = $xml->createElement('root');
		
	$xml->appendChild($root);
    for($i = 1; $i <= count($list); ++$i) {
    $homework = $xml->createElement("homework");
    $homework = $root->appendChild($homework);
    $homework->appendChild($xml->createElement('homework_id',$list[$i]['homework_id']));
    $homework->appendChild($xml->createElement('title', $list[$i]['title']));
    $homework->appendChild($xml->createElement('due_date', $list[$i]['due_date']));
    $homework->appendChild($xml->createElement('description', $list[$i]['description']));
    $homework->appendChild($xml->createElement('author', $list[$i]['author']));
    


    }
  
	
	
	echo header("Content-type:application/xml");

	echo $xml->saveXML();
?>
