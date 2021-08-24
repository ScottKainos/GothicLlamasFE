const express = require('express');
const app = express();
const bodyParser = require('body-parser')
const nunjucks = require('nunjucks');
const http = require('http');

/**
 * Only add new .get() methods below current last one
 * so that npm test runs as expected
 */

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

//render the homepage when root of site accessed
app.get('/', function (req, res) {
    res.render('index');    
});


//render the job-roles page
app.get('/job-roles', function (req, res) {
    res.render('job-roles', {});
});

app.use(middle)

app.get('/testJava', function(req, res){
    //TODO
    const httpConfig = {
        hostname: 'localhost',
        port: 8080,
        // Can set below attributes as and when they need to be used.
        path: '/hello.html',
        method: 'GET',
        headers: {
            'Content-Type': 'text/html',
        }
    };
    
    //http.request async, needs fix
    const javaAPIReq = http.request(httpConfig)
    javaAPIReq.end()
    console.log(javaAPIReq)
});

//start listening on 7999 port
app.listen(7999, function() {
    console.log('Started')
});