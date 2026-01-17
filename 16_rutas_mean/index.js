const express = require('express');
const app = express();
const rutaCoches = require('./routes/coche.routes');

//Middleware
app.use(express.json());
app.use('/api/coches', rutaCoches);

//levantar el servicio
app.listen(3000, () => console.log('proyecto arrancado por el puerto 3000'));
