var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

// JavaScript : callback함수기반
// single-thread, non-blockingI/O
app.listen(8989); // Node.js back-end 서비스 포트
// /te.st라는 주소로 get방식 요청 받으면 응답하기
app.get('/te.st', function(req, res) { // app.post(); 도 있음
    res.send('<html>');
});

// /param.test?a=10&b=5 
app.get('/param.test', function(req, res) {
	var aaa = req.query.a * 1; // req.query.파라메터명;
	var bbb = req.query.b * 1;
	res.send(aaa + bbb + "");
});

// /kakaoBlog.get 요청하면 DB에 있는 거 JSON으로 나오게
app.get('/kakaoBlog.get', function(req, res) {
	var mjs = require('mongojs');
		// 생성자(연결할 서버 ip주소 / 연결할 db 이름, ['앞으로 써먹을 테이블명', ...]);
	var db = mjs('192.168.0.125/xe',['kakaoBlog']); 
	
	// Node.js : JavaScript Back-end
	// MongoDB : JavaScriptDB, 말이 테이블명이지 그냥 객체지
	// 심지어는 같은 회사꺼... 그래서 그냥 MongoDB 문법 쓰면 됨
	db.kakaoBlog.find(function(err, result) {
		res.send(result);
	});
	// linux : clear
	// cmd : cls
});

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
