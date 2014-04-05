<?php
class Homework{
	private $homework_id;
	private $title;
	private $due_date;
	private $description;
	private $author;
	private $group_id;
	private $create_date;
	private $key;
	private $attachment; //extra feature 
	private $sqlqueryer;
	
	
	public function __construct($homework_id=0){
		$this->sqlqueryer = new SQLQuery();
		$this->homework_id = $homework_id;
		if($homework_id != 0){
			$temp = $this->sqlqueryer->getHomework($this->homework_id); 
			$this->title = $temp["title"];
			$this->due_date = $temp["due_date"]; //d-m-Y H:i:s
			$this->description = $temp["description"];
			$this->author = $temp["author"];
			$this->group_id =$temp["group_id"];
			$this->key = $temp["key"];
			//$this->attachment = $attachment;
			$this->create_date = $temp["create_date"];
		}
		
		
	}
	
	
	//return the homework info as an array
	public function getHomework(){		
		$temp = $this->sqlqueryer->getHomework($this->homework_id);
		return $temp;	
	}
	
	public function setHomework($title,$due_date,$description,$key,$author,$group_id){
		$create_date = date('d-m-Y H:i:s');
		$this->sqlqueryer->setHomework($title,$due_date,$description,$key,$author,$group_id,$create_date);
	}
	
	public function updateHomework($homework_id,$title,$due_date,$description,$key,$author,$group_id){
		$create_date = date('d-m-Y H:i:s');
		$this->sqlqueryer->updateHomework($title,$due_date,$description,$key,$author,$group_id,$create_date);		
	}
	
	public function deleteHomework(){
		$this->sqlqueryer->deleteHomework($this->homework_id);
	}
	
	
	
	
	
	
	
	
	
	
}