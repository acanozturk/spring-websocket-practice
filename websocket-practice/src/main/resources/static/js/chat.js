'use strict';

const CHAT_DESTINATION = "/app/chat";
const CHAT_ENDPOINT = "/chat";
const CHAT_TOPIC = "/topic/chat";
const JOIN_DESTINATION = "/app/join";
const COLORS = [
    '#2196F3',
    '#32c787',
    '#00BCD4',
    '#ff5652',
    '#ffc107',
    '#ff85af',
    '#FF9800',
    '#39bbb0'
];

let usernamePage = document.querySelector('#username-page');
let chatPage = document.querySelector('#chat-page');
let usernameForm = document.querySelector('#usernameForm');
let messageForm = document.querySelector('#messageForm');
let messageInput = document.querySelector('#message');
let messageArea = document.querySelector('#messageArea');
let connectingElement = document.querySelector('.connecting');

let stompClient = null;
let username = null;

function connect(event) {
    username = document.querySelector('#name').value.trim();

    if (username) {
        usernamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');

        stompClient = Stomp.over(new SockJS(CHAT_ENDPOINT));

        stompClient.connect({}, onConnected);
    }

    event.preventDefault();
}


function onConnected() {
    stompClient.subscribe(
        CHAT_TOPIC,
        onMessageReceived
    );

    let joinMessage = {
        sender: username,
        chatMessageType: 'JOIN'
    };

    stompClient.send(
        JOIN_DESTINATION,
        {},
        JSON.stringify(joinMessage)
    );

    connectingElement.classList.add('hidden');
}

function send(event) {
    let messageContent = messageInput.value.trim();

    if (messageContent && stompClient) {
        let chatMessage = {
            sender: username,
            content: messageInput.value,
            chatMessageType: 'CHAT_MESSAGE'
        };

        stompClient.send(
            CHAT_DESTINATION,
            {},
            JSON.stringify(chatMessage)
        );

        messageInput.value = '';
    }

    event.preventDefault();
}


function onMessageReceived(payload) {
    let message = JSON.parse(payload.body);
    let messageElement = document.createElement('li');

    if (message.chatMessageType === 'JOIN') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' joined!';
    } else if (message.chatMessageType === 'LEAVE') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' left!';
    } else {
        messageElement.classList.add('chat-message');

        let avatarElement = document.createElement('i');
        let avatarText = document.createTextNode(message.sender[0]);
        avatarElement.appendChild(avatarText);
        avatarElement.style['background-color'] = getAvatarColor(message.sender);

        messageElement.appendChild(avatarElement);

        let usernameElement = document.createElement('span');
        let usernameText = document.createTextNode(message.sender);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);
    }

    let textElement = document.createElement('p');
    let messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);

    messageElement.appendChild(textElement);

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;
}


function getAvatarColor(messageSender) {
    let hash = 0;

    for (let index = 0; index < messageSender.length; index++) {
        hash = 31 * hash + messageSender.charCodeAt(index);
    }
    
    return COLORS[Math.abs(hash % COLORS.length)];
}

usernameForm.addEventListener('submit', connect, true)
messageForm.addEventListener('submit', send, true)