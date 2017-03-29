	var app = angular.module('compare-app', []);
	app.controller('myCtrl', function($scope, $http) {
		$scope.loadResults= function() {
			if($scope.myForm.$valid == true) {
				$http.get("/OnlineMathTool/compare/lists?list1="+$scope.input_list1.replace(/\s{1,}|\n{1,}|\r{1,/g, ',')+"&list2="+$scope.input_list2.replace(/\s{1,}|\n{1,}|\r{1,/g, ',')).then(function(response) {
					if(response.data.success == true) {
						clearContents();
						$scope.results = "Result: ";
						$scope.commonElements = "Common Elements: " + response.data.commonElements;
						$scope.list1Only = "List1 Only Elements: " + response.data.list1Only;
						$scope.list2Only = "List2 Only Elements: " + response.data.list2Only;
						$scope.list1OrList2 = "List1 or List2 Elements: " + response.data.list1OrList2;
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
			$scope.list1Only = null;
			$scope.list2Only = null;
			$scope.list1OrList2 = null;
	        // Internal function, only available to code executed after
	        // localFunc is declared
	    };
	});
