<!DOCTYPE html>
<html>
    <head>
        <title>Exemplo 1</title>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.12/angular.min.js"></script>
    </head>
    <body>
        <div ng-app="">
            <p>Nome: <input type="text" ng-model="nome"></p>
            <p ng-bind="nome"></p>
        </div>
    </body>
</html>