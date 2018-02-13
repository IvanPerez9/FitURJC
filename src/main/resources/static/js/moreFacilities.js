$(document).ready(function(){
  var coontAll = 0;
  $("#btnMoreFacilities").on("click", function() {
    $('#spinner').html("<img src='/img/spinner.gif'>");
    coontAll++;
    $.get("/moreFacilities", {
      page: coontAll
      })
      .done(function(data) {
      $('#spinner').empty();
        if (!$.trim(data)) {
          $("#btnMoreFacilities").html("No hay más resultados");
        } else {
          $("#listFacilities").append(data);
        }
      });
  });
});