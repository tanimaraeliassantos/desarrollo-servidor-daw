const express = require('express');
const ruta = express.Router();
const usuarioController = require('../controller/usuario.controllers');

ruta.get('/cargainicial', usuarioController.cargaInicial);

module.exports = ruta;
