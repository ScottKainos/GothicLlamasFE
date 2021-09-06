//mocking and setup

const mockApp = {
    get: jest.fn(),
    listen: jest.fn(),
    set: jest.fn(),
    use: jest.fn(),
}


const mockExpress = jest.fn(() => mockApp)
mockExpress.static = jest.fn()  

jest.mock('express', () => mockExpress)

const mockNodeFetch = jest.fn()
jest.mock('node-fetch', () => mockNodeFetch)
    
require('../app.js')
jest.mock('../ReturnNonDuplicateArrays')

const { expect } = require('@jest/globals')
const exp = require('constants')

describe('Application testing', () => {
    describe('/job-roles testing', () => {

        test("/job-roles route get method set up in express", () => {
            expect(mockApp.get).toHaveBeenCalledWith('/job-roles', expect.any(Function))
        })

        test("Unhappy path, API not serving /job-roles", async () => {
            expect.assertions(2)
            await unhappyPathErrorThrown(1)
        })

        test("Unhappy path, API serving /job-roles but not 200 status code", async () => {
            //mock response but with none 200 status code
            mockNodeFetch.mockImplementationOnce(() => Promise.resolve({ status: 0, json: () => Promise.resolve({ data: "Test Data" })}))
            const behaviour = mockApp.get.mock.calls[1][1] 
            const res = { render: jest.fn() }
            
            expect(behaviour).rejects.toThrow()
            await expect(res.render).not.toHaveBeenCalled()
        })

        test("Happy path, API serving /job-roles", async () => {
            mockNodeFetch.mockImplementationOnce(() => Promise.resolve({ status: 200, json: () => Promise.resolve({ data: "Test Data" })}))
            //tracks all app.get calls when require('../app.js') line is run, get ('job-roles') is second hence [1][1] call
            const behaviour = mockApp.get.mock.calls[1][1] // grab the second [1] param of the second [1] call
            const res = { render: jest.fn() }
                //call function used by get handler
            await behaviour(null, res)
            await expect(res.render).toHaveBeenCalledWith('job-roles', {apiData: {data: 'Test Data'}})
        })
    })

    describe("/job-spec page testing", () =>{
        test("route for /job-spec get method set up in express", () => {
            expect(mockApp.get).toHaveBeenCalledWith('/job-spec', expect.any(Function))
        })
        
        test("Unhappy path, API not serving /job-spec", async () => {
            expect.assertions(2)
            await unhappyPathErrorThrown( 2)
        })

        test("Unhappy path, API serving /job-spec but not 200 status code", async () => {
            //mock response but with none 200 status code
            mockNodeFetch.mockImplementationOnce(() => Promise.resolve({ status: 0, json: () => Promise.resolve({ data: "Test Data" })}))
            const behaviour = mockApp.get.mock.calls[2][1] 
            const res = { render: jest.fn() }
            
            expect(behaviour).rejects.toThrow()
            await expect(res.render).not.toHaveBeenCalled()
        })

        test("Happy path, API serving /job-spec", async () => {
            mockNodeFetch.mockImplementationOnce(() => Promise.resolve({ status: 200, json: () => Promise.resolve({ data: "Test Data" })}))
            //tracks all app.get calls when require('../app.js') 
            const behaviour = mockApp.get.mock.calls[2][1] 
            const res = { render: jest.fn() }

            await behaviour(null, res)
            await expect(res.render).toHaveBeenCalledWith('job-spec', {jobSpec: {data: 'Test Data'}})
        })
    })

    describe("/job-capabilities page testing", () =>{
        test("route for /job-capabalities get method set up in express", () => {
            expect(mockApp.get).toHaveBeenCalledWith('/job-capabilities', expect.any(Function))
        })
        
        test("Unhappy path, API not serving /job-capabilities", async () => {
            expect.assertions(2)
            await unhappyPathErrorThrown( 3)
        })

        test("Unhappy path, API serving /job-capabilities but not 200 status code", async () => {
            //mock response but with none 200 status code
            mockNodeFetch.mockImplementationOnce(() => Promise.resolve({ status: 0, json: () => Promise.resolve({ data: "Test Data" })}))
            const behaviour = mockApp.get.mock.calls[3][1] 
            const res = { render: jest.fn() }
            
            expect(behaviour).rejects.toThrow()
            await expect(res.render).not.toHaveBeenCalled()
        })

        test("Happy path, API serving /job-capabilities", async () => {
            mockNodeFetch.mockImplementationOnce(() => Promise.resolve({ status: 200, json: () => Promise.resolve({ data: "Test Data" })}))
            const behaviour = mockApp.get.mock.calls[3][1] // grab the fourth [3] param of the second [1] call
            const res = { render: jest.fn() }

            await behaviour(null, res)
            await expect(res.render).toHaveBeenCalledWith('job-capability', {jobCapability: {data: 'Test Data'}})
        })
    })


    describe("/band-levels page testing", () =>{
        test("route for /band-levels get method set up in express", () => {
            expect(mockApp.get).toHaveBeenCalledWith('/band-levels', expect.any(Function))
        })
        
        test("Unhappy path, API not serving /band-levels", async () => {
            //expecting 2 passing tests from the called function
            expect.assertions(2)
            await unhappyPathErrorThrown(4)
        })

        test("Unhappy path, API serving /band-levels but not 200 status code", async () => {
            //mock response but with none 200 status code
            mockNodeFetch.mockImplementationOnce(() => Promise.resolve({ status: 0, json: () => Promise.resolve({ data: "Test Data" })}))
            const behaviour = mockApp.get.mock.calls[4][1] 
            const res = { render: jest.fn() }
            
            expect(behaviour).rejects.toThrow()
            await expect(res.render).not.toHaveBeenCalled()
        })

        test("Happy path, API serving /band-levels", async () => {
            mockNodeFetch.mockImplementationOnce(() => Promise.resolve({ status: 200, json: () => Promise.resolve({ data: "Test Data" })}))
            //tracks all app.get calls when require('../app.js') line is run, get ('job-roles') is second hence [1][1] call
            const behaviour = mockApp.get.mock.calls[4][1] // grab the second [1] param of the second [1] call
            const res = { render: jest.fn() }

            await behaviour(null, res)
            await expect(res.render).toHaveBeenCalledWith('band-levels', {bandLevels: {data: 'Test Data'}})
        })
    })


    test("root route serves index html page", () => {
        expect(mockApp.get).toHaveBeenCalledWith('/', expect.any(Function))

        const behaviour = mockApp.get.mock.calls[0][1] 
        const res = { render: jest.fn() }
        //call function used by get handler
        behaviour(null, res)
        expect(res.render).toHaveBeenCalledWith('index')
    })


    test("Start successfully and listen on port 7999", () => {
        expect(mockApp.listen).toHaveBeenCalledWith(7999, expect.any(Function))
    })
})


/**
 * function to test that the expected error gets thrown if the java endpoint
 * is down
 * @param {*} errorExpected , the error message that expected
 */
async function unhappyPathErrorThrown(methodNumber){
    let thrownError = {
        //specific error thrown back when java API endpoint is down
        message:   "Cannot read property 'status' of undefined"
    } 
    mockNodeFetch.mockImplementationOnce(() => Promise.reject(thrownError))
    const behaviour = mockApp.get.mock.calls[methodNumber][1] 
    const res = { render: jest.fn() }
    expect(behaviour).rejects.toThrow(thrownError.message)
    //call function used by get handler
    await expect(res.render).not.toHaveBeenCalled()
}
