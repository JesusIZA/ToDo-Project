var burgerClick = null;

$(function () {
	burgerClick = function(){
		var burger = $(".burger");
		burger.toggleClass("opened");
		burger.children().toggleClass("opened");

		$("menu form").slideToggle(400);

		$(".tasks").toggleClass("opened");
	}
});