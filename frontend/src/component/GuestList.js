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
                <button onClick={()=> actions.fetchGuests(this.state)}>Listáz</button>
                {this.state.guests.map(({id,guestName,email,phone}, index)=>{
                    return(
                        <GuestListItem key={index} id={id} guestName={guestName} email={email} phone={phone}/>
                );
                })}
            </div>
        );
    }
}

export default GuestList;
