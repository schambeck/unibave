<?php

session_start();

if (empty($_SESSION['count'])) {
 $_SESSION['count'] = 1;
} else {
 $_SESSION['count']++;
}
?>

<p>
Olá visitante, você já visitou esta página <?php echo $_SESSION['count']; ?> vezes.
</p>
