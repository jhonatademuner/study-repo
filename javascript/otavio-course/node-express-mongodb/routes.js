const express = require('express');
const route = express.Router();
const homeController = require('./src/controllers/homeController');
const contatoController = require('./src/controllers/contatoController');




route.get('/', homeController.homeGet);

route.post('/', homeController.homePost);

route.get('/contato', contatoController.contatoGet);

module.exports = route;