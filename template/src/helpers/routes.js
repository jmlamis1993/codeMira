import React from 'react';
import { Navigate } from 'react-router-dom';
import {LoginView} from '../view/auth';
import MainLayout from '../layouts/loginLayout';
import Dashboard from '../layouts/dashboardLayout';
import { Home } from '../view/app/home';
import { BranchView } from '../view/branch/BranchView';
//import { CalendarView } from '../views/calendar/CalendarView';
//import { BranchView } from '../views/branch/BranchView';

const routes =(isLogging) => [
  {
    path: '/app',    
    element: isLogging ? <Dashboard/>: <Navigate to="/login"/>,
    children: [ 
      { path: 'home', element: <Home/> },
      { path: 'product', element: <BranchView/> },
    ]
  },
 {
    path: '/',
    element: !isLogging ? <MainLayout/> : <Navigate to="/app/home"/>,
    children: [
      { path: '/login', element: <LoginView /> },     
    ]
  }
];

export default routes;