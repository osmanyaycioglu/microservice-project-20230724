import '../App.css';
import ProfileCard from "./ProfileCard";
import OutWrite from "./OutWrite";
import MyCounter from "./MyCounter";

const myVal = {
    test : "osman",
}

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <MyCounter />
                <p>
                    hello world
                    <OutWrite text="deneme upper" max={5} min={100} />
                </p>
                <ProfileCard />
            </header>
        </div>
    );
}

export {myVal};
export default App;
