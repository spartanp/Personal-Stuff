// ==UserScript==
// @name          Switch Dashboard
// @namespace     http://www.example.com/gmscripts
// @description   Switch to the old dashboard on smm
// @include       https://c1-vmdjb147.d1.constantcontact.com/rnavmap/distui/smm*
// @version       1.0
// ==/UserScript==

var gm$;

// Add jQuery
function GM_loadJquery () {
    if (typeof unsafeWindow.jQuery == 'undefined') {
        var GM_Head = document.getElementsByTagName('head')[0] || document.documentElement,
            GM_JQ = document.createElement('script');

        GM_JQ.src = 'http://ajax.googleapis.com/ajax/libs/jquery/1.6.3/jquery.min.js';
        GM_JQ.type = 'text/javascript';
        GM_JQ.async = true;

        GM_Head.insertBefore(GM_JQ, GM_Head.firstChild);
    }
    GM_wait();
};

// Check if jQuery's loaded
function GM_wait() {
    if (typeof unsafeWindow.jQuery == 'undefined') {
        window.setTimeout(GM_wait, 100);
    } else {
        gm$ = unsafeWindow.jQuery.noConflict(true);
        letsJQuery();
    }
}

function letsJQuery() {
	// create a button for teh switch
	var div = gm$('<div style="position:absolute;top:0;right:0">' +
		'<input type="button" value="switch dashboard" id="switch-dashboard">' +
		'</div>');
	gm$("body").append(div);
	
	gm$("#switch-dashboard").click(function(e) {
		
	});
}

window.addEventListener("load", GM_loadJquery, false);
