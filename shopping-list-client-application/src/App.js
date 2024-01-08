import logo from './logo.svg';
import './App.css';

import React from 'react';
import TodoList from './TodoList';
import AddTodo from './AddTodo';


import { Home } from "./Home.js";

function App() {
  return (
    <div className="app">
      <Home/>
    </div>
  );
}

export default App;
