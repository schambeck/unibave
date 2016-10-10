<!DOCTYPE html>
<html>
    <style>
        table, th , td  {
            border: 1px solid grey;
            border-collapse: collapse;
            padding: 5px;
        }
        table tr:nth-child(odd)	{
            background-color: #f1f1f1;
        }
        table tr:nth-child(even) {
            background-color: #ffffff;
        }
    </style>
    <script src= "http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
    <body>
        <div ng-app="meuApp" ng-controller="produtosCtrl"> 
            <table>
                <tr ng-repeat="x in produtos | orderBy : 'id'">
                    <td>{{ x.id }}</td>
                    <td>{{ x.nome }}</td>
                    <td>{{ x.preco }}</td>
                    <td>{{ x.descricao }}</td>
                </tr>
            </table>
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
