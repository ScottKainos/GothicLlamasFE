function returnCapabilities(jobCapability){
     //collect all capabilities into set to remove duplicates
    return new Set(jobCapability.map(function(object){
        return object.capability;
    }))
}

function returnBandLevels(bandLevels){
    return new Set(bandLevels.map(function(object){
        return object.bandLevel;
    }))
}

module.exports.returnCapabilities = returnCapabilities
module.exports.returnBandLevels = returnBandLevels
