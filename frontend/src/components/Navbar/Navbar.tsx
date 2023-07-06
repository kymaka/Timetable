import * as React from 'react'
import { NavLink } from 'react-router-dom';
import "../../index.css"

export function NavBar() {
  return (
    <div className="navbar-container">
      <nav className="navbar-container">

        <NavLink to="/groups">Groups</NavLink>
        <NavLink to="/subjects">Subjects</NavLink>
        <NavLink to="/rooms">Rooms</NavLink>
        <NavLink to="/teachers">Teachers</NavLink>
        <NavLink to="/timeslots">Timeslots</NavLink>

      </nav>
    </div>
  );
}