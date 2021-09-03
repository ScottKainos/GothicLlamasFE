/**
 * Function to map an array into a set of values 
 * @param {} inputArray array to be mapped
 * @param {*} mapper mapping function
 * @returns 
 */
function mapDistinct(inputArray, mapper){
    return new Set(inputArray.map(mapper))
}

module.exports.mapDistinct = mapDistinct
