import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/ReservationActionConstants'

export const recordReservation = ({campId, campingstyle, electricity, guestId, price, reserveEnd, reserveStart}) => {
    axios.post('/reserves/record',
        {
            campId : campId,
            campingstyle : campingstyle,
            electricity : electricity,
            guestId : guestId,
            price : price,
            reserveEnd :reserveEnd,
            reserveStart : reserveStart
        });
}
export const fetchReserves = () =>{

    axios.get('/reserves/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.referesh,
            payload : resp.data
        });
    })
}