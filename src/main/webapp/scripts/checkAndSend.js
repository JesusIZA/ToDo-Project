function send(command, contextPath) {
    var flag = false;
    var vars = "command="+command;

    if (command == "login") {
        var login = document.querySelector("#login"),
            password = document.querySelector("#password");

        if (loginChecker(login) && passwordChecker(password)){
            vars += "&login=" + login.value + "&password=" + password.value;
            login.value = "";
            password.value = "";
            flag = true;
        }
    } else if (command == "registration") {
        var name = document.querySelector("#name"),
            email = document.querySelector("#email"),
            login = document.querySelector("#login"),
            password = document.querySelector("#password");

        if (nameChecker(name) && emailChecker(email) && loginChecker(login) && passwordChecker(password)){
            vars += "&name="+name.value+"&email="+email.value+"&login="+login.value+"&password="+password.value;
            name.value = "";
            email.value = "";
            login.value = "";
            password.value = "";
            flag = true;
        }
    }

    if (flag) {
        var hr = new XMLHttpRequest();
        var url = contextPath + "/do";
        hr.open("POST", url, true);
        hr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        hr.send(vars);
        flag = false;
    }
};
function loginChecker(login) {
    if(login.value.length == 0){
        login.style.border = "1px solid red";
        return false;
    } else {
        login.style.border = "1px solid grey";
        return true;
    }
};
function passwordChecker(password) {
     if(password.value.length == 0){
        password.style.border = "1px solid red";
        return false;
    } else {
        password.style.border = "1px solid grey";
        return true;
    }
}
function nameChecker(name) {
    if(name.value.length == 0){
        name.style.border = "1px solid red";
        return false;
    } else {
        name.style.border = "1px solid grey";
        return true;
    }
}
function emailChecker(email) {
    if(email.value.length == 0){
        email.style.border = "1px solid red";
        return false;
    } else {
        email.style.border = "1px solid grey";
        return true;
    }
}

