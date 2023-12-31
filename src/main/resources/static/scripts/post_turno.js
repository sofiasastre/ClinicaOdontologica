window.addEventListener('load', function(){
    const formulario = document.querySelector('#add_new_turno');
    formulario.addEventListener('submit', function(event){
        const formData = {
            date: document.querySelector('#date').value,
            paciente: { id: document.querySelector('#paciente').value},
            odontologo:{id:document.querySelector('#odontologo').value }
        };

        const url ='/turnos';
        const settings= {
            method: 'POST',
            headers: {
                'Content-Type':'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                let successAlert = '<div class="alert alert-success alert-dismissible">'+'<button type="button" class="close" data-dismiss="alert">&times;</button>'+'<strong></strong>Turno agregado </div>'

                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();
            })
            .catch(error => {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">'+
                '<button type="button" class="close" data-dismiss="alert">&times;</button>'+'<strong></strong>Error intente nuevamente</div>'

                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();
            })
    });

    function resetUploadForm(){
        document.querySelector('#date').value = "";
        document.querySelector('#paciente').value = "";
        document.querySelector('#odontologo').value = "";
    }
    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector("nav .nav-item a:first").classList.add("active");
        }else if(pathname === "/pacienteList.html"){
            document.querySelector("nav .nav-item a:last").classList.add("active");
        }
    })();


})