//variable used for the conversions
var toCm, toMm, toM, toKm;
var millilitre, litre, gallon, pint;
var toGram, toKilogram, toStone, toPound;
//holds the user input value
var givenNumber;
//holding the chosen units from the dropdown list
var fromInput, toOutput;
//keeps temporary choosen conversions
var favoriteConv = [];
//Keeps the output of each conversion represented as String
var formattedOutput;
//holds the result of the conversion
var holder;
//holds representation in ordered list for each kept conversion
var text;
//reset var givenNumber to the given user input so is ready for new calculation
function refreshGivenDistance() {
    givenNumber = Number(document.getElementById("givenDistance").value);
}

//Distance calculator
function switchDistance() {
    //assign the variables to desired from user units
    fromInput = document.getElementById("from").value;
    toOutput = document.getElementById("to").value;
//translate each variable according to the unit we convert from
    switch (fromInput) {

        case "mm":
            toMm = 1;
            toCm = 0.1;
            toM = 1000;
            toKm = 1000000;
            break;
        case "cm":
            toMm = 0.1;
            toCm = 1;
            toM = 100;
            toKm = 100000;
            break;
        case "m":
            toMm = 0.001;
            toM = 1;
            toCm = 100;
            toKm = 1000;
            break;
        case "km":
            toMm = 0.000001;
            toCm = 100000;
            toM = 0.001;
            toKm = 1;
            break;
    }

//make the calculation having already set the values in switch(fromInput)
    switch (toOutput) {

        case "mm":
            givenNumber /= toMm;
            break;
        case "cm":
            givenNumber *= toCm;
            break;
        case "m":
            givenNumber /= toM;
            break;
        case "km":
            givenNumber /= toKm;
            break;

    }//write the result in the html page
    document.getElementById("output").innerHTML = givenNumber;
    //as we need the converter ready for nex calculation we have to reset givenNumber
    // but we also need its value and holder will keep it
    holder = givenNumber;
    refreshGivenDistance();

}
//reset var givenNumber to the given user input so is ready for new calculation
function refreshGivenWeight() {
    givenNumber = document.getElementById("givenVolume").value;
}
//weight calculator
function switchWeight() {
    //assign the variables to desired from user units
    fromInput = document.getElementById("from").value;
    toOutput = document.getElementById("to").value;

//translate each variable according to the unit we convert from
    switch (fromInput) {
        case "gr":
            toGram = 1;
            toKilogram = 1000;
            toStone = 6350;
            toPound = 453;
            break;
        case "kg":
            toGram = 0.001;
            toKilogram = 1;
            toStone = 6.35;
            toPound = 0.453592;
            break;
        case "st":
            toGram = 0.000157473;
            toKilogram = 0.157473;
            toStone = 1;
            toPound = 0.0714286;
            break;
        case "lb":
            toGram = 0.00220462;
            toKilogram = 2.20462;
            toStone = 14;
            toPound = 1;
            break;
    }

    //make the calculation having already set the values in switch(fromInput)
    switch (toOutput) {
        case "gr":
            givenNumber /= toGram;
            break;
        case "kg":
            givenNumber /= toKilogram;
            break;
        case "st":
            givenNumber /= toStone;
            break;
        case "lb":
            givenNumber /= toPound;
            break;
    }
    //write the result in the html page
    document.getElementById("weightOutput").innerHTML = givenNumber.toFixed(4);
    //as we need the converter ready for nex calculation we have to reset givenNumber
    // but we also need its value and holder will keep it
        holder = givenNumber;
    refreshGivenWeight();
}

//if user uses litres as base unit this function calculates the rest of the units
// according base unit
function fromLitre() {
    litre = document.getElementById("litre").value;
    document.getElementById("millilitre").value = litre / 0.001;
    document.getElementById("gallon").value = (litre / 4.546).toFixed(3);
    document.getElementById("pint").value = (litre * 1.76).toFixed(3)
}

//if user uses millilitres as base unit this function calculates the rest of the units
// according base unit
function fromMillilitre() {
    millilitre = document.getElementById("millilitre").value;
    document.getElementById("litre").value = millilitre / 1000;
    document.getElementById("gallon").value = (millilitre / 4546).toFixed(4);
    document.getElementById("pint").value = (millilitre / 568).toFixed(3)
}

//if user uses gallon as base unit this function calculates the rest of the units
// according base unit
function fromGallon() {
    gallon = document.getElementById("gallon").value;
    document.getElementById("litre").value = (gallon * 4.546).toFixed(2);
    document.getElementById("millilitre").value = (gallon * 4546).toFixed(0);
    document.getElementById("pint").value = (gallon * 8).toFixed(1);
}

//if user uses pint as base unit this function calculates the rest of the units
// according base unit
function fromPint() {
    pint = document.getElementById("pint").value;
    document.getElementById("millilitre").value = (pint * 568).toFixed(2);
    document.getElementById("litre").value = (pint / 1.76).toFixed(2);
    document.getElementById("gallon").value = (pint / 8).toFixed(2);
}


//writes current conversion into html doc (persist only for the session)
function keepConv() {
    //write only if there is any input
    if (typeof fromInput !== "undefined") {
        //if we calculate distance and weight represent the calculation on this format
        formattedOutput = [givenNumber + "" + fromInput + " is equal to: " + holder.toFixed(4) + "" + toOutput];
    } else {//get and set all variables before print them in the html
        //we need to do it because only the base unit variable is set for the conversion
        pint = document.getElementById("pint").value;
        millilitre = document.getElementById("millilitre").value;
        litre = document.getElementById("litre").value;
        gallon = document.getElementById("gallon").value;

        //if we calculate liquid represent the calculation in this format
        formattedOutput = [millilitre + "ml Equals: " + litre + "l = " + gallon + "gal = " + pint + "pt"];
    }//input the conversion result in the input form so is ready to be send in the database
    document.getElementById("saveDB").value =formattedOutput;
    //add current conversion to arr which holds all kept calculations for this session
    //so we can print all kept conversions up to now and the new added
    favoriteConv.push(formattedOutput);
    text = "<ol>";
    //iterate over the arr and format the values in it like ordered list
    favoriteConv.forEach(getElement);
    text += "</ol>";
    document.getElementById("displayConv").innerHTML = text;
    function getElement(value) {
        text += "<li>" + value + "</li>"
    }

}


