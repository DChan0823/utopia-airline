'use strict';

const ticket = require('../model/ticket');

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

            if (request.resource === '/agent/tickets')
            {
                ticket.findAll().then(result =>
                {
                    response.body = JSON.stringify(result);

                    callback(null, response);
                });
            }
            else if (request.resource === '/agent/tickets/{ticketId}')
            {
                ticket.findById(request.pathParameters.ticketId).then(result =>
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
            else if (request.resource === '/agent/tickets/reservations/{reservationId}')
            {
                ticket.findAll({ where: { reservationId: request.pathParameters.reservationId } }).then(result =>
                {
                    response.body = JSON.stringify(result);

                    callback(null, response);
                });
            }

            break;
        }
        case 'POST': {

            if (request.resource === '/agent/tickets')
            {
                const parseBody = JSON.parse(request.body);

                ticket.create({
                    reservationId: parseBody.reservationId, flightId: parseBody.flightId,
                    seatId: parseBody.seatId, ticket_num: parseBody.ticket_num, price: parseBody.price,
                    passenger_name: parseBody.passenger_name, passenger_age: parseBody.passenger_age
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

            if (request.resource === '/agent/tickets/{ticketId}')
            {
                ticket.findById(request.pathParameters.ticketId).then(result =>
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