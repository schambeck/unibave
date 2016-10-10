<?php

class ImpostoRenda {

    function calcular($salarioBruto, $valorINSS, $dependentes) {
        $valorDependentes = 189.59 * $dependentes;
        $baseCalculo = $salarioBruto - $valorINSS - $valorDependentes;
        if ($baseCalculo <= 1903.98) {
            $aliquota = 0;
        } elseif ($baseCalculo <= 2826.65) {
            $aliquota = 7.5;
            $valorDeducao = 142.8;
        } elseif ($baseCalculo <= 3751.05) {
            $aliquota = 15;
            $valorDeducao = 354.8;
        } elseif ($baseCalculo <= 4664.68) {
            $aliquota = 22.5;
            $valorDeducao = 636.13;
        } else {
            $aliquota = 27.5;
            $valorDeducao = 869.36;
        }
        $valor = ($baseCalculo / 100 * $aliquota) - $valorDeducao;
        return $valor;
    }

    function calcularINSS($salarioBruto) {
        if ($salarioBruto <= 1399.12) {
            $aliquota = 8;
        } elseif ($salarioBruto <= 2331.88) {
            $aliquota = 9;
        } else {
            $aliquota = 11;
        }
        $valor = $salarioBruto / 100 * $aliquota;
        return $valor;
    }

}

$salarioBruto = 10000;
$impostoRenda = new ImpostoRenda;
$valorINSS = $impostoRenda->calcularINSS($salarioBruto);
$valorImpostoRenda = $impostoRenda->calcular($salarioBruto, $valorINSS, 0);
$salarioLiquido = $salarioBruto - $valorImpostoRenda - $valorINSS;
echo "Salário Bruto: $salarioBruto</br>Imposto Renda: $valorImpostoRenda</br>Salário Líquido: $salarioLiquido";
?>
