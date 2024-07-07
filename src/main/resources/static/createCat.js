// fetch("http://localhost:8080/api/v1/admin/createSet", {
//     method: "POST",
//     headers: {
//         "Content-type": "application/json",
//     },
//     body: JSON.stringify({
//         name: "Домашний",
//         price: 2000,
//         image: "helloworld",
//         rolls: [2, 3]

//     })
// })
// .then(data => data.json())
// .then(e => console.log(e))
// .catch(error => console.error('Error:', error));

// fetch("http://localhost:8080/api/v1/admin/getCats")
// .then(data => data.json())
// .then(e => console.log(e[0].rolls))
// .catch(error => console.error('Error:', error));

fetch("http://localhost:8080/api/v1/admin/updateRoll/2", {
    method: "PATCH",
    headers: {
        "Content-type": "application/json",
    },
    body: JSON.stringify({
        name: "Филадельфия",
        price: 200,
        image: "helloworld",
        composition: "пиво, водка, салями",
        category: "Запеченые",
    })
})
.then(data => data.json())
.then(e => console.log(e))
.catch(error => console.error('Error:', error));