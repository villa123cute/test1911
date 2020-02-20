

					/*  $(function() {
						
						$("#pageDivUI").on("click","#HousingDetailsInformation",doHousingDetailsData);
					})  */
                   
					$(document).ready(function(){
						console.log(111)
						$('#inputHouseType').find('input[type=checkbox]').bind('click', function(){
						$('#inputHouseType').find('input[type=checkbox]').not(this).attr("checked", false);
						});
						});
					

function getHouseType() {
	var radio=document.getElementsByName("houseTypey");
	 var selectvalue=null;   //  selectvalue为radio中选中的值
	 for(var i=0;i<radio.length;i++){
	 if(radio[i].checked==true) {
	selectvalue=radio[i].value;
	return selectvalue;
  }
}
}    
	
	function doHousingDetailsData() {
          debugger
		var params = {};
		var r = $('form').serializeArray();
		$.each(r, function() {
				params[this.name] = this.value;
		});
		var houseClass=getHouseType();
		//$("#mainContent").data("id", HouseId)
		//var  HouseId= [[${HouseId}]];
		//localStorage.setItem("id",HouseId);
		var HouseId = localStorage.getItem("houseId");
		params["houseId"]=HouseId;
		params["houseClass"]= selectvalue;
		var url = "house/updateHouseDetails";
		$.post(url, params,function(result){
			if(result.state==1){
	    		  alert(result.message);
	    		  doHouseDescription();
	    	  }else{
	    		  alert(result.message);
	    	  }
		});
         function doHouseDescription(){
		var url2 = "doHouseDescription";
		$("#pageDivUI").load(url2);
         }
	}

	function doAddBedType(){
	var div = " <div class='ivu-form-item-content'><div data-v-3ad2572c='' class='ivu-input-wrapper ivu-input-type' style='width: 200px;'> "+
								 "  <i class='ivu-icon ivu-icon-load-c ivu-load-loop ivu-input-icon ivu-input-icon-validate'></i>  "+
								 "  <input name='bedType' autocomplete='off' spellcheck='false' type='text' placeholder='大小...类型......' maxlength='4' class='ivu-input'> "+ 
								"  </div>"+
								 " <span data-v-3ad2572c=''></span>  "+
								 "  </div>";
						$("#bedTypeDiv").append(div);
					}		