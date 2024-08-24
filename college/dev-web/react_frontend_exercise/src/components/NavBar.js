import { getUser, logout } from "../helpers/Utils";
import * as React from 'react';
import { useNavigate } from 'react-router-dom';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import Menu from '@mui/material/Menu';
import MenuIcon from '@mui/icons-material/Menu';
import Container from '@mui/material/Container';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import Tooltip from '@mui/material/Tooltip';
import MenuItem from '@mui/material/MenuItem';
import AdbIcon from '@mui/icons-material/Adb';


function NavBar({onLogin}) {
  const [anchorElNav, setAnchorElNav] = React.useState(null);
  const [anchorElUser, setAnchorElUser] = React.useState(null);

  const navigate = useNavigate();

  const handleOpenNavMenu = (event) => {
    setAnchorElNav(event.currentTarget);
  };
  const handleOpenUserMenu = (event) => {
    setAnchorElUser(event.currentTarget);
  };

  const handleCloseNavMenu = (op) => {
    setAnchorElNav(null);
    handleMenuOptions(op);
  };

  const handleCloseUserMenu = (op) => {
    setAnchorElUser(null);
    handleMenuOptions(op);
  };

  const handleMenuOptions = (op) => {
    if(op === 'opLogout' ) {
      logout();
      onLogin(false);
      navigate('/');
    }
    if(op === 'opHome' ) {
      navigate('/'); 
    }
    if(op === 'opNewProduct' ) {
      navigate('/createProduct'); 
    }
    if(op === 'opUpdateProduct' ) {
      navigate('/updateProduct'); 
    }
    if(op === 'opDeleteProduct' ) {
      navigate('/deleteProduct'); 
    }
    if(op === 'opProductDetails' ) {
      navigate('/productDetails'); 
    }
    if(op === 'opLogin' ) {
      navigate('/login'); 
    }
    if(op === 'opRegisterUser' ) {
      navigate('/register'); 
    }
  }

  let pages;
  let settings;
  let avatarLetter;

  let userLogin = getUser();

  if(userLogin) {
    pages = [
      {
        op : 'opNewProduct',
        text : 'Cadastar Produto'
      },
      {
        op : 'opUpdateProduct',
        text : 'Atualizar Produto'
      },
      {
        op : 'opDeleteProduct',
        text : 'Remover Produto'
      },
      {
        op : 'opProductDetails',
        text : 'Buscar Detalhes do Produto'
      }
    ];

    settings = [
      {
        op : 'opLogout',
        text : 'Logout'
      }
    ];

    avatarLetter = userLogin.toUpperCase()[0];
  }
  else {
    pages = [
      {
        op : 'opLogin',
        text : 'Login'
      },
      {
        op : 'opRegisterUser',
        text : 'Cadastar Usuário'
      }
    ];
    
    settings = [];
    avatarLetter = '';
  }

  return (
    <AppBar position="static">
      <Container maxWidth="xl">
        <Toolbar disableGutters>
          <AdbIcon sx={{ display: { xs: 'none', md: 'flex' }, mr: 1 }} />
          <Typography
            variant="h6"
            noWrap
            component="a"
            href=""
            onClick={() => handleMenuOptions('opHome')}
            sx={{
              mr: 2,
              display: { xs: 'none', md: 'flex' },
              fontFamily: 'monospace',
              fontWeight: 700,
              letterSpacing: '.3rem',
              color: 'inherit',
              textDecoration: 'none',
            }}
          >
            PRODUTOS
          </Typography>

          <Box sx={{ flexGrow: 1, display: { xs: 'flex', md: 'none' } }}>
            <IconButton
              size="large"
              aria-label="account of current user"
              aria-controls="menu-appbar"
              aria-haspopup="true"
              onClick={handleOpenNavMenu}
              color="inherit"
            >
              <MenuIcon />
            </IconButton>
            <Menu
              id="menu-appbar"
              anchorEl={anchorElNav}
              anchorOrigin={{
                vertical: 'bottom',
                horizontal: 'left',
              }}
              keepMounted
              transformOrigin={{
                vertical: 'top',
                horizontal: 'left',
              }}
              open={Boolean(anchorElNav)}
              onClose={handleCloseNavMenu}
              sx={{
                display: { xs: 'block', md: 'none' },
              }}
            >
              {pages.map((page) => (
                <MenuItem key={page.op} onClick={() => handleCloseNavMenu(page.op)}>
                  <Typography textAlign="center">{page.text}</Typography>
                </MenuItem>
              ))}
            </Menu>
          </Box>
          <AdbIcon sx={{ display: { xs: 'flex', md: 'none' }, mr: 1 }} />
          <Typography
            variant="h5"
            noWrap
            component="a"
            href=""
            onClick={() => handleMenuOptions('opHome')}
            sx={{
              mr: 2,
              display: { xs: 'flex', md: 'none' },
              flexGrow: 1,
              fontFamily: 'monospace',
              fontWeight: 700,
              letterSpacing: '.3rem',
              color: 'inherit',
              textDecoration: 'none',
            }}
          >
            PRODUTOS
          </Typography>
          <Box sx={{ flexGrow: 1, display: { xs: 'none', md: 'flex' } }}>
            {pages.map((page) => (
              <Button
                key={page.op}
                onClick={() => handleCloseNavMenu(page.op)}
                sx={{ my: 2, color: 'white', display: 'block' }}
              >
                {page.text}
              </Button>
            ))}
          </Box>

          {userLogin && (
            <Box sx={{ flexGrow: 0 }}>
              <Tooltip title="Open settings">
                <IconButton onClick={handleOpenUserMenu} sx={{ p: 0 }}>
                  <Avatar alt="Remy Sharp" src="/static/images/avatar/2.jpg">
                  {avatarLetter}
                  </Avatar>
                </IconButton>
              </Tooltip>
              <Menu
                sx={{ mt: '45px' }}
                id="menu-appbar"
                anchorEl={anchorElUser}
                anchorOrigin={{
                  vertical: 'top',
                  horizontal: 'right',
                }}
                keepMounted
                transformOrigin={{
                  vertical: 'top',
                  horizontal: 'right',
                }}
                open={Boolean(anchorElUser)}
                onClose={handleCloseUserMenu}
              >
                {settings.map((setting) => (
                  <MenuItem key={setting.op} onClick={() => handleCloseUserMenu(setting.op)}>
                    <Typography textAlign="center">{setting.text}</Typography>
                  </MenuItem>
                ))}
              </Menu>
            </Box>
          )}
        </Toolbar>
      </Container>
    </AppBar>
  );
}
export default NavBar;