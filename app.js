const express = require('express');
const app = express();
const nunjucks = require('nunjucks');
const fetch = require('node-fetch');

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
app.get('/job-roles', async function (req, res) {
    let apiData= {}
    try{
        let response = await fetch('http://localhost:8000/api/JobRoles').catch(e => { console.log(e) });    
        //ensure page has been gathered
        if (response.status === 200) {
            let data = await response.json().catch(e => { console.log(e) });
            // handle data
            apiData = data
        }else{
            throw err
        }
    }catch(err){
        console.log("Endpoint unreachable.")
        throw err
    }
    res.render('job-roles', {apiData});
});


//render the job-spec page
app.get('/job-spec', async function (req, res) {
    let jobSpec = {}
    try{
        let response = await fetch('http://localhost:8000/api/JobSpecifications').catch(e => { console.log(e) });    
        //ensure page has been gathered
        if (response.status === 200) {
            let data = await response.json().catch(e => { console.log(e) });
            // handle data
            jobSpec = data
        }else{
            throw err;
        }
    }catch(err){
        console.log("Endpoint unreachable.")
        throw err;
    }
    res.render('job-spec', {jobSpec});
});

//render job-capabilities 
app.get('/job-capabilities', async function (req, res) {
    let jobCapability = {}
    try{
        let response = await fetch('http://localhost:8000/api/JobCapability').catch(e => { console.log(e) });    
        //ensure page has been gathered
        if (response.status === 200) {
            let data = await response.json().catch(e => { console.log(e) });
            // handle data
            console.log(data)
            jobCapability = data
        }else{
            throw err;
        }
    }catch(err){
        console.log("Endpoint unreachable or returned no body.")
    }
    res.render('job-capability', {jobCapability});
});


app.use(middle)
//start listening on 7999 port
app.listen(7999, function() {
    console.log('Started')
});