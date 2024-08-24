import { useEffect, useState } from "react"
import ProductItem from "../components/ProductItem";
import axios from "axios";
import { getPassword, getUser } from "../helpers/Utils";
import Pagination from '@mui/material/Pagination';
import Grid from '@mui/material/Grid';
import Stack from '@mui/material/Stack';
import '../styles/Home.css';

function Items({currentItems}) {
    return (
        <Grid container spacing={2}>
            {currentItems && currentItems.map((item) => (
                <Grid item xs={2} sm={4} md={4} key={item.id}>
                    <ProductItem item={item} />
                </Grid>
            ))}
        </Grid>
    );
}

export default function Home() {

    let itensPerPage = 6;

    const handlePageClick = (event, value) => {
        const newOffset = value * itensPerPage % itensCount;
        setItemOffset(newOffset);
    }

    const [currentItems, setCurrentItems] = useState(null);
    const [pageCount, setPageCount] = useState(0);
    const [itemOffset, setItemOffset] = useState(0);
    const [itensCount, setItensCount] = useState(1);

    useEffect( () => {
        axios({
            method: 'get',
            url: 'https://productifes-dispmoveisbsi.b4a.run/pegar_produtos.php',
            params: {
                limit: itensPerPage,
                offset: itemOffset
            },
            auth: {
                username: getUser(),
                password: getPassword()
            },
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then((response) => {
            if(response.status === 200) {
                if(response.data["sucesso"] === 1) {
                    setCurrentItems(response.data["produtos"]);
                    let qtde_produtos = response.data["qtde_produtos"];
                    setItensCount(qtde_produtos);
                    setPageCount( Math.floor(qtde_produtos, itensPerPage));
                }
                else {
                    //var erro =  response.data["erro"];
                    //window.alert("Erro ao obter lista de produtos: \n" . erro);
                }
            }
            else {
                window.alert("Erro ao obter lista de produtos: \n");
            }

        })
    }, [itemOffset, itensPerPage]);


    return(
        <Stack spacing={2} alignItems="center">
            <Items currentItems={currentItems} />
            <Pagination count={pageCount} onChange={handlePageClick} />
        </Stack>   
    );
}