const openWeatherMapApi = "994bba9626e560b0a6731d44542b089b";
const lon = -74.5;
const lat = 39.31;
let url = `https://api.openweathermap.org/data/3.0/onecall?lat=${lat}&lon=${lon}&appid=${openWeatherMapApi}`


fetch(url)
.then(response => response.json())
.then(data => console.log(data));