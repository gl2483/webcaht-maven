/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var ws;
window.onbeforeunload = closingCode;
function closingCode(){
   if(ws.readyState === ws.CONNECTED){
        ws.close();
        alert("CLOSEd");
   }
   return null;
}
$().ready(function(){
        
     $("#connect").click(function(){
         try{
            ws = new WebSocket("ws://localhost:8080/WebChat/webchat");
        
            ws.onopen = function(){
                $("#text").append("connected\n");
            };
        
            ws.onclose = function(){
                $("#text").append("disconnected\n");
            };
        
            ws.onmessage = function(msg){
                $("#text").append(msg.data + " \n");
            };
         }catch(exception){
             alert(exception);
         }
        
     });
     
     $("#disconnect").click(function(){
        ws.close();
        
     });
     
     $("#send").click(function(){
         if(ws.readyState === ws.CLOSED)
             $("#text").append("Connection has closed\n");
         else
             ws.send($("#msg").val());
     });
});   
   
