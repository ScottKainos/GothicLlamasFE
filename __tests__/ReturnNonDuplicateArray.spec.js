const { expect } = require('@jest/globals')
const { mapDistinct } = require('../ReturnNonDuplicateArrays')


    
test("Non duplicate mapping function is working correctly on capabilities", () =>{
    const mockObjectArray =   [
        {
            capability: 'Business Development and Marketing',
            bandLevel: null,
            jobRole: 'Marketing Assistant',
            jobDescription: null,
            linkToFullDescription: null
        },
        {
            capability: 'Organisational Strategy and Planning',
            bandLevel: null,
            jobRole: 'Head of Practice',
            jobDescription: null,
            linkToFullDescription: null
        },
        {
            capability: 'Organisational Strategy and Planning',
            bandLevel: null,
            jobRole: 'Head of Quality and Compliance',
            jobDescription: null,
            linkToFullDescription: null
        }
    ]

    //expected set to get returned, for capabilities
    const expectedReturnedArray = new Set ([
        "Business Development and Marketing",
        "Organisational Strategy and Planning"
    ])

    expect(mapDistinct(mockObjectArray, (object) => object.capability)).toEqual(expectedReturnedArray)
}) 

test("Non duplicate mapping function is working correctly on band levels", () =>{
    const mockObjectArray = [
        {
            capability: null,
            bandLevel: '7 - apprentice',
            jobRole: 'Software Engineer',
            jobDescription: null,
            linkToFullDescription: null
        },
        {
            capability: null,
            bandLevel: '7 - apprentice',
            jobRole: 'Software Engineer',
            jobDescription: null,
            linkToFullDescription: null
        },
        {
            capability: null,
            bandLevel: '1 - principal',
            jobRole: 'Principal Architect',
            jobDescription: null,
            linkToFullDescription: null
        }
    ]

    //expected set to get returned, for capabilities
    const expectedReturnedArray = new Set ([
        "7 - apprentice",
        "1 - principal"
    ])

    expect(mapDistinct(mockObjectArray, (object) => object.bandLevel)).toEqual(expectedReturnedArray)
}) 
