import React from 'react';
import './App.scss';

import 'bootstrap/dist/css/bootstrap.min.css';
import 'jquery/dist/jquery.min.js';
import 'bootstrap/dist/js/bootstrap.min.js';

import {BrowserRouter, Switch, Route} from "react-router-dom";
import GuestRecordingForm from "./component/GuestRecordingForm";
import Navbar from "./component/NavBar";
import GuestList from './component/GuestList';

import ReservationRecordingForm from "./component/ReservationRecordinForm";
import ReservationList from "./component/ReservationList";

function App() {
  return (
     <BrowserRouter>
         <Navbar/>
         <Switch>
              <Route path="/guests/record" component={GuestRecordingForm}/>
              <Route path="/guests" component={GuestList}/>
              <Route path="/reservations/record" component={ReservationRecordingForm}/>
              <Route peth="/reservations" component={ReservationList}/>
         </Switch>
     </BrowserRouter>
  
  );
}

export default App;
