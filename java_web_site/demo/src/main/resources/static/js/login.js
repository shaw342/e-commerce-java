
document.getElementById("submit").addEventListener("click",(e)=>{
    let name  = document.getElementById("name");
    let password = document.getElementById("password");
    let email = document.getElementById("email");
    let elementName = name.value;
    let elementPassword = password.value;
    let elementEmail = email.value;

    let userInfo = {
        name:elementName,
        email:elementEmail,
        password:elementPassword,
    }
    
    
    fetch('http://localhost:8080/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userInfo)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Réponse du serveur:', data);
    })
    .catch(error => {
        console.error('Erreur lors de la requête:', error);
    });

})
