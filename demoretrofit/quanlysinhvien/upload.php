<?php
	$target_dir = "image/";
	$file_path = $target_dir.basename($_FILES['uploaded_file']['name']);
	
	if(move_uploaded_file($_FILES['uploaded_file']['tmp_name'], $file_path)){
		echo $_FILES['uploaded_file']['name'];
	}else{
		echo 'fail';
	}

?>