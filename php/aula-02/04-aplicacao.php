<!DOCTYPE html>
<html>
    <head>
        <title>Exemplo Aplicação</title>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.12/angular.min.js"></script>
    </head>
    <body>
        <div ng-app="myApp" ng-controller="myCtrl">

        Nome: <input type="text" ng-model="nome"><br>
        Sobrenome: <input type="text" ng-model="sobrenome"><br>
        <br>
        Nome completo: {{nome + " " + sobrenome}}

        </div>
        <script>
            var app = angular.module('myApp', []);
            app.controller('myCtrl', function($scope) {
                $scope.nome= "John";
                $scope.sobrenome= "Doe";
            });
        </script>
    </body>
</html>
