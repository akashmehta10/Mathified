function MainCtrl(dataFactory, $http, $scope) {
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
		 //alert(this.db.items.length);
		 //var finalData = [];
		 var finalData = {
				    gridData: []
				};
		    for (var i = 0; i < this.db.items.length; i++) {
		    	finalData.gridData.push({
		    		"col1":this.db.items[i].column1,
		    		"col2":this.db.items[i].column2,
		    		"col3":this.db.items[i].column3,
		    		"col4":this.db.items[i].column4,
		    		"col5":this.db.items[i].column5,
		    		"col6":this.db.items[i].column6,
		    		"col7":this.db.items[i].column7,
		    		"col8":this.db.items[i].column8,
		    		"col9":this.db.items[i].column9,
		    		"col10":this.db.items[i].column10
		    	});
	    }
		    //alert(JSON.stringify(finalData));
		 $http.post("/OnlineMathTool/grid/data?selectedColumn="+$scope.selectedColumn,JSON.stringify(finalData)).then(function(response) {
				if(response.data.success == true) {
				}
				else {
				}
		 });
	 }
    	this.onAfterSelection = function(row, column) {
    		$scope.selectedColumn = column;
            $scope.$apply();
       	}
	}

MainCtrl.$inject = ['dataFactory','$http','$scope'];


angular
.module('app', ['ngHandsontable'])
.controller('MainCtrl', MainCtrl);
    //angular.bootstrap(document, ['app']);