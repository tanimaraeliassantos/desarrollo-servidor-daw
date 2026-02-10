const express = require('express');
const ruta = express.Router();
const VentaController = require('../controller/venta.controllers');

ruta.post('/', VentaController.registro);
ruta.get('/:id', VentaController.findById)


module.exports = ruta;
