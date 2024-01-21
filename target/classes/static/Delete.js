function deleteData() {
    const url = 'https://@{/delete/{bookId}(bookId=${b.bookId})}'; // Replace with your API endpoint

    fetch(url, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json', // Adjust headers if necessary
            // Include any other headers needed for your API
        },
        // You can include a body if your DELETE request requires it
        // body: JSON.stringify({ /* data */ }),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json(); // Parse the response if needed
    })
    .then(data => {
        // Handle successful deletion
        console.log('Deleted:', data);
    })
    .catch(error => {
        // Handle errors
        console.error('There was a problem with the delete request:', error);
    });
}
