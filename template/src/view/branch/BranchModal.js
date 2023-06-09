import {React, useState, useEffect} from 'react'
import Modal from '@mui/material/Modal';
import {
  Box,
 
} from '@mui/material';
import { useSelector } from 'react-redux'
import { BranchForm } from './BranchForm';
import { uiCloseBranchModal } from '../../actions/ui';
import { useDispatch } from 'react-redux'
import { branchClearActiveEvent } from '../../actions/branch';
import { v4 as uuid } from 'uuid';

const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',    
    bgcolor: 'background.paper',
    width: 800,
    border: '1px solid #000',
    boxShadow: 24,
    p: 4,
    height:'90%',
    overflow:'scroll',
  };


export const BranchModal = () => {

    //const {modalBranchOpen} = useSelector(state => state.ui);
    const {modalBranchOpen} = false;
    const dispatch = useDispatch();
     
    const handleClose = () =>
    {
    dispatch(uiCloseBranchModal());
    dispatch(branchClearActiveEvent());
    //setFieldValue(initialValues);
   } 



  return (
    <>
    <Modal
      open={modalBranchOpen}
      onClose={handleClose}
      aria-labelledby="modal-modal-title"
      aria-describedby="modal-modal-description"      
    >
      <Box sx={style}>     
       <BranchForm />
      </Box>
    </Modal>
    </>
   
  )


}
