var canvas = document.getElementById("yzm");
var ctx = canvas.getContext("2d");

function randomNum(min, max) {
	return Math.floor(Math.random() * (max - min) + min);
}

function randomColor(min, max) {
	var r = randomNum(min, max);
	var g = randomNum(min, max);
	var b = randomNum(min, max);
	return "rgb(" + r + "," + g + "," + b + ")"
}
//获取较小的边
var size = Math.min(canvas.width, canvas.height);
//文字
var str = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";

function getYzm() {
	var str_yzm = '';
	//背景
	ctx.fillStyle = randomColor(150, 250);
	ctx.fillRect(0, 0, canvas.width, canvas.height);
	for (var i = 0; i < 4; i++) {
		var txt = str[randomNum(0, str.length - 1)];
		str_yzm = str_yzm + txt;
		ctx.fillStyle = randomColor(10, 150)
		ctx.textBaseline = "bottom";
		ctx.font = randomNum(size * 0.5, size * 0.8) + "px Arial";
		var x = canvas.width * 0.1 + i * canvas.width * 0.2;
		var y = canvas.height * 0.9;
		var angle = randomNum(-30, 30);
		ctx.translate(x, y);
		ctx.rotate(angle * Math.PI / 180);
		ctx.fillText(txt, 0, 0);
		ctx.rotate(-angle * Math.PI / 180);
		ctx.translate(-x, -y);
	}
	//干扰线
	for (var i = 0; i < size / 8; i++) {
		ctx.strokeStyle = randomColor(0, 255);
		var x1 = randomNum(0, canvas.width);
		var y1 = randomNum(0, canvas.height);
		var x2 = randomNum(0, canvas.width);
		var y2 = randomNum(0, canvas.height);
		ctx.moveTo(x1, y1);
		ctx.lineTo(x2, y2);
		ctx.stroke();
	}
	//干扰点
	for (var i = 0; i < size / 3; i++) {
		var x = randomNum(0, canvas.width);
		var y = randomNum(0, canvas.height);
		ctx.fillStyle = randomColor(0, 100);
		ctx.beginPath();
		ctx.arc(x, y, size / 40, 0, Math.PI * 2, false)
		ctx.closePath();
		ctx.fill();
	}
	return str_yzm;
}