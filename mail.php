<?php
if($_POST['button']) 
{ 
	
	$sender_name = $_POST["sender_name"]; //sender name 
	$reply_to_email = $_POST["sender_email"]; //sender email, it will be used in "reply-to" header 
	$recipient_email = $_POST["reciver_email"];

	
	error_reporting(E_ALL);
    require("PHPMailer_5.2.4/class.phpmailer.php");
    $mail = new PHPMailer();
	

    $mail->FromName = $sender_name;
	$mail ->AddAddress($recipient_email,"");
	$mail->AddReplyTo($reply_to_email,$sender_name);
    $mail->WordWrap = 50;
    $mail->AddAttachment("steg.png");
    $mail->IsHTML(TRUE);
    $mail->subject="Image";
	$mail->Body="This is the Stegnographysed Image";
	
	$sent = $mail->Send();
    if($sent)
    {
        echo "Message Sent Succesfully";
    }
	else
	{
		echo "Message sending Failed";
	}
	
}
?>