$(document).ready(function(){
  var coontAll = 0;
  $("#btnMoreFacilities").on("click",function() {
    $('#spinner').html('<center> <i class="fa fa-spinner fa-pulse fa-3x fa-fw"></i></center>');
    coontAll++;
    $.get("/moreFacilities", {
      page: coontAll
      })
      .done(function(data) {
      $('#spinner').empty();
        if (!$.trim(data)) {
          $("#btnMoreFacilities").html("No more results available");
        } else {
          $("#listFacilities").append(data);
        }
      });
  });
});