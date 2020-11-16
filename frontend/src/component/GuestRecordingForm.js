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
            <div className="insertForm mx-auto mt-5">
                <h3 className="text-center">Vendég létrehozása</h3>
                <div className="table-responsive">
                <ErrorMessageWell/>
                    <table className="table borderless">
                        <tbody>
                            <tr>
                                <td>Név</td>
                                <td><input 
                                        type={"text"}
                                        value={this.state.guestName}
                                        onChange={(e)=>{
                                            let st = this.state;
                                            st.guestName = e.target.value;
                                            this.setState(st);}}
                                    /></td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td><input type={"text"}
                                            value={this.state.email}
                                            onChange={(e)=>{
                                                let st = this.state;
                                                st.email = e.target.value;
                                                this.setState(st);
                                            }}           
                                /></td>
                            </tr>
                            <tr>
                                <td>Telefonszám</td>
                                <td><input type={"number"}
                                            value={this.state.phone}
                                            onChange={(e)=>{
                                                let st = this.state;
                                                st.phone = e.target.value;
                                                this.setState(st);
                                            }}           
                                /></td>
                            </tr>
                            
                            <tr>
                                <td 
                                colSpan={2}>
                                    <button
                                        className="btn btn-info"
                                        onClick={()=>{actions.recordGuest(this.state)}}
                                        >Létrehoz
                                    </button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default GuestRecordingForm
