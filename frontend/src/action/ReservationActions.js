import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/ReservationActionConstants'

export const recordReserve = ({guestId,campId,campingStyle,electricity,price,reserveStart,reserveEnd}) =>{
    axios.post('/reserves/record',
        {
            guestId : guestId,
            campId: campId,
            campingStyle : campingStyle,
            electricity :electricity,
            price : price,
            reserveStart : reserveStart,
            reserveEnd : reserveEnd
        });

}
export const fetchReserves = () =>{

    axios.get('/reserves/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}