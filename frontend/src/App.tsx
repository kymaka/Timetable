import React from 'react';
import logo from './logo.svg';
import './App.css';
import "bootstrap/dist/css/bootstrap.min.css"
import StudentGroupComponent from './components/TypeComponents/StudentGroupComponent';
import RoomComponent from './components/TypeComponents/RoomComponent';
import { RoomType } from './enums/RoomType';
import DataPage from './pages/DataPage';
import { Route, Routes } from 'react-router-dom';
import { TimetablePage } from './pages/TimetablePage';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Routes>
          <Route path="/rooms" element={<DataPage />} />
          <Route path="/subjects" element={<DataPage />} />
          <Route path="/groups" element={<DataPage />} />
          <Route path="/teachers" element={<DataPage />} />
          <Route path="/timeslots" element={<DataPage />} />
          <Route path="/timetable/:number" element={<TimetablePage />} />
        </Routes>
      </header>
    </div>
  );
}

export default App;
