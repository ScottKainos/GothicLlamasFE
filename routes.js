const express = require('express')
const app = express()
const nunjucks = require('nunjucks')
const fetch = require('node-fetch')
const { mapDistinct } = require('./utils')

/**
 * Only add new .get() methods below current last one
 * so that npm test runs as expected
 */

//'viewdir' tells nunjucks where to look for file templates
nunjucks.configure('views', {
    express: app
})

app.set('view engine', 'html')

//render the homepage when root of site accessed
app.get('/', function (req, res) {
    res.render('index')    
})


//render the job-roles page
app.get('/job-roles', async function (req, res) {
    let apiData= {}
    try{
        let response = await fetch('http://localhost:8000/api/JobRoles').catch(e => {})    
        //ensure page has been gathered
        if (response.status === 200) {
            let data = await response.json().catch(e => {})
            // handle data
            apiData = data
        }else{
            throw err
        }
    }catch(err){
        throw err
    }
    res.render('job-roles', {apiData})
})


//render the job-spec page
app.get('/job-spec', async function (req, res) {
    let jobSpec = {}
    try{
        let response = await fetch('http://localhost:8000/api/JobSpecifications').catch(e => {})    
        //ensure page has been gathered
        if (response.status === 200) {
            let data = await response.json().catch(e => {})
            // handle data
            jobSpec = data
        }else{
            throw err
        }
    }catch(err){
        throw err
    }
    res.render('job-spec', {jobSpec})
})

//render job-capabilities 
app.get('/job-capabilities', async function (req, res) {
    let jobCapability = {}
    try{
        let response = await fetch('http://localhost:8000/api/JobCapability').catch(e => {})    
        //ensure page has been gathered
        if (response.status === 200) {
            let data = await response.json().catch(e => {})
            // handle data
            jobCapability = data

        }else{
            throw err
        }
    }catch(err){
        throw err
    }
    //fetch non duplicate array (set) of capabilities
    var capabilities = mapDistinct(jobCapability, (object) => object.capability)

    res.render('job-capability', {jobCapability, capabilities})
})

//render band-levels 
app.get('/band-levels', async function (req, res) {
    let bandLevels = {}
    try{
        let response = await fetch('http://localhost:8000/api/BandLevels').catch(e => {})    
        //ensure page has been gathered
        if (response.status === 200) {
            let data = await response.json().catch(e => {})
            // handle data
            bandLevels = data
        }else{
            throw err
        }
    }catch(err){
        throw err
    }
    //fetch set of band levels
    var bandLevelsSet = mapDistinct(bandLevels, (object) => object.bandLevel)
    res.render('band-levels', {bandLevels, bandLevelsSet})
})

app.use(express.static('resources'))
module.exports = app