	var app = angular.module('compare-app', []);
	app.controller('myCtrl', function($scope, $http) {
		hideResultTexts();
		$scope.loadResults= function() {
			if($scope.myForm.$valid == true) {
				$http.get("/OnlineMathTool/compare/lists?list1="+$scope.input_list1.replace(/\s{1,}|\n{1,}|\r{1,/g, ',')+"&list2="+$scope.input_list2.replace(/\s{1,}|\n{1,}|\r{1,/g, ',')).then(function(response) {
					if(response.data.success == true) {
						clearContents();
						$scope.results = "Result: ";
						showResultTexts();
						$scope.commonElements = "Common Elements:\n" + response.data.commonElements;
						$scope.list1Only = "Input 1 Only Elements:\n" + response.data.list1Only;
						$scope.list2Only = "Input 2 Only Elements:\n" + response.data.list2Only;
						$scope.list1OrList2 = "Input 1 or Input 2 Elements:\n" + response.data.list1OrList2;
					}
					else {
						clearContents();
						hideResultTexts();
						$scope.results = "Error: Invalid input!"
					}
					}).error(function(){
		            })
			}
			else {
				clearContents();
				hideResultTexts();
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
	    function showResultTexts() {
	    	$scope.commonElementsShow = true;
	    	$scope.list1OnlyShow = true;
	    	$scope.list2OnlyShow = true;
	    	$scope.list1OrList2Show = true;
	    }
	    function hideResultTexts() {
	    	$scope.commonElementsShow = false;
	    	$scope.list1OnlyShow = false;
	    	$scope.list2OnlyShow = false;
	    	$scope.list1OrList2Show = false;
	    }
	});
