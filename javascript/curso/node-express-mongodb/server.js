require('dotenv').config();

const express = require('express');
const app = express();
const mongoose = require('mongoose');

mongoose.connect(process.env.CONNECTIONSTRING, { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => {
        app.emit('pronto')
    })
    .catch((err) => { console.log('Erro ao conectar ao MongoDB: ' + err) });

const session = require('express-session');
const MongoStore = require('connect-mongo');
const flash = require('connect-flash');
const path = require('path');
const routes = require('./routes');
const helmet = require('helmet');
const csrf = require('csurf');


const sessionOptions = session({
    secret: 'qualquercoisa',
    store: MongoStore.create({ mongoUrl: process.env.CONNECTIONSTRING }),
    resave: false,
    saveUninitialized: false,
    cookie: {
        maxAge: 1000 * 60 * 60 * 24 * 7, // 7 days
        httpOnly: true
    }
});

app.use(sessionOptions);
app.use(flash());


const { middlewareGlobal, checkCsrfError, csrfMiddleware} = require('./src/middlewares/middleware');


app.use(express.urlencoded({ extended: true }));
app.use(express.static(path.resolve(__dirname, 'public')));
app.use(helmet());
app.use(csrf());

app.use(csrfMiddleware);
app.use(checkCsrfError);
app.use(middlewareGlobal);
app.use(routes);

app.set('views', path.resolve(__dirname, 'src', 'views'));
app.set('view engine', 'ejs');

app.on('pronto', () => {
    app.listen(3000, () => {
        console.log('Acessar http://localhost:3000');
        console.log('Servidor executando na porta 3000');
    });
});


