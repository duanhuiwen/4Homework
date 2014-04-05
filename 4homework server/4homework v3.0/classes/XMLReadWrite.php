<?php
/*
 * Used to create XML files for the phone and reads the XML which comes from the phone.
 */

class XMLReadWrite{

static function writeXml($group_id){
	$group = new Group($group_id);
	$list = $group->getHomeworksByGroup();
	$xml = new DomDocument();
$xml->xmlStandalone = false;
	$xml->formatOutput =true;
	$root = $xml->createElement('root');
		
	$xml->appendChild($root);
    for($i = 0; $i < count($list); $i++) {
    $homework = $xml->createElement("homework");
    $homework = $root->appendChild($homework);
    $homework->appendChild($xml->createElement('homework_id',$list[$i]['homework_id']));
    $homework->appendChild($xml->createElement('title', $list[$i]['title']));
	
    $homework->appendChild($xml->createElement('due_date', substr($list[$i]['due_date'], 0, 10)));
     $homework->appendChild($xml->createElement('due_date_time', substr($list[$i]['due_date'],11,18)));
    $homework->appendChild($xml->createElement('description', $list[$i]['description']));
    $homework->appendChild($xml->createElement('author', $list[$i]['author']));
    }
  	return $xml->saveXML();
	}//end of function writexml
	
	
function readXml($xml){
	
}//end of function readxml

}//end of class
?>
