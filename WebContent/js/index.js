$(function() {
  var $navLi = $(".head li");
  $navLi.each(function(i) {
    $navLi.eq(i).click(function() {
      $navLi.children("a").removeClass("on");
      $(this).children("a").addClass("on");
      $("body").stop(false, true).animate({
      scrollTop: $("#step_" + i).offset().top - 80
      }, 800);
    });
  });

  $(window).scroll(function() {
    var scTop = $(window).scrollTop(),
        $navLia = $(".head li a"),
        dis_1 = $('#step_1').offset().top - 80,
        dis_2 = $('#step_2').offset().top - 100;
        console.log(scTop,dis_1,dis_2);
        if(scTop < dis_1) {
          $navLia.removeClass("on");
          $navLia.eq(0).addClass("on");
        } else if( scTop <= dis_2) {
          $navLia.removeClass("on");
          $navLia.eq(1).addClass("on");
        } else {
          $navLia.removeClass("on");
          $navLia.eq(2).addClass("on");
        }
  });
});