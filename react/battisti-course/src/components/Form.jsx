import { useState } from "react";

function Form() {
  function registerUser(e) {
    e.preventDefault();
    console.log(name);
    console.log(password);
    console.log("registerUser");
  }

  const [name, setName] = useState();
  const [password, setPassword] = useState();

  return (
    <div className="form">
      <h1>Form</h1>
      <form onSubmit={registerUser}>
        <label htmlFor="name">Name:</label>
        <input type="text" id="name" name="name" onChange={(e) => {
          setName(e.target.value)
        }} />
        <label htmlFor="password">Password:</label>
        <input type="password" id="password" name="password" onChange={(e) => {
          setPassword(e.target.value)
        }} />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default Form;
