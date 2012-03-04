var accessTokenForCtctTestAccount = "AAABhwVyM24IBAG6J9e6FFA9qBZA3kiAH1D0Rl9ODhpUxFmIEsCHqhLNacZBZB77HEZCZBZCzw7r8EFSoULPa2tecibbgEKyV0ZD",
    macNotifierToken = "AAABhwVyM24IBAPitlv7YV8eHztxZAu5wbJNR1Ml9UaKIcErhuW6OJi9BZAdhmcRc0tnZCCdjTuN3TiEU9xDQz4pcv04XfV74neGboPMigZDZD",
    fbapi = require('facebook-api'),
    raw = require('facebook-api').raw,
    
    categoriesToTest = [
        {"2506":'Airport'},
        {"2508":'Arts/Entertainment/Nightlife'},
        {"2523":'Attractions/Things to Do'},
        {"2509":'Automotive'},
        {"2512":'Bank/Financial Services'},
        {"2100":'Bar'},
        {"1305":'Book Store'},
        {"2518":'Business Services'},
        {"2612":'Cause/Community'},
        {"2264":'Church/Religious Organization'},
        {"2101":'Club'},
        {"2519":'Community/Government'},
        {"1209":'Concert Venue'},
        {"2248":'Consulting/Business Services'},
        {"2250":'Education'},
        {"2251":'Engineering/Construction'},
        {"2511":'Event Planning/Event Services'},
        {"2246":'Farming/Agriculture'},
        {"2513":'Food/Grocery'},
        {"2604":'Government Organization'},
        {"2514":'Health/Medical/Pharmacy'},
        {"2515":'Home Improvement'},
        {"2527":'Hospital/Clinic'},
        {"2501":'Hotel'},
        {"2236":'Insurance Company'},
        {"2256":'Internet/Software'},
        {"2503":'Landmark'},
        {"2249":'Legal/Law'},
        {"1306":'Library'},
        {"2500":'Local Business'},
        {"2233":'Media/News/Publishing'},
        {"2245":'Mining/Materials'},
        {"1111":'Movie Theater'},
        {"2528":'Museum/Art Gallery'},
        {"2235":'Non-Governmental Organization (NGO)'},
        {"2603":'Non-Profit Organization'},
        {"2231":'Outdoor Gear/Sporting Goods'},
        {"2516":'Pet Services'},
        {"2261":'Political Organization'},
        {"2618":'Political Party'},
        {"2517":'Professional Services'},
        {"2522":'Public Places'},
        {"2520":'Real Estate'},
        {"2239":'Retail and Consumer Merchandise'},
        {"1900":'Restaurant/Cafe'},
        {"2601":'School'},
        {"2521":'Shopping/Retail'},
        {"2510":'Spas/Beauty/Personal Care'},
        {"2507":'Sports Venue'},
        {"2524":'Sports/Recreation/Activities'},
        {"2253":'Telecommunication'},
        {"2525":'Tours/Sightseeing'},
        {"2242":'Transport/Freight'},
        {"2258":'Travel/Leisure'},
        {"2602":'University'}
    ],
    totalCategories = categoriesToTest.length,
    currentItem = 0,
    numRequests = 0,
    successfulCategories = [],
    unSuccessfulCategories = [];

function processFbResponse(err, data, categoryId) { 
    if(err) {
        unSuccessfulCategories.push(categoryId);
        console.log("Error: " + JSON.stringify(err)); 
    } else { 
        console.log("Data: " + JSON.stringify(data)); 
        successfulCategories.push(categoryId);
    }
    numRequests--;
    if (numRequests === 0) {
        console.log("successful Page categories:" + successfulCategories);
        console.log("unsuccessful Page categories:" + unSuccessfulCategories);
    }
}


/**
* This function will work only if the list is a dictionary.
*/
function processCategory(categoryInfo) {
    for (var c in categoryInfo) {
        if (categoryInfo.hasOwnProperty(c)) {
            var categoryId = c,
                categoryName = categoryInfo[c];
            raw("POST", 
                "/me/accounts", 
                {
                    "access_token": macNotifierToken,
                    "name": categoryName,
                    "category": categoryId
                }, 
                (function() {
                    console.log(categoryId);
                    return function(err, data) {
                        var lcid = categoryId;
                        processFbResponse(err, data, lcid);
                        currentItem++;
                        processNextCategory();
                    };
                }())
            );
            numRequests++;
        }
    }
}

function processNextCategory() {
    var categoryIfo = categoriesToTest[currentItem];
    processCategory(categoryIfo);
}

processNextCategory();
