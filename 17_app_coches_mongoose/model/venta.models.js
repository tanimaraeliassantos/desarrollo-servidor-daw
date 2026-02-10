const mongoose = require('mongoose');
const ventaSchema = new mongoose.Schema(
	{
		coche: {
			type: mongoose.Schema.Types.ObjectId,
			ref: 'coche',
			required: true,
		},

		usuario: {
			type: mongoose.Schema.Types.ObjectId,
			red: 'usuario',
			required: true,
		},

		precio: Number,
	},
	{ versionKey: false, timestamp: true },
);

const Venta = mongoose.model('venta', ventaSchema);

module.exports = Venta;
