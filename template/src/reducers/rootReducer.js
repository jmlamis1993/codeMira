import { combineReducers } from "redux";
import  authReducer  from "./authReducer";
//import calendarReducer from "./calendarReducer";
import uiReducer from "./uiReducer";
import branchReducer from "./branchReducer"

export const rootReducer = combineReducers({
    auth : authReducer,
    ui: uiReducer,    
    //calendar: calendarReducer,
    branch : branchReducer,
    //TODO:AuthReducer
    //TODO:CalendarReducer
})