window.addEventListener('load', function () {

    const formulario = document.querySelector('#update_paciente_form');

    formulario.addEventListener('submit', function (event) {
        let pacientetId = document.querySelector('#paciente_id').value;

        const formData = {
            id: document.querySelector('#paciente_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            fechaIngreso: document.querySelector('#fechaIngreso').value,
            domicilio: {
                calle: document.querySelector('#calle').value,
                numero: document.querySelector('#numero').value,
                localidad: document.querySelector('#localidad').value,
                provincia: document.querySelector('#provincia').value,
            }
        };

        const url = '/pacientes';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())
    })
 })
   function findBy(id) {
          const url = '/paciente/' + id;
        const settings = {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json'
          },
        }
        fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let paciente = data;
              document.querySelector('#paciente_id').value = pacientes.id;
              document.querySelector('#nombre').value = pacientes.nombre;
              document.querySelector('#apellido').value = pacientes.apellido;
              document.querySelector('#dni').value = pacientes.dni;
              document.querySelector('#fechaIngreso').value = pacientes.fechaIngreso;
              document.querySelector('#calle').value = paciente.domicilios.calle;
              document.querySelector('#numero').value = paciente.domicilios.numero;
              document.querySelector('#localidad').value = paciente.domicilios.localidad;
              document.querySelector('#provincia').value = paciente.domicilios.provincia;

            //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_paciente_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
    }
