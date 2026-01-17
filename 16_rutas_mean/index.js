const express = require('express');
const app = express();
const rutaCoches = require('./routes/coche.routes');

app.use(express.json());
app.use('/api/coches', rutaCoches);

app.get('/saludo', (req, res) => {
	res.status(200).send('Hola mundo!');
});

app.get('/saludo/:nombre/:edad', (req, res) => {
	let nombre = req.params.nombre;
	let edad = req.params.edad;

	res.status(200).send(`Hola me llamo ${nombre} y tengo ${edad} años`);
});

app.get('/saludo/con-parametros', (req, res) => {
	let nombre = req.query.nombre;
	let edad = req.query.edad;

	res.status(200).send(`Hola me llamo ${nombre} y tengo ${edad} años`);
});

app.listen(3000, () => console.log('proyecto arrancado por el puerto 3000'));
