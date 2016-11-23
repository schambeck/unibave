var app = angular.module('meuApp', []);
app.controller('produtosCtrl', function ($scope, $http) {
    $http.get("/rest/produtos")
        .then(function (response) {
            $scope.produtos = response.data;
        }, function(response) {
            alert('Falha: ' + response.status + " " + response.statusText);
        });
});
