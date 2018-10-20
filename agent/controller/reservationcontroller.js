'use strict';

const reservation = require('../model/reservation');

exports.handler = function (request, context, callback)
{
    context.callbackWaitsForEmptyEventLoop = false;

    let response = {
        isBase64Encoded: false,
        statusCode: 200,
        headers: {},
        body: ''
    };

    try
    {
        switch (request.httpMethod)
        {
        case 'GET': {

            if (request.resource === '/agent/reservations')
            {
                reservation.findAll().then(result =>
                {
                    response.body = JSON.stringify(result);

                    callback(null, response);
                });
            }
            else if (request.resource === '/agent/reservations/{reservationId}')
            {
                reservation.findById(request.pathParameters.reservationId).then(result =>
                {
                    if (result === null)
                    {
                        response.statusCode = 404;

                        callback(null, response);
                    }
                    else
                    {
                        response.body = JSON.stringify(result);

                        callback(null, response);
                    }
                });
            }
            else if (request.resource === '/agent/reservations/users/{userId}')
            {
                reservation.findAll({ where: { userId: request.pathParameters.userId } }).then(result =>
                {
                    response.body = JSON.stringify(result);

                    callback(null, response);
                });
            }

            break;
        }
        case 'POST': {

            if (request.resource === '/agent/reservations')
            {
                const parseBody = JSON.parse(request.body);

                reservation.create({
                    userId: parseBody.userId, reservation_num: parseBody.reservation_num,
                    book_date: parseBody.book_date
                }).then(result =>
                {
                    response.statusCode = 201;
                    response.body = JSON.stringify(result);

                    callback(null, response);
                });
            }

            break;
        }
        case 'DELETE': {

            if (request.resource === '/agent/reservations/{reservationId}')
            {
                reservation.findById(request.pathParameters.reservationId).then(result =>
                {
                    if (result === null)
                    {
                        response.statusCode = 404;

                        callback(null, response);
                    }
                    else
                    {
                        result.destroy().then(() =>
                        {
                            response.statusCode = 204;

                            callback(null, response);
                        });
                    }
                });
            }

            break;
        }
        }

    } catch (e)
    {
        callback(e, null);
    }
};