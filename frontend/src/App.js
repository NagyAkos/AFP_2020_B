import React from 'react';
import './App.scss';

import 'bootstrap/dist/css/bootstrap.min.css';
import 'jquery/dist/jquery.min.js';
import 'bootstrap/dist/js/bootstrap.min.js';

import {BrowserRouter, Switch, Route} from "react-router-dom";
import GuestRecordingForm from "./component/GuestRecordingForm";
import Navbar from "./component/NavBar";
import GuestList from './component/GuestList';

import ReservesList from "./component/ReservationList";
import ReservesRecordForm from "./component/ReservationRecordingForm";

function App() {
    return (
        <BrowserRouter>
            <Navbar/>
            <Switch>
                <Route path="/reserves/record" component={ReservesRecordForm}/>
                <Route path="/guests/record" component={GuestRecordingForm}/>
                <Route path="/guests" component={GuestList}/>
                <Route peth="/reserves" component={ReservesList}/>
            </Switch>
        </BrowserRouter>

    );
}

export default App;
