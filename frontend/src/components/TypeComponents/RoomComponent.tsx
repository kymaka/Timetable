import React from 'react'
import Room from '../../types/Room'
import Input from '@mui/material/Input';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { RoomType, RoomTypeInfo } from '../../enums/RoomType';
import MenuItem from '@mui/material/MenuItem';
import { Button } from '@material-ui/core';

const RoomComponent = ({ updateData }: any) => {
  const room: Room = {
    id: 0,
    number: '',
    type: RoomType.General
  };
  return (
    <Box>
      <Input placeholder="Room number" onInput=
        {e => room.number = ((e.target as HTMLInputElement).value)}
      />
      <TextField
        id="outlined-select-type"
        select
        label="Select"
        helperText="Select room type."
      >
        {Object.keys(RoomType).map((option) => (
          <MenuItem
            onInput={e => room.type = ((e.target as HTMLInputElement).value as RoomType)}
            key={option}
            value={option}>
            {option}
          </MenuItem>
        ))}
      </TextField>
      <Button onClick={() => updateData(room)}>
        Save
      </Button>
    </Box>
  );
};

export default RoomComponent;
