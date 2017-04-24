$(document).ready(function() {

    $(window).scroll(function() {
        if ($(window).scrollTop() == $(document).height() - $(window).height()) {
            $.ajax({
                url: 'Ejercicio7contenidopagina.html',
                dataType: 'html',
                success: function(html) {
                    $('#posts').append(html);
                }
            });

        }
    });
});