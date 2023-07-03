function deleteBy(id) {
    // Con fetch invocamos a la API de pacientes con el método DELETE
    // pasándole el id en la URL
    const url = '/pacientes/' + id;
    const settings = {
        method: 'DELETE'
    };

    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            // Borrar la fila del paciente eliminado
            let row_id = "#tr_" + id;
            document.querySelector(row_id).remove();
        })
        .catch(error => {
            console.error('Error:', error);
            // Manejo de error si es necesario
        });
}
