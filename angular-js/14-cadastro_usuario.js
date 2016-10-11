angular.module('meuApp', []).controller('usuarioCtrl', function ($scope, $http) {
    $scope.campos = {id: null, nome: "", sobrenome: "", senha: ""};
    $scope.campos.id = null;
    $scope.campos.nome = '';
    $scope.campos.sobrenome = '';
    $scope.campos.senha = '';
    $scope.senha2 = '';
    $http.get("http://localhost:8000/app_dev.php/rest/usuario")
                        .success(function (response) {
                            $scope.usuarios = response;
                        });
//    $scope.usuarios = [
//        {id: 1, nome: 'Hege', sobrenome: "Pege"},
//        {id: 2, nome: 'Kim', sobrenome: "Pim"},
//        {id: 3, nome: 'Sal', sobrenome: "Smith"},
//        {id: 4, nome: 'Jack', sobrenome: "Jones"},
//        {id: 5, nome: 'John', sobrenome: "Doe"},
//        {id: 6, nome: 'Peter', sobrenome: "Pan"}
//    ];
    $scope.editando = true;
    $scope.error = false;
    $scope.incomplete = false;

    $scope.editar = function (id) {
        if (id == 'new') {
            $scope.editando = true;
            $scope.incomplete = true;
            $scope.campos.id = null;
            $scope.campos.nome = '';
            $scope.campos.sobrenome = '';
        } else {
            $scope.editando = false;
            $scope.campos.id = id.id;
            $scope.campos.nome = id.nome;
            $scope.campos.sobrenome = id.sobrenome;
        }
    };
    
    $scope.salvar = function () {
        if ($scope.campos.id == null) {
            $http.post('http://localhost:8000/app_dev.php/rest/usuario/', $scope.campos)
                        .success(function(data, status){
                            $scope.campos.id = data.id;
                            alert('Usuário cadastrado com sucesso: ' + data.id + ' - ' + data.nome);
                        })
                        .error(function(data, status){
                            alert('Falha ao atualizar usuário');
                        });
        } else {
            $http.put('http://localhost:8000/app_dev.php/rest/usuario/', $scope.campos)
                        .success(function(data, status){
                            $scope.campos.id = data.id;
                            alert('Usuário atualizado com sucesso: ' + data.id + ' - ' + data.nome);
                        })
                        .error(function(data, status){
                            alert('Falha ao atualizar usuário');
                        });
        }
    };

    $scope.excluir = function (id) {
        $http.delete('http://localhost:8000/app_dev.php/rest/usuario/' + id.id)
                    .success(function(data, status){
                        alert('Usuário excluído com sucesso: ' 
                        + id.id + ' - ' + id.nome);
                    })
                    .error(function(data, status){
                        alert('Falha ao excluir usuário');
                    });
    };

    $scope.$watch('senha', function () {
        $scope.validar();
    });
    $scope.$watch('senha2', function () {
        $scope.validar();
    });
    $scope.$watch('nome', function () {
        $scope.validar();
    });
    $scope.$watch('sobrenome', function () {
        $scope.validar();
    });

    $scope.validar = function () {
        if ($scope.campos.senha !== $scope.senha2) {
            $scope.error = true;
        } else {
            $scope.error = false;
        }
        $scope.incomplete = false;
        if ($scope.editando && (!$scope.campos.nome.length ||
                !$scope.campos.sobrenome.length ||
                !$scope.campos.senha.length || !$scope.senha2.length)) {
            $scope.incomplete = true;
        }
    };
});
