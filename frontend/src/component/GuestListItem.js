import React from 'react';

function GuestListItem({id,guestName,email,phone}){
    return (
        <span>({id}, {guestName}, {email}, {phone})</span>
    );
}

export default GuestListItem;
