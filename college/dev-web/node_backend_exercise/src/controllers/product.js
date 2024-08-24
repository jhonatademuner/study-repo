const db = require("../config/database");
const { ImgurClient } = require("imgur");
const dotenv = require("dotenv");
const { createReadStream } = require("fs");

exports.getAllProducts = async (req, res) => {
  if (req.query.hasOwnProperty("limit") && req.query.hasOwnProperty("offset")) {
    const { limit, offset } = req.query;
    try {
      const getAllProductsQuery = await db.query(
        "SELECT * FROM produtos LIMIT $1 OFFSET $2",
        [limit, offset]
      );
      if (getAllProductsQuery.rows.length !== 0) {
        res.status(200).send({
          sucesso: 1,
          produtos: getAllProductsQuery.rows,
          qtde_produtos: getAllProductsQuery.rows.length,
        });
      }
    } catch (err) {
      var errorMsg = "erro BD: ";
      -res.status(200).send({
        sucesso: 0,
        cod_erro: 2,
        erro: errorMsg.concat(err),
      });
    }
  } else {
    var errorMsg = "faltam parametros";
    res.status(200).send({
      sucesso: 0,
      cod_erro: 3,
      erro: errorMsg,
    });
  }
};

exports.addProduct = async (req, res) => {
  if (
    "nome" in req.body &&
    "preco" in req.body &&
    "descricao" in req.body &&
    req.hasOwnProperty("file")
  ) {
    const { nome, preco, descricao } = req.body;

    const imgurClient = new ImgurClient({
      clientId: process.env.IMGUR_CLIENT_ID,
    });
    const imgurRes = await imgurClient.upload({
      image: createReadStream(req.file.path),
      type: "stream",
    });
    if (imgurRes.status === 200) {
      try {
        const addProductQuery = await db.query(
          "INSERT INTO produtos(nome, preco, descricao, img, usuarios_login) VALUES($1, $2, $3, $4, $5)",
          [nome, preco, descricao, imgurRes.data.link, req.auth.user]
        );
        res.status(200).send({
          sucesso: 1,
        });
      } catch (err) {
        var erroMsg = "erro BD: ";
        res.status(200).send({
          sucesso: 0,
          cod_erro: 2,
          erro: erroMsg.concat(err),
        });
      }
    } else {
      res.status(200).send({
        sucesso: 0,
        cod_erro: 2,
        erro: "erro IMGUR: falha ao subir imagem para o IMGUR",
      });
    }
  } else {
    var erroMsg = "faltam parametros";
    res.status(200).send({
      sucesso: 0,
      cod_erro: 3,
      erro: erroMsg,
    });
  }
};

exports.getProductDetails = async (req, res) => {
  const { id } = req.query;
  if (id) {
    try {
      const getProductDetailsQuery = await db.query(
        "SELECT * FROM produtos where id = $1",
        [id]
      );
      if (getProductDetailsQuery.rows.length !== 0) {
        const product = getProductDetailsQuery.rows[0];
        const responseObject = {
          sucesso: 1,
          nome: product.nome,
          preco: product.preco,
          descricao: product.descricao,
          criado_por: product.usuarios_login,
          criado_em: product.criado_em,
          img: product.img,
        };
        res.status(200).send(responseObject);
      } else {
        res.status(200).send({
          sucesso: 0,
          cod_erro: 2,
          erro: "produto nao existe",
        });
        return;
      }
    } catch (err) {
      var errorMsg = "erro BD: ";
      res.status(200).send({
        sucesso: 0,
        cod_erro: 2,
        erro: errorMsg.concat(err),
      });
    }
  } else {
    var erroMsg = "faltam parametros";
    res.status(200).send({
      sucesso: 0,
      cod_erro: 3,
      erro: erroMsg,
    });
  }
};

exports.updateProduct = async (req, res) => {
  if (
    "novo_nome" in req.body &&
    "novo_preco" in req.body &&
    "nova_descricao" in req.body &&
    req.hasOwnProperty("file") &&
    "id" in req.body
  ) {
    const { novo_nome, novo_preco, nova_descricao, id } = req.body;
    const imgurClient = new ImgurClient({
      clientId: process.env.IMGUR_CLIENT_ID,
    });
    const imgurRes = await imgurClient.upload({
      image: createReadStream(req.file.path),
      type: "stream",
    });
    if (imgurRes.status === 200) {
      try {
        const authUserQuery = await db.query(
          "SELECT * FROM produtos WHERE id = $1 AND usuarios_login = $2",
          [id, req.auth.user]
        );
        if (authUserQuery.rows.length === 0) {
          res.status(200).send({
            sucesso: 0,
            cod_erro: 2,
            erro: "produto nao existe ou nao pertence ao usuario logado",
          });
          return;
        }
        const updateProductQuery = await db.query(
          "UPDATE produtos SET nome = $2 , preco = $3 , descricao = $4, img = $5 WHERE id = $1 AND usuarios_login = $6",
          [
            id,
            novo_nome,
            novo_preco,
            nova_descricao,
            imgurRes.data.link,
            req.auth.user,
          ]
        );
        res.status(200).send({
          sucesso: 1,
        });
      } catch (err) {
        var erroMsg = "erro BD: ";
        res.status(200).send({
          sucesso: 0,
          cod_erro: 2,
          erro: erroMsg.concat(err),
        });
      }
    } else {
      res.status(200).send({
        sucesso: 0,
        cod_erro: 2,
        erro: "erro IMGUR: falha ao subir imagem para o IMGUR",
      });
    }
  } else {
    var erroMsg = "faltam parametros";
    res.status(200).send({
      sucesso: 0,
      cod_erro: 3,
      erro: erroMsg,
    });
  }
};

exports.deleteProduct = async (req, res) => {
  const { id } = req.query;
  if (id) {
    try {
      const authUserQuery = await db.query(
        "SELECT * FROM produtos WHERE id = $1 AND usuarios_login = $2",
        [id, req.auth.user]
      );
      if (authUserQuery.rows.length === 0) {
        res.status(200).send({
          sucesso: 0,
          cod_erro: 2,
          erro: "produto nao existe ou nao pertence ao usuario logado",
        });
        return;
      }
      const deleteProductQuery = await db.query(
        "DELETE FROM produtos WHERE id = $1 AND usuarios_login = $2",
        [id, req.auth.user]
      );
      res.status(200).send({
        sucesso: 1,
      });
    } catch (err) {
      var erroMsg = "erro BD: ";
      res.status(200).send({
        sucesso: 0,
        cod_erro: 2,
        erro: erroMsg.concat(err),
      });
    }
  } else {
    var erroMsg = "faltam parametros";
    res.status(200).send({
      sucesso: 0,
      cod_erro: 3,
      erro: erroMsg,
    });
  }
};
