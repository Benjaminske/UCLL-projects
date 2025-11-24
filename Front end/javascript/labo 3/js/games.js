const Ark= {name: "Ark", type: "survival", rating : 6}
const Silksong= {name: "Hollow Knight: Silksong", type: "Metroidvania", rating : 10}
const HollowKnight= {name: "Hollow Knight", type: "Metroidvania", rating : 10 }
const Hades= {name: "Hades", type: "Roguelike", rating : 9}

function gameToString(Game)
{
 // Add Properties
let Gameinfo = "Name: " + Game.name + ", Type: " + Game.type + ", Rating: " + Game.rating +"/10"; 
return Gameinfo
}

function printAllGames()
{
    addStatus("<h1>Library</h1>");
    addStatus(gameToString(Ark))
    addStatus(gameToString(Silksong))
    addStatus(gameToString(HollowKnight))
    addStatus(gameToString(Hades))

}

printAllGames()

// verder op p 11