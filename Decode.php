<?php

    if(isset($_POST['Decrypt']))
    {
        $password = $_POST['password'];
        $f = $_FILES['path']['tmp_name'];
        $path = realpath($f);
        $command = 'java LSB_decode "'.$password.'" "'.$path.'"';
    

        $decode = shell_exec($command);
        
        echo $decode. "<br>";
    }

   
   


  
?>