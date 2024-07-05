fetch("http://localhost:8080/api/v1/admin/createSet", {
    method: "POST",
    headers: {
        "Content-type": "application/json",
    },
    body: JSON.stringify({
        name: "Домашний",
        price: 2000,
        image: "helloworld",
        rolls: [2, 3]

    })
})
.then(data => data.json())
.then(e => console.log(e))
.catch(error => console.error('Error:', error));