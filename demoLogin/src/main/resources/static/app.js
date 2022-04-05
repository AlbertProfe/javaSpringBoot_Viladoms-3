var stompClient = null;

connect();

function setConnected(connected) {
   
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#response").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {

        setConnected(true);
        console.log('Connected: ' + frame);
       
        stompClient.subscribe('/login/response', function (loginresponse) {
			console.log('Response from server: ' + loginresponse);
            showTextMessage(JSON.parse(loginresponse.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
 
    console.log("Disconnected");
}

function sendLogin() {
	
	console.log('About to send userName: ' + $("#username").val());
	console.log('About to send password: ' + $("#password").val());
	
    stompClient.send("/app/login", {}, JSON.stringify({'userName': $("#username").val() , 'password': $("#password").val() } ));
}

function showTextMessage(message) {
	console.log('Response from server: ' + message);
    $("#response").append("<tr><td>" + message + "</td></tr>");
    
    //disconnect();   
}


$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#send" ).click(function() { sendLogin(); });
});

