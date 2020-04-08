<?php

    if(isset($_POST['Encrypt']))
    {
        $message = $_POST['message'];
        $password = $_POST['password'];
        $f = $_FILES['path']['tmp_name'];
        $file = Fopen($f,"r");
        $path = realpath($f);
		$command = 'java LSB_encode "'.$message.'" "'.$password.'" "'.$path.'"';
		$encode = shell_exec($command);
		echo $encode. "<br>";
		echo "<button> <a href='mail.html'> Send  </a> </button>"; 
	
    }
	
   


  
?>