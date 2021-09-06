const { expect } = require('@jest/globals')
const { mapDistinct } = require('../ReturnNonDuplicateArrays')


test("Non duplicate mapping function is working correctly", () =>{
    const mockObjectArray =   [{
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

    const expectedReturnedArray = new Set ([
        "Business Development and Marketing",
        "Organisational Strategy and Planning"
    ])

    expect(mapDistinct(mockObjectArray, (object) => object.capability)).toEqual(expectedReturnedArray)
}) 