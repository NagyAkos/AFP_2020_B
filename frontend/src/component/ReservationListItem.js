import React from 'react';

function GuestListItem({campId,campingStyle,electricity,guestId, id, price, reserveEnd, reserveStart}){
    return (
        <span>({campId}, {campingStyle}, {electricity}, {guestId}), {id}, {price}, {reserveEnd}, {reserveStart}</span>
    );
}

export default GuestListItem;