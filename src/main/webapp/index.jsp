<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">

function login() {
	alert($('#form1').serialize());
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "us/log" ,//url
        data: $('#form1').serialize(),
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}





function SendShort() {
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "shortmessage/AddShotr",//url
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}




function Mohu(){
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "fina/SelectDayHm" ,//url
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}

function SelectHm(){
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "fina/SelectHm" ,//url
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}

function SelectExcel(){
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "fina/SelectHm" ,//url
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}


function SelectExcelDay(){
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "fina/SelectHm" ,//url
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}

function GroupName(){
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "con/UpdateGroup" ,//url
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}


function login() {
	alert($('#form1').serialize());
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "us/log" ,//url
        data: $('#form1').serialize(),
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}

function GroupFz() {
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "grou/SelectGroup" ,//url
        data:{
        	page:1
        },
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}


function SelectExcelInput(){
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "exce/InputStema" ,//url
        data:{
        	files:"E:\\rr11.xls"
        },
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}

function TONUmber(){
    $.ajax({
        type: "post",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "shortmessage/test" ,//url
        data:{
        	files:"E:\\rr11.xls"
        },
        success: function (msg) {
           alert(msg);
            if (msg!=null) {
            	alert("登陆成功");
            }else{
            	alert("账号或密码错误!!");
            };
        }
    });
    
}






</script>
</head>
<body>
<center>
<form action="Openac/OpenInsert" method="post" enctype="multipart/form-data">
        图片：<input type="file" name="file">
        <input type="submit" value="提交">
    </form>
</center>	
</body>
</html>