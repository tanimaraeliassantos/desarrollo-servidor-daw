const express = require('express');
const ruta = express.Router();
const cocheController = require('../controller/coche.controllers');

ruta.get('/cargainicial', cocheController.cargaInicial);
ruta.get('/', cocheController.findAll);
ruta.get('/precio-mayor/:precio', cocheController.findByPrecioGreaterThan);
ruta.get('/marca/:marca', cocheController.findByMarca);
ruta.post('/', cocheController.insertOne);
ruta.put('/:id', cocheController.updateOne);
ruta.delete('/:id', cocheController.deleteOne);

module.exports = ruta;
