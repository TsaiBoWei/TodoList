/**
 * Learning to use Vue.js
 */

var app = new Vue({ 
    el: '#app',
    data: {
        message: 'Hello Vue!',
        seen: true,
        todos: [
            { text: 'Learn JavaScript' },
            { text: 'Learn Vue' },
            { text: 'Build something awesome' }
        ]
    }
});

app.message = 'I have changed the data!';