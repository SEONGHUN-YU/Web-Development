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

// 웹소켓 서버 시작
// => IP주소:포트번호/socket.io/socket.io.js
// 저 파일을 갖다 쓰면 웹소켓 사용 가능
var sio = require('socket.io');
var io = sio(); // 객체 기본생성
io.listen(9999); // <- 여기까지해주면 웹소켓 서버가 시작됨, 자동으로 해줌

io.sockets.on('connection', function(socket) {
	socket.on('msggg', function(zxc) {
		io.sockets.emit('srvMsggg', zxc);
	});
});

// io.sockets : 연결된 모든 소켓들
// socket : 소켓 하나

// .emit('제목', 내용) : 보내기(돌려줄 때도)
// .on('제목', 콜백함수) : 받기

app.use('/', indexRouter); // 요청받는 용도로 쓸 거면 지움, 이번엔 아니어서 그냥 냅둬 봄
app.use('/users', usersRouter);

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
