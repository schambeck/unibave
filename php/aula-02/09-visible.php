<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Exemplo Visible</title>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.12/angular.min.js"></script>
    </head>
    <body>
        <div ng-app="" ng-init="mySwitch=true">
            <p>
                <button ng-show="mySwitch">Clique me!</button>
            </p>
            <p>
                <input type="checkbox" ng-model="mySwitch"/>Botão
            </p>
            <p>
                {{ mySwitch }}
            </p>
        </div> 
    </body>
</html>
