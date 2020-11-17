import React from "react";
import * as actions from '../action/ReservationActions';
import ErrorMessageWell from "./ErrorMessageWell";
class ReservationRecordingForm extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            campId : 1,
            campingStyle : true,
            electricity : true,
            guestId : 1,
            price : 3000,
            reserveEnd : "20200312",
            reserveStart : "20190911"
        };
        this.formOnChange = this.formOnChange.bind(this);
    }

    formOnChange(event) {
        const {name,value} = event.target;
        this.setState({[name] : value});
    }


    render(){
        return(
            <div className="insertForm mx-auto mt-5">
                <h3 className="text-center">Foglalás létrehozása</h3>
                <div className="table-borderless">
                    <tbody>
                    <tr>
                        <td>Camp Id</td>
                        <td>
                            <input type={"checkbox"}
                                   value={this.state.campingStyle}
                                   onChange={(e )=>{
                                       let st = this.state;
                                       st.campingStyle = e.target.value;
                                       this.setState(st);
                                   }}/>
                        </td>
                    </tr>
                        <tr>
                            <td>Camping stílus</td>
                            <td>
                                <input type={"checkbox"}
                                       value={this.state.campingStyle}
                                       onChange={(e )=>{
                                           let st = this.state;
                                           st.campingStyle = e.target.value;
                                           this.setState(st);
                                       }}/>
                            </td>
                        </tr>
                        <tr>
                            <td>Elektromosság</td>
                            <td>
                                <input type={"checkbox"}
                                       value={this.state.electricity}
                                       onChange={(e  )=>{
                                           let st = this.state;
                                           st.electricity = e.target.value;
                                           this.setState(st);
                                       }}/>
                            </td>
                        </tr>
                        <tr>
                            <td>Ár</td>
                            <td>
                                <input type={"text"}
                                       value={this.state.price}
                                       onChange={(e  )=>{
                                           let st = this.state;
                                           st.price = e.target.value;
                                           this.setState(st);
                                       }}/>
                            </td>
                        </tr>
                    </tbody>
                </div>
            </div>
        );
    }
}

export default ReservationRecordingForm