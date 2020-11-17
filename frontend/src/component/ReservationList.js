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


    render() {
        return (
            <div>
                <button className="btn btn-info" onClick={() => actions.fetchReserves(this.state)}>Listáz</button>
                <div div className="table-responsive">
                    <table className="product_table table">
                        <thead>
                        <tr>
                            <td>Hely ID</td>
                            <td>Típus</td>
                            <td>Áram</td>
                            <td>Vendég ID</td>
                            <td>ID</td>
                            <td>Ár</td>
                            <td>Foglalás kezdete</td>
                            <td>Foglalás vége</td>
                        </tr>
                        </thead>
                        <tbody>
                        {this.state.reservations.map(({campId, campingStyle, electricity, guestId, id, price, reserveEnd, reserveStart}) => {
                            return (
                                <tr key={id}>
                                    <td>{campId}</td>
                                    <td>{campingStyle}</td>
                                    <td>{electricity}</td>
                                    <td>{guestId}</td>
                                    <td>{price}</td>
                                    <td>{reserveEnd}</td>
                                    <td>{reserveStart}</td>


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
export default ReservationList