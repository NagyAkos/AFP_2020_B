import React from "react";
import * as actions from '../action/GuestsActions';
import ErrorMessageWell from "./ErrorMessageWell";
class GuestRecordingForm extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            guestName : "János",
            email : "asd@asd.com",
            phone : 123456789
        };
        this.formOnChange = this.formOnChange.bind(this);
    }

    formOnChange(event){
        const {name,value} = event.target;
        this.setState({[name] : value});
    }

    render() {
        return(
            <div>
                <ErrorMessageWell/>
                    <label htmlFor={"guestName"} >Név</label>
                    <input type={"text"} id={"guestName"} name={"guestName"} value={this.state.guestName} onChange={this.formOnChange}/>
                    <br/>
                    <label htmlFor={"email"}>Email</label>
                    <input type={"text"} id={"email"} name={"email"} value={this.state.email} onChange={this.formOnChange}/>
                    <br/>
                    <label htmlFor={"phone"}>Telefonszám</label>
                    <input type={"number"} id={"phone"} name={"phone"} value={this.state.phone} onChange={this.formOnChange}/>
                    <br/>
                    <button onClick={()=> actions.recordGuest(this.state)}>Felvétel</button>
            </div>
        );
    }
}

export default GuestRecordingForm
