<?php
// define $authorized = true somente se o usuário for autenticado
if (authenticated_user()) {
    $authorized = true;
}
// Porque nós não inicializamos $authorized como false, ela pode ser
// definida através de register_globals, como usando GET auth.php?authorized=1
// Dessa maneira, qualquer um pode ser visto como autenticado!
if ($authorized) {
    echo "<p>Usuário autorizado!</p>";
} else {
    echo "<p>Usuário não autorizado!</p>";
}

function authenticated_user() {
    return FALSE;
}
?>
