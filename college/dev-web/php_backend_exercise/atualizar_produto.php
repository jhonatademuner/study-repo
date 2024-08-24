<?php

header('Access-Control-Allow-Origin: *');
header("Access-Control-Allow-Headers: *");

require_once('conexao_db.php');

require_once('autenticacao.php');

$resposta = array();

if(autenticar($db_con)) {
	
	if (isset($_POST['productId']) && isset($_POST['novo_nome']) && isset($_POST['novo_preco']) && isset($_POST['nova_descricao']) && isset($_FILES['nova_img'])) {
        
        $productId = $_POST['productId'];
		$nome = $_POST['novo_nome'];
        $preco = $_POST['novo_preco'];
        $descricao = $_POST['nova_descricao'];
        
        $filename = $_FILES['nova_img']['tmp_name'];
		$client_id="ce5d3a656e2aa51";
		$handle = fopen($filename, "r");
		$data = fread($handle, filesize($filename));
		$pvars   = array('image' => base64_encode($data));
		$timeout = 30;
		$curl = curl_init();
		curl_setopt($curl, CURLOPT_URL, 'https://api.imgur.com/3/image.json');
		curl_setopt($curl, CURLOPT_TIMEOUT, $timeout);
		curl_setopt($curl, CURLOPT_HTTPHEADER, array('Authorization: Client-ID ' . $client_id));
		curl_setopt($curl, CURLOPT_POST, 1);
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
		curl_setopt($curl, CURLOPT_POSTFIELDS, $pvars);
		$out = curl_exec($curl);
		curl_close ($curl);
		$pms = json_decode($out,true);
		$img_url=$pms['data']['link'];

        if ( isset( $_SERVER['PHP_AUTH_USER'] ) ) {
            $login = $_SERVER['PHP_AUTH_USER'];
        }
        elseif(isset( $_SERVER['HTTP_AUTHORIZATION'])) {
            if(preg_match( '/^basic/i', $_SERVER['HTTP_AUTHORIZATION']))
                list($login) = explode(':', base64_decode(substr($_SERVER['HTTP_AUTHORIZATION'], 6)));
        }

        $consulta = $db_con->prepare("UPDATE produtos SET nome = '$nome', preco = '$preco', descricao = '$descricao', img = '$img_url' WHERE ID = $productId AND usuarios_login = '$login'");

		if ($consulta->execute()) {
			$resposta["sucesso"] = 1;
		} else {
			$resposta["sucesso"] = 0;
			$resposta["erro"] = "Erro ao criar produto no BD: " . $consulta->errorInfo()[2];
			$resposta["cod_erro"] = 2;
		}
	} else {
		$resposta["sucesso"] = 0;
		$resposta["erro"] = "Campo requerido nao preenchido";
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