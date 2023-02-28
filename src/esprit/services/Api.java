/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.services;

import java.io.BufferedReader;  
import java.net.HttpURLConnection;  
import java.io.IOException;  
import java.io.OutputStream;  
import java.io.InputStreamReader;  
import java.net.URL;  
import java.net.ProtocolException;  
import java.net.MalformedURLException;  
import java.io.OutputStreamWriter;  
    


/**
 * 
 *
 * @author Asus
 */
public class Api {
     public int POSTReq(String str) throws IOException   
{  
// The message that is going to be sent to the server  
// using the POST request  
final String messageContent = "{\n"+
"\"content\" : \""+str+"\" }";  

String message  = "{\n" + "\"Headers\":";
// Printing the message  
System.out.println(messageContent);  
// URL of the API or Server  
String url = "https://neutrinoapi.net/bad-word-filter";  
URL urlObj = new URL(url);  

HttpURLConnection postCon = (HttpURLConnection) urlObj.openConnection();  
postCon.setRequestMethod("POST");  
postCon.setRequestProperty("User-ID", "firas");  
postCon.setRequestProperty("API-Key", "zlmcfp3p1ie9tvV0yZzRxItVDwhpXnl0pMIMKMdyuciBvnMl");  

// Setting the message content type as JSON  
postCon.setRequestProperty("Content-Type", "application/json");  
postCon.setDoOutput(true);  
// for writing the message content to the server  
OutputStream osObj = postCon.getOutputStream();  
osObj.write(messageContent.getBytes());  
// closing the output stream  
osObj.flush();  
osObj.close();  
int respCode = postCon.getResponseCode();  
System.out.println("Response from the server is: \n");  
System.out.println("The POST Request Response Code :  " + respCode);  
System.out.println("The POST Request Response Message : " + postCon.getResponseMessage());  
if (true)   
{   
// reaching here means the connection has been established  
// By default, InputStream is attached to a keyboard.  
// Therefore, we have to direct the InputStream explicitly  
// towards the response of the server  
InputStreamReader irObj = new InputStreamReader(postCon.getInputStream());   
BufferedReader br = new BufferedReader(irObj);  
String input = null;  
StringBuffer sb = new StringBuffer();  
while ((input = br .readLine()) != null)   
{  
    sb.append(input);  
}   
br.close();  
postCon.disconnect();  
// printing the response  
String s = sb.toString();

if(s.contains("false"))
    return 1;
else 
    return 0;
}   
else   
{  
// connection was not successful  
System.out.println("POST Request did not work.");  
}  
return -1;

}  
     public static void main(String argvs[]) throws IOException  
{  
// Creating an instance of the JavaPOSTExample  
Api obj = new Api();
// invoking the method POSTReq()  
int res = obj.POSTReq("firas");

    System.out.println(res
);
}  
}
