function priceControl(){
	// 今天
	var today = new Date();
	// 定义周数组，用来显示周几
	var weekdays = ['日','一','二','三','四','五','六'];
	// 但前选中的日期
	var current;	
	// 存储经计算后所需的日期变量
	var need;
	// y用于存储节日字符串
	var str;
	// json传递参数
	var params;
	// joson数据
	var jsonData;
	
	var price;
	
	
	// 调整计算天数
	var countTime = function (day,n){
		var getTime = day.getTime()+(24*60*60*1000)*n;
		var needDate = new Date(getTime);
		return needDate;
	}

	// 对Date的扩展，将 Date 转化为指定格式的String
	// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
	// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
	// 例子：
	// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
	// (new Date()).Format("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18


	var holiday = function (day){
		var byear = day.getFullYear();
		var bmon = day.getMonth()+1;
		var bday = day.getDate();
		var temp = calendar.solar2lunar(byear,bmon,bday);
		var smon = temp.IMonthCn;
		var sday = temp.IDayCn;
		if ((bmon == 1) && (bday == 1)) {
			str = "元旦";
		} else if ((bmon == 2) && (bday == 14)) {
			str = "情人节";
		} else if ((bmon == 4) && (bday == 5)) {
			str = "清明节";
		} else if ((bmon == 5) && (bday == 1)) {
			str = "劳动节";
		} else if ((bmon == 10) && (bday == 1)) {
			str = "国庆节";
		} else if ((bmon == 12) && (bday == 24)) {
			str = "圣诞节";
		} else if ((bmon == 12) && (bday == 25)) {
			str = "圣诞节";
		} else if ((smon == "正月") && (sday == "初一")) {
			str = "春节";
		} else if ((smon == "五月") && (sday == "初五")) {
			str = "端午节";
		} else if ((smon == "七月") && (sday == "初七")) {
			str = "七夕";
		} else if ((smon == "八月") && (sday == "十五")) {
			str = "中秋节";
		} else if((smon == "腊月") && (sday == "三十")) {
			str = "除夕";
		}
	}

	var createDate = function (firstDay){
		var showDate;
		$("#date td").remove();
		for(var i = 0;i<14;i++){
			var targetDay = countTime(firstDay,i);
			if(today.toDateString()==targetDay.toDateString()){
				showDate = "<td>今天</td>";
			}else{
				var target = targetDay.getDate();
				showDate = "<td>"+target+"</td>"
			}
			$("#date").append(showDate);
		}
		current = firstDay;
	}

	var createWeek = function(firstDay){
		var showDate;
		$("#week td").remove();
		for(var i = 0;i<14;i++){
			var targetDay = countTime(firstDay,i);
			holiday(targetDay);
			if(str!=null){
				showDate = "<td style='color:#ff0000'>"+str+"</td>"
				str = null;
			}else{
				showDate = "<td>"+weekdays[targetDay.getDay()]+"</td>";
			}
			$("#week").append(showDate);
		}
	}
	
	function firstPriceList(result){
		if(result.state==1){
			jsonData = result.data;
			doShowData(today);
		}else{
			alert(result.message)
		}
	}
	
	function doShowData(firstday){
		var showData;
		var priceList;
		$(".priceList").remove();
		$.each(jsonData,function(index,value){
			priceList = doShowPrice(firstday,value);
			showData = "<div class='priceList'><table><tr><td colspan='2'><img style='width: 120px' src='"+ value.picPath[0] +"'/></td><td class='houseinfo' colspan='11'><h1 id='housetitle'>"+ value.houseName +"</h1><p>房屋编号："+ value.houseId +"</p></td><td colspan='1'>已上架</td></tr><tr id='tra'>"+ priceList +"</tr><tr><td colspan='14'><a class='modify' href ='#' style='float:right; text-decoration:underline;color:#5264cc'>去管理基础价</a></td></tr></table></div>"
			$("#floor").append(showData);
			$(".priceList").last().data("value",value);
		});
		$(".modify").on("click",toModifyPrice);
	}
	
	var doShowPrice = function(firstDay,priceValue){
		var finalPrice ="";
		var showPrice;
		var holidayPice = priceValue.prices;
		for(var i = 0;i<14;i++){
			var targetDay = countTime(firstDay,i);
			holiday(targetDay);
			if(str!=null&&holidayPice!=null&&holidayPice.length!=0){
				$.each(holidayPice,function(index,value){
					if(str==value.holidayName){
						price=value.price;
						showPrice = "<td class='pricetd'><dl><dt>￥"+ price +"</dt><dt>1</dt></dl></td>";
						return false;
					}
				});
			}	
			if(price==null&&priceValue.chargingMode==1){
				var target = targetDay.getDay();
				if(target==0||target==6){
					price=priceValue.weekendPrice;
				}else{
					price=priceValue.weekdayPrice;
				}
				showPrice = "<td class='pricetd'><dl><dt>￥"+ price +"</dt><dt>1</dt></dl></td>";
			}else if(price==null&&(priceValue.chargingMode==0||priceValue.chargingMode==null)){
				price=priceValue.basePrice;
				showPrice = "<td class='pricetd'><dl><dt>￥"+ price +"</dt><dt>1</dt></dl></td>";
			}
			finalPrice = finalPrice + showPrice;
			price = null;
			str = null;
		}
		return finalPrice;
	}
	
	function toModifyPrice(){
		$("#right").data("value",$(this).parents(".priceList").data("value"));
		console.log($("#right").data("value"));
		$("#right").load("modifyPrice.html");		
	}

	// 设置input日期输入框为当前日期
	$("#inputDate").val(today.Format("yyyy-MM-dd"));
	createDate(today);
	createWeek(today);
	params = {"landlordId":1};
	$.getJSON("price/doFindAllPrice",params,firstPriceList);

	$("#weekBefore").on("click",function(){
		need = countTime(current,-7);
		createDate(need);
		createWeek(need);
		doShowData(need);
		$("#inputDate").val(need.Format("yyyy-MM-dd"));
	});
	
	$("#weekAfter").on("click",function(){
		need = countTime(current,7);
		createDate(need);
		createWeek(need);
		doShowData(need);
		$("#inputDate").val(need.Format("yyyy-MM-dd"));
	});

	$("#inputDate").on("change",function(){
		current = new Date($("#inputDate").val());
		createDate(current);
		createWeek(current);
		doShowData(current);
	});
}