import React from 'react';
import './Signup.css';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';


const Signup= () => {
  return (
    <form className="login-form">
      <h2>Registration</h2>
      <fieldset className="login-fieldset">
        <div className="form-group">
          <label className="form-label"><legend>Username</legend></label>
          <input type="text" id="username" name="username" className="form-input" required />
        </div>
        <div className="form-group">
          <label className="form-label"><legend>Email</legend></label>
          <input type="email" id="email" name="email" className="form-input" required />
        </div>
        <div className="form-group">
          <label className="form-label"><legend>Password</legend></label>
          <input type="password" id="password" name="password" className="form-input" required />
        </div>
        <div className="form-group">
          <label className="form-label"><legend>Confirm Password</legend></label>
          <input type="password" id="Confirm password" name="Confirm password" className="form-input" required />
        </div>
        <Link to='/'>
        <button type="submit" className="login-button">Register</button>
        </Link>
      </fieldset>
      <p className='crea'>Already Have an Account? 
      <Link to='/'>Login</Link>
      </p>
    </form>
  );
};

export default Signup;
