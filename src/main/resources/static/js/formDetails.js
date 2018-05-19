	var lenth;
 	var tableName;
 	$(function(){
 	
		tableName=getPrama('tableName');
		$.ajax({
			url:'tableDetail',
			type:'get',
			data:{'tableName':tableName},
			success:function(data){
				console.log(data);
				lenth=data.data.length;
                insertForm(lenth,0);
                for(var i=0; i<lenth;i++){
                    $('input').eq(i).val(data.data[i].column_comment+"("+data.data[i].column_name+")");
                    $('input').eq(i).attr('readonly','readonly');
                    $('input').eq(i).attr('ziduan',data.data[i].column_name);

                }

                $('input').mouseover(function(e){
                    $('.message').css('display','block');
                    $('.message').css({'left':e.pageX+5+'px','top':e.pageY-5+'px'});
                    $('.message').text($(this).attr('ziduan'));
                });
                $('input').mouseout(function(){
                    $('.message').css('display','none');
                });
			}
		});
		

 	});
	function insertData(btn){
		btn.style.display='none';
		
		insertForm(lenth,1);
	}
    function insertForm(leng,nu){
        var $form=$("<form class='form-inline'></form>");
        for(var i=0;i<leng;i++){
            var $input=$("<input class='form-control'>");

            if(nu==0){

                $input=$("<input class='form-control' type='text'>");
            }

            $form.append($input);
        }
        var $button=$("<input type='button' value='+' class='button' onclick='insertData(this)'>");
        $form.append($button);
        $('.main').append($form);
        var width=$(window).width();

        if(leng*($input.outerWidth(true))-width>=0){
            $form.css('width',(leng)*($input.outerWidth(true))+50+'px');
        }
    }
	function updataForm(){
		var elm=$('.main').children();
		if(elm.length==1){
			alert("请添加信息");
		}else{
			var Datas=[];
			for(var i=1;i<elm.length;i++){
				var obj={};
				var zid=0;
				for(var j=0;j<$(elm[i]).children().length-1;j++){
					if($($(elm[i]).children()[j]).val()==''){
						zid++;
					}
					if(zid==$(elm[i]).children().length-1){
						alert('请至少填一条表单');
						return;
					}
					obj[$($(elm[0]).children()[j]).attr('ziduan')]=$($(elm[i]).children()[j]).val();
				}
				Datas.push(obj);
			}
			var data={'Datas':Datas,
			'tableName':tableName
			};
			$.ajax({
				url:'insertData',
				type:'post',
				data: {"data": JSON.stringify(data)},
				success:function(data){
				
					elm.length-1===data?alert('操作成功'):alert('有'+(elm.length-1-data)+'条数据操作失败');
					
					
				}
			});
		}
	}
	function  getPrama(param){
		// 获取参数
	    var url = window.location.search;
	    // 正则筛选地址栏
	    var reg = new RegExp("(^|&)"+ param +"=([^&]*)(&|$)");
	    // 匹配目标参数
	    var result = url.substr(1).match(reg);
	    //返回参数值
	    return result ? decodeURIComponent(result[2]) : null;
	}
