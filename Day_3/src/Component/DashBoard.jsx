import React from 'react'
import './DashBoard.css';
import { Link } from 'react-router-dom';
const DashBoard = () => {
  return (
    <div>
        <div class="leftnav">
        <a class="active" href="#home">DashBoard</a>
        <a href="#news">Profile</a>
        </div>
        <div className='wel'>
          <fieldset className='field'>
            Welcome (Name)!
          </fieldset>
        </div>
        <p className='log'>  
      <Link to='/'>Logout</Link>
      </p>
    </div>
  )
}

export default DashBoard
