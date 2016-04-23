$('.table-selectable > tbody > tr').click(function() {
   if($(this).hasClass('active')){
    $(this).removeClass('active');  
  }else{
    $(".table-selectable > tbody > tr.active").removeClass('active');
    $(this).addClass('active');
  }

  if(($(".table-selectable > tbody > tr.active").length)){
    $("#btn-editar").prop( "disabled", false );
    $("#btn-deletar").prop( "disabled", false );
  }else{
    $("#btn-editar").prop( "disabled", true );
    $("#btn-deletar").prop( "disabled", true );
  } 

});


$(document).ready(function () {

    (function ($) {

        $('#filter').keyup(function () {

            var rex = new RegExp($(this).val(), 'i');
            $('.searchable tr').hide();
            $('.searchable tr').filter(function () {
                return rex.test($(this).text());
            }).show();

        })

    }(jQuery));
});
