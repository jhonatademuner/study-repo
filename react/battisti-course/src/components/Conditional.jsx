import { useState } from "react";

function Conditional() {
  const [email, setEmail] = useState();
  const [userEmail, setUserEmail] = useState();

  function sendEmail(e) {
    e.preventDefault();
    setUserEmail(email);
  }

  function clearEmail(e) {
    e.preventDefault();
    setUserEmail('');
  }

  return (
    <div>
      <h2>Register yout email:</h2>
      <form>
        <input
          type="email"
          onChange={(e) => {
            setEmail(e.target.value);
          }}
        />
        <button type="submit" onClick={sendEmail}>
          Send Email
        </button>
        {userEmail && (
          <div>
            <p>The user e-mail is: {userEmail}</p>
            <button onClick={clearEmail}>Clear Email</button>
          </div>
        )}
      </form>
    </div>
  );
}

export default Conditional;
