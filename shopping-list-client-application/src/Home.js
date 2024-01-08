import React, {useEffect, useState} from 'react';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';

import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';

import {getTodos, addTodo, deleteTodo} from "./ItemService";

export const Home = () => {

    const [list, setList] = useState([]);
    const [todo, setTodo] = useState('');


    useEffect(() => {
        getTodos().then(response => setList(response.data));
    }, []);
    const handleSubmit = (e) => {
        e.preventDefault();
        addTodo(todo).then(() => {
            setList([...list, todo]);
        });

    };

    const handleDelete = (todoID) => {
        deleteTodo(todoID).then(() => {
            setList(list.filter(todo => todo !== todoID));
        });
    };

    return (
        <div style={{display: 'flex', justifyContent: 'center', flexDirection: 'column', alignItems: 'center'}}>
            <h1 className='text-white font-bold text-2xl'>Todos</h1>
            <form style={{
                display: 'flex',
                justifyContent: 'center',
                flexDirection: 'column',
                alignItems: 'center',
                marginTop: '20px'
            }} onSubmit={handleSubmit}>
                <TextField

                    onChange={(e) => setTodo(e.target.value)}
                    value={todo}
                    style={{marginTop: '20px', color: 'white !important'}}
                    label="Todo"
                    variant="outlined"
                    InputProps={{style: {color: 'white', borderColor: 'white'}}}
                />
                <Button style={{marginTop: '20px'}} type='submit' variant="outlined">Add</Button>
            </form>

            <List style={{marginTop: '40px'}}>
                {list.map((item, index) => (
                    <ListItem key={index}>
                        <ListItemText style={{}} primary={item.replace('=','')} className='text-white text-center'/>
                        <Button style={{marginLeft: '20px'}} onClick={() => handleDelete(item) } variant="outlined">Delete</Button>
                    </ListItem>
                ))}
            </List>
        </div>


    );
};