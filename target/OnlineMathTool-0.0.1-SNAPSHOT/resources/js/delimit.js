	var app = angular.module('delimit-app', []);
	app.controller('myCtrl', function($scope, $http) {
		$scope.loadResults= function() {
			if($scope.myForm.$valid == true) {
				if($scope.delimitter_input === "New Line") {
					$scope.output_list = $scope.input_list.replace(/\s{1,}|\n{1,}|\r{1,/g, ',').replace(/,/g,'\n');
				}
				else if($scope.delimitter_input === "Space") {
					$scope.output_list = $scope.input_list.replace(/\s{1,}|\n{1,}|\r{1,/g, ',').replace(/,/g,' ');

				}
				else {
					$scope.output_list = $scope.input_list.replace(/\s{1,}|\n{1,}|\r{1,/g, ',').replace(/,/g,$scope.delimitter_input);
				}
			}
			else {
				//clearContents();
				$scope.results = "Error: Input is required!"
			}
		};
	});
