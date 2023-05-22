import React from 'react';
import { Navigate } from 'react-router-dom';
import LoginView from '../view/auth/login';
import MainLayout from '../layouts/loginLayout';
//import Dashboard from '../layout/dashboardLayout';
//import { Home } from '../views/dashboard/Home';
//import { CalendarView } from '../views/calendar/CalendarView';
//import { BranchView } from '../views/branch/BranchView';



const routes =(isLogging) => [
  /*{
    path: '/app',    
    element: isLogging ? <Dashboard/>: <Navigate to="/login"/>,
    children: [      
          
    ]
  },*/
 {
    path: '/',
    element: !isLogging ? <MainLayout /> : <Navigate to="/app/home"/>,
    children: [
      { path: '/login', element: <LoginView /> },     
    ]
  }
];

export default routes;