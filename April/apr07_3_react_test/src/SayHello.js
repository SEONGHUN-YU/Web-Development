// class를 만들 건데

import React from "react";

// JSX(JavaScriptXml ?)
//      HTML처럼 생겼지만 XML 이라 함
//      무조건 하나로 나와야 함 -> div 하나 속에 여러 데이터는 div 하나임, tuple 느낌?
//      <div>는 <>로 생략가능함
//      <br>, <img src=""> 이런식으로 썼었는데 react에선 무조건 종료태그까지 다 필요함 <- <br/> 이런 건 가능
const SayHello = () => {
  return (
    <>
      <h1>안녕</h1>
      <h2>ㅎㅇ</h2>
    </>
  );
};

export default SayHello;
