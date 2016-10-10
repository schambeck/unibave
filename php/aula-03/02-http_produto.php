<!DOCTYPE html>
<html>
    <script src= "http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
    <body>
        <div ng-app="meuApp" ng-controller="produtosCtrl"> 
            <ul>
                <li ng-repeat="x in produtos">
                    {{ x.id  + ' - ' + x.nome }}
                </li>
            </ul>
        </div>
        <script>
            var app = angular.module('meuApp', []);
            app.controller('produtosCtrl', function ($scope, $http) {
                $http.get("http://localhost:8000/app_dev.php/rest/produto")
                        .success(function (response) {
                            $scope.produtos = response;
                        });
            });
        </script>
    </body>
</html>
