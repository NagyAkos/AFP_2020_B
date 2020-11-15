import React from 'react';
import './App.scss';

import 'bootstrap/dist/css/bootstrap.min.css';
import 'jquery/dist/jquery.min.js';
import 'bootstrap/dist/js/bootstrap.min.js';

import {BrowserRouter, Switch, Route} from "react-router-dom";
import GuestRecordingForm from "./component/GuestRecordingForm";
import Navbar from "./component/NavBar";
import GuestList from './component/GuestList';

function App() {
  return (
     <BrowserRouter>
         <Navbar/>
         <Switch>
              <Route path="/guests/record" component={GuestRecordingForm}/>
              <Route path="/guests" component={GuestList}/>
         </Switch>
     </BrowserRouter>
  
  );
}

export default App;
