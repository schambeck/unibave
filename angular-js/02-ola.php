<!DOCTYPE html>
<html>
    <head>
        <title>Exemplo Olá!</title>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.12/angular.min.js"></script>
    </head>
    <body>
        <div ng-app="">
                <p>Nome: <input type="text" ng-model="nome"></p>
                <h1>Olá {{nome}}</h1>
        </div>
</body>
</html>