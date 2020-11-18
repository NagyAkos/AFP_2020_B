import React from 'react';


class NavBar extends React.Component{
    render(){
        return(
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <a className="navbar-brand" href="/">Camping Manager System</a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>

                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle" href="#" id="guestDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Vendégek
                            </a>
                            <div className="dropdown-menu" aria-labelledby="productDropdown">
                                <a className="dropdown-item nav-link" href="/guests">Vendégek listázása</a>
                                <a className="dropdown-item nav-link" href="/guests/record">Vendég létrehozása</a>
                            </div>
                        </li>
                        <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle" href="#" id="guestDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Foglalások
                            </a>
                            <div className="dropdown-menu" aria-labelledby="productDropdown">
                                <a className="dropdown-item nav-link" href="/reserves">Foglalások listázása</a>
                                <a className="dropdown-item nav-link" href="/reserves/record">Foglalás létrehozása</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
        );
    }
}

export default NavBar;