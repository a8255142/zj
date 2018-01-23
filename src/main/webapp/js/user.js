$(document).ready(function() {
	
});

function sub(){
	var name = $("#name").val();
	var cardnum = $("#cardnum").val();
	if(name==''){
		alert("姓名不能为空！！");
		return;
	}
	if(cardnum==''){
		alert("身份证不能为空！！");
		return;
	}
	 $.ajax({
         type:"post",
         async: false,
         dataType: "json",
         url: "insert.do",
         data:  $("#frm").serialize(),
         success: function(data) {
        	 if(data!=null){
        		 if(data.code=='0'){
        			 alert(data.Msg);
        			 location.reload();
        		 }else{
        			 alert(data.Msg);
        		 }
        		 
        	 }else{
        		 alert("添加失败！！")
        	 }
         },
         error:function(data) {
        	 alert("添加失败！！")
         }
         });
}
function updateUser(){
	var name = $("#miffrm input[name=name]").val();
	var cardnum = $("#miffrm input[name=name]").val();
	if(name==''){
		alert("姓名不能为空！！");
		return;
	}
	if(cardnum==''){
		alert("身份证不能为空！！");
		return;
	}
	 $.ajax({
        type:"post",
        async: false,
        dataType: "json",
        url: "update.do",
        data:  $("#miffrm").serialize(),
        success: function(data) {
       	 if(data!=null){
       		 if(data.code=='0'){
       			 alert(data.Msg);
       			 location.reload();
       		 }else{
       			 alert(data.Msg);
       		 }
       		 
       	 }else{
       		 alert("更新失败！！")
       	 }
        },
        error:function(data) {
       	 alert("更新失败！！")
        }
        });
}

function delUser(userId){
	 $.ajax({
         type:"post",
         async: false,
         dataType: "json",
         url: "delete.do",
         data:  {'userId':userId},
         success: function(data) {
        	 if(data!=null){
        		 if(data.code=='0'){
        			 alert(data.Msg);
        			 location.reload();
        		 }else{
        			 alert(data.Msg);
        		 }
        		 
        	 }else{
        		 alert("删除失败！！")
        	 }
         },
         error:function(data) {
        	 alert("删除失败！！")
         }
         });
}