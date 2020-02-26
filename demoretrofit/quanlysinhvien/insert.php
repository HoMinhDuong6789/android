<?php
	require "connect.php";
	
	$taikhoan =$_POST['taikhoan'];
	$matkhau = $_POST['matkhau'];
	$hinhanh = $_POST['hinhanh'];
	if(strlen($taikhoan) > 0 && strlen($matkhau) > 0 && strlen($hinhanh) >0){
		$query = //"INSERT INTO sinhvien VALUES (null, '$taikhoan', '$matkhau', '$hinhanh')";
		           "INSERT INTO sinhvien(taikhoan, matkhau, hinhanh) VALUES ('$taikhoan', '$matkhau', '$hinhanh')";
		
		$data = mysqli_query($con, $query);
		if($data){
			echo "Success";
		}else{
			echo "fail";
		}
	}else{
		echo "null";
	}
?>