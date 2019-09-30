!function(){var t=function(){var t=document.createElement("script");t.src="https://ws.audioeye.com/ae.js",t.type="text/javascript",t.setAttribute("async",""),document.getElementsByTagName("body")[0].appendChild(t)};"complete"!==document.readyState?window.addEventListener?window.addEventListener("load",t):window.attachEvent&&window.attachEvent("onload",t):t()}()

// Parse QueryString (default value will be 'ppc')
    var referrerValue = "ppc";
    var reg = new RegExp('[?&]referrer=([^&#]*)', 'i');
    var value = reg.exec(window.location.href);

    referrerValue = ((value && value[1] !== "" && value[1] !== undefined && value[1] !== null) ?
            value[1] + "_" + referrerValue :
            referrerValue);

// Update Button HREF link to include query string parameter
    var BASE_URL = "/web/personalservices/gatewaytire/applynow"
    var buttonsList = document.getElementsByClassName("btn apply-now-link");

    for (var i = 0; i < buttonsList.length; i++){
        buttonsList[i].setAttribute("href", BASE_URL + "?referrer=" + referrerValue);
    }

// Display current year
    var currentDate = new Date();
    var yearElement = document.getElementById("current-year");
    yearElement.innerHTML = currentDate.getFullYear();
