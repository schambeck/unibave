<?php

function foo() {
    echo "Chamou foo()<br>\n";
}

function bar($arg = '') {
    echo "Chamou bar(); com argumento '$arg'.<br />\n";
}

// Essa eh uma funcao wrapper para echo()
function echoit($string) {
    echo $string;
}

$func = 'foo';
$func();        // Chama foo()

$func = 'bar';
$func('test');  // Chama bar()

$func = 'echoit';
$func('test');  // Chama echoit()
?>