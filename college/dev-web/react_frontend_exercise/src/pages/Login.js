import '../styles/login.css';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { login } from '../helpers/Utils';
import Stack from '@mui/material/Stack';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';

export default function Login({onLogin}) {

    const [userName, setUserName] = useState("");
    const [userPassword, setUserPassword] = useState("");

    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();

        axios(
            {
                method: 'post',
                url: 'https://productifes-dispmoveisbsi.b4a.run/login.php',
                auth: {
                    username: userName,
                    password: userPassword
                }
            }
        ).then((response) => {
            if(response.data["sucesso"] === 1) {
                login(userName, userPassword);
                onLogin(true);
                navigate('/');
            }
            else {
                window.alert("Erro ao autenticar usuário: \n" + response.data["erro"]);
            }
        });
    };

    return (
        <form onSubmit={handleSubmit}>
            <Stack spacing={2}>
                <TextField
                    required
                    id="outlined-required"
                    name="userName"
                    label="Login"
                    value={userName}
                    onChange={(e) => setUserName(e.target.value)}
                />
                <TextField
                    required
                    id="outlined-password-input"
                    name="userPassword"
                    label="Password"
                    type="password"
                    autoComplete="current-password"
                    value={userPassword}
                    onChange={(e) => setUserPassword(e.target.value)}
                />
                <Button variant="contained" type="submit">
                    Login
                </Button>
            </Stack>
        </form>
    );
}
