function WriteCookie()
{
   cookievalue= "Sergio Roselló Morell";
   document.cookie=cookievalue;
   document.write (cookievalue);
}

function removeCookie() {
    var elem = document.getElementById('cookie');
    elem.parentNode.removeChild(elem);
    return false;
}