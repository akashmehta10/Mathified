	var app = angular.module('feedback-app', []);
	app.controller('myCtrl', function($scope, $http) {
		$scope.submitFeedback= function() {
			if($scope.myForm.$valid == true) {
				 var finalData = {
						 feedback: {
							    name:$scope.name,
							    email:$scope.email,
							    feedbackText:$scope.feedback 
						 }
						};
				$http.post("/OnlineMathTool/feedback/submit", JSON.stringify(finalData)).then(function(response) {
					if(response.data.success == true) {
						clearContents();
						$scope.myForm.$valid = true;
						$scope.buttonDisabled = true;
						$scope.results = "Your feedback has been recorded, we will contact you if required.";
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
				$scope.results = "Error: Invalid/Missing input!"
			}
		};
	    function clearContents() {
			$scope.results = null;
	        // Internal function, only available to code executed after
	        // localFunc is declared
	    };
	});
