/**
 * 
 */

//en el segundo arg de module(), agregar las dependencias de angular
angular.module('clientes',["ngRoute"])

.service('loginUser', function($http) {
	
	this.autenticar = function(usuario, pass) {
		return $http({
			method: "GET",
			url: "http://localhost:8080/JerseyHolaMundo/rest/ServicioUsuario/login",
			params:{
				id: usuario,
				password: pass
			}
		});
		
	}
	
	
})

.config(['$routeProvider', function($routeProvider) {
	//Cuando este en '/' corre la configuracion del json
	$routeProvider.when('/', {
		templateUrl: "login.html",
		controller: "loginCtrl"
			});
}])

.controller('loginCtrl', function($scope, loginUser) {
	//$scope es el modelo que permite interaccion entre vista y controlador
	$scope.username = '';
	$scope.password = '';
	
	$scope.autenticar = function() {
		loginUser.autenticar($scope.username,$scope.password)
				.success(function(data, status, headers, config) {
					alert(status + ":" + data);
					console.log("headers: " + headers);
		});
	};
	
	
})