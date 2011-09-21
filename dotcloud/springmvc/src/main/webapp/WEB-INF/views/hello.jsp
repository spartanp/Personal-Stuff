<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/functions' prefix='fn' %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
    <body>
        <div id="fb-root"></div>
<script>
window.fbAsyncInit = function() {
   FB.init({
    appId  : '136541613110954',
    status : true, // check login status
    cookie : true, // enable cookies to allow the server to access the session
    xfbml  : true, // parse XFBML
    //channelURL : 'http://WWW.MYDOMAIN.COM/channel.html', // channel.html file
    oauth  : true // enable OAuth 2.0
  });
  
  FB.Event.subscribe('edge.create',
    function(response) {
        window.top.location = "http://www.facebook.com/pages/Spartan-Inc/216928404997036?sk=app_136541613110954";
    }
  );
 };
 
(function(d){
     var js, id = 'facebook-jssdk'; if (d.getElementById(id)) {return;}
     js = d.createElement('script'); js.id = id; js.async = true;
     js.src = "//connect.facebook.net/en_US/all.js";
     d.getElementsByTagName('head')[0].appendChild(js);
   }(document)); 
</script>

<div class="fb-like" data-href="http://www.facebook.com/pages/Spartan-Inc/216928404997036?sk=app_136541613110954" data-send="false" data-width="450" data-show-faces="true"></div>
        <p>
            Hello World
        </p>
        <c:choose>
            <c:when test="${isLikedByUser}">
                you are a fan and you can access content
            </c:when>
            <c:otherwise>
                become a fan please
            </c:otherwise>
        </c:choose>

    </body>
</html>