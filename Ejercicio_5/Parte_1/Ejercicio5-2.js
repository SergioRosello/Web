function removeCookieBanner() {
  var elem = document.getElementById('cookie');
  elem.parentNode.removeChild(elem);
  return false;
}

function doCookieOnce() {
   removeCookieBanner();
   if (document.cookie.replace(/(?:(?:^|.*;\s*)cookie\s*\=\s*([^;]*).*$)|^.*$/, "$1") !== "true") {
     document.cookie = "cookie=true; expires=Fri, 31 Dec 9999 23:59:59 GMT";
  }
}