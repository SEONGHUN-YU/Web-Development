import "./App.css";
import MyButton from "./MyButton";
import SayHello from "./SayHello";

// JavaScript로 클라이언트쪽에서 HTML/CSS 끝내자
// => 많은 JavaScript lib들이 생김
// jQuery : HTML의 특정 부분만 수정 가능(소스는 부분만 수정하는 것처럼 쓰지만)
//          실제 브라우저는 처음부터 다시 다 그린다고 함
// react : VirtualDOM 이라는 컨셉을 내세움 + OOP
//         VirtualDOM 이라는 곳에다가 일단 그리고나서
//         수정사항만 실제 웹페이지에 그린다(수정사항이 생기면 VirtualDOM에서 처리, 그 부분만 업데이트)
//         웹페이지에 업데이트가 되게 잦은 사이트에 유리하다
//         업데이트가 잦지 않으면, 정적인 사이트이면, 괜히 VirtualDOM에 그려야하니 느려짐

function App() {
  return (
    <>
      <MyButton/>
      <hr/>
      <button></button>
      <hr/>
      <SayHello/>
    </>
  );
}

export default App;
