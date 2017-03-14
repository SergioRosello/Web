function removeCookieBanner() {
  var elem = document.getElementById('cookie');
  elem.parentNode.removeChild(elem);
  return false;
}

function doCookieOnce() {
 if (document.cookie.replace(/(?:(?:^|.*;\s*)cookie\s*\=\s*([^;]*).*$)|^.*$/, "$1") !== "true") {
  show();
  document.cookie = "cookie=true; expires=Fri, 31 Dec 9999 23:59:59 GMT";
  hide();
}
}


function show() {
 document.getElementById('cookie').style.display='block'; 
 return false;
} 
function hide() {
  if (document.cookie.indexOf("cookie") >= 0) {
  document.getElementById('cookie').style.display='none';
}
return false;
}  