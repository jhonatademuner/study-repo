import './App.css';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom"
import Stack from '@mui/material/Stack';
import Box from '@mui/material/Box';

import { useState } from 'react'
import { getUser } from './helpers/Utils';

import Home from './pages/Home';
import Login from './pages/Login';
import Register from './pages/Register';
import CreateProduct from './pages/CreateProduct';
import ProductDetails from './pages/ProductDetails';
import NavBar from './components/NavBar';
import UpdateProduct from './pages/UpdateProduct';
import DeleteProduct from './pages/DeleteProduct';
 
function App() {

  const [isLogged, setIsLogged] = useState(getUser() ? true : false);

  function handleLogin(isAuth) {
    setIsLogged(isAuth);
  }

  return (
    <Box  sx={{ width: '100%' }}>
    <Stack spacing={2} alignItems="center" >
      
      <Router>
        <NavBar onLogin={handleLogin}/>
        <Routes>
          <Route path='/' element={ isLogged ? <Home/> : <Login onLogin={handleLogin}/>} />
          <Route path='/home' element={<Home itensPerPage={5}/>} />
          <Route path='/login' element={<Login onLogin={handleLogin}/>} />
          <Route path='/register' element={<Register/>} />
          <Route path='/createProduct' element={<CreateProduct/>} />
          <Route path='/updateProduct' element={<UpdateProduct/>} />
          <Route path='/deleteProduct' element={<DeleteProduct/>} />
          <Route path='/productDetails' element={<ProductDetails/>} />
        </Routes>
      </Router>
    </Stack>
    </Box>
  );
}

export default App;
