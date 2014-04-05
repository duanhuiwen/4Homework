<?php

$host = 'mysql.metropolia.fi';
$dbname = 'huiwend';
$username = 'huiwend';
$password = '12345';


try {
	$DBH = new PDO("mysql:host=$host;dbname=$dbname", $username, $password);
	$DBH->setAttribute( PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION );
}
catch(PDOException $e) {
	echo "Could not connect to database.";
	file_put_contents('PDOErrors.txt', $e->getMessage(), FILE_APPEND);
}

?>