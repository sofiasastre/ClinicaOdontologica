window.addEventListener('load', function(){
    const formulario = document.querySelector('#add_new_odontologo');
    formulario.addEventListener('submit', function(event){
        const formData = {
            matricula: document.querySelector('#matricula').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
        };

        const url ='/odontologos';
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
                let successAlert = '<div class="alert alert-success alert-dismissible">'+'<button type="button" class="close" data-dismiss="alert">&times;</button>'+'<strong></strong>Odontologo agregado </div>'

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
        document.querySelector('#matricula').value = "";
        document.querySelector('#nombre').value = "";
        document.querySelector('#apellido').value = "";
    }
    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector("nav .nav-item a:first").classList.add("active");
        }else if(pathname === "/odontologoList.html"){
            document.querySelector("nav .nav-item a:last").classList.add("active");
        }
    })();


})