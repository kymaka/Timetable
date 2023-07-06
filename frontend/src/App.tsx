import './App.css';
import "bootstrap/dist/css/bootstrap.min.css"
import DataPage from './pages/DataPage';
import { Route, Routes } from 'react-router-dom';
import { TimetablePage } from './pages/TimetablePage';
import { NavBar } from './components/Navbar/Navbar';


function App() {
  return (
    <div className="App">
      <header className="App-header">
        <NavBar />
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
