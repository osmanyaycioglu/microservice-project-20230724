import React from 'react';
import OutWrite from "./OutWrite";

const ProfileCard = () => {
    const minVal = 10;
    const maxVal = 20;

    return (
        <div>
            Profile
            <textarea autoFocus={true} />
            <input type="number" min={minVal} max={maxVal} />
            <p> Minimum {minVal} ile maximum {maxVal} arasında giriniz </p>
            <OutWrite text="deneme" min={minVal} max={maxVal}/>
        </div>
    );
};

export default ProfileCard;