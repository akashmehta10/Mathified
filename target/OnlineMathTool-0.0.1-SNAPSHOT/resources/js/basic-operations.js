	var app = angular.module('basic-operations-app', []);
	app.controller('myCtrl', function($scope, $http) {
		$scope.loadResults= function() {
			if($scope.myForm.$valid == true) {
				 var finalData = {
						    numberList:$scope.number_list.replace(/\s{1,}|\n{1,}|\r{1,/g, ',')
						};
				$http.post("/OnlineMathTool/basic/results", JSON.stringify(finalData)).then(function(response) {
					if(response.data.success == true) {
						clearContents();
						$scope.results = "Result: ";
						$scope.count = "Count: " + response.data.count;
						$scope.sum = "Sum: " + response.data.sum;
						$scope.average = "Average: " + response.data.average;
						$scope.SD = "Standard Deviation: " + response.data.sd;
						$scope.variance = "Variance: " + response.data.variance;
					}
					else {
						clearContents();
						$scope.results = "Error: Invalid input!"
					}
					}).error(function(){
		            })
			}
			else {
				clearContents();
				$scope.results = "Error: Input is required!"
			}
		};
	    function clearContents() {
			$scope.results = null;
			$scope.count = null;
			$scope.sum = null;
			$scope.average = null;
			$scope.SD = null;
			$scope.variance = null;
	        // Internal function, only available to code executed after
	        // localFunc is declared
	    };
	});
