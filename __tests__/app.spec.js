//mocking and setup

const mockApp = {
    get: jest.fn(),
    listen: jest.fn(),
    set: jest.fn(),
    use: jest.fn()
}

jest.mock('express', () => jest.fn(() => mockApp))
require('../app.js')

describe('Basic set up testing', () => {
    test("job-roles Route serves job-roles html page", () => {
        //call get function here?
        expect(mockApp.get).toHaveBeenCalledWith('/job-roles', expect.any(Function))

        //tracks all app.get calls when require('../app.js') line is run, get ('job-roles') is second hence [1][1] call
        const behaviour = mockApp.get.mock.calls[1][1] // grab the second [1] param of the second [1] call
        const res = { render: jest.fn() }
        
        //call function used by get handler
        behaviour(null, res)
        expect(res.render).toHaveBeenCalledWith('job-roles', {})
    });

    test('Start successfully and listen on port 7999', () => {
        expect(mockApp.listen).toHaveBeenCalledWith(7999, expect.any(Function))
    })
});