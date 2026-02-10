const express = require('express');
const ruta = express.Router();
const Usuario = require('../model/usuario.models');
const usuarios = require('../bbdd/usuarios');

class UsuarioController {
	async cargaInicial(req, res) {
		await Usuario.insertMany(usuarios);
		return res.status(201).send('Carga de usuarios completada.');
	}

	async findByUserNameAndPassword(req, res) {
		const result = Usuario.findOne({
			username: req.body.username,
			password: req.body.password,
		});
		if (!result) return res.status(404).send('Usuario o password incorrecto');
	}

	async registrar(req, res) {}

	async findById(req, res) {}
}

module.exports = new UsuarioController();
