<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Exemplo Tabela</title>
        <link rel="stylesheet" href = "http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.12/angular.min.js" type="text/javascript"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/restangular/1.3.1/restangular.min.js" type="text/javascript"></script>
    </head>
    <body ng-app="meuApp" ng-controller="usuarioCtrl">
        <div class="container">
            <h3>Usuários</h3>
            <button class="btn btn-success" ng-click="editar('new')">
                <span class="glyphicon glyphicon-usuario"></span>  Criar Novo Usuário
            </button>
            <hr>
            <h3 ng-show="editando">Criar Novo Usuário:</h3>
            <h3 ng-hide="editando">Editar Usuário:</h3>
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label class="col-sm-2">Id:</label>
                    <div class="col-sm-10">
                        <input type="text" ng-model="campos.id" ng-disabled="true" placeholder="Id" class="form-control">
                    </div>
                </div> 
                <div class="form-group">
                    <label class="col-sm-2">Nome:</label>
                    <div class="col-sm-10">
                        <input type="text" ng-model="campos.nome" placeholder="Nome" class="form-control">
                    </div>
                </div> 
                <div class="form-group">
                    <label class="col-sm-2">Sobrenome:</label>
                    <div class="col-sm-10">
                        <input type="text" ng-model="campos.sobrenome" placeholder="Sobrenome" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2">Senha:</label>
                    <div class="col-sm-10">
                        <input type="password" ng-model="campos.senha" placeholder="Senha" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2">Repetir Senha:</label>
                    <div class="col-sm-10">
                        <input type="password" ng-model="senha2" placeholder="Repetir Senha" class="form-control">
                    </div>
                </div>
            </form>
            <hr>
            <button class="btn btn-success" ng-disabled="error || incomplete" ng-click="salvar()">
                <span class="glyphicon glyphicon-save"></span>  Gravar Alterações
            </button>
            <hr>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>Editar</th>
                        <th>Nome</th>
                        <th>Sobrenome</th>
                    </tr>
                </thead>
                <tbody>
                    <tr ng-repeat="usuario in usuarios">
                        <td>
                            <button class="btn" ng-click="editar(usuario)">
                                <span class="glyphicon glyphicon-pencil"></span>  Editar
                            </button>
                            <button class="btn" ng-click="excluir(usuario)">
                                <span class="glyphicon glyphicon-pencil"></span>  Excluir
                            </button>
                        </td>
                        <td>{{ usuario.nome }}</td>
                        <td>{{ usuario.sobrenome }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <script src= "14-cadastro_usuario.js"></script>
    </body>
</html>
