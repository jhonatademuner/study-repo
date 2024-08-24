import React, { useState } from "react";
import axios from "axios";
import { getPassword, getUser } from "../helpers/Utils";
import ProductDetailItem from "../components/ProductDetailItem";
import Stack from "@mui/material/Stack";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import Divider from "@mui/material/Divider";

export default function ProductDetails() {
  const [id, setId] = useState(null);
  const [product, setProduct] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();

    axios({
      method: "get",
      url: `https://productifes-dispmoveisbsi.b4a.run/pegar_detalhes_produto.php?id=${id}`,
      auth: {
        username: getUser(),
        password: getPassword(),
      },
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
    }).then((response) => {
      if (response.status === 200 && response.data["sucesso"] === 1) {
        setProduct(response.data);
      } else {
      }
    });
  };

  return (
    <>
      <Stack
        direction="row"
        alignItems="center"
        divider={<Divider orientation="vertical" flexItem />}
        spacing={2}
      >
        <form onSubmit={handleSubmit}>
          <Stack spacing={2}>
            <TextField
              required
              name="productId"
              label="ID do Produto"
              placeholder="Digite o ID do produto"
              onChange={(e) => setId(e.target.value)}
            />
            <Button variant="contained" type="submit">
              Buscar detalhes do produto
            </Button>
          </Stack>
        </form>
        {product && (
          <ProductDetailItem item={product} />
          )}
      </Stack>
    </>
  );
}
