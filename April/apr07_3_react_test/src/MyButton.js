import React, { useState } from "react";

// 각 객체들은 상태라는 게 있는데
// txt라는 이름의 멤버변수 만들고 -> ㅋㅋㅋ 값 넣고, setter까지 만든 거 <- 라고 보면 됨
const MyButton = () => {
  const [txt, setTxt] = useState("ㅋㅋㅋ");
  return (
    <button
      onClick={() => {
        setTxt("누름");
      }}
    >
      {txt}
    </button>
  );
};

export default MyButton;
