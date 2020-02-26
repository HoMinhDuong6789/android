<?php
	$hostname = "localhost";
	$username = "root";
	$password = "";
	$databasename = "quanlysinhvien";
	
	$con = mysqli_connect($hostname, $username, $password, $databasename);
	if($con){
		echo "ket noi thanh cong";
	}else{
		echo "ket noi KO thanh cong";
	}

?>