import React from 'react';
import './App.scss';
import GuestRecordingForm from "./component/GuestRecordingForm";
import GuestList from "./component/GuestList";

function App() {
  return (
    <div className={["App","container"]}>
        <div className={"row"}>
            <div className={"col-md-3"}></div>
            <div className={"col-md-6"}>
                <GuestRecordingForm/>
                <GuestList/>
            </div>
            <div className={"col-md-3"}></div>
        </div>
    </div>
  );
}

export default App;
