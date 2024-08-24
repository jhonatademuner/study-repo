import '../styles/CreateProduct.css';
import { useState } from 'react';
import axios from 'axios';
import { getPassword, getUser } from '../helpers/Utils';
import { useNavigate } from "react-router-dom";
import { MuiFileInput } from 'mui-file-input';
import Stack from '@mui/material/Stack';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';

export default function CreateProduct() {
    
    const navigate = useNavigate();

    const [name, setName] = useState("");
    const [price, setPrice] = useState("");
    const [description, setDescription] = useState("");
    const [selectedImage, setSelectedImage] = useState(null);

    const handleFileInputChange = (newFile) => {
        setSelectedImage(newFile)
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        if(!selectedImage) {
            window.alert("É preciso selecionar uma imagem para o produto");
            return;
        }

        const formData = new FormData();
        formData.append('nome', name);
        formData.append('preco', price);
        formData.append('descricao', description);
        formData.append('img', selectedImage);

        axios({
            method: 'post',
            url: 'https://productifes-dispmoveisbsi.b4a.run/criar_produto.php',
            data: formData,
            auth: {
                username: getUser(),
                password: getPassword()
            },
            headers: { "Content-Type": "multipart/form-data"}
        }).then((response) => {
            if(response.data["sucesso"] === 1) {
                window.alert("Produto criado com sucesso");
                navigate('/');
            }
            else {
                window.alert("Erro ao cadastrar produto: \n" + response.data["erro"]);
            }
        });
    };

    return (
        <form onSubmit={handleSubmit}>
            <Stack spacing={2}>
                {selectedImage  && (
                    <img alt='product_img'
                    src={URL.createObjectURL(selectedImage)}
                />
                )}
                <MuiFileInput 
                    inputProps={{ accept: 'image/*' }}
                    value={selectedImage} 
                    onChange={handleFileInputChange} />
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
                <Button variant="contained" type="submit">
                    Criar Produto
                </Button>
            </Stack>
        </form>
    );
}
