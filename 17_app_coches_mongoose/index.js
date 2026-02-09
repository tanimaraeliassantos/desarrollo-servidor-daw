const express = require('express');
const app = express();
const mongoose = require('mongoose');
const bodyparser = require('body-parser');

const rutaCoches = require('./routes/coche.routes');
const rutaUsuarios = require('./routes/usuario.routes');

//Middleware
app.use(express.json());
app.use(bodyparser.urlencoded({ extended: true }));
app.use('/api/coches', rutaCoches);
app.use('/api/usuarios', rutaUsuarios);

//conexion a mongoose
mongoose
	.connect('mongodb://127.0.0.1:27017/bbdd-coches_coches_2026_Unir_daw')
	.then(() => console.log('base de datos de Mongo en marcha...'))
	.catch(() => console.log('BBDD NO arrancada'));
//levantar el servicio
app.listen(3000, () => console.log('proyecto arrancado por el puerto 3000'));
