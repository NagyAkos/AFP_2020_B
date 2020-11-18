import {EventEmitter} from 'events'
import dispatcher from "../dispatcher/Dispatcher";
import {refresh} from '../dispatcher/ReservationActionConstants';

class ReservationStore extends EventEmitter{

    _reserves = [];

    emitChange(){
        this.emit('Change');
    }

    addChangeListener(callback){
        this.addListener('Change',callback);
    }

    removeChangeListener(callback){
        this.removeListener('Change',callback);
    }
}

const store = new ReservesStore();
export default store;

dispatcher.register(({action,payload})=>{
    if(action !== refresh ) return;
    store._reserves = payload;
    store.emitChange();
})
