function MainCtrl(dataFactory, $http) {
	  this.rowHeaders = true;
	  this.colHeaders = true;
	  this.db = {
			    items: dataFactory.generateArrayOfArrays(2, 2)
			  };
	  this.settings = {
			    contextMenu: [
			      'row_above', 'row_below', 'remove_row'
			    ]
			  };
	 this.loadResults= function() {
		 //alert("I was clicked");
		 alert(this.db.items.length);
		 var finalData = [];
		    for (var i = 0; i < this.db.items.length; i++) {
		    	finalData.push([]);
		    	finalData[i].push( new Array(3));
		    	finalData[i][0] = this.db.items[i].column1;
		    	finalData[i][1] = this.db.items[i].column2;
		    	finalData[i][2] = this.db.items[i].column3;
	    }
		 $http.get("/OnlineMathTool/grid/data?gridData="+JSON.stringify(finalData)).then(function(response) {
				if(response.data.success == true) {
				}
				else {
				}
		 });

	 }
	}

MainCtrl.$inject = ['dataFactory','$http'];


angular
.module('app', ['ngHandsontable'])
.controller('MainCtrl', MainCtrl);