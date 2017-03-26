	var app = angular.module('compare-app', []);
	app.controller('myCtrl', function($scope, $http) {
		$scope.loadResults= function() {
			if($scope.myForm.$valid == true) {
				$http.get("/OnlineMathTool/compare/lists?list1="+$scope.input_list1.replace(/\s{1,}|\n{1,}|\r{1,/g, ',')+"&list2="+$scope.input_list2.replace(/\s{1,}|\n{1,}|\r{1,/g, ',')).then(function(response) {
					if(response.data.success == true) {
						clearContents();
						$scope.results = "Result: ";
						$scope.commonElements = "Common Elements: " + response.data.commonElements;
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
			$scope.commonElements = null;
	        // Internal function, only available to code executed after
	        // localFunc is declared
	    };
	});
