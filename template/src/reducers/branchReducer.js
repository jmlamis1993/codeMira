import { types } from "../types/types"
import data from "../view/branch/data"

const initialState = {
    branches : data,
    activeEvent : null
}

export default (state = initialState, { type, payload }) => {
  switch (type) {
  case types.branchSetActive:   
    return { ...state, activeEvent : payload }
  case types.branchAddNew:
    return {
        ...state,
        branches :[            
                ...state.branches,
                 payload            
          ]  
    } 
    case types.branchClearActiveEvent:
        return {
            ...state,
            activeEvent : null
        }   
        case types.branchUpdate:
            return{
               ... state,
               branches : state.branches.map(
                 e => (e.id === payload.id) ? payload : e
               )
            }
            case types.branchDelete:              
                return{
                   ... state,
                   branches : state.branches.filter(             
                     e => (e.id !== payload)                
                   ),
                   activeEvent: null 
                }         

  default:
    return state
  }
}
