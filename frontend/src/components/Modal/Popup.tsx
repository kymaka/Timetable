import * as React from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import RoomComponent from '../TypeComponents/RoomComponent';
import TimeSlot from '../../types/TimeSlot';
import Subject from '../../types/Subject';
import StudentGroup from '../../types/StudentGroup';
import Room from '../../types/Room';
import Teacher from '../../types/Teacher';

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
  const [data, setData] = React.useState<Teacher | TimeSlot | Subject | StudentGroup | Room | null>(null);
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
          <TypeParser type={type} setData={setData} />
        </Box>
      </Modal>
    </div>
  );
}

function TypeParser({ type }: any, { setData }: any) {
  if (type === 'room') {
    return (
      <div>
        <RoomComponent setData={() => setData} />
      </div>
    )
  }
  return <></>
}