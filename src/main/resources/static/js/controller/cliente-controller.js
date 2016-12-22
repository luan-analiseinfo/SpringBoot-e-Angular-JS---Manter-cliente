app.controller("clienteController", function($scope, $http) {

	$scope.nome = "Luan";
	$scope.sobrenome = "Lucas";
	$scope.clientes = [];
	$scope.cliente = {};
	

	$scope.carregarClientes = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/private/clientes'
		}).then(function(response) {
			$scope.clientes = response.data;
			console.log(response.data);
			console.log(response.status);

		}), function(response) {
			// erro
			console.log(response.data);
			console.log(response.status);
		}

	}
	
	$scope.salvarClientes = function(){
		$http({
			method : 'POST',
			url : 'http://localhost:8080/private/clientes',
			data : $scope.cliente
		}).then(function(response) {
			$scope.clientes.push(response.data);
			$scope.limparDados();
			$scope.carregarClientes();

		}), function(response) {
			// erro
			console.log(response.data);
			console.log(response.status);
		}

	}

	$scope.alterarDadosCliente = function(){
		$http({
			method : 'PUT',
			url : 'http://localhost:8080/private/clientes',
			data : $scope.cliente
		}).then(function(response) { 
			$scope.carregarClientes();
			$scope.cancelarAlteracaoCliente($scope.cliente);
		}), function(response) {
			// erro
			console.log(response.data);
			console.log("Deu errado");
		}

	}

	
	
	
	$scope.excluirCliente = function(cliente){
		$http({
			method : 'DELETE',
			url : 'http://localhost:8080/private/clientes/'+ cliente.id
		}).then(function(response) {
			pos = $scope.clientes.indexOf(cliente);
			$scope.clientes.splice(pos, 1);
			

		}), function(response) {
			// erro
			console.log(response.data);
			console.log(response.status);
		}

	}
	
	$scope.alterarCliente = function (cliente){
		$scope.cliente = angular.copy(cliente);
	}
	
	
	$scope.visualizaCliente = function (cliente){
		$
		$scope.cliente = $scope.angular.copy(cliente);
	}
	
	$scope.cancelarAlteracaoCliente = function (){
		$scope.cliente ={};
	}
	
	$scope.limparDados = function (){
		$scope.cliente ={};
	}
	
	$scope.carregarClientes();

	
});