window.addEventListener('load', function() {
    (function() {
        const url = '/turnos';
        const settings = {
            method: 'GET'
        };
        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                for (turno of data) {
                    var table = document.getElementById("turnosTable");
                    var turnosRow = table.insertRow();
                    let tr_id = 'tr_' + turno.id;
                    turnosRow.id = tr_id;

                    let deleteButton = '<button ' +
                        'id="' + 'btn_delete_' + turno.id + '" ' +
                        'type="button" onclick="deleteBy(' + turno.id + ')" class="btn btn-danger">' +
                        '&times;' +
                        '</button>';

                    let updateButton = '<button ' +
                        'id="' + 'btn_id_' + turno.id + '" ' +
                        'type="button" onclick="findBy(' + turno.id + ')" class="btn btn-info btn_id">' +
                        turno.id +
                        '</button>';

                    turnoRow.innerHTML =
                        '<td>' + updateButton + '</td>' +
                        '<td class="td_fecha">' + turno.date.toUpperCase() + '</td>' +
                        '<td class="td_paciente">' + turno.paciente.id + '</td>' +
                        '<td class="td_odontologo">' + turno.odontologo.id + '</td>' +
                        '<td>' + deleteButton + '</td>';
                }
            });
    })();

    (function() {
        let pathname = window.location.pathname;
        if (pathname === "/") {
            document.querySelector("nav .nav-item a:first").classList.add("active");
        } else if (pathname === "/turnoList.html") {
            document.querySelector("nav .nav-item a:last").classList.add("active");
        }
    })();
});

