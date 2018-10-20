'use strict';

const user = require('../model/user');

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

            if (request.resource === '/agent/users')
            {
                user.findAll().then(result =>
                {
                    response.body = JSON.stringify(result);

                    callback(null, response);
                });
            }
            else if (request.resource === '/agent/users/{userId}')
            {
                user.findById(request.pathParameters.userId).then(result =>
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
        case 'POST': {

            if (request.resource === '/agent/users')
            {
                const parseBody = JSON.parse(request.body);

                user.create({
                    email: parseBody.email, password: parseBody.password, name: parseBody.name,
                    role: parseBody.role
                }).then(result =>
                {
                    response.statusCode = 201;
                    response.body = JSON.stringify(result);

                    callback(null, response);
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