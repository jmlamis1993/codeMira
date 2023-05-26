import React from 'react';

import GridItem from "../../components/Grid/GridItem.js";
import GridContainer from "../../components/Grid/GridContainer.js";
import Tasks from "../../components/Tasks/Tasks.js";
import CustomTabs from "../../components/CustomTabs/CustomTabs.js";
import BugReport from "@mui/icons-material/BugReport";
import Code from "@mui/icons-material/Code";
import Cloud from "@mui/icons-material/Cloud";
import { bugs, website, server } from "../../helpers/general";
import dashboardStyle from "../../assets/dashboardStyle";
import useClasses from '../../helpers/useClasses';

export const Home = () => {  
const useStyles = useClasses(dashboardStyle);
  return (
    <>
      <GridContainer>
        <GridItem xs={12} sm={12} md={6}>
          
        </GridItem>
        </GridContainer>
    </>
   
  )
}