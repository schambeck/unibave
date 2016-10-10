<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        if (strpos($_SERVER['HTTP_USER_AGENT'], 'Chrome') !== FALSE) {
            echo 'Você está usando o Chrome';
        } elseif (strpos($_SERVER['HTTP_USER_AGENT'], 'Firefox') !== FALSE) {
            echo 'Você está usando o Firefox';
        } else {
            echo 'Navegador não identificado';
        }
        ?>
    </body>
</html>
