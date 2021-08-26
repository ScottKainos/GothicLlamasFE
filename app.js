const express = require('express');
const app = express();
const bodyParser = require('body-parser')
const nunjucks = require('nunjucks');
const http = require('http');
const fetch = require('node-fetch')

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

//inital POC to test 3-tier architecture
app.get('/testJava', async function(req, res){
    try{
        let response = await fetch('http://localhost:8000/api/print/h').catch(e => { console.log(e) });    
        //ensure page has been gathered
        if (response.status === 200) {
            let data = await response.json().catch(e => { console.log(e) });
            // handle data
            console.log(data)
        }
    }catch(err){
        console.log("Endpoint unreachable.")
    }
});

app.use(middle)
//start listening on 7999 port
app.listen(7999, function() {
    console.log('Started')
});