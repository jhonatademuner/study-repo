import '../styles/register.css';
import { useState } from 'react';
import axios from 'axios';
import Stack from '@mui/material/Stack';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';

export default function Register() {

    const [userName, setUserName] = useState("");
    const [userPassword, setUserPassword] = useState("");
    const [userPasswordAgain, setUserPasswordAgain] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();

        if(userPassword !== userPasswordAgain) {
            window.alert("Campos de senha não batem");
            return;
        }

        let data = {
            novo_login : userName,
            nova_senha : userPassword
        };

        await axios.post('https://productifes-dispmoveisbsi.b4a.run/registrar.php',
            data,
            {headers: {'Content-Type': 'application/x-www-form-urlencoded'}}
        ).then((response) => {
            if(response.data["sucesso"] === 1) {
                window.alert("Usuário registrado com sucesso!");
            }
            else {
                window.alert("Erro ao registrar usuário: \n" + response.data["erro"]);
            }
        });
    };

    return (
        <form onSubmit={handleSubmit}>
            <Stack spacing={2}>
                <TextField
                    required
                    name="userName"
                    label="Login"
                    value={userName}
                    onChange={(e) => setUserName(e.target.value)}
                />
                <TextField
                    required
                    name="userPassword"
                    label="Senha"
                    type="password"
                    autoComplete="current-password"
                    value={userPassword}
                    onChange={(e) => setUserPassword(e.target.value)}
                />
                <TextField
                    required
                    name="userPasswordAgain"
                    label="Senha Novamente"
                    type="password"
                    autoComplete="current-password"
                    value={userPassword}
                    onChange={(e) => setUserPasswordAgain(e.target.value)}
                />
                <Button variant="contained" type="submit">
                    Cadastrar
                </Button>
            </Stack>
        </form>
    );
}
