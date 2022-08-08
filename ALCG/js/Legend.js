class Legend {
    #value = 0;
    #name = null;
    #type = null;
    #legendImage = null;
    #typeImage = null;
    constructor(value, name, type, fileName) {
        this.value = value;
        this.name = name;
        this.type = type;
        this.fileName = fileName;
    }
}



var bloodhound = new Legend(0, "Bloodhound", "Recon", "Bloodhound.png");

var gibraltar = new Legend(1, "Gibraltar", "Defensive", "Gibraltar.png");

var lifeline = new Legend(2, "Lifeline", "Support", "Lifeline.png");

var pathfinder = new Legend(3, "Pathfinder", "Recon", "Pathfinder.png");

var wraith = new Legend(4, "Wraith", "Offensive", "Wraith.png");

var bangalore = new Legend(5, "Bangalore", "Offensive", "Bangalore.png");

var caustic = new Legend(6, "Caustic", "Defensive", "Caustic.png");

var mirage = new Legend(7, "Mirage", "Offensive", "Mirage.png");

var octane = new Legend(8, "Octane", "Offensive", "Octane.png");

var wattson = new Legend(9, "Wattson", "Defensive", "Wattson.png");

var crypt0 = new Legend(10, "Crypto", "Recon", "Crypto.png");

var revenant = new Legend(11, "Revenant", "Offensive", "Revenant.png");

var loba = new Legend(12, "Loba", "Support", "Loba.png");

var rampart = new Legend(13, "Rampart", "Defensive", "Rampart.png");

var horizon = new Legend(14, "Horizon", "Offensive", "Horizon.png");

var fuse = new Legend(15, "Fuse", "Offensive", "Fuse.png");

var valkyrie = new Legend(16, "Valkyrie", "Offensive", "Valkyrie.png");

var seer = new Legend(17, "Seer", "Recon", "Seer.png");

var ash = new Legend(18, "Ash", "Offensive", "Ash.png");

var madMaggie = new Legend(19, "Mad Maggie", "Offensive", "Mad Maggie.png");

var newCastle = new Legend(20, "New Castle", "Defensive", "New Castle.png");

var vantage = new Legend(21, "Vantage", "Recon", "Vantage.png");

const roster = [bloodhound, gibraltar, lifeline, pathfinder, wraith, bangalore,
    caustic, mirage,
    octane, wattson, crypt0, revenant, loba, rampart, horizon, fuse,
    valkyrie, seer, ash, madMaggie, newCastle,
    vantage
];

const generateButton = document.getElementById('generateButton')
generateButton.addEventListener("click", function() {
    shuffle();
})


generateButton.addEventListener('keypress', (event) => {
    if (event.code == "Space")
        shuffle();
});



function shuffle(type0, type1, type2) {
    document.getElementById("generateButton").focus();
    for (let i = 0; i < roster.length; i++) {
        var j = Math.floor(Math.random() * roster.length);
        var temp = roster[i];
        roster[i] = roster[j];
        roster[j] = temp;
    }

    for (let i = 0; i < roster.length; i++) {
        console.log("" + i + ". " + roster[i].name + roster[i].value);
    }



    var typeList0 = document.getElementById("typeList0");
    document.getElementById("type0").value = typeList0.options[typeList0
        .selectedIndex].text;
    var typeList1 = document.getElementById("typeList1");
    document.getElementById("type1").value = typeList1.options[typeList1
        .selectedIndex].text;
    var typeList2 = document.getElementById("typeList2");
    document.getElementById("type2").value = typeList2.options[typeList2
        .selectedIndex].text;

    if (document.getElementById("type2").value == "Support" && document
        .getElementById("type1").value == "Support" && document.getElementById(
            "type0").value == "Support") {
        document.getElementById("type2").value = "Any";
        document.getElementById("supportError").innerHTML =
            "Cannot have 3 Support Legends";
    } else {
        document.getElementById("supportError").innerHTML = "";
    }

    type0 = document.getElementById("type0").value;
    type1 = document.getElementById("type1").value;
    type2 = document.getElementById("type2").value;



    var randomLegends = [roster[0], roster[1], roster[2]];


    //Legend 1
    for (let i = 0; i < roster.length; i++) {
        if (type0 == "Any") {
            randomLegends[0] = roster[i];
            console.log("#1 - " + i + ". " + roster[i].name + roster[i].value);
            break;
        }
        if (roster[i].type == type0) {
            randomLegends[0] = roster[i];
            console.log("#1 - " + i + ". " + roster[i].name + roster[i].value);
            break;
        }
    }

    //Legend 2
    for (let i = 0; i < roster.length; i++) {
        if (type1 == "Any" && roster[i].name != randomLegends[0].name) {
            randomLegends[1] = roster[i];
            console.log("#2 - " + i + ". " + roster[i].name + roster[i].value);
            break;
        }
        if (roster[i].type == type1 && roster[i].name != randomLegends[0]
            .name) {
            randomLegends[1] = roster[i];
            console.log("#2 - " + i + ". " + roster[i].name + roster[i].value);
            break;
        }
    }

    for (let i = 0; i < roster.length; i++) {
        if (type2 == "Any" && roster[i].name != randomLegends[0].name && roster[
                i].name != randomLegends[1].name) {
            randomLegends[2] = roster[i];
            console.log("#3 - " + i + ". " + roster[i].name + roster[i].value);
            break;
        }
        if (roster[i].type == type2 && roster[i] != randomLegends[0] && roster[
                i].name != randomLegends[1].name) {
            randomLegends[2] = roster[i];
            console.log("#3 - " + i + ". " + roster[i].name + roster[i].value);
            break;
        }
    }

    document.getElementById("legend0").src = "Legends/" + randomLegends[0]
        .fileName;
    document.getElementById("legend1").src = "Legends/" + randomLegends[1]
        .fileName;
    document.getElementById("legend2").src = "Legends/" + randomLegends[2]
        .fileName;


    document.getElementById("legend0Type").src = "Types/" + randomLegends[0]
        .type.toLowerCase() + ".png";
    document.getElementById("legend1Type").src = "Types/" + randomLegends[1]
        .type.toLowerCase() + ".png";
    document.getElementById("legend2Type").src = "Types/" + randomLegends[2]
        .type.toLowerCase() + ".png";

    document.getElementById("legend0Name").innerHTML = randomLegends[0].name
        .toUpperCase();
    document.getElementById("legend1Name").innerHTML = randomLegends[1].name
        .toUpperCase();
    document.getElementById("legend2Name").innerHTML = randomLegends[2].name
        .toUpperCase();



    //document.getElementById("legend1Name").innerHTML = randomLegends[1].name;
    document.getElementById("generateButton").focus();
}
