'use strict';

const flight = require('../model/flight');

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

            if (request.resource === '/agent/flights')
            {
                flight.findAll({ raw: true }).then(result =>
                {
                    response.body = JSON.stringify(result);

                    callback(null, response);
                }
                );
            }
            else if (request.resource === '/agent/flights/{flightId}')
            {
                flight.findById(request.pathParameters.flightId).then(result =>
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

            break;
        }
        }

    } catch (e)
    {
        callback(e, null);
    }
};