<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        if (strpos($_SERVER['HTTP_USER_AGENT'], 'Chrome') !== FALSE) {
        ?>
            <h3>strpos() deve retornar não-falso</h3>
            <p>Você está usando Chrome</p>
        <?php
        } else {
        ?>
            <h3>strpos() deve retornar falso</h3>
            <p>Você não está usando Chrome</p>
        <?php
        }
        ?>
    </body>
</html>
