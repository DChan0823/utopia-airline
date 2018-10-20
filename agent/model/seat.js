'use strict';

const { Sequelize, sequelize } = require('../db');

const Seat = sequelize.define('seat',
    {
        seatId:
        {
            primaryKey: true,
            type: Sequelize.INTEGER
        },
        seat_num:
        {
            type: Sequelize.TINYINT
        },
        flightId:
        {
            primaryKey: true,
            type: Sequelize.INTEGER
        },
        priceClass:
        {
            type: Sequelize.CHAR
        }
    },
    {
        freezeTableName: true,
        timestamps: false
    }
);

module.exports = Seat;