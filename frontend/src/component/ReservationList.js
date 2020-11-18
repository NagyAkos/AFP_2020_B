import React from 'react';
import {default as store} from '../store/ReservationStore'
import * as actions from '../action/ReservationActions';

class ReservationList extends React.Component{

    constructor(props) {
        super(props);
        this.state = {reserves : []};
        this._updateState = this._updateState.bind(this);
    }


    componentDidMount() {
        store.addChangeListener(this._updateState);
    }


    componentWillUnmount() {
        store.removeChangeListener(this._updateState);
    }

    _updateState(){
        this.setState({reserves : store._reserves});
    }

    render() {
        return(
            <div>
                <button className="btn btn-info" onClick={()=> actions.fetchReserves(this.state)}>Listáz</button>
                <div div className="table-responsive">
                    <table className="product_table table">
                        <thead>
                        <tr>
                            <td>Id </td>
                            <td>Vendég Id </td>
                            <td>Camp Id </td>
                            <td>Camping stílus </td>
                            <td>Áram </td>
                            <td>Ár </td>
                            <td>Foglalás kezdete </td>
                            <td>Foglalás vége </td>

                        </tr>
                        </thead>
                        <tbody>
                        {this.state.reserves.map(({id,guestId,campId,campingSytle,electricity,price,reserveStart,reserveEnd})=>{
                            return(
                                <tr key={id}>
                                    <td>{id}</td>
                                    <td>{guestId}</td>
                                    <td>{campId}</td>
                                    <td>{campingSytle}</td>
                                    <td>{electricity}</td>
                                    <td>{price}</td>
                                    <td>{reserveStart}</td>
                                    <td>{reserveEnd}</td>

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

export default ReservationList;
