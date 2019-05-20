
//鑾峰緱coolie 鐨勫��

function cookie(name){    

   var cookieArray=document.cookie.split("; "); //寰楀埌鍒嗗壊鐨刢ookie鍚嶅�煎    

   for (var i=0;i<cookieArray.length;i++){    

      var arr=cookieArray[i].split("=");       //灏嗗悕鍜屽�煎垎寮�    

      if(arr[0]==name)return unescape(arr[1]); //濡傛灉鏄寚瀹氱殑cookie锛屽垯杩斿洖瀹冪殑鍊�    

   } 

   return ""; 

} 

 

/*function delCookie(name)//鍒犻櫎cookie

{

   document.cookie = name+"=;expires="+(new Date(0)).toGMTString();

}*/



function getCookie(objName){//鑾峰彇鎸囧畾鍚嶇О鐨刢ookie鐨勫��

    var arrStr = document.cookie.split("; ");

    for(var i = 0;i < arrStr.length;i ++){

        var temp = arrStr[i].split("=");

        if(temp[0] == objName) return unescape(temp[1]);

   } 

}

 

function addCookie(objName,objValue,objHours){      //娣诲姞cookie

    var str = objName + "=" + escape(objValue);

    if(objHours > 0){                               //涓烘椂涓嶈瀹氳繃鏈熸椂闂达紝娴忚鍣ㄥ叧闂椂cookie鑷姩娑堝け

        var date = new Date();

        var ms = objHours*3600*1000;

        date.setTime(date.getTime() + ms);

        str += "; expires=" + date.toGMTString();
   }

   document.cookie = str;

}

 

function SetCookie(name,value)//涓や釜鍙傛暟锛屼竴涓槸cookie鐨勫悕瀛愶紝涓�涓槸鍊�

{

    var Days = 30; //姝� cookie 灏嗚淇濆瓨 30 澶�

    var exp = new Date();    //new Date("December 31, 9998");

    exp.setTime(exp.getTime() + Days*24*60*60*1000);

    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();


}

function getCookie(name)//鍙朿ookies鍑芥暟        

{

    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));

     if(arr != null) return unescape(arr[2]); return null;

 

}

function delCookie(name)//鍒犻櫎cookie
{
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval=getCookie(name);
    if(cval!=null) {
    	document.cookie= name + "="+cval+";expires="+exp.toGMTString();
    }
}

