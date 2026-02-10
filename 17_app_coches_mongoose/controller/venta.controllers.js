const express = require('express');
const ruta = express.Router();
const Usuario = require('../model/usuario.models');
const Coche = require('../model/coche.models');
const Venta = require('../model/venta.models');

class VentaController {
	async registro(req, res) {
		const usuarioVenta = await Usuario.findById(req.body.idUsuario);
		if (!usuarioVenta) return res.status(404).send('usuario no existe');

		const cocheVenta = await Coche.findById(req.body.idCoche);
		if (!cocheVenta) return res.status(404).send('coche no existe');

		const VentaNueva = new Venta({
			usuario: {
				_id: usuarioVenta._id,
			},
			coche: {
				_id: cocheVenta._id,
			},
			precio: req.body.precio,
		});

		const resultVenta = await VentaNueva.save();

		cocheVenta.isVendido = true;

		await cocheVenta.save();
		return res
			.status(201)
			.json({ mensaje: 'Venta realizada', datos: resultVenta });
	}

	async findById(req, res) {
		let venta = await Venta.findById(req.params.id)
			.populate('usuario', 'nombre email')
			.populate('coche', 'marca modelo');
		if (!venta) return res.status(404).send('Venta no existe');
		else return res.status(200).send(venta);
	}
}

module.exports = new VentaController();
