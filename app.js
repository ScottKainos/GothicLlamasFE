const express = require('express');
const app = express();
const bodyParser = require('body-parser')
const nunjucks = require('nunjucks');

//'viewdir' tells nunjucks where to look for file templates

nunjucks.configure('views', {

    express: app
    
});

app.set('view engine', 'html');

var middle = function (req, res, next) {

    console.log('middleware');

    //calls next function which may be another middleware, if not it calls original callback on url requested

    next();

};

//render the homepage when site accessed

app.get('/', function (req, res) {

    res.render('index');

});

app.use(middle)

app.listen(7999, function() {

    console.log('Started')
    
});