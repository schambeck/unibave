<?php
if (isset($_POST['usuario'])) {
    $user = $_POST['usuario'];
    setcookie("usuario", $user);
    $mensagem = "Usuário $user conectado.<p>";
} else {
    $mensagem = "Digite o seu nome de usuário<p>";
}
?>
<html>
    <head>
        <title>Teste PHP</title>
    </head>
    <body>
        <?
        echo $mensagem;
        ?>
        <form method="post" action="10-cookie.php">
            Nome de Usuário: <input type="text" name="usuario">
            <br>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>