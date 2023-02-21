if ('geolocation' in navigator) {
  const successCallback = (position) => {
    const openWeatherMapApi = config.OPEN_WEATHER_MAP_API_KEY;
    const lon = position.coords.longitude;
    const lat = position.coords.latitude;
    let musicGenre = "";
    const locationUrl = `http://api.openweathermap.org/geo/1.0/reverse?lat=${lat}&lon=${lon}&limit=5&appid=${openWeatherMapApi}`;
    let weatherUrl = `https://api.openweathermap.org/data/3.0/onecall?lat=${lat}&lon=${lon}&units=imperial&appid=${openWeatherMapApi}`;
    let musicUrl = `https://shazam-core.p.rapidapi.com/v1/charts/genre-world?genre_code=`;
    const baseUrl = `http://localhost:8080/api/v1/weatherTypes/`;
    let weather = "";

    async function getWeather() {
        let response = await fetch(weatherUrl);
        let data = await response.json();
        return data;
    }

    async function getLocation() {
        let response = await fetch(locationUrl);
        let data = await response.json();
        return data;
    }

    async function getWeatherGenre() {
        console.log(weather);
        const weatherGenreUrl = baseUrl + weather;
        let response = await fetch(weatherGenreUrl);
        let data = await response.json();
        return data;
    }

    async function getMusic() {
        const options = {
            method: 'GET',
            headers: {
                'X-RapidAPI-Key': config.RAPID_API_KEY,
                'X-RapidAPI-Host': 'shazam-core.p.rapidapi.com'
            }
        };
        let response = await fetch(musicUrl, options);
        let data = await response.json();
        return data;
    }

    getLocation()
        .then(data => {
                const location = document.getElementById("location");
                location.innerText = data[0].name;
            }
        );

    getWeather()
        .then(data => {
            const temp = document.getElementById("temp");
            const weatherType = document.getElementById("weatherType");
            const weatherIcon = document.getElementById("weatherIcon");
            temp.innerText = `${data.current.temp} °F`;
            weatherType.innerText = data.current.weather[0].main;
            weatherIcon.src = `http://openweathermap.org/img/wn/${data.current.weather[0].icon}@2x.png`
            weatherIcon.alt = data.current.weather[0].main;
            weather = data.current.weather[0].main.toLowerCase();

           getWeatherGenre()
                .then(data => {
                    musicUrl = musicUrl + data.genre.type;

                    getMusic()
                        .then(data => {
                            const audio = document.getElementById("audio");
                            const albumCover = document.getElementById("albumCover");
                            const artists = document.getElementById("artists");
                            const title = document.getElementById("title");
                            const uri = data[0]?.hub?.actions[1]?.uri;

                            albumCover.src = data[0].images?.coverart;
                            artists.innerText = data[0].subtitle;
                            title.innerText = data[0].title;

                            let sound = new Howl({
                                src: [uri],
                                volume: 0.5
                            });

                            const play = document.getElementById("play");
                            const pause = document.getElementById("pause");

                            play.onclick = () => sound.play();
                            pause.onclick = () => sound.pause();
                        });
           });
        });
  };

  const errorCallback = (error) => {
    console.log(error);
  };

  navigator.geolocation.getCurrentPosition(successCallback, errorCallback);
} else {
  /* geolocation IS NOT available */
}

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}