const express = require('express');
const app = express();
const mongoose = require('mongoose');

const rutaCoches = require('./routes/coche.routes');

//Middleware
app.use(express.json());
app.use('/api/coches', rutaCoches);

//conexion a mongoose
mongoose
	.connect('mongodb://127.0.0.1:27017/ejemplobbdd')
	.then(() => console.log('base de datos de Mongo en marcha...'))
	.catch(() => console.log('BBDD NO arrancada'));
//levantar el servicio
app.listen(3000, () => console.log('proyecto arrancado por el puerto 3000'));
