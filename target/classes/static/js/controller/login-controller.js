app.controller("loginController", function($scope, $http) {
	
	$scope.usuario={};
	
	$scope.autenticar = function() {
		console.log("chamou")
		$http({
			method : 'POST',
			url : 'http://localhost:8080/autenticar',
			data : $scope.usuario
		}).then(function(response) {
			console.log("sucesso");
		}), function(response) {
			// erro
			console.log("falha");

		}
	}
	
});