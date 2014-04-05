
<?php
session_start();
require_once('../classes/Group.php');
require_once('../classes/Homework.php');
require_once('../classes/SQLQuery.php');

if(!$_SESSION['loggedin']){
	header( 'Location: check_auth.php' );
}
$group_id =  $_GET['group_id'];
?>

<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>4Homework</title>
    <link rel="stylesheet" href="style.css">
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script src="scripts.js"></script>
    <script type="text/javascript">
		function deleteHomework() {
		    $.get("deleteHomework.php<? ?>");
			var x;
			
			var key=prompt("Enter the key to delete this homework","key");
			
			if (key!=null)
			  {
			  x="Hello " + name + "! How are you today?";
			  document.getElementById("demo").innerHTML=x;
			  }
					    
		    
		    
		    
		    return false;
		}
	</script>
    
  </head>
  <body>
    <div id="main">
	<div id="header"><img src="images/logo_small.png" class="clearfix" /><h1 id="logo">Group ID: <?php echo $group_id; ?></h1></div>
			<div id="container" class="clearfix">
				<div id="sidebar">
					<!--<form action="http://users.metropolia.fi/~pasihu/ilearn/whatever.php" method="POST">
					<input type="button" value="Add new">
					</form>
					<h2></h2>-->
					<? 
					$group = new Group($group_id);
					$list = $group->getHomeworksByGroup();
					$i = 0;
				    while($i < count($list)){
						$homework = new Homework($list[$i]['homework_id']);
						
						
						echo '<ul id="'.$list[$i]['homework_id'] .'">
						<li>'. $list[$i]['due_date'] .'</li>
						<li>'.$list[$i]['title'].'</li>
						<li class="remove-button"><a href=""><span id="'.$list[$i]['homework_id'] .'"></span></a></li>
					    </ul>';
					    $i++;
						
					}
					//echo  count($list);
					//echo $list[0]['homework_id'];
					//print_r($list);

					?>
					
				
				</div>
				
				<div id="content">
				<form action="addHomework.php" method="POST">
				    <input type="hidden" class="text" name="group_id" id="group_id" value="<?echo $_GET['group_id']; ?>"/>
<p class="input_name">Title</p>
					<input id="title" type="text" name="title" placeholder="Title of your task e.g. Math">
<p class="input_name">Due date</p>
					<input id="due" type="datetime" name="due" placeholder="YYYY-MM-DD HH:MM:SS">
<p class="input_name">Description</p>
					<textarea placeholder="Describe your task" id="desc" type="text" name="desc"></textarea>
<p class="input_name">Author</p>
					<input id="author" type="text" name="author" placeholder="Your name">
<p class="input_name">Key</p>
					<input id="key" type="text" name="key" placeholder="Secret key to delete this entry">
				
				
					<input type="submit" id="button"value="Submit">
					<input type="reset"   id="button" value="Cancel"><!-- Does this button just clear the form or what? If it does something else then type="button" will work -->
				</form>
				
				</div>
			
			</div>
		
		</div>
	
  
</body></html>

