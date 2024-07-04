fetch("http://localhost:8080/api/v1/admin/createRoll", {
    method: "POST",
    headers: {
        "Content-type": "application/json",
    },
    body: JSON.stringify({
        name: "Филадельфия",
        category: "Жареные",
        composition: "соус, рис",
        price: 200,
        image: "hi"
        
    })
})
.then(data => data.json())
.then(e => console.log(e))
.catch(error => console.error('Error:', error));