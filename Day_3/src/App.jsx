import { Route, Routes } from 'react-router-dom';
import { ReactDOM } from 'react-dom';
import Signup from './Component/Signup.jsx';
import Login from './Component/Login.jsx';
import React from 'react';
import DashBoard from './Component/DashBoard.jsx';

function App(){
    return(
            <Routes>
                <Route exact path='/'element={<Login/>}/>
                <Route exact path='/Signup'element={<Signup/>}/>
                <Route exact path="/dash" element={<DashBoard/>}/>
            </Routes>
    );
}

export default App
