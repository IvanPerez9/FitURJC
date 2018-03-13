$(document).ready(function () {
    $("#boton").click(function () {
        $('#datos').html('<center> <i class="fa fa-spinner fa-pulse fa-5x fa-fw"></i></center>');
        $.ajax({
            url: ""
        }).done(function (data) {
            sleep(2000); //Solo se usa para ver el spinner más tiempo en el ejemplo
            $('#datos').html("")
                
        });
    })
});
 

function sleep(milisegundos) {
  var comienzo = new Date().getTime();
  while (true) {
    if ((new Date().getTime() - comienzo) > milisegundos)
      break;
  }
}
