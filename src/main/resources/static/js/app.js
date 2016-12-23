var app = angular
  .module('myapp', [
    'ngRoute'
  ]);

// Definindo Rotas
app.config(function($routeProvider,$locationProvider) {
  
	$routeProvider
    .when('/', {
      templateUrl: 'view/home.html',
      controller: 'HomeController'
    }).when('/clientes', {
        templateUrl: 'view/cliente.html',
        controller: 'clienteController'
      }).
      when('/clientes/:clienteId', {
          templateUrl: 'view/cliente-detalhe.html',
          controller: 'clienteDetalheController'
        }).
        when('/login', {
            templateUrl: 'view/login.html',
            controller: 'loginController'
          }).
    otherwise({
      redirectTo: '/'
    });
    
  // habilitar o uso da API HTML5 History
  $locationProvider.html5Mode(true);
});

app.config(function($httpProvider) {
	$httpProvider.interceptors.push("tokenInterceptor");
});