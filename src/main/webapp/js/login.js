document.querySelector("#loginbutton").addEventListener("click", login);

function login(event) {
    console.log("Login functie");
    var formData = new FormData(document.querySelector("#inlogFormulier"));
    var encData = new URLSearchParams(formData.entries());

    fetch("rest/authentication", { method: 'POST', body: encData })
        .then(function(response) {
            console.log(response);
            if (response.ok) {
                alert("Ingelogd");
                console.log("Ingelogd");
                document.getElementById('incorrect').style.display = 'none';
                return response.json();
            }
            else {
                document.getElementById('incorrect').style.display = 'block';
                throw "Wrong username/password";
            }
        })
        .then(function (myJson) {
            for (const object of myJson) {
                window.sessionStorage.setItem("myJWT", object.token);
                window.sessionStorage.setItem("role", object.role);
                window.sessionStorage.setItem("username", object.username)
                redirect(object.role);
            }
        })
        .catch(error => console.log(error));
}
