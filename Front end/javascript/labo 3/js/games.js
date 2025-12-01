const GamesArray = [
     Ark= {name: "Ark Survival Ascended", type: "survival", rating : 6, IsFavorite : true},
     Silksong= {name: "Hollow Knight: Silksong", type: "Metroidvania", rating : 10, IsFavorite : false},
     HollowKnight= {name: "Hollow Knight", type: "Metroidvania", rating : 10, IsFavorite : true },
     Hades= {name: "Hades", type: "Roguelike", rating : 9, IsFavorite : false}
];
const [a, b] = GamesArray;

function gameToString(game)
{
 // Add Properties
let Gameinfo = "Name: " + game.name + ", Type: " + game.type + ", Rating: " + game.rating +"/10" + " Favorite? " + game.IsFavorite; 
return Gameinfo
}
function bestGameToString(Game)
{
 // Add Properties
let Gameinfo = Game.name + ". With a rating of: " + Game.rating +"/10!"; 
return Gameinfo
}

function getAverageRating(){
    let sum = 0;
    let counter =0;
    for (let Game of GamesArray){
    sum += Game.rating;
    counter += 1;
    }
    let total = sum/counter;
    return total.toFixed(2) + "/10";
}

function getHighestRating(){
    let topGames = [];
    let ratingList = [];
    for(let Game of GamesArray){
    ratingList.push(Game.rating);
    sortedRatings = ratingList.sort();
    };
    

    for (let Game of GamesArray){
        if( Game.rating >= sortedRatings[0]){
            topGames.push(Game);};
    };
    return topGames.map(bestGameToString);

}
function first2Games(x){
    let GameInfo = x.name;
    return GameInfo
}

function printAllGames()
{
   for (let Game of GamesArray){
    addStatus(gameToString(Game));
  }
    addStatus("<h1> Statistics for Nerds and AI overviews:</h1>");
    addStatus("<h1>Ratings</h1>");
    addStatus("<p>Average Game rating: "+ getAverageRating() + "</p");

    addStatus("<h1>Favorites</h1>");
    for(let Game of GamesArray){
        if (Game.IsFavorite == true){
            let Gameinfo = Game.name; 
             addStatus(Gameinfo);
        }
    }
    addStatus("<h1>Highest Ratings</h1>");
    addStatusArray(getHighestRating());
    addStatus("<h1>My first 2 games</h1>");
    addStatus(first2Games(a))
    addStatus(first2Games(b))
}
printAllGames()

