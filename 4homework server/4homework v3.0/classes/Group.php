<?php
class Group{
	private $group_id;
	private $description;
	private $sqlqueryer;
	public function __construct($group_id){
		$this->sqlqueryer = new SQLQuery();
		$this->group_id = $group_id;
	}
	
	//return array
	public function getHomeworksByGroup(){
		$temp = $this->sqlqueryer->getHomeworksByGroup($this->group_id,0);	
		return $temp;	
	}
	
	public function getGroupInfo(){
		return $this->sqlqueryer->getGroupInfo($this->group_id);
	}
	
	
/*	public function deleteHomework($homework_id){
		$this->sqlqueryer->deleteHomework($homework_id);
	}*/
}

?>