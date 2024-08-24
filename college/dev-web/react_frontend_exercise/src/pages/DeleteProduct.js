import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { getPassword, getUser } from "../helpers/Utils";
import Stack from "@mui/material/Stack";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import Divider from "@mui/material/Divider";
import Popover from "@mui/material/Popover";

export default function DeleteProduct() {
  const [id, setId] = useState(null);
  const [anchorEl, setAnchorEl] = useState(null);

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  const open = Boolean(anchorEl);
  const popoverId = open ? "simple-popover" : undefined;

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    axios({
      method: "post",
      url: `https://productifes-dispmoveisbsi.b4a.run/excluir_produto.php?id=${id}`, // testado com api local: `http://localhost:3000/api/excluir_produto?id=${id}`
      auth: {
        username: getUser(),
        password: getPassword(),
      },
      headers: { "Content-Type": "application/x-www-form-urlencoded" },
    }).then((response) => {
      if (response.status === 200 && response.data["sucesso"] === 1) {
        window.alert("Produto excluído com sucesso");
        navigate("/");
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
            <Button
              aria-describedby={popoverId}
              variant="contained"
              onClick={handleClick}
            >
              Excluir produto
            </Button>
            <Popover
              id={popoverId}
              open={open}
              anchorEl={anchorEl}
              onClose={handleClose}
              anchorOrigin={{
                vertical: "center",
                horizontal: "center",
              }}
              transformOrigin={{
                vertical: "center",
                horizontal: "center",
              }}
            >
              <Stack spacing={2} padding={1}>
                <p>Tem certeza que deseja excluir o produto?</p>
                <Stack
                  spacing={2}
                  direction="row"
                  justifyContent="center"
                  alignItems="center"
                >
                  <Button
                    variant="contained"
                    type="submit"
                    onClick={handleSubmit}
                  >
                    Sim
                  </Button>
                  <Button
                    variant="contained"
                    onClick={handleClose}
                    color="error"
                  >
                    Não
                  </Button>
                </Stack>
              </Stack>
            </Popover>
          </Stack>
        </form>
      </Stack>
    </>
  );
}
