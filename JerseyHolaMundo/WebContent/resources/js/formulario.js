/**
 * 
 */

//El segundo parametro de module es un ambito de valores que nuevo se va a usar
//si modulo solo tiene un parametro, esta haciendo una referencia a un modulo ya creado
var modulo = angular.module('formulario',[]);

modulo.controller('form', ['$scope', function($scope){
	$scope.lista = [
	                {texto: 'prueba 1', seleccionado:true},
	                {texto: 'prueba 2', seleccionado:false}
	                ];
	
	$scope.agregar = function(){
		if($scope.myName == ''){
			alert("Debe digitar el nombre");
			return;
		}
		var dato = {texto:$scope.myName, select:$scope.seleccionado};
		$scope.lista.push(dato);
	};
	
	$scope.eliminar = function(){
		var oldNames = $scope.lista;
		$scope.lista = [];
		angular.forEach(oldNames, function(name){
			if(!name.seleccionado) $scope.lista.push(name)
		})
	}
	
	$scope.eliminar2 = function(){
		$scope.lista = $scope.lista.filter(function(dato){
			if(dato.seleccionado){
				return false;
			}else{ return true;}
		})
	}
	
}]);