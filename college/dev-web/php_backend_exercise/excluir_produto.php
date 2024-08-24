<?php

header('Access-Control-Allow-Origin: *');
header("Access-Control-Allow-Headers: *");

require_once('conexao_db.php');

require_once('autenticacao.php');

$resposta = array();

if(autenticar($db_con)) {
	
	if (isset($_POST['productId'])) {

        if ( isset( $_SERVER['PHP_AUTH_USER'] ) ) {
            $login = $_SERVER['PHP_AUTH_USER'];
        }
        elseif(isset( $_SERVER['HTTP_AUTHORIZATION'])) {
            if(preg_match( '/^basic/i', $_SERVER['HTTP_AUTHORIZATION']))
                list($login) = explode(':', base64_decode(substr($_SERVER['HTTP_AUTHORIZATION'], 6)));
        }
	 
		$productId = $_POST['productId'];
 
		$consulta = $db_con->prepare("DELETE FROM produtos WHERE ID = $productId AND usuarios_login = '$login'");

		if($consulta->execute()) {			
            $resposta["sucesso"] = 1;
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