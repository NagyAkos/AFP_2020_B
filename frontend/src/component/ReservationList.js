import React from 'react';
import {default as store} from '../store/ReservationStore';
import * as actions from '../action/ReservationActions';
import ReservationListItem from "./ReservationListItem";

class ReservationList extends React.Component {

    constructor(props) {
        super(props);
        this.state = {reservations: []};
        this._updateState = this._updateState.bind(this);
    }


    componentDidMount() {
        store.addChangeListener(this._updateState);
    }


    componentWillUnmount() {
        store.removeChangeListener(this._updateState);
    }

    _updateState() {
        this.setState({reservations: store._guests});
    }
}
export default ReservationList