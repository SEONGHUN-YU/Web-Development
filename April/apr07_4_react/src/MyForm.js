import React, { useState } from "react";
import "./myFormCSS.css";

// $('button').click(function() {}); 익명함수
// $('button').click(() => {}); 화살표함수

// rafce
const MyForm = () => {
  // btnTxt라는 멤버변수, 초기값은 useState를 써서 "홀"로 설정해줌
  // setBtnTxt는 Java의 setter 느낌
  const [btnTxt, setBtnTxt] = useState("홀");
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");

  const laugh = () => {
    setBtnTxt(btnTxt === "홀" ? "짝" : "홀");
  };

  return (
    <>
      <input
        value={name}
        onChange={(e) => {
          setName(e.target.value);
        }}
        placeholder="이름"
      />
      <br />
      <input
        value={price}
        onChange={(e) => {
          setPrice(e.target.value);
        }}
        placeholder="가격"
      />
      <br />
      <button className="b" onClick={laugh}>
        {btnTxt}
      </button>
    </>
  );
};

export default MyForm;
