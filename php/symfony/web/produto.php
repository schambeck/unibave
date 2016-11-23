<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista de Produtos</title>
        <link rel="stylesheet" type="text/css" href="produto.css">
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
    </head>
    <body>
        <div ng-app="meuApp" ng-controller="produtosCtrl"> 
            <table>
                <tr ng-repeat="x in produtos | orderBy : 'nome'">
                    <td>{{ x.id }}</td>
                    <td>{{ x.nome }}</td>
                    <td>{{ x.preco }}</td>
                    <td>{{ x.descricao }}</td>
                </tr>
            </table>
        </div>
        <script src="produto.js"></script>
    </body>
</html>
