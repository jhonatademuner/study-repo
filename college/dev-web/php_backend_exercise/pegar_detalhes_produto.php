<?php

header('Access-Control-Allow-Origin: *');
header("Access-Control-Allow-Headers: *");

require_once('conexao_db.php');

require_once('autenticacao.php');

$resposta = "";

if(autenticar($db_con)) {
	
	if (isset($_GET['productId'])) {
	 
		$productId = $_GET['productId'];
 
		$consulta = $db_con->prepare("SELECT * FROM produtos WHERE ID = " . $productId);

		if($consulta->execute()) {
			
            $resposta = $consulta->fetch(PDO::FETCH_ASSOC);

		}
		else {
			$resposta["sucesso"] = 0;
			$resposta["erro"] = "Erro no BD: " . $consulta->errorinfo()[2] ;
			$resposta["cod_erro"] = 2;
		}
	}
	else {
		$resposta["sucesso"] = 0;
		$resposta["erro"] = "Campo requerido não preenchido";
		$resposta["cod_erro"] = 3;
	}
}
else {
	$resposta["sucesso"] = 0;
	$resposta["erro"] = "usuario ou senha não confere";
	$resposta["cod_erro"] = 0;
}

$db_con = null;

echo json_encode($resposta);
?>