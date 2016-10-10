<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Exemplo Clique</title>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.12/angular.min.js"></script>
    </head>
    <body>
        <div ng-app="meuApp" ng-controller="meuCtrl">
            <button ng-click="count = count + 1">Clique me!</button>
            <p>{{ count }}</p>
        </div>
        <script>
            var app = angular.module('meuApp', []);
            app.controller('meuCtrl', function ($scope) {
                $scope.count = 0;
            });
        </script> 
    </body>
</html>
