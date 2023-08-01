import React, {useEffect, useState} from 'react';


const MyCounter = () => {
    const [counter,setCounter] = useState(0);
    const [obj,setObj] = useState({name:"osman",age:53});

    function countMe(){
        setCounter(counter + 1);
    }

    function changeMe() {
        const newObj =  {...obj};
        newObj.age = obj.age + 1;
        setObj(newObj);
    }

    useEffect(() => {
        console.log("effect fired");
    },[counter,obj]);


    return (
        <div>
            <button onClick={countMe}>Click me</button>
            <p>{counter}</p>
            <button onClick={changeMe}>Click me</button>
            <h1>Person name : {obj.name} age : {obj.age}</h1>
        </div>
    );
};

export default MyCounter;