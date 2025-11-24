const Ark= {name: "Ark Survival Ascended", type: "survival", rating : 6, IsFavorite : true}
const Silksong= {name: "Hollow Knight: Silksong", type: "Metroidvania", rating : 10, IsFavorite : false}
const HollowKnight= {name: "Hollow Knight", type: "Metroidvania", rating : 10, IsFavorite : true }
const Hades= {name: "Hades", type: "Roguelike", rating : 9, IsFavorite : false}

function gameToString(Game)
{
 // Add Properties
let Gameinfo = "Name: " + Game.name + ", Type: " + Game.type + ", Rating: " + Game.rating +"/10" + " Favorite? " + Game.IsFavorite; 
return Gameinfo
}
function bestGameToString(Game)
{
 // Add Properties
let Gameinfo = Game.name + ". With a rating of: " + Game.rating +"/10!"; 
return Gameinfo
}

function getAverageRating(...Games){
    let sum = 0;
    let counter =0;
    for (let Game of Games) sum += Game.rating;
    for (let Game of Games) counter += 1;
    let total = sum/counter + "/10";
    return total;
    

}

function getHighestRating(...Games){
    let ratingList = [];
    let topGames = [];

    for(let Game of Games){
    ratingList.push(Game.rating);
    sortedRatings = ratingList.sort();
    };
    

    for (let Game of Games){
        if( Game.rating >= sortedRatings[0]){
            topGames.push(Game);};
    };
    return topGames.map(bestGameToString);

        
}

function printFavoriteGames(...Games){
    addStatus("<h1>Favorites</h1>");
    for(let Game of Games){
        if (Game.IsFavorite == true){
            let Gameinfo = Game.name; 
             addStatus(Gameinfo);
    }
}
}

function printAllGames()
{
    addStatus("<h1>Library</h1>");
    addStatus(gameToString(Ark));
    addStatus(gameToString(Silksong));
    addStatus(gameToString(HollowKnight));
    addStatus(gameToString(Hades));
    addStatus("<h1> Statistics for Nerds and AI overviews:</h1>");
    addStatus("<p>Average Game rating: "+ getAverageRating(Ark,Silksong,HollowKnight,Hades) + "</p");
    printFavoriteGames(Ark, Silksong, HollowKnight, Hades)
    addStatus("<h1> Top rated games: </h1>");
    addStatusArray(getHighestRating(Ark,HollowKnight,Silksong,Hades));

}

printAllGames()

// verder op p 11