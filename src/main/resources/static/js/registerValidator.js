function validateRegister() {
    var login = document.getElementById("login").value;
    var pass = document.getElementById("pass").value;
    var pass2 = document.getElementById("pass2").value;

    var regex = new RegExp("[A-Za-z0-9]{5}.*");
    var flag = true;

    if (!regex.test(login)) {
        document.getElementById("login").style.backgroundColor = 'RED';
        flag = false;
    } else {
        document.getElementById("login").style.backgroundColor = 'BLUE';
    }

    if (!regex.test(pass)) {
        document.getElementById("pass").style.backgroundColor = 'RED';
        flag = false;
    } else {
        document.getElementById("pass").style.backgroundColor = 'BLUE';
    }

    if (!regex.test(pass2)) {
        document.getElementById("pass2").style.backgroundColor = 'RED';
        flag = false;
    } else {
        document.getElementById("pass2").style.backgroundColor = 'BLUE';
    }

    if (pass != pass2) {
        document.getElementById("pass").style.backgroundColor = 'RED';
        document.getElementById("pass2").style.backgroundColor = 'RED';
        flag = false;
    } else {
        if (flag) {
            document.getElementById("pass").style.backgroundColor = 'BLUE';
            document.getElementById("pass2").style.backgroundColor = 'BLUE';
        }
    }

    return flag;

}