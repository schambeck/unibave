<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Exemplo Objetos</title>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.12/angular.min.js"></script>
    </head>
    <body>
        <div ng-app="" ng-init="pessoa={nome:'João',sobrenome:'Santos'}">
            <p>O sobrenome é {{pessoa.sobrenome}}</p>
        </div>
    </body>
</html>
