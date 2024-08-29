const express = require('express');
const history = require('connect-history-api-fallback');

const app = express();

app.get('/api/parts', (req, res) => res.send({
    heads: [
        {
            id: 1,
            description: 'my head description',
            title: 'my head',
            src: '/api/images/cachorropanca.png'
        },
    ],
    bases: [
        {
            id: 2,
            description: 'my base description',
            title: 'my base',
            src: '/api/images/cachorropanca.png'
        },
    ],
    arms: [
        {
            id: 3,
            description: 'my arm description',
            title: 'my arm',
            src: '/api/images/cachorropanca.png'
        },
    ]
}))

app.use(history({index: '/index.html'}));

app.use('/api/images', express.static('images'));

app.use('/', express.static('dist', {index: 'index.html'}));

app.listen(3000, () => console.log('porra espessa.'));
