/* first-slide area */
$(".stopbtn a img").on('click', function() {
  swiper.autoplay.stop();
  $(this).css("display", "none");
  $(".startbtn a img").css("display", "block");
  return false;
});

$(".startbtn a img").on('click', function() {
  swiper.autoplay.start();
  $(this).css("display", "none");
  $(".stopbtn a img").css("display", "block");
  return false;
});
