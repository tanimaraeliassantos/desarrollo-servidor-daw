const express = require('express');
const ruta = express.Router();
const Coche = require('../model/coche.models');
const coches = require('../bbdd/coches');

const cargaInicial = async (req, res) => {
	await Coche.insertMany(coches);
	return res.status(201).send('Carga completada');
};

const findAll = async (req, res) => {
	const result = await Coche.find();
	return res.status(200).send(result);
};

const findByPrecioGreaterThan = async (req, res) => {
	const result = await Coche.find({
		precio: { $gt: req.params.precio },
	});
	return res.status(200).send(result);
};

const findByMarca = async (req, res) => {
	const result = await Coche.find({
		marca: { $gt: req.params.marca },
	});
	return res.status(200).send(result);
};

const insertOne = async (req, res) => {
	try {
		const coche = req.body;
		const cocheNuevo = new Coche(coche);
		result = await cocheNuevo.save();
		return res.status(201).send(result);
	} catch (err) {
		console.error('error en insertOne de Coche', err);
		return res.status(500).json({ mensaje: 'Error interno' });
	}
};

const updateOne = async (req, res) => {
	try {
		const coche = req.body;
		const cocheActualizado = await Coche.findByIdAndUpdate(
			req.params.id,
			coche,
			{
				new: true,
				runValidators: true,
			},
		);
		if (!cocheActualizado) return res.status(404).send('Coche no existe');
		return res.status(200).send(cocheActualizado);
	} catch (err) {
		console.error('error en insertOne de Coche', err);
		return res.status(500).json({ mensaje: 'Error interno' });
	}
};

const deleteOne = async (req, res) => {
	try {
		const cocheActualizado = await Coche.findByIdAndDelete(req.params.id);
		if (!cocheActualizado) return res.status(404).send('Coche no existe');
		return res.status(200).send('Coche eliminado');
	} catch (err) {
		console.error('error en deleteOne de Coche', err);
		return res.status(500).json({ mensaje: 'Error interno' });
	}
};

module.exports = {
	cargaInicial,
	findAll,
	findByPrecioGreaterThan,
	findByMarca,
	insertOne,
	updateOne,
	deleteOne,
};
