<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Exemplo HTTP</title>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.12/angular.min.js"></script>
    </head>
    <body>
        <div ng-app="meuApp" ng-controller="clientesCtrl"> 
            <ul>
                <li ng-repeat="x in clientes">
                    {{ x.nome + ', ' + x.pais }}
                </li>
            </ul>
        </div>
        <script>
            var app = angular.module('meuApp', []);
            app.controller('clientesCtrl', function ($scope, $http) {
                $http.get("12-clientes.json")
                        .success(function (response) {
                            $scope.clientes = response.clientes;
                        });
            });
        </script>
    </body>
</html>
