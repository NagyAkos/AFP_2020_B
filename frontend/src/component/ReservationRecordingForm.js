import React from "react";
import * as actions from '../action/ReservationActions';
import ErrorMessageWell from "./ErrorMessageWell";
class ReservationRecordingForm extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            guestId : 1,
            campId : 1,
            campingStyle : true,
            electricity: false,
            price : 10,
            reserveStart: "2020-01-01",
            reserveEnd: "2020-02-02"

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
                <h3 className="text-center">Foglalás létrehozása</h3>
                <div className="table-responsive">
                    <ErrorMessageWell/>
                    <table className="table borderless">
                        <tbody>
                        <tr>
                            <td>Vendég Id</td>
                            <td><input
                                type={"number"}
                                value={this.state.guestId}
                                onChange={(e)=>{
                                    let st = this.state;
                                    st.guestId = e.target.value;
                                    this.setState(st);}}
                            /></td>
                        </tr>
                        <tr>
                            <td>Camp id</td>
                            <td><input type={"number"}
                                       value={this.state.campId}
                                       onChange={(e)=>{
                                           let st = this.state;
                                           st.campId = e.target.value;
                                           this.setState(st);
                                       }}
                            /></td>
                        </tr>
                        <tr>
                            <td>Camping Stílus (normál/kocsis)</td>
                            <td><input type={"checkbox"}
                                       value={this.state.campingStyle}
                                       onChange={(e)=>{
                                           let st = this.state;
                                           st.campingStyle = e.target.value;
                                           this.setState(st);
                                       }}
                            /></td>
                        </tr>
                        <tr>
                            <td>Áram</td>
                            <td><input type={"checkbox"}
                                       value={this.state.electricity}
                                       onChange={(e)=>{
                                           let st = this.state;
                                           st.electricity = e.target.value;
                                           this.setState(st);
                                       }}
                            /></td>
                        </tr>
                        <tr>
                            <td>Ár</td>
                            <td><input type={"number"}
                                       value={this.state.price}
                                       onChange={(e)=>{
                                           let st = this.state;
                                           st.price = e.target.value;
                                           this.setState(st);
                                       }}
                            /></td>
                        </tr>
                        <tr>
                            <td>Foglalás kezdete</td>
                            <td><input type={"text"}
                                       value={this.state.reserveStart}
                                       onChange={(e)=>{
                                           let st = this.state;
                                           st.reserveEnd = e.target.value;
                                           this.setState(st);
                                       }}
                            /></td>
                        </tr>
                        <tr>
                            <td>Foglalás vége</td>
                            <td><input type={"text"}
                                       value={this.state.reserveEnd}
                                       onChange={(e)=>{
                                           let st = this.state;
                                           st.reserveEnd = e.target.value;
                                           this.setState(st);
                                       }}
                            /></td>
                        </tr>
                        <tr>
                            <td
                                colSpan={2}>
                                <button
                                    className="btn btn-info"
                                    onClick={()=>{actions.recordReserve(this.state)}}
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

export default ReservationRecordingForm
