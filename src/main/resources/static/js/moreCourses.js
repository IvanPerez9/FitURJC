$(document).ready(function(){
  var coontAll = 0;
  $("#btnMoreCourses").on("click",function() {
    $('#spinner').html('<center> <i class="fa fa-spinner fa-pulse fa-3x fa-fw"></i></center>');
    coontAll++;
    $.get("/moreCourses", {
      page: coontAll
      })
      .done(function(data) {
      $('#spinner').empty();
        if (!$.trim(data)) {
          $("#btnMoreCourses").html("No more results available");
        } else {
          $("#listCourses").append(data);
        }
      });
  });
});
