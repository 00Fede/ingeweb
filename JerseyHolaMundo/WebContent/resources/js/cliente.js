/**
 * Modulo de angular para manejar la interacción del usuario con las vistas de manera
 * dinamica
 * 
 * 
 * @author Federico Ocampo
 */

const URL_HOME = "http://localhost:8080/JerseyHolaMundo/rest/";
const URL_CLIENTES = "ServicioCliente";

//en el segundo arg de module(), agregar las dependencias de angular
angular.module('clientes',["ngRoute"])

/**
 * Servicio para acceder al servicio web de hacer login al usuario
 */
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
/**
 * Servicio que llama el servicio web listarClientes
 */
.service('clientes', function($http) {
	this.listarClientes = function(){
		return $http({
			method: 'GET',
			url: URL_HOME+URL_CLIENTES
		})
	} 
})

.config(['$routeProvider', function($routeProvider) {
	//Cuando este en '/' corre la configuracion del json
	$routeProvider.when('/', {
		templateUrl: "login.html",
		controller: "loginCtrl"
			});
	
	$routeProvider.when('/clientes', {
		templateUrl: "listClientes.html",
		controller: "clienteCtrl"
			});
}])

/**
 * Controlador que permite manejar el login del usuario en la vista
 */
.controller('loginCtrl', function($scope,$location, loginUser) {
	//$scope es el modelo que permite interaccion entre vista y controlador
	$scope.username = '';
	$scope.password = '';
	
	$scope.autenticar = function() {
		loginUser.autenticar($scope.username,$scope.password)
				.success(function(data, status, headers, config) {
					if(data != 'Registro Exitoso'){
						//si el registro no es exitoso
						alert(status + ":" + data);
						$scope.username = '';
						$scope.password = '';
					}else{
						alert("Datos Correctos " + data);
						$location.url("/clientes");
					}
					
				})
	};
	
	
})

/**
 * Controlador que maneja la interacción con la vista de lista de clientes,
 * aqui se accede al servicio listarClientes definido en el modulo y se valida
 * si el resultado es un array de clientes o un solo elemento.
 */
.controller('clienteCtrl' , function($scope, clientes) {
	//listarClientes se llama al inicializar controlador
	clientes.listarClientes().then(function successCallback(response) {
		var l = response.data.clienteWs.length;
		
		console.log("Data de la respuesta" + JSON.stringify(response.data));
		console.log("longitud de response con attr length: " + l);
		$scope.listaClientes = response.data.clienteWs;
		if(l!=undefined){
			$scope.listaClientes = response.data.clienteWs;
			console.log("array que retorna a vista: " +  JSON.stringify($scope.listaClientes));
		}else{
			$scope.listaClientes = response.data;
			console.log("Single data set de cliente:" + $scope.listaClientes);
		}
		
	}, function errorCallback(response) {
		alert("Ha ocurrido un error consultado los clientes");
	});
})
