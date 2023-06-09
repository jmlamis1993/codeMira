import * as React from 'react';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import ListSubheader from '@mui/material/ListSubheader';
import DashboardIcon from '@mui/icons-material/Dashboard';
import DateRangeIcon from '@mui/icons-material/DateRange';
import AssignmentIcon from '@mui/icons-material/Assignment';
import FolderIcon from '@mui/icons-material/Folder';
import AlternateEmailIcon from '@mui/icons-material/AlternateEmail';
import AccountBoxIcon from '@mui/icons-material/AccountBox';
import ApartmentIcon from '@mui/icons-material/Apartment';
import AddShoppingCartIcon from '@mui/icons-material/AddShoppingCart';
import { NavLink as RouterLink } from 'react-router-dom';


export const mainListItems = ( 
  <React.Fragment>
    <ListItemButton  component={RouterLink}  to='/app/home'>
      <ListItemIcon>
        <DashboardIcon />
      </ListItemIcon>
      <ListItemText primary="Dashboard" />
    </ListItemButton>   
    <ListItemButton component={RouterLink}  to='/app/product'>
      <ListItemIcon>
        <AddShoppingCartIcon />
      </ListItemIcon>
      <ListItemText primary="Product"/>
    </ListItemButton>  
   
    
    
  </React.Fragment>
);

export const secondaryListItems = (
  <React.Fragment>
    <ListSubheader component="div" inset>
    </ListSubheader>
    <ListItemButton component={RouterLink}  to='/app/profile'>
       <ListItemIcon>        
        <AccountBoxIcon />
      </ListItemIcon>
      <ListItemText primary="User Profile" />
    </ListItemButton>
   
    

  </React.Fragment>
);