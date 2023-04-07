import axios from "axios";
import React, { useState } from "react";

const Weather = () => {
  const [city, setCity] = useState("");
  const [description, setDescription] = useState("");
  const [temp, setTemp] = useState("");
  const [humidity, setHumidity] = useState("");
  const showWeather = () => {
    const u =
      "https://api.openweathermap.org/data/2.5/weather?q=" +
      city +
      "&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr";
    axios.get(u).then((res) => {
      setDescription(res.data.weather[0].description);
      setTemp(res.data.main.temp);
      setHumidity(res.data.main.humidity);
    });
  };
  const changeCity = (e) => {
    setCity(e.target.value);
    showWeather();
  };
  return (
    <>
      <input value={city} onChange={changeCity} placeholder="도시명" />
      <button onClick={showWeather}>확인</button>
      <h1>날씨 : {description}</h1>
      <h1>기온 : {temp}</h1>
      <h1>습도 : {humidity}</h1>
    </>
  );
};

export default Weather;
