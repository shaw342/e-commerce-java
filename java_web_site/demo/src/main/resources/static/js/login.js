
document.getElementById("submit").addEventListener("click",(e)=>{
    let name  = document.getElementById("name");
    let password = document.getElementById("password");
    let email = document.getElementById("email");
    let elementName = name.value;
    let elementPassword = password.value;
    let elementEmail = email.value;

    let userInfo = {
        nameUser:elementName,
        emailUser:elementEmail,
        passwordUser:elementPassword,
    }
    console.log(userInfo);
    fetch("/register",{

        method:"post",
        headers:{
            "Content-Type": "application/json",
        },
        body:JSON.stringify(userInfo),
    }).then(async result =>{

    })
})
