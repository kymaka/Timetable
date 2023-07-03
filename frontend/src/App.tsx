import React from 'react';
import logo from './logo.svg';
import './App.css';
import "bootstrap/dist/css/bootstrap.min.css"
import StudentGroupComponent from './components/StudentGroupComponent';
import RoomComponent from './components/RoomComponent';
import { RoomType } from './enums/RoomType';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h1>Rooms</h1>
        <RoomComponent id={0} number={''} type={RoomType.Terminal} />
        <h1>Groups</h1>
        <StudentGroupComponent id={0} number={''} subjects={[]} timetableEntries={[]} />
      </header>
    </div>
  );
}

export default App;
