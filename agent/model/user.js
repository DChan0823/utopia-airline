'use strict';

const { Sequelize, sequelize } = require('../db');

const User = sequelize.define('user',
    {
        userId:
        {
            primaryKey: true,
            type: Sequelize.INTEGER
        },
        name:
        {
            type: Sequelize.STRING
        },
        email:
        {
            type: Sequelize.STRING
        },
        role:
        {
            type: Sequelize.STRING
        },
        password:
        {
            type: Sequelize.STRING
        }
    },
    {
        freezeTableName: true,
        timestamps: false
    }
);

module.exports = User;