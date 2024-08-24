import "../styles/CreateProduct.css";
import { useState } from "react";
import axios from "axios";
import { getPassword, getUser } from "../helpers/Utils";
import { useNavigate } from "react-router-dom";
import { MuiFileInput } from "mui-file-input";
import Stack from "@mui/material/Stack";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import Popover from "@mui/material/Popover";

export default function UpdateProduct() {

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

  const [id, setId] = useState("");
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [description, setDescription] = useState("");
  const [selectedImage, setSelectedImage] = useState(null);

  const handleFileInputChange = (newFile) => {
    setSelectedImage(newFile);
  };

  const handleGetProduct = async (e) => {
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
        setName(response.data["nome"]);
        setPrice(response.data["preco"]);
        setDescription(response.data["descricao"]);
      } else {
      }
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!selectedImage) {
      window.alert("É preciso selecionar uma imagem para o produto");
      return;
    }

    const formData = new FormData();
    formData.append("id", id);
    formData.append("novo_nome", name);
    formData.append("novo_preco", price);
    formData.append("nova_descricao", description);
    formData.append("nova_img", selectedImage);

    axios({
      method: "post",
      url: "https://productifes-dispmoveisbsi.b4a.run/atualizar_produto.php", // testado com api local: `http://localhost:3000/api/atualizar_produto` 
      data: formData,
      auth: {
        username: getUser(),
        password: getPassword(),
      },
      headers: { "Content-Type": "multipart/form-data" },
    }).then((response) => {
      if (response.data["sucesso"] === 1) {
        window.alert("Produto atualizado com sucesso");
        navigate("/");
      } else {
        window.alert("Erro ao atualizar produto: \n" + response.data["erro"]);
      }
    });
  };

  return (
    <form onSubmit={handleSubmit}>
      <Stack spacing={2}>
        <Stack spacing={2} direction="row">
          <TextField
            required
            name="id"
            label="ID do Produto"
            value={id}
            onChange={(e) => setId(e.target.value)}
          />
          <Button variant="contained" type="submit" onClick={handleGetProduct}>
            Pegar informações do produto
          </Button>
        </Stack>
        {selectedImage && <img src={URL.createObjectURL(selectedImage)} alt="preview"/>}
        <MuiFileInput
          inputProps={{ accept: "image/*" }}
          value={selectedImage}
          onChange={handleFileInputChange}
        />
        <TextField
          required
          name="name"
          label="Nome"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <TextField
          required
          name="price"
          label="Preço"
          value={price}
          onChange={(e) => setPrice(e.target.value)}
        />
        <TextField
          required
          name="description"
          label="Descrição"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        />
        <Button aria-describedby={popoverId}
              variant="contained"
              onClick={handleClick}>
          Atualizar Produto
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
                <p>Tem certeza que deseja atualizar o produto?</p>
                <Stack spacing={2} direction="row" justifyContent="center" alignItems="center">
                  <Button variant="contained" type="submit" onClick={handleSubmit}>
                    Sim
                  </Button>
                  <Button variant="contained" onClick={handleClose} color="error">
                    Não
                  </Button>
                </Stack>
              </Stack>
            </Popover>
      </Stack>
    </form>
  );
}
