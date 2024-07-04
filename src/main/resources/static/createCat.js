fetch("http://localhost:8080/api/v1/admin/createCategory", {
    method: "POST",
    headers: {
        "Content-type": "application/json",
    },
    body: JSON.stringify({
        name: "Жареные",
        
    })
})
.then(data => data.json())
.then(e => console.log(e))
.catch(error => console.error('Error:', error));