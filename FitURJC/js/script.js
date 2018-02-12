$(document).ready(function () {
    $("#boton").click(function () {
        $('#datos').html('<center> <i class="fa fa-spinner fa-pulse fa-3x fa-fw"></i></center>')
        $.ajax({
            url: "https://www.googleapis.com/books/v1/volumes?q=intitle:javascript"
        }).done(function (data) {
            sleep(2000) //Solo se usa para ver el spinner más tiempo en el ejemplo
            $('#datos').html("")
            for (var i = 0; i < data.items.length; i++) {
                var libro = data.items[i].volumeInfo;
                var autor = libro.authors  
                if(autor == undefined)
                    autor = "?"
                $('#datos').append("<div><h4>"+(i+1)+") "+libro.title + "</h4> - <span> Autor/es: "+autor+"</span></div>")
          
            }
        });
    })
})
 
function sleep(milisegundos) {
  var comienzo = new Date().getTime();
  while (true) {
    if ((new Date().getTime() - comienzo) > milisegundos)
      break;
  }
}