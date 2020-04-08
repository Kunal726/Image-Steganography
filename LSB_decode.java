import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
;
import java.util.Scanner;

import javax.imageio.ImageIO;
public class LSB_decode {
	static String STEGIMAGEFILE = "";
	public static String b_msg="";
	static StringBuffer s = new StringBuffer();
	public static int len = 0;
	static String pass = "";
	public static void main(String[] args) throws Exception {
		STEGIMAGEFILE = args[1];			
		BufferedImage yImage=readImageFile(STEGIMAGEFILE);

DecodeTheMessage(yImage);
String msg="";

for(int i=0;i<len*8;i=i+8){
	
	String sub=b_msg.substring(i,i+8);
	
	int m=Integer.parseInt(sub,2);
	char ch=(char) m;

	msg+=ch;

	
}
 char[] mess = msg.toCharArray();
for (int i = 0; i < 8 ; i++)
{
	pass = pass + mess[i];
}
if (pass.equals(args[0]))
{
	for (int i = 8; i < mess.length ; i++)
{
	s.append(mess[i]);
}
System.out.println(s);
}
else
{
	System.out.println("Invalid Password!!!!!!");
	System.out.println("Please Enter Password");
}
}
public static BufferedImage readImageFile(String COVERIMAGEFILE){
BufferedImage theImage = null;
File p = new File (COVERIMAGEFILE);
try{
theImage = ImageIO.read(p);
}catch (IOException e){
e.printStackTrace();
System.exit(1);
}
return theImage;
}


public static void DecodeTheMessage (BufferedImage yImage) throws Exception{

int j=0;
int currentBitEntry=0;
String bx_msg="";
for (int x = 0; x < yImage.getWidth(); x++){
for ( int y = 0; y < yImage.getHeight(); y++){
if(x==0&&y<8){

	int currentPixel = yImage.getRGB(x, y);	
	int red = currentPixel>>16;
	red = red & 255;
	int green = currentPixel>>8;
	green = green & 255;
	int blue = currentPixel;
	blue = blue & 255;
	String x_s=Integer.toBinaryString(blue);
	bx_msg+=x_s.charAt(x_s.length()-1);
	len=Integer.parseInt(bx_msg,2);
	
}
else if(currentBitEntry<len*8){

	int currentPixel = yImage.getRGB(x, y);	
	int red = currentPixel>>16;
	red = red & 255;
	int green = currentPixel>>8;
	green = green & 255;
	int blue = currentPixel;
	blue = blue & 255;
	String x_s=Integer.toBinaryString(blue);
	b_msg+=x_s.charAt(x_s.length()-1);

	
	currentBitEntry++;	
	
}
}
}
}
}