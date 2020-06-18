document.querySelector(".post-name").addEventListener('click', () => {
   console.log("posting");
   fetch("/api/protected", {
            method: "POST",
            headers: {
                "content-type": "application/json"
            },
            body: JSON.stringify({
                "user": "shyueb",
                "token": "oeiefpuniqwiuf23i32uhiu4h"
            })
    })
    .then(response => response.json())
    .then(response => {
        console.log("response has been got");
        console.log(response);
    });
});

document.querySelector(".post-name2").addEventListener('click', () => {
   console.log("posting2");
   fetch("/api/protected", {
            method: "POST",
            headers: {
                "content-type": "application/json"
            },
            body: JSON.stringify({
                "user": "shyueb2",
                "token": "oeiefpuniqwiuf23i32uhiu4h"
            })
    })
    .then(response => response.json())
    .then(response => {
        console.log("response has been got2");
        console.log(response);
    });
});
