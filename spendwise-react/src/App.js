// src/App.js
import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import ExpenseList from './ExpenseList';

const App = () => {
  return (
    <Router>
      <div>
        <h1>SpendWise</h1>
        <Route path="/" exact component={ExpenseList} />
      </div>
    </Router>
  );
};

export default App;
