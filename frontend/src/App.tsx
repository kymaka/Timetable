import React from 'react';
import logo from './logo.svg';
import './App.css';
import "bootstrap/dist/css/bootstrap.min.css"
import StudentGroupComponent from './components/StudentGroupComponent';
import RoomComponent from './components/RoomComponent';
import { RoomType } from './enums/RoomType';
import DataPage from './pages/DataPage';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <DataPage />
      </header>
    </div>
  );
}

export default App;
