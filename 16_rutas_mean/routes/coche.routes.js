const express = require('express');

const ruta = express.Router();

let coches = [
	{ _id: 0, marca: 'Renault', modelo: 'R5', year: '1978' },
	{ _id: 1, marca: 'Renault', modelo: 'R4', year: '1968' },
	{ _id: 2, marca: 'Seat', modelo: '600-D', year: '1972' },
];

ruta.get('/todos', (req, res) => {
	res.status(200).send(coches);
});

module.exports = ruta;
