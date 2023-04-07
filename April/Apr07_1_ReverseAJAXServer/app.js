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

var sio = require('socket.io');
var io = sio();
io.listen(8888); // http://192.168.0.157:8888/socket.io/socket.io.js

app.listen(9999);
app.get('/snack.reg', function(req, res) {
	var n = req.query.name;
	var p = req.query.price * 1;
	var db = require('mongojs')('192.168.0.152/xe', ['apr07_snack']);
	db.apr07_snack.insert({name : n, price : p}, function(err, result) {
		db.apr07_snack.find(function(err2, result2) {
			io.sockets.emit("snacks", result2);
		});
	});
});

app.get('/snack.get', function(req, res) {
	var db = require('mongojs')('192.168.0.152/xe', ['apr07_snack']);
	db.apr07_snack.find(function(err, result) {
		res.setHeader('Access-Control-Allow-Origin', '*');
		res.send(result);
	});
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
