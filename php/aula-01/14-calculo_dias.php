<?php

date_default_timezone_set("Brazil/East");
$data1 = new DateTime('2016-10-01');
$data2 = new DateTime();

$intervalo = $data1->diff( $data2 );

echo "Intervalo é de {$intervalo->days} dias";

?>
