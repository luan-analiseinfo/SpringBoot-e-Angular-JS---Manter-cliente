app.controller("loginController", function($scope, $http) {
	
	$scope.usuario={};
	$scope.token="";
	
	
	$scope.autenticar = function() {
		console.log("chamou")
		$http({
			method : 'POST',
			url : 'http://localhost:8080/autenticar',
			data : $scope.usuario
		}).then(function(response) {
			console.log("sucesso");
			$scope.usuario= response.data;
		}), function(response) {
			// erro
			console.log("falha");

		}
	}
	
});