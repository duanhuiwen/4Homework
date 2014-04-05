<?php

class SQLQuery{
	
//php database object
private $DBH;
	
	
	
	public function __construct(){

//		require_once('../setting/dbsettings.php');
		$host = 'mysql.metropolia.fi';
		$dbname = 'huiwend';
		$username = 'huiwend';
		$password = '12345';
		
		
		try {
			$this->DBH = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);
			$this->DBH->setAttribute( PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION );
		}
		catch(PDOException $e) {
			echo "Could not connect to database.";
			file_put_contents('PDOErrors.txt', $e->getMessage(), FILE_APPEND);
		}
		//$this->DBH = $DBH;
		
	
	}
	
	
	

	//about homeworks
	public function getHomework($homework_id){
		//require_once('../setting/dbsettings.php');
		$sql = "SELECT * FROM `homework` WHERE `homework_id` = '$homework_id'";
		$STH = $this->DBH->query($sql);
		$STH->setFetchMode(PDO::FETCH_ASSOC);
		$row = $STH->fetch();
		if($row != null){
			return $row; //return the homework info as an array
		}else{
			return false;
		}		
	}
	
	
	public function setHomework($title,$due_date,$description,$key,$author,$group_id,$create_date){
		$sql = "INSERT INTO `homework` (`homework_id`,`title`,`due_date`,`description`,`key`,`author`,`group_id`,`create_date`)VALUES (NULL,'$title','$due_date','$description','$key','$author','$group_id','$create_date');";
		$STH = $this->DBH->exec($sql);
	}
	
	public function updateHomework($homework_id,$title,$due_date,$description,$key,$author,$group_id,$create_date){
		$sql = "UPDATE `homework` SET `title`='$title',`due_date`='$due_date',`description`='$description',`key` = '$key',`author` = '$author',`group_id`='$group_id',`create_date`='$create_date' WHERE `homework_id`='$homework_id' ;";
		$STH = $this->DBH->exec($sql);
	}
	
	public function deleteHomework($homework_id){
		$sql = "DELETE * FROM `homework` WHERE `homework_id` = '$homework_id'";
		$STH = $this->DBH->exec($sql);
	}
	
	
	
	public function getHomeworksByGroup($group_id,$sort=0){
		//default $sort = 0 means sort by due_date asc, $sort=1 means sort by create_date desc 
		if($sort==0){
					
			$sql = "SELECT * FROM `homework` WHERE `group_id` = '$group_id' ORDER BY `due_date` ASC ;";
			$STH = $this->DBH->query($sql);
			$STH->setFetchMode(PDO::FETCH_ASSOC);
			$list = $STH->fetchAll();	
			
		}else{
			//sort by create date
			$sql = "SELECT * FROM `homework` WHERE `group_id` = '$group_id' ORDER BY `create_date` DESC;";
			$STH = $this->DBH->query($sql);
			$STH->setFetchMode(PDO::FETCH_ASSOC);
			$list = $STH->fetchAll();	
		}

		return $list;
	}
	
	
	
	//about group
	public function getGroupInfo($group_id){
		
	}
	
	public function isGroupExist($group_id){
		
		//if($this->DBH != null) {echo 'ih';};
		$sql = "SELECT * FROM `group` WHERE `group_id` = '$group_id';";
		$STH = $this->DBH->query($sql);
		$STH->setFetchMode(PDO::FETCH_ASSOC);
		$list = $STH->fetch();	
		if($list!=null){
			return true;
		}else{
			return false;
		}
		
		
	}
	
	
	
	
	
	
}