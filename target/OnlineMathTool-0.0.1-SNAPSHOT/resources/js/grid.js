function MainCtrl(dataFactory, $http, $scope) {
	  $scope.groupByResultShow = false;
	  $scope.groupByResultTextShow = false;
	  this.rowHeaders = true;
	  this.colHeaders = true;
	  this.db = {
			    items: dataFactory.generateArrayOfArrays(100, 2)
			  };
	  this.settings = {
			    contextMenu: [
			      'row_above', 'row_below', 'remove_row'
			    ]
			  };
	 this.loadResults= function() {
		 $scope.inputErrorFromServer = "";
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
		    var groupBySumColumn = "";
		    if($scope.groupBySumColumn != "" && $scope.groupBySumColumn != "N/A") {
		    	groupBySumColumn = $scope.groupBySumColumn;
		    }

		 $http.post("/OnlineMathTool/grid/data?selectedColumn="+$scope.selectedColumn+"&groupBySumColumn="+groupBySumColumn,JSON.stringify(finalData)).then(function(response) {
			 $scope.groupByResultTextShow = true;
			 	if(response.data.success == true) {
			 		$scope.groupByResultShow = true;
					$scope.groupByOperationFromServer = response.data.groupByOperation;
					$scope.selectedColumnFromServer = response.data.selectedColumn;
					$scope.groupByResult = response.data.resultArray;
				}
				else {
					$scope.inputErrorFromServer = "Input Error";
					$scope.groupByResultShow = false;
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