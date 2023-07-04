window.addEventListener("load", function() {
    const formulario = document.querySelector('#update_turno_form');
    formulario.addEventListener('submit', function(event){
        const formData = {
            id: document.querySelector('#turno_id').value,
            date: document.querySelector('#date').value,
            paciente: { id: document.querySelector('#paciente').value},
            odontologo:{id:document.querySelector('#odontologo').value }
        };

        const url = '/turnos';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        }
            fetch(url, settings)
            .then(response => response.json())
    })
})

    function findBy(id){
        const url = '/turnos/' + id;
        const settings = {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        }
        fetch(url, settings)
          .then(response => response.json())
          .then(data => {
                let odontologo = data;
                document.querySelector('#turno_id').value = turno.id;
                document.querySelector('#paciente').value = paciente.id;
                document.querySelector('#odontologo').value = odontologo.id;

                document.querySelector('#div_turno_updating').style.display = 'block';
            }).catch(error =>{
                alert("Error: " + error)
            })
    }