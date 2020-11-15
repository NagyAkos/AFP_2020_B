import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/GuestsActionConstants'

export const recordGuest = ({guestName,email,phone}) =>{
    axios.post('/guests/record',
        {
            guestName : guestName,
            email: email,
            phone : phone
        });
}
export const fetchGuests = () =>{
    
    axios.get('/guests/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}