import React from 'react';
import {default as store} from '../store/GuestsStore'
import * as actions from '../action/GuestsActions';
import GuestListItem from "./GuestListItem";

class GuestList extends React.Component{

    constructor(props) {
        super(props);
        this.state = {guests : []};
        this._updateState = this._updateState.bind(this);
    }


    componentDidMount() {
        store.addChangeListener(this._updateState);
    }


    componentWillUnmount() {
        store.removeChangeListener(this._updateState);
    }

    _updateState(){
        this.setState({guests : store._guests});
    }

    render() {
        return(
            <div>
                <button className="btn btn-info" onClick={()=> actions.fetchGuests(this.state)}>Listáz</button>
                <div div className="table-responsive">
                    <table className="product_table table">
                        <thead>
                            <tr>
                                <td>Id </td>
                                <td>Név </td>
                                <td>Email </td>
                                <td>Telefonszám </td>
                            </tr>
                        </thead>
                        <tbody>
                        {this.state.guests.map(({id,guestName,email,phone})=>{
                    return(
                        <tr key={id}>
                            <td>{id}</td>
                            <td>{guestName}</td>
                            <td>{email}</td>
                            <td>{phone}</td>
                            
                        </tr>
                            );
                        })}
                        </tbody>
                    </table>
                </div>
                
            </div>
        );
    }
}

export default GuestList;
