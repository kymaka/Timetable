import React from 'react'
import Room from '../../types/Room'
import Input from '@mui/material/Input';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { RoomType, RoomTypeInfo } from '../../enums/RoomType';
import MenuItem from '@mui/material/MenuItem';
import { Button } from '@material-ui/core';

const RoomComponent = () => {
  return (
    <Box>
      <Input placeholder="Room number" />
      <TextField
        id="outlined-select-type"
        select
        label="Select"
        helperText="Select room type."
      >
        {Object.keys(RoomType).map((option) => (
          <MenuItem key={option} value={option}>
            {option}
          </MenuItem>
        ))}
      </TextField>
    </Box>
  );
};

export default RoomComponent;
