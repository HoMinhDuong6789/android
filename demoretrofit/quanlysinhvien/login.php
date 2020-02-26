<?php
	require "connect.php";
	
	$taikhoan = $_POST['taikhoan'];
	$matkhau = $_POST['matkhau'];
	
	
	class SinhVien{
		function __construct ($id, $user, $password, $hinhanh){
			$this ->id = $id;
			$this ->taikhoan = $user;
			$this ->matkhau = $password;
			$this ->hinhanh = $hinhanh;	
		}
	
	}
	
	if(strlen($taikhoan) >0 && strlen($matkhau) >0){
		$mangsinhvien = array();
		$query = "SELECT * FROM sinhvien WHERE FIND_IN_SET('$taikhoan', taikhoan) AND FIND_IN_SET('$matkhau', matkhau)";
		
		$data = mysqli_query($con, $query);
		if($data){
			while($row = mysqli_fetch_assoc($data)){
				array_push($mangsinhvien, new SinhVien($row['id'], $row['taikhoan'], $row['matkhau'], $row['hinhanh']));
			}
			if(count($mangsinhvien)>0){
				echo json_encode($mangsinhvien);
			}else{
				echo "fail";
			}
		}else{
			echo "null";
		}
	}
?>