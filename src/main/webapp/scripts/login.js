function userLogin(){
				//测试绑定事件
				//alert("堵哪了？");
				//获取参数
				var name=$("#count").val().trim();
				var password=$("#password").val().trim();
				//alert(name+","+password);
				$("#count_span").html("");
				$("#password_span").html("");
				//格式检测
				var ok=true;
				if(name==""){
					$("#count_span").html("用户不能为空");
					ok=false;
				}
				if(password==""){
					$("#password_span").html("密码不能为空");
					ok=false;
				}
				//发送请求
				if(ok){//检测格式通过
					//发送ajax请求
					$.ajax({
						url:path+"/user/login.do",
						type:"post",
						data:{"name":name,"password":password},
						dataType:"json",
						success:function(result){
							//result是服务器返回的JSON结果
							console.log(result.status);
							
							if(result.status==0){
								//将用户信息保存到cookie
								var userId=result.data.c_user_id;
								var userName=result.data.c_user_name;
								addCookie("userName",userName);
								addCookie("userId",userId);
								window.location.href="chat_admin.html";
							}else if(result.status==1){
								//用户名错误
								$("#count_span").html(result.msg);
							}else if(result.status==2){
								$("#password_span").html(result.msg);
							}
						},
						error:function(){
							ok=false;
							alert("登录失败！");
						}
					});
				}
			}