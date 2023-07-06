import * as React from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import RoomComponent from '../TypeComponents/RoomComponent';

const style = {
  position: 'absolute' as 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 24,
  p: 4,
};

export default function BasicModal({ type }: any, { handleAdd }: any) {
  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  return (
    <div>
      <Button onClick={handleOpen}>Add</Button>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <Typography id="modal-modal-title" variant="h6" component="h2">
            Add {type}
          </Typography>
          <TypeParser type={type} handleAdd={handleAdd} />
          <Button onClick={() => handleAdd(type,)}>
            Save
          </Button>
        </Box>
      </Modal>
    </div>
  );
}

function TypeParser({ type }: any) {
  if (type === 'room') {
    return (
      <div>
        <RoomComponent />
      </div>
    )
  }
  return <></>
}