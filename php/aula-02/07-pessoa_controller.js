angular.module('meuApp', []).controller('pessoaCtrl', function($scope) {
    $scope.pessoas = [
        {nome:'João',pais:'Itália'},
        {nome:'Daniel',pais:'Suécia'},
        {nome:'Fábio',pais:'Dinamarca'}
    ];
});