//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

const favoriteSong = document.getElementById("favoriteSong");

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = "http://localhost:8080/api/v1/songs/"

async function addSong(obj) {
    const response = await fetch(`${baseUrl}user/${userId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200) {
        document.getElementById("favoriteSong").innerHTML = '<i class="fa-solid fa-heart"></i>'
    }
}

async function handleDelete(songId){
    await fetch(baseUrl + songId, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))
}

const handleFavorite = async (e) =>{
    const title = document.getElementById("title");
    const artists = document.getElementById("artists");
    const albumCover = document.getElementById("albumCover").src;

    let bodyObj = {
        title: title.innerText,
        artist: artists.innerText,
        albumArt: albumCover
    }

    await addSong(bodyObj);
}

favoriteSong.addEventListener("click", handleFavorite);


